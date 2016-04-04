// Generated code from Butter Knife. Do not modify!
package com.codepath.apps.mysimpletweet;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class TweetArrayAdapter$ViewHolder$$ViewBinder<T extends com.codepath.apps.mysimpletweet.TweetArrayAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427450, "field 'ivProfile'");
    target.ivProfile = finder.castView(view, 2131427450, "field 'ivProfile'");
    view = finder.findRequiredView(source, 2131427451, "field 'tvUsername'");
    target.tvUsername = finder.castView(view, 2131427451, "field 'tvUsername'");
    view = finder.findRequiredView(source, 2131427456, "field 'tvBody'");
    target.tvBody = finder.castView(view, 2131427456, "field 'tvBody'");
    view = finder.findRequiredView(source, 2131427455, "field 'ivNew'");
    target.ivNew = finder.castView(view, 2131427455, "field 'ivNew'");
    view = finder.findRequiredView(source, 2131427454, "field 'tvDate'");
    target.tvDate = finder.castView(view, 2131427454, "field 'tvDate'");
  }

  @Override public void unbind(T target) {
    target.ivProfile = null;
    target.tvUsername = null;
    target.tvBody = null;
    target.ivNew = null;
    target.tvDate = null;
  }
}
