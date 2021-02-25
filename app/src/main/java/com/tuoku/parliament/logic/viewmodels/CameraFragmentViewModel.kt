package com.tuoku.parliament.logic.viewmodels

import android.app.Application
import android.util.Log
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tuoku.parliament.views.ui.MainActivity
import java.util.concurrent.ExecutionException

class CameraFragmentViewModel : ViewModel() {

        val TAG = "CameraFragmentViewModel"
        var cameraProviderLiveData: MutableLiveData<ProcessCameraProvider>? = null

        fun getProcessCameraProvider(): LiveData<ProcessCameraProvider>? {
            if (cameraProviderLiveData == null) {
                cameraProviderLiveData = MutableLiveData()
                val cameraProviderFuture =
                    ProcessCameraProvider.getInstance(MainActivity.getCon().applicationContext)
                cameraProviderFuture.addListener(
                    {
                        try {
                            cameraProviderLiveData!!.setValue(cameraProviderFuture.get())
                        } catch (e: ExecutionException) {
                            // Handle any errors (including cancellation) here.
                            Log.e(TAG, "Unhandled exception", e)
                        } catch (e: InterruptedException) {
                            Log.e(TAG, "Unhandled exception", e)
                        }
                    },
                    ContextCompat.getMainExecutor(MainActivity.getCon().applicationContext)
                )
            }
            return cameraProviderLiveData
        }
}