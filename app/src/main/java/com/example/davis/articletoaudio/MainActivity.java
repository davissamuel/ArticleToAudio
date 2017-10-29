package com.example.davis.articletoaudio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnGet = findViewById(R.id.btnGet);
        EditText URL = findViewById(R.id.URL);
        if (URL.getText() != null) {
            btnGet.setOnClickListener(this);
        }
    }

    /*
    @Override
    public void onClick(final View v) {
        EditText URL = findViewById(R.id.URL);
        String urlString = URL.getText().toString();
        v.setEnabled(false);
        final AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://api.diffbot.com/v3/article?token=ca4574ef7f0d608cbf2a167783349894&url=" + urlString, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (responseBody != null) {
                    TextView txtResponse = findViewById(R.id.txtResponse);
                    assert txtResponse != null;
                    txtResponse.setText(new String(responseBody));
                }
                v.setEnabled(true);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                v.setEnabled(true);
            }
        });
    }
    */

    public void onClick(final View v) {
        EditText URL = findViewById(R.id.URL);
        String urlString = URL.getText().toString();
        v.setEnabled(false);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://api.diffbot.com/v3/article?token=ca4574ef7f0d608cbf2a167783349894&url=" + urlString, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                v.setEnabled(true);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                v.setEnabled(true);
                
            }
        });
    }
}
