package com.codepath.apps.mysimpletweet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONObject;

/**
 * Created by AlecksJohanssen on 3/28/2016.
 */
public class posttwt extends AppCompatActivity{
    private RestClient client;
    Button btn;
    String body;
    EditText edt;
    public void postTweet(String body)
    {

        client.postTweet(body, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(posttwt.this, "RIP it happen", Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        body = String.valueOf(edt = (EditText) findViewById(R.id.posttwt));
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postTweet(body);
            }
        });
    }


}
