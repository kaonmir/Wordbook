package com.example.wordbook

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.fragment.app.Fragment

class DictionaryFragment : Fragment() {
    private val TAG = "DictionaryFragment"

    private var mWebView: WebView? = null
    private lateinit var mWebSettings: WebSettings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dictionary, container, false)

        mWebView = view.findViewById(R.id.webView)

        mWebSettings = mWebView!!.settings
        mWebSettings.javaScriptEnabled = true
        mWebSettings.useWideViewPort = true

        mWebView!!.loadUrl("https://dic.daum.net/")
        Log.d(TAG, "load url successfully")

        return view
    }
}
