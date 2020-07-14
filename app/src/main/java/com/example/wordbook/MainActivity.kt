package com.example.wordbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager.adapter = Adapter(this, 4)
        pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        pager.isUserInputEnabled = false

        bottom_navigation_view.setOnNavigationItemSelectedListener { item ->
            pager.currentItem = when(item.itemId) {
                R.id.action1 -> 1
                R.id.action2 -> 2
                R.id.action3 -> 3
                R.id.action4 -> 4
                else -> 0 // else 가 나오면 그건 오류다.
            } - 1
            true
        }

    }
/*
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CAMERA_PERMISSION -> {
                var i = 0
                while (i < permissions.size) {
                    val permission = permissions[i]
                    val grantResult = grantResults[i]
                    if (permission == Manifest.permission.CAMERA) {
                        if (grantResult == PackageManager.PERMISSION_GRANTED) {
                            mCameraTextureView = findViewById(R.id.camera_preview)
                            mPreview = Preview(this, mCameraTextureView)
                            Log.d(TAG, "mPreview set")
                        } else {
                            Toast.makeText(
                                this,
                                "Should have camera permission to run",
                                Toast.LENGTH_LONG
                            ).show()
                            finish()
                        }
                    }
                    i++
                }
            }
        }
    }
    */

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}