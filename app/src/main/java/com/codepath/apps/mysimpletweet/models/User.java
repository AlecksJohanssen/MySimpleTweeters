package com.codepath.apps.mysimpletweet.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by AlecksJohanssen on 3/26/2016.
 */
public class User {
    private String name;
    private long uid;
    private String screenname;
    private String profileImageUrl;

    public String getName() {
        return name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public long getUid() {
        return uid;
    }

    public String getScreenname() {
        return screenname;
    }

    public  static User fromJSON(JSONObject json)
    {
        User u = new User();

        try {
            u.uid = json.getLong("id");
            u.screenname = json.getString("screen_name");
            u.profileImageUrl = json.getString("profile_image_url");
            u.name = json.getString("name");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return u;
    }
}
