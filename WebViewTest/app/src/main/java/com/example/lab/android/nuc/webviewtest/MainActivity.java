package com.example.lab.android.nuc.webviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = (WebView) findViewById(R.id.web_view);
//        让WebView支持JavaScript脚本
        webView.getSettings().setJavaScriptEnabled(true);
//        当从一个网页跳转到另一个网页的时候，不会打开浏览器，而是仍然在当前WebView中显示
        webView.setWebViewClient(new WebViewClient());
//        打开网页
        webView.loadUrl("http://www.baidu.com");
    }
}
