package com.example.wordbook

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment

class CameraFragment() : Fragment() {
    private val TAG = "camera"
    private val TAKE_PICTURE = 1
    private val GET_PICTURE = 2

    private lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_camera, container, false)

        imageView = view.findViewById(R.id.imageView)
        val btnCamera = view.findViewById<ImageButton>(R.id.btnCamera)
        val btnAlbum = view.findViewById<ImageButton>(R.id.btnAlbum)

        btnCamera.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, TAKE_PICTURE)
        }
        btnAlbum.setOnClickListener {
            val albumIntent = Intent(Intent.ACTION_GET_CONTENT)
            albumIntent.type = "image/*"
            startActivityForResult(albumIntent, GET_PICTURE)
        }

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            TAKE_PICTURE -> if (resultCode == Activity.RESULT_OK && data!!.hasExtra("data")) {
                val bitmap = data.extras?.get("data") as Bitmap?
                if (bitmap != null) imageView.setImageBitmap(bitmap)
            }
            GET_PICTURE -> if (resultCode == Activity.RESULT_OK && data != null) {
                imageView.setImageURI(data.data)
            }
        }
    }

    private fun zoomImage() {

    }
}
