package com.example.myapp

import android.R
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class Upload : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload.xml.xml)

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)

        button1.setOnClickListener { view -> onButtonClick(view) }
        button2.setOnClickListener { view -> onButtonClick(view) }
        button3.setOnClickListener { view -> onButtonClick(view) }
    }

    private fun onButtonClick(view: View) {
        when (view.id) {
            R.id.button1 -> {

            }
            R.id.button2 -> {

            }
            R.id.button3 -> {
                // Registers a photo picker activity launcher in single-select mode.
                val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                    // Callback is invoked after the user selects a media item or closes the
                    // photo picker.
                    if (uri != null) {
                        Log.d("PhotoPicker", "Selected URI: $uri")
                    } else {
                        Log.d("PhotoPicker", "No media selected")
                    }
                }
            // Launch the photo picker and let the user choose only images.
                pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            // Launch the photo picker and let the user choose only images/videos of a
            // specific MIME type, such as GIFs.
                val mimeType = "image/gif"
                pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.SingleMimeType(mimeType)))
            }
}}}