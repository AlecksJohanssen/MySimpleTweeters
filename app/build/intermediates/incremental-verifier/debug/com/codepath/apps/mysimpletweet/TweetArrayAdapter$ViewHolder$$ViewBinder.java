// Generated code from Butter Knife. Do not modify!
package com.codepath.apps.mysimpletweet;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class TweetArrayAdapter$ViewHolder$$ViewBinder<T extends com.codepath.apps.mysimpletweet.TweetArrayAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427451, "field 'ivProfile'");
    target.ivProfile = finder.castView(view, 2131427451, "field 'ivProfile'");
    view = finder.findRequiredView(source, 2131427452, "field 'tvUsername'");
    target.tvUsername = finder.castView(view, 2131427452, "field 'tvUsername'");
    view = finder.findRequiredView(source, 2131427458, "field 'tvBody'");
    target.tvBody = finder.castView(view, 2131427458, "field 'tvBody'");
    view = finder.findRequiredView(source, 2131427453, "field 'tvSName'");
    target.tvSName = finder.castView(view, 2131427453, "field 'tvSName'");
    view = finder.findRequiredView(source, 2131427456, "field 'ivNew'");
    target.ivNew = finder.castView(view, 2131427456, "field 'ivNew'");
    view = finder.findRequiredView(source, 2131427457, "field 'tvDate'");
    target.tvDate = finder.castView(view, 2131427457, "field 'tvDate'");
    view = finder.findRequiredView(source, 2131427459, "field 'ivFavorite'");
    target.ivFavorite = finder.castView(view, 2131427459, "field 'ivFavorite'");
  }

  @Override public void unbind(T target) {
    target.ivProfile = null;
    target.tvUsername = null;
    target.tvBody = null;
    target.tvSName = null;
    target.ivNew = null;
    target.tvDate = null;
    target.ivFavorite = null;
  }
}
