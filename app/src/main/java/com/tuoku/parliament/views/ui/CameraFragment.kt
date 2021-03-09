package com.tuoku.parliament.views.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.AssetManager
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Environment
import android.service.media.CameraPrewarmService
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.CameraView
import androidx.camera.view.PreviewView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.contains
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.google.android.gms.tasks.OnSuccessListener
import com.google.common.util.concurrent.ListenableFuture
import com.google.mlkit.common.MlKitException
import com.google.mlkit.common.model.LocalModel
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.face.Face
import com.google.mlkit.vision.face.FaceDetectorOptions
import com.tuoku.parliament.R
import com.tuoku.parliament.databinding.FragmentCameraBinding
import com.tuoku.parliament.logic.models.Prediction
import com.tuoku.parliament.logic.utils.FaceDetectorProcessor
import com.tuoku.parliament.logic.utils.FaceGraphic.Companion.faces
import com.tuoku.parliament.logic.utils.FaceNetModel
import com.tuoku.parliament.logic.utils.GraphicOverlay
import com.tuoku.parliament.logic.utils.VisionImageProcessor
import com.tuoku.parliament.logic.viewmodels.CameraFragmentViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.tensorflow.lite.support.image.ImageProcessor
import java.io.Console
import java.io.File
import java.lang.Error
import java.util.ArrayList
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.math.pow
import kotlin.math.round
import kotlin.math.sqrt

class CameraFragment : Fragment(), LifecycleOwner, View.OnTouchListener {

    private lateinit var viewModel: CameraFragmentViewModel
    private lateinit var binding: FragmentCameraBinding

    private var previewView: PreviewView? = null
    private var graphicOverlay: GraphicOverlay? = null
    private var cameraProvider: ProcessCameraProvider? = null
    private var previewUseCase: Preview? = null
    private var analysisUseCase: ImageAnalysis? = null
    private var imageProcessor: FaceDetectorProcessor? = null
    private var needUpdateGraphicOverlayImageSourceInfo = false
    private var lensFacing = CameraSelector.LENS_FACING_BACK
    private var cameraSelector: CameraSelector? = null
    private var imageData = ArrayList<Pair<String,FloatArray>>()
    private var imageLabelPairs = ArrayList<Pair<Bitmap,String>>()
    private var model: FaceNetModel? = null


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_camera, container, false)
        viewModel = ViewModelProvider(this).get(CameraFragmentViewModel::class.java)

        cameraSelector = CameraSelector.Builder().requireLensFacing(lensFacing).build()
        previewView = binding.camView
        graphicOverlay = binding.camOverlay
        model = FaceNetModel(this.requireContext())
        imageProcessor = try {
            val optionsBuilder = FaceDetectorOptions.Builder()
                .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_NONE)
                .setContourMode(FaceDetectorOptions.CONTOUR_MODE_NONE)
                .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_NONE)
                .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_FAST)
                .setMinFaceSize(0.1.toFloat())
            optionsBuilder.enableTracking()
            val faceDetectorOptions = optionsBuilder.build()
            FaceDetectorProcessor(this.requireContext(), faceDetectorOptions)
        }catch (e:Error){
            Log.e("e",e.toString())
            null
        }



        viewModel.getProcessCameraProvider()?.observe(viewLifecycleOwner,{
            cameraProvider = it
            if(allPermissionsGranted()){
                bindAllCameraUseCases()
            }
        })
        if (!allPermissionsGranted()) {
            runtimePermissions
        }
        binding.camView.setOnTouchListener(object: View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                if(event?.action == MotionEvent.ACTION_UP) {
                    Log.d("camfrag", "onTouch ${faces.size}")

                    for(face in faces){
                        var p = Point()
                        p.x = event.x.toInt()
                        p.y = event.y.toInt() - 100
                        if(face.boundingBox.contains(p)){
                            Log.d("camfrag", "tapped a rect")
                            Log.d("camfrag","pX ${p.x}, pY ${p.y}, bbX ${face.boundingBox.centerX()}, bbY ${face.boundingBox.centerY()}")
                            Log.d("camfrag",face.trackingId.toString())
                            val rr = Rect(face.boundingBox.left - 100,face.boundingBox.top - 200,face.boundingBox.right + 100,face.boundingBox.bottom + 200)
                            val tbmp = cropRectFromBitmap(binding.camView.bitmap!!,rr,false)
                            val inputImage = InputImage.fromByteArray(BitmaptoNv21(tbmp),
                                tbmp.width
                                ,tbmp.height
                                ,0
                                ,InputImage.IMAGE_FORMAT_NV21)
                            val successListener = OnSuccessListener<List<Face?>> { faces ->
                                if (faces.isNotEmpty()) {
                                    val fBmp =
                                        faces[0]?.let {
                                            cropRectFromBitmap(
                                                tbmp,
                                                it.boundingBox,
                                                false
                                            )
                                        }
                                    binding.imageView3.setImageDrawable(
                                        BitmapDrawable(
                                            resources,
                                            fBmp
                                        )
                                    )
                                    GlobalScope.launch {
                                        val identifiedID = fBmp?.let {
                                            imageProcessor?.runModel(
                                                face,
                                                it
                                            )
                                        }
                                        val idd = identifiedID!!.toIntOrNull()
                                        if (idd != null) {
                                            findNavController().navigate(
                                                R.id.memberFragment,
                                                bundleOf("id" to idd)
                                            )
                                        }
                                    }
                                } else{
                                    Toast.makeText(context,"Tunnistaminen epäonnistui",Toast.LENGTH_SHORT).show()
                                }
                            }
                            imageProcessor!!.detector.process(
                                    inputImage
                                    ).addOnSuccessListener(successListener)
                        }
                    }
                }
                return true
            }

        })
        scanStorageForImages( File( MainActivity.getCon().getExternalFilesDir(null)?.absolutePath +  "/ParliamentImages/"))

        return binding.root
    }

    private fun cropRectFromBitmap(source: Bitmap, rect: Rect , preRotate : Boolean ): Bitmap {
        var width = rect.width()
        var height = rect.height()
        if ( (rect.left + width) > source.width ){
            width = source.width - rect.left
        }
        if ( (rect.top + height ) > source.height ){
            height = source.height - rect.top
        }
        val croppedBitmap = Bitmap.createBitmap(
            if ( preRotate ) rotateBitmap( source , -90f )!! else source,
            rect.left,
            rect.top,
            width,
            height )
        //saveBitmap( croppedBitmap , "image")
        return croppedBitmap
    }
    private fun rotateBitmap(source: Bitmap, angle: Float): Bitmap? {
        val matrix = Matrix()
        matrix.postRotate( angle )
        return Bitmap.createBitmap(source, 0, 0, source.width, source.height, matrix , false )
    }

    public override fun onResume() {
        super.onResume()
        bindAllCameraUseCases()
    }
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        if(event?.action == MotionEvent.ACTION_UP){
            Log.d("camfrag","onTouch")
        }
        Log.d("camfrag","onTouchhhhhh")
        return true
    }


    private fun bindAllCameraUseCases() {
        if (cameraProvider != null) {
            // As required by CameraX API, unbinds all use cases before trying to re-bind any of them.
            cameraProvider!!.unbindAll()
            bindPreviewUseCase()
            bindAnalysisUseCase()
        }
    }

    private fun bindPreviewUseCase() {

        if (cameraProvider == null) {
            return
        }
        if (previewUseCase != null) {
            cameraProvider!!.unbind(previewUseCase)
        }

        val builder = Preview.Builder()
        val targetResolution = android.util.Size(1080,1920)
        builder.setTargetResolution(targetResolution)
        previewUseCase = builder.build()
        previewUseCase!!.setSurfaceProvider(previewView!!.createSurfaceProvider())
        cameraProvider!!.bindToLifecycle(/* lifecycleOwner= */this, cameraSelector!!, previewUseCase)
    }

    @SuppressLint("UnsafeExperimentalUsageError")
    private fun bindAnalysisUseCase() {
        if (cameraProvider == null) {
            return
        }
        if (analysisUseCase != null) {
            cameraProvider!!.unbind(analysisUseCase)
        }
        if (imageProcessor != null) {
            imageProcessor!!.stop()
        }
        imageProcessor = try {

                    Log.i(
                        TAG,
                        "Using Face Detector Processor"
                    )
                    val optionsBuilder = FaceDetectorOptions.Builder()
                        .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_NONE)
                        .setContourMode(FaceDetectorOptions.CONTOUR_MODE_NONE)
                        .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_NONE)
                        .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_FAST)
                        .setMinFaceSize(0.1.toFloat())
                    optionsBuilder.enableTracking()
                    val faceDetectorOptions = optionsBuilder.build()
                    FaceDetectorProcessor(this.requireContext(), faceDetectorOptions)

        } catch (e: Exception) {
            Log.e(
                TAG,
                "Can not create image processor",
                e
            )
            Toast.makeText(
                this.requireContext(),
                "Can not create image processor: " + e.localizedMessage,
                Toast.LENGTH_LONG
            )
                .show()
            return
        }

        val builder = ImageAnalysis.Builder()
        val targetResolution = android.util.Size(1080,1920)
        builder.setTargetResolution(targetResolution)
        analysisUseCase = builder.build()

        needUpdateGraphicOverlayImageSourceInfo = true

        analysisUseCase?.setAnalyzer(
            // imageProcessor.processImageProxy will use another thread to run the detection underneath,
            // thus we can just runs the analyzer itself on main thread.
            ContextCompat.getMainExecutor(this.requireContext()),
            ImageAnalysis.Analyzer { imageProxy: ImageProxy ->
                if (needUpdateGraphicOverlayImageSourceInfo) {
                    val isImageFlipped =
                        lensFacing == CameraSelector.LENS_FACING_FRONT
                    val rotationDegrees =
                        imageProxy.imageInfo.rotationDegrees
                    if (rotationDegrees == 0 || rotationDegrees == 180) {
                        graphicOverlay!!.setImageSourceInfo(
                            imageProxy.width, imageProxy.height, isImageFlipped
                        )
                    } else {
                        graphicOverlay!!.setImageSourceInfo(
                            imageProxy.height, imageProxy.width, isImageFlipped
                        )
                    }
                    needUpdateGraphicOverlayImageSourceInfo = false
                }
                try {
                    imageProcessor!!.processImageProxy(imageProxy, graphicOverlay)
                } catch (e: MlKitException) {
                    Log.e(
                        TAG,
                        "Failed to process image. Error: " + e.localizedMessage
                    )
                    Toast.makeText(
                        this.requireContext(),
                        e.localizedMessage,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
        )
        cameraProvider!!.bindToLifecycle( /* lifecycleOwner= */this, cameraSelector!!, analysisUseCase)
    }
    private val requiredPermissions: Array<String?>
        get() = try {
            val info = this.requireContext().packageManager
                .getPackageInfo(this.requireContext().packageName, PackageManager.GET_PERMISSIONS)
            val ps = info.requestedPermissions
            if (ps != null && ps.isNotEmpty()) {
                ps
            } else {
                arrayOfNulls(0)
            }
        } catch (e: Exception) {
            arrayOfNulls(0)
        }

    private fun allPermissionsGranted(): Boolean {
        for (permission in requiredPermissions) {
            if (!isPermissionGranted(this.requireContext(), permission)) {
                return false
            }
        }
        return true
    }

    private val runtimePermissions: Unit
        get() {
            val allNeededPermissions: MutableList<String?> = ArrayList()
            for (permission in requiredPermissions) {
                if (!isPermissionGranted(this.requireContext(), permission)) {
                    allNeededPermissions.add(permission)
                }
            }
            if (allNeededPermissions.isNotEmpty()) {
                ActivityCompat.requestPermissions(
                    this.requireActivity(),
                    allNeededPermissions.toTypedArray(),
                    PERMISSION_REQUESTS
                )
            }
        }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        Log.i(TAG, "Permission granted!")
        if (allPermissionsGranted()) {
            bindAllCameraUseCases()
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun scanStorageForImages( imagesDir : File ) {
        val imageSubDirs = imagesDir.listFiles()
        Log.e( "App" , imagesDir.absolutePath )
        if ( imageSubDirs == null ) {
            Log.d("scanner", "no imgs found")

        }
        else {
            // List all the images in the "images" dir. Create a Hashmap of <Path,Bitmap> from them.
            for ( imageSubDir in imagesDir.listFiles() ) {
                for ( image in imageSubDir.listFiles() ) {
                    imageLabelPairs.add( Pair( BitmapFactory.decodeFile( image.absolutePath ) , imageSubDir.name ))
                }
            }
            // Initiate the loop
            scanImage( 0 )
        }
    }

    private fun scanImage(counter: Int){
        val sample = imageLabelPairs[counter]
        val inputImage = InputImage.fromByteArray(BitmaptoNv21(sample.first),
            sample.first.width
            ,sample.first.height
            ,0
            ,InputImage.IMAGE_FORMAT_NV21)
        val successListener = OnSuccessListener<List<Face?>>{ faces ->
            if(faces.isNotEmpty()){
                imageData.add(
                    Pair( sample.second,
                        model!!.getFaceEmbeddingWithoutBBox(sample.first)
                    )
                )
            }
            if(counter + 1 == imageLabelPairs.size){
                Log.d("IMGS", imageLabelPairs.size.toString())
                imageProcessor?.faceList = imageData
            } else {
                scanImage(counter + 1)
            }
        }
        imageProcessor!!.detector.process(inputImage).addOnSuccessListener(successListener)
    }
    private fun BitmaptoNv21( bitmap: Bitmap ): ByteArray {
        val argb = IntArray(bitmap.width * bitmap.height )
        bitmap.getPixels(argb, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)
        val yuv = ByteArray(bitmap.height * bitmap.width + 2 * Math.ceil(bitmap.height / 2.0).toInt()
                * Math.ceil(bitmap.width / 2.0).toInt())
        encodeYUV420SP( yuv, argb, bitmap.width, bitmap.height)
        return yuv
    }
    private fun encodeYUV420SP(yuv420sp: ByteArray, argb: IntArray, width: Int, height: Int) {
        val frameSize = width * height
        var yIndex = 0
        var uvIndex = frameSize
        var R: Int
        var G: Int
        var B: Int
        var Y: Int
        var U: Int
        var V: Int
        var index = 0
        for (j in 0 until height) {
            for (i in 0 until width) {
                R = argb[index] and 0xff0000 shr 16
                G = argb[index] and 0xff00 shr 8
                B = argb[index] and 0xff shr 0
                Y = (66 * R + 129 * G + 25 * B + 128 shr 8) + 16
                U = (-38 * R - 74 * G + 112 * B + 128 shr 8) + 128
                V = (112 * R - 94 * G - 18 * B + 128 shr 8) + 128
                yuv420sp[yIndex++] = (if (Y < 0) 0 else if (Y > 255) 255 else Y).toByte()
                if (j % 2 == 0 && index % 2 == 0) {
                    yuv420sp[uvIndex++] = (if (V < 0) 0 else if (V > 255) 255 else V).toByte()
                    yuv420sp[uvIndex++] = (if (U < 0) 0 else if (U > 255) 255 else U).toByte()
                }
                index++
            }
        }
    }


    companion object {
        private const val TAG = "CameraXLivePreview"
        private const val PERMISSION_REQUESTS = 1

        private fun isPermissionGranted(
            context: Context,
            permission: String?
        ): Boolean {
            if (ContextCompat.checkSelfPermission(context, permission!!)
                == PackageManager.PERMISSION_GRANTED
            ) {
                Log.i(TAG, "Permission granted: $permission")
                return true
            }
            Log.i(TAG, "Permission NOT granted: $permission")
            return false
        }
    }

}