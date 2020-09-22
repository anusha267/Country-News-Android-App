package com.anushabhattacharya.countrynewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class OpenNews extends AppCompatActivity {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_news);
        Intent intent = getIntent();
        webview=findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());
        String url1=intent.getStringExtra("url");
        if(url1!=null) {
            webview.setVisibility(View.VISIBLE);
            openWebView(url1);
        }else
        {
            webview.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Error loading data! Please check your network connection!", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }


    }

    private void openWebView(String url) {

        WebSettings webSettings=webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webview.loadUrl(url);

    }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack()){
            webview.goBack();
        }else {
            super.onBackPressed();
        }
    }
}