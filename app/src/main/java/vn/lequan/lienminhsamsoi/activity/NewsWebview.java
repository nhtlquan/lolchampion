package vn.lequan.lienminhsamsoi.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;

import vn.lequan.lienminhsamsoi.AdvancedWebView;
import vn.lequan.lienminhsamsoi.Debug;
import vn.lequan.lienminhsamsoi.R;

public class NewsWebview extends AppCompatActivity {
    AdvancedWebView webView;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        setContentView(R.layout.activity_news_webview);
        button2 = (Button) findViewById(R.id.button2);

        webView = (AdvancedWebView) findViewById(R.id.help_webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        webView.loadUrl("https://lienminh.garena.vn/" + getIntent().getStringExtra("link"));
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
