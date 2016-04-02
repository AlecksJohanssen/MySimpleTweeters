package com.codepath.apps.mysimpletweet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.codepath.apps.mysimpletweet.models.Tweet;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by AlecksJohanssen on 4/1/2016.
 */
@SuppressLint("ValidFragment")
public class PostTweetDialog extends DialogFragment  {
    private RestClient client;
    private PostTweetInterface dialogFragment;
    ArrayList<Tweet> tweets;
    TweetArrayAdapter adapter;
    String body;
    private EditText etComposeTweet;
    @SuppressLint("ValidFragment")
    public PostTweetDialog(RestClient client) {
        this.client = client;
    }
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.post_tweet, null);
        tweets = new ArrayList<>();
        adapter = new TweetArrayAdapter(tweets);
        AlertDialog.Builder TweetDialog = new AlertDialog.Builder(getActivity());
        TweetDialog.setTitle("Post Tweet");
        TweetDialog.setView(dialogView)
                .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        etComposeTweet = (EditText) dialogView.findViewById(R.id.posttxt);
                        body = etComposeTweet.getText().toString();
                        client.postTweet(body, new JsonHttpResponseHandler() {
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, JSONObject json) {
                                Tweet myNewTweet = Tweet.fromJSON(json);
                                tweets.add(0,myNewTweet);
                                adapter.notifyItemInserted(0);
                            }
                            @Override
                            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                                Log.d("Madness", errorResponse.toString());
                            }

                        });

                    }

                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialogFragment.onDialogNegativeClick(PostTweetDialog.this);
            }
        });
        return TweetDialog.create();

    }

}
