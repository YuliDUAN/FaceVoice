package com.iflytek.wangzhan;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.iflytek.voicedemo.R;

public class WbActivity extends AppCompatActivity {
    private WebView mWvMain1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wb);
        mWvMain1= (WebView) findViewById(R.id.wv_1);

        mWvMain1.getSettings().setJavaScriptEnabled(true);
        mWvMain1.setWebViewClient(new WebViewActivity.MyWebViewClinet());
       //mWvMain1.setWebChromeClient(new WebViewActivity.MyWebChromeClient());
        mWvMain1.loadUrl("http://bj.cltt.org/Web/SignUpOnLine/SingUp.aspx");

    }
    class MyWebViewClinet extends WebViewClient {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }
    }

    class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK&&mWvMain1.canGoBack())
        {
            mWvMain1.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
