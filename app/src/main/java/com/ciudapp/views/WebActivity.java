package com.ciudapp.views;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.ciudapp.R;
import com.ciudapp.managers.Listeners.ListenWeb;


public class WebActivity extends AppCompatActivity {
    /*
    variables
     */
    private WebView webView;
    private ListenWeb listenWeb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        listenWeb = new ListenWeb(this);
        cargarComponentes();;
    }

    public void cargarComponentes(){
        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("http://margaesnoz.com/CiudAPP/");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (Uri.parse(url).getHost().contains(".es")) {
                    return false;
                } else {

                    return true;
                }
            }
        });


    }

    public WebView getWebView() {
        return webView;
    }

    public void setWebView(WebView webView) {
        this.webView = webView;
    }
}



