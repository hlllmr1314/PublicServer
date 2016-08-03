package com.haley.appserver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import com.haley.appserver.controller.net.request.GetIdCardRequest;
import com.haley.appserver.controller.net.request.RequestCallBack;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.number_webview)
    WebView webView;
    @Bind(R.id.number_et)
    EditText numberEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    public void search(View view) {
        GetIdCardRequest.requestIdCard(numberEt.getText().toString(), new RequestCallBack() {
            @Override
            public void back(boolean success, Object obj) {
                webView.loadDataWithBaseURL(null,
                        (String) obj,
                        "text/html",
                        "utf-8",
                        null);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
