package com.codepath.apps.mysimpletweet;

import android.content.Context;
import android.util.Log;

import com.codepath.apps.mysimpletweet.models.Tweet;
import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.TwitterApi;

/*
 *
 * This is the object responsible for communicating with a REST API.
 * Specify the constants below to change the API being communicated with.
 * See a full list of supported API classes:
 *   https://github.com/fernandezpablo85/scribe-java/tree/master/src/main/java/org/scribe/builder/api
 * Key and Secret are provided by the developer site for the given API i.e dev.twitter.com
 * Add methods for each relevant endpoint in the API.
 *
 * NOTE: You may want to rename this object based on the service i.e TwitterClient or FlickrClient
 *
 */
public class RestClient extends OAuthBaseClient {
	public static final Class<? extends Api> REST_API_CLASS = TwitterApi.class; // Change this
	public static final String REST_URL = "https://api.twitter.com/1.1/"; // Change this, base API URL
	public static final String REST_CONSUMER_KEY = "fHzaEX4JhOa38HEkNoHKLXCJk";       // Change this
	public static final String REST_CONSUMER_SECRET = "gBMbjlugtTPb21tAri6PT3UyuOMNDTpOqaW4ZNcvTylmPZkWRI"; // Change this
	public static final String REST_CALLBACK_URL = "oauth://CPTweetAppBasic"; // Change this (here and in manifest)

	public RestClient(Context context) {
		super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
	}
	// CHANGE THIS
	// DEFINE METHODS for different API endpoints here
	public void getHomeTimeline( AsyncHttpResponseHandler handler,int page){
		String apiUrl = getApiUrl("statuses/home_timeline.json");
		RequestParams params = new RequestParams();
		params.put("count",25);
		params.put("since_id",1);
		params.put("page",page);
		getClient().get(apiUrl, params, handler);

	}
	public void postTweet(String body, AsyncHttpResponseHandler handler) {
		String apiUrl = getApiUrl("statuses/update.json");
		RequestParams params = new RequestParams();
		params.put("status", body);
		getClient().post(apiUrl, params, handler);
	}

	public void getMentionTimelines(AsyncHttpResponseHandler handler)
	{
		String apiUrl = getApiUrl("statuses/mentions_timeline.json");
		RequestParams params = new RequestParams();
		params.put("since_id",1);
		getClient().get(apiUrl, params, handler);
	}
	public void performFavorite(Tweet tweet, AsyncHttpResponseHandler handler) {
		RequestParams params = new RequestParams();
		params.put("id", tweet.getUid());
		Log.d("id1","id2"+tweet.getUid());
		String apiUrl = getApiUrl("favorites/create.json");
		getClient().post(apiUrl, params, handler);
	}
	/* 1. Define the endpoint URL with getApiUrl and pass a relative path to the endpoint
	 * 	  i.e getApiUrl("statuses/home_timeline.json");
	 * 2. Define the parameters to pass to the request (query or body)
	 *    i.e RequestParams params = new RequestParams("foo", "bar");
	 * 3. Define the request method and make a call to the client
	 *    i.e client.get(apiUrl, params, handler);
	 *    i.e client.post(apiUrl, params, handler);
	 */

}