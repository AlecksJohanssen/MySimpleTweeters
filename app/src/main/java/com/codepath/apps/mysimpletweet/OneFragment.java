package com.codepath.apps.mysimpletweet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.apps.mysimpletweet.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;

import java.util.ArrayList;

public class OneFragment extends Fragment {
        private TweetArrayAdapter adapter;
        private RecyclerView rvItems;
        public TimelineActivity timeline;
        private int page;
        private ArrayList<Tweet> tweets;


    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View v = layoutInflater.inflate(R.layout.fragment_one, null);
        tweets = new ArrayList<>();
        adapter = new TweetArrayAdapter(tweets);
        rvItems = (RecyclerView) v.findViewById(R.id.rvItems);
        rvItems.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvItems.setAdapter(adapter);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        populateTimeline(page);
    }

    public void populateTimeline(int page) {
        RestApplication.getRestClient().getHomeTimeline(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                Log.d("DEBUG", response.toString());
                tweets.addAll(Tweet.fromJSONArray(response));

                Log.d("DEBUG", "null " + (tweets.size()));
                adapter.updateTweets(tweets);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
            }
        }, page);
    }



}