package com.codepath.apps.mysimpletweet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.mysimpletweet.models.Tweet;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by AlecksJohanssen on 3/26/2016.
 */
public class TweetArrayAdapter extends RecyclerView.Adapter<TweetArrayAdapter.ViewHolder> {
    Context context;
View tweetView;

    private List<Tweet> lTweets;
    public TweetArrayAdapter(List<Tweet> tweets)
    {
        lTweets = tweets;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivProfile;
        private TextView tvUsername;
        private TextView tvBody;
        private ImageView ivNew;
        private TextView tvDate;
        public ViewHolder(View view) {
            super(view);
            ivProfile = (ImageView) view.findViewById(R.id.ivAva);
            tvUsername = (TextView) view.findViewById(R.id.tvName);
            tvBody = (TextView) view.findViewById(R.id.tvBodyText);
            ivNew = (ImageView) view.findViewById(R.id.ivPictures);
            tvDate = (TextView) view.findViewById(R.id.tvDate);
            view.setOnClickListener(this);

        }
        @Override
        public void onClick(View v) {

        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        tweetView = inflater.inflate(R.layout.item_tweets, parent, false);
        ViewHolder viewHolder = new ViewHolder(tweetView);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tweet tweet = lTweets.get(position);
        holder.tvDate.setText(tweet.getRelativeTimeAgo());
        if (tweet.getUrlImageNews() != null && !tweet.getUrlImageNews().isEmpty()) {
            holder.ivNew.setVisibility(View.VISIBLE);
            Picasso.with(context).load(tweet.getUrlImageNews()).fit().into(holder.ivNew);
        } else
            holder.ivNew.setVisibility(View.GONE);
        holder.tvUsername.setText(tweet.getUser().getName());
        holder.tvBody.setText(tweet.getBody());
        holder.ivProfile.setImageResource(android.R.color.transparent);
        Picasso.with(context).load(tweet.getUser().getProfileImageUrl()).into(holder.ivProfile);
    }
    @Override
    public int getItemCount() {
        if(lTweets == null){return 0;}
        else return lTweets.size();
    }
}

