package com.example.retrofitsampleapp.ui.screens.takePictures

import android.graphics.Color
import android.view.ViewGroup
import android.widget.Toast
import androidx.camera.core.ImageCapture
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import java.util.concurrent.Executor

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CamaraScreen() {
    val cameraPermissionSate: PermissionState =
        rememberPermissionState(android.Manifest.permission.CAMERA)

    LaunchedEffect(key1 = Unit) {
        if (!cameraPermissionSate.status.isGranted && !cameraPermissionSate.status.shouldShowRationale) {
            cameraPermissionSate.launchPermissionRequest()
        }
    }

    if (cameraPermissionSate.status.isGranted) {
        CamaraPreview()
    } else {
        Toast.makeText(LocalContext.current, "Need Camera Permissions!!", Toast.LENGTH_SHORT).show()
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun CamaraPreview() {
    val context = LocalContext.current
    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
    val cameraController: LifecycleCameraController =
        remember { LifecycleCameraController(context) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                val mainExecutor: Executor = ContextCompat.getMainExecutor(context)
                cameraController.takePicture(mainExecutor,
                    object : ImageCapture.OnImageCapturedCallback() {

                    })
            }) {
                Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "")
            }
        }
    ) { paddingValues ->
        AndroidView(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
            factory = { context ->
                PreviewView(context).apply {
                    setBackgroundColor(Color.WHITE)
                    implementationMode = PreviewView.ImplementationMode.COMPATIBLE
                    scaleType = PreviewView.ScaleType.FILL_START
                }.also { previewView ->
                    previewView.controller = cameraController
                    cameraController.bindToLifecycle(lifecycleOwner)
                }
            },
            onRelease = {
                cameraController.unbind()
            },
            onReset = {

            }
        )
    }
}