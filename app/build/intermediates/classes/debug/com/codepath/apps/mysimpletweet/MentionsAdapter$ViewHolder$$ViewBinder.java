// Generated code from Butter Knife. Do not modify!
package com.codepath.apps.mysimpletweet;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MentionsAdapter$ViewHolder$$ViewBinder<T extends com.codepath.apps.mysimpletweet.MentionsAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427450, "field 'ivProfile'");
    target.ivProfile = finder.castView(view, 2131427450, "field 'ivProfile'");
    view = finder.findRequiredView(source, 2131427451, "field 'tvUsername'");
    target.tvUsername = finder.castView(view, 2131427451, "field 'tvUsername'");
    view = finder.findRequiredView(source, 2131427453, "field 'tvMentions'");
    target.tvMentions = finder.castView(view, 2131427453, "field 'tvMentions'");
    view = finder.findRequiredView(source, 2131427452, "field 'tvMentionsDate'");
    target.tvMentionsDate = finder.castView(view, 2131427452, "field 'tvMentionsDate'");
  }

  @Override public void unbind(T target) {
    target.ivProfile = null;
    target.tvUsername = null;
    target.tvMentions = null;
    target.tvMentionsDate = null;
  }
}
