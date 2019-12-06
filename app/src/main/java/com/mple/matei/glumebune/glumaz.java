package com.mple.matei.glumebune;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class glumaz extends AppCompatActivity {
private WebView myWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_glumaz);


        myWeb=(WebView)findViewById(R.id.webView);
        WebSettings webSettings = myWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWeb.loadUrl("https://glumebuneblog.wordpress.com/");










    }
}
