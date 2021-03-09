package com.tuoku.parliament.logic.utils

/*
 * Copyright 2020 Google LLC. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.face.*
import com.google.mlkit.vision.face.FaceDetector
import com.tuoku.parliament.views.ui.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.pow
import kotlin.math.sqrt

/** Face Detector Demo.  */
class FaceDetectorProcessor(context: Context, detectorOptions: FaceDetectorOptions?) :
    VisionProcessorBase<List<Face>>(context) {

    val detector: FaceDetector
    private val model = FaceNetModel(context)
    var faceList = ArrayList<Pair<String, FloatArray>>()
    private var mImg: InputImage? = null

    init {
        val options = detectorOptions
            ?: FaceDetectorOptions.Builder()
                .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL)
                .enableTracking()
                .build()

        detector = FaceDetection.getClient(options)

        Log.v(MANUAL_TESTING_LOG, "Face detector options: $options")
    }

    override fun stop() {
        super.stop()
        detector.close()
    }

    override fun detectInImage(image: InputImage): Task<List<Face>> {

        return detector.process(image)
    }

    override fun onSuccess(faces: List<Face>, graphicOverlay: GraphicOverlay) {
        for (face in faces) {
            graphicOverlay.add(FaceGraphic(graphicOverlay, face))
            logExtrasForTesting(face)
            FaceGraphic.faces.add(face)
        }

    }

    private fun bitmapToFile(bitmap: Bitmap): Uri {
        // Get the context wrapper
        val wrapper = ContextWrapper(MainActivity.getCon())

        // Initialize a new file instance to save bitmap object
        var file = wrapper.getDir("Images", Context.MODE_PRIVATE)
        file = File(file, "bmpToTest.jpg")

        try {
            // Compress the bitmap and save in jpg format
            val stream: OutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            stream.flush()
            stream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        // Return the saved bitmap uri
        return Uri.parse(file.absolutePath)
    }

    override fun onFailure(e: Exception) {
        Log.e("PROC", "Face detection failed $e")
    }

    suspend fun runModel(face: Face, cameraFrameBitmap: Bitmap): String {
        var finalID = "aa"
        withContext(Dispatchers.Default) {
            val predictions = ArrayList<com.tuoku.parliament.logic.models.Prediction>()

            try {
                // Crop the frame using face.boundingBox.
                // Convert the cropped Bitmap to a ByteBuffer.
                // Finally, feed the ByteBuffer to the FaceNet model.
                val subject = model.getFaceEmbeddingWithoutBBox(cameraFrameBitmap)
                Log.i("Model", "New frame received.")

                // Perform clustering ( grouping )
                // Store the clusters in a HashMap. Here, the key would represent the 'name'
                // of that cluster and ArrayList<Float> would represent the collection of all
                // L2 norms.
                val nameScoreHashmap = HashMap<String, ArrayList<Float>>()
                for (i in 0 until faceList.size) {
                    // If this cluster ( i.e an ArrayList with a specific key ) does not exist,
                    // initialize a new one.
                    if (nameScoreHashmap[faceList[i].first] == null) {
                        // Compute the L2 norm and then append it to the ArrayList.
                        val p = ArrayList<Float>()
                        p.add(cosineSimilarity(subject, faceList[i].second))
                        nameScoreHashmap[faceList[i].first] = p
                    }

                    // If this cluster exists, append the L2 norm to it.
                    else {
                        nameScoreHashmap[faceList[i].first]?.add(
                            cosineSimilarity(
                                subject,
                                faceList[i].second
                            )
                        )
                    }
                }
                // Compute the average of all scores norms for each cluster.
                val avgScores = nameScoreHashmap.values.map { scores ->
                    scores.toFloatArray().average()
                }
                Log.i("Model", "Average score for each user : $nameScoreHashmap")
                // Get the names of unique users
                val names = nameScoreHashmap.keys.map { key -> key }

                // Calculate the minimum L2 distance from the stored average L2 norms.
                var bestScoreUserName: String
                bestScoreUserName = names[avgScores.indexOf(avgScores.maxOrNull()!!)]


                Log.i("Model", "Person identified as ${bestScoreUserName}")
                // Push the results in form of a Prediction.
                finalID = bestScoreUserName
                predictions.add(
                    com.tuoku.parliament.logic.models.Prediction(
                        face.boundingBox,
                        bestScoreUserName
                    )
                )
            } catch (e: Exception) {
                // If any exception occurs with this box and continue with the next boxes.
                Log.e("Model", "Exception in FrameAnalyser : ${e.message}")
            }

            withContext(Dispatchers.Main) {
                // Clear the BoundingBoxOverlay and set the new results ( boxes ) to be displayed.
                // boundingBoxOverlay.faceBoundingBoxes = predictions
                //boundingBoxOverlay.invalidate()

                // Declare that the processing has been finished and the system is ready for the next frame.
                //isProcessing.set(false)
            }
        }
        return finalID
    }

    // Compute the cosine of the angle between x1 and x2.
    fun cosineSimilarity(x1: FloatArray, x2: FloatArray): Float {
        var dotProduct = 0.0f
        var mag1 = 0.0f
        var mag2 = 0.0f
        var sum = 0.0f
        for (i in x1.indices) {
            dotProduct += (x1[i] * x2[i])
            mag1 += x1[i].toDouble().pow(2.0).toFloat()
            mag2 += x2[i].toDouble().pow(2.0).toFloat()
            sum += (x1[i] - x2[i]).pow(2)
        }
        mag1 = sqrt(mag1)
        mag2 = sqrt(mag2)
        return dotProduct / (mag1 * mag2)
    }


    companion object {
        private const val TAG = "FaceDetectorProcessor"
        private fun logExtrasForTesting(face: Face?) {
            if (face != null) {
                Log.v(
                    MANUAL_TESTING_LOG,
                    "face bounding box: " + face.boundingBox.flattenToString()
                )
                Log.v(
                    MANUAL_TESTING_LOG,
                    "face Euler Angle X: " + face.headEulerAngleX
                )
                Log.v(
                    MANUAL_TESTING_LOG,
                    "face Euler Angle Y: " + face.headEulerAngleY
                )
                Log.v(
                    MANUAL_TESTING_LOG,
                    "face Euler Angle Z: " + face.headEulerAngleZ
                )
                // All landmarks
                val landMarkTypes = intArrayOf(
                    FaceLandmark.MOUTH_BOTTOM,
                    FaceLandmark.MOUTH_RIGHT,
                    FaceLandmark.MOUTH_LEFT,
                    FaceLandmark.RIGHT_EYE,
                    FaceLandmark.LEFT_EYE,
                    FaceLandmark.RIGHT_EAR,
                    FaceLandmark.LEFT_EAR,
                    FaceLandmark.RIGHT_CHEEK,
                    FaceLandmark.LEFT_CHEEK,
                    FaceLandmark.NOSE_BASE
                )
                val landMarkTypesStrings = arrayOf(
                    "MOUTH_BOTTOM",
                    "MOUTH_RIGHT",
                    "MOUTH_LEFT",
                    "RIGHT_EYE",
                    "LEFT_EYE",
                    "RIGHT_EAR",
                    "LEFT_EAR",
                    "RIGHT_CHEEK",
                    "LEFT_CHEEK",
                    "NOSE_BASE"
                )
                for (i in landMarkTypes.indices) {
                    val landmark = face.getLandmark(landMarkTypes[i])
                    if (landmark == null) {
                        Log.v(
                            MANUAL_TESTING_LOG,
                            "No landmark of type: " + landMarkTypesStrings[i] + " has been detected"
                        )
                    } else {
                        val landmarkPosition = landmark.position
                        val landmarkPositionStr =
                            String.format(
                                Locale.US,
                                "x: %f , y: %f",
                                landmarkPosition.x,
                                landmarkPosition.y
                            )
                        Log.v(
                            MANUAL_TESTING_LOG,
                            "Position for face landmark: " +
                                    landMarkTypesStrings[i] +
                                    " is :" +
                                    landmarkPositionStr
                        )
                    }
                }
                Log.v(
                    MANUAL_TESTING_LOG,
                    "face left eye open probability: " + face.leftEyeOpenProbability
                )
                Log.v(
                    MANUAL_TESTING_LOG,
                    "face right eye open probability: " + face.rightEyeOpenProbability
                )
                Log.v(
                    MANUAL_TESTING_LOG,
                    "face smiling probability: " + face.smilingProbability
                )
                Log.v(
                    MANUAL_TESTING_LOG,
                    "face tracking id: " + face.trackingId
                )
            }
        }
    }
}
