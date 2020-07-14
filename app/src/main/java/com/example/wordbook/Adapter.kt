package com.example.wordbook

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class Adapter(fa: FragmentActivity, private val count: Int): FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> return CameraFragment()
            1 -> return DictionaryFragment()
            2 -> return CameraFragment()
            3 -> return CameraFragment()
        }

        return CameraFragment() // Needless, but for satisfying nullable
    }

    override fun getItemCount(): Int {
        return count
    }

}