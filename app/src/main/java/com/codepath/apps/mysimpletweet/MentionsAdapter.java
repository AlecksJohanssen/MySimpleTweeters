package com.codepath.apps.mysimpletweet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.mysimpletweet.models.Tweet;
import com.codepath.apps.mysimpletweet.models.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by AlecksJohanssen on 3/26/2016.
 */
public class MentionsAdapter extends RecyclerView.Adapter<MentionsAdapter.ViewHolder> {
    Context context;
    View tweetView;

    private List<Tweet> lTweets;
    public MentionsAdapter(List<Tweet> tweets)
    {
        lTweets = tweets;
    }
    public void clear() {
        lTweets.clear();
        notifyDataSetChanged();
    }

    // Add a list of items
    public void addAll(List<Tweet> list) {
        lTweets.addAll(list);
        notifyDataSetChanged();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.ivAva) ImageView ivProfile;
        @Bind(R.id.tvName) TextView tvUsername;
        @Bind(R.id.tvMentions) TextView tvMentions;
        @Bind(R.id.tvMentionsDate) TextView tvMentionsDate;
        @Bind(R.id.ivPictures) ImageView ivNew;
        @Bind(R.id.tvScreenName) TextView tvSName;
        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
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
        tweetView = inflater.inflate(R.layout.item_metions, parent, false);
        ViewHolder viewHolder = new ViewHolder(tweetView);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("debug", "int:: " + position);
        Tweet tweet = lTweets.get(position);
        holder.tvMentionsDate.setText(tweet.getRelativeTimeAgo());
        holder.tvUsername.setText(tweet.getUser().getName());
        holder.ivProfile.setImageResource(android.R.color.transparent);
        holder.tvMentions.setText(tweet.textMentions);
        Glide.with(context).load(tweet.getUser().getProfileImageUrl()).into(holder.ivProfile);
        Glide.with(context).load(tweet.getUser().getProfileImageUrl()).into(holder.ivNew);
        holder.tvSName.setText("@"+tweet.getUser().getScreenname());
    }

    @Override
    public int getItemCount() {
        if(lTweets == null){
            Log.d("debug", "null");
            return 0;
        }
        else {
            Log.d("debug", ":: " + lTweets.size());
            return lTweets.size();
        }
    }
}

