package com.example.wordbook

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.KeyEvent
import android.view.View


class Zoom(context: Context, imageUrl: Int) : View(context) {
    private var image: Drawable? = context.getDrawable(imageUrl)
    private var zoomController = 20

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //here u can control the width and height of the images........ this line is very important
        image?.setBounds(
            width / 2 - zoomController,
            height / 2 - zoomController,
            width / 2 + zoomController,
            height / 2 + zoomController
        )
        image?.draw(canvas!!)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_DPAD_UP -> zoomController += 10
            KeyEvent.KEYCODE_DPAD_DOWN -> zoomController -= 10
            else -> if (zoomController < 10) zoomController = 10
        }
        invalidate()
        return true
    }

    fun setImageBitmap(bitmap: Bitmap) {
        image = BitmapDrawable(bitmap)
    }
    fun setImageURI(uri: Uri?) {

    }
}