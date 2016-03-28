package com.codepath.apps.mysimpletweet;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.codepath.apps.mysimpletweet.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TimelineActivity extends AppCompatActivity {
    private RestClient client;
    private ArrayList<Tweet> Tweet;
    private TweetArrayAdapter taAdapter;
    private RecyclerView rvItems;
    String body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        rvItems = (RecyclerView) findViewById(R.id.rvItems);
        Tweet = new ArrayList<>();
        taAdapter = new TweetArrayAdapter(Tweet);
        rvItems.setAdapter(taAdapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        client = RestApplication.getRestClient();
        populateTimeline(1);
        rvItems.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TimelineActivity.this, posttwt.class);
                startActivity(intent);
            }

        });

                rvItems.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
                    @Override
                    public void onLoadMore(int page, int totalItemsCount) {
                        populateTimeline(page);
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }
    public void doThis(MenuItem item){
        Intent intent = new Intent(TimelineActivity.this, posttwt.class);
        startActivity(intent);
    }

    private void populateTimeline(int page) {
         client.getHomeTimeline(new JsonHttpResponseHandler(){
             @Override
             public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                 Log.d("debug", response.toString());
                 Tweet.addAll(com.codepath.apps.mysimpletweet.models.Tweet.fromJSONArray(response));
                 int curSize = taAdapter.getItemCount();
                 taAdapter.notifyItemRangeInserted(curSize, Tweet.size() - 1);
             }

             @Override
             public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                 Log.d("DEBUG",errorResponse.toString());
             }
         },page);
    }

    }
