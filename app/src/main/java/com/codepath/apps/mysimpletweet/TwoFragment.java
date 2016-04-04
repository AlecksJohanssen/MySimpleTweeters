package com.codepath.apps.mysimpletweet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
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
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.Bind;


public class TwoFragment extends Fragment{
    private SwipeRefreshLayout swipeContainer;
    private MentionsAdapter adapter;
    private RecyclerView rvItems;
    public TimelineActivity timeline;
    private int page;
    private ArrayList<Tweet> tweets;
    public TwoFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View v = layoutInflater.inflate(R.layout.fragment_two, null);
        tweets = new ArrayList<>();
        adapter = new MentionsAdapter(tweets);
        swipeContainer = (SwipeRefreshLayout) v.findViewById(R.id.swipeContainer2);
        rvItems = (RecyclerView) v.findViewById(R.id.rvItems2);
        rvItems.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvItems.setAdapter(adapter);
        return v;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getMentions();
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.clear();
                getMentions();
                swipeContainer.setEnabled(true);
                adapter.addAll(tweets);
                adapter.notifyDataSetChanged();
            }
        });
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }

    public void getMentions()
    {
        RestApplication.getRestClient().getMentionTimelines(new JsonHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray
                    jsonArray)
            {
                Log.d("DEBUG", jsonArray.toString());
                tweets.addAll(Tweet.fromJSONArray(jsonArray));
                Log.d("DEBUG", "null " + (tweets.size()));
                adapter.notifyDataSetChanged();
                swipeContainer.setRefreshing(false);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }

}
