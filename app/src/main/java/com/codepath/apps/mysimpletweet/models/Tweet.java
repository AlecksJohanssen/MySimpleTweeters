package com.codepath.apps.mysimpletweet.models;

import android.text.format.DateUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by AlecksJohanssen on 3/26/2016.
 */
public class Tweet {
    public String body;
    private long uid;
    private String createAt;
    private User user;
    private String urlImageNews;
    private static String url;
    public ArrayList<User> mentions;
    public String textMentions;
    public String getTextMentions()
    {
        return textMentions;
    }
    public String getUrlImageNews()
    {
        return urlImageNews;
    }
    public String getBody() {
        return body;
    }

    public long getUid() {
        return uid;
    }

    public String getCreateAt() {
        return createAt;
    }
    public User getUser() {
        return user;
    }
    public String getUrl()
    {
        return url;
    }
    public String getRelativeTimeAgo() {
        String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
        SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.getDefault());
        sf.setLenient(true);
        String relativeDate = "";
        try {
            long dateMillis = sf.parse(getCreateAt()).getTime();
            relativeDate = DateUtils.getRelativeTimeSpanString(dateMillis,
                    System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return relativeDate;
    }
    public static Tweet fromJSON(JSONObject jsonObject)
    {
        Tweet twt = new Tweet();
        try {
            twt.body = jsonObject.getString("text");
            twt.uid = jsonObject.getLong("id");
            twt.createAt = jsonObject.getString("created_at");
            twt.user = User.fromJSON(jsonObject.getJSONObject("user"));
            twt.mentions = LoadMentions(jsonObject);
            twt.textMentions = jsonObject.getString("text");
            JSONArray media = jsonObject.getJSONObject("entities").optJSONArray("media");
            if (media != null) {
                for (int i = 0; i < media.length(); i++) {
                    JSONObject a = media.getJSONObject(i);
                    if (a.getString("type").equals("photo")) {
                        twt.urlImageNews = a.getString("media_url_https");

                    }

                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return twt;
    }
    private static ArrayList<User> LoadMentions(JSONObject object) throws JSONException{
        if (!object.getJSONObject("entities").has("user_mentions")) {
            return  null;
        }

        ArrayList<User> mentions = new ArrayList<User>();
        JSONArray mentionsJSON = object.getJSONObject("entities").getJSONArray("user_mentions");
        for (int i = 0; i < mentionsJSON.length(); i++) {
            User user = User.fromJSON(mentionsJSON.getJSONObject(i));
            mentions.add(user);
        }
        return mentions;

    }
    public static ArrayList<Tweet> fromJSONArray(JSONArray jsonArray)
    {
        ArrayList<Tweet> tweets = new ArrayList<>();
        for ( int i = 0 ; i < jsonArray.length(); i++)
        {
            try {
                JSONObject tweetjson = jsonArray.getJSONObject(i);
                Tweet tweet = Tweet.fromJSON(tweetjson);
                if(tweet != null)
                {

                    tweets.add(tweet);
                }

            } catch (JSONException e) {
                e.printStackTrace();
                continue;
            }
        }
        return tweets;
    }
}
