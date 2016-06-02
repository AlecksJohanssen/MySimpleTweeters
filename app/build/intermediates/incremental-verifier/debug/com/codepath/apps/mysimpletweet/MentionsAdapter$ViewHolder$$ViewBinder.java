// Generated code from Butter Knife. Do not modify!
package com.codepath.apps.mysimpletweet;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MentionsAdapter$ViewHolder$$ViewBinder<T extends com.codepath.apps.mysimpletweet.MentionsAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427451, "field 'ivProfile'");
    target.ivProfile = finder.castView(view, 2131427451, "field 'ivProfile'");
    view = finder.findRequiredView(source, 2131427452, "field 'tvUsername'");
    target.tvUsername = finder.castView(view, 2131427452, "field 'tvUsername'");
    view = finder.findRequiredView(source, 2131427455, "field 'tvMentions'");
    target.tvMentions = finder.castView(view, 2131427455, "field 'tvMentions'");
    view = finder.findRequiredView(source, 2131427454, "field 'tvMentionsDate'");
    target.tvMentionsDate = finder.castView(view, 2131427454, "field 'tvMentionsDate'");
    view = finder.findRequiredView(source, 2131427456, "field 'ivNew'");
    target.ivNew = finder.castView(view, 2131427456, "field 'ivNew'");
    view = finder.findRequiredView(source, 2131427453, "field 'tvSName'");
    target.tvSName = finder.castView(view, 2131427453, "field 'tvSName'");
  }

  @Override public void unbind(T target) {
    target.ivProfile = null;
    target.tvUsername = null;
    target.tvMentions = null;
    target.tvMentionsDate = null;
    target.ivNew = null;
    target.tvSName = null;
  }
}
