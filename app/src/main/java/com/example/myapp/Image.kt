package com.example.myapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class Image : AppCompatActivity() {

    private val CAMERA_PERMISSION_REQUEST_CODE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val requestPermissionButton: Button = findViewById(R.id.request_permission_button)

        // Set an OnClickListener to the button
        requestPermissionButton.setOnClickListener(View.OnClickListener {
            // Check if the camera permission has been granted
            if (ContextCompat.checkSelfPermission(this@Image, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
                // You have camera permission, you can proceed with camera-related operations.
            } else {
                // Request camera permission
                ActivityCompat.requestPermissions(this@Image,
                    arrayOf(Manifest.permission.CAMERA),
                    CAMERA_PERMISSION_REQUEST_CODE)
            }
        })
    }

    // Handle the result of the permission request
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Camera permission granted, you can proceed with camera-related operations.
            } else {
                // Camera permission denied, handle accordingly (e.g., show a message to the user).
            }
        }
    }
}
