// Generated by view binder compiler. Do not edit!
package com.example.lesson_6_migunova.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.lesson_6_migunova.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentThirdBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AppBarLayout appbarThird;

  @NonNull
  public final MaterialButton buttonShowBanner;

  @NonNull
  public final FragmentContainerView fragmentBanner;

  @NonNull
  public final MaterialToolbar toolbar;

  private FragmentThirdBinding(@NonNull LinearLayout rootView, @NonNull AppBarLayout appbarThird,
      @NonNull MaterialButton buttonShowBanner, @NonNull FragmentContainerView fragmentBanner,
      @NonNull MaterialToolbar toolbar) {
    this.rootView = rootView;
    this.appbarThird = appbarThird;
    this.buttonShowBanner = buttonShowBanner;
    this.fragmentBanner = fragmentBanner;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentThirdBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentThirdBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_third, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentThirdBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.appbarThird;
      AppBarLayout appbarThird = ViewBindings.findChildViewById(rootView, id);
      if (appbarThird == null) {
        break missingId;
      }

      id = R.id.button_show_banner;
      MaterialButton buttonShowBanner = ViewBindings.findChildViewById(rootView, id);
      if (buttonShowBanner == null) {
        break missingId;
      }

      id = R.id.fragment_banner;
      FragmentContainerView fragmentBanner = ViewBindings.findChildViewById(rootView, id);
      if (fragmentBanner == null) {
        break missingId;
      }

      id = R.id.toolbar;
      MaterialToolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new FragmentThirdBinding((LinearLayout) rootView, appbarThird, buttonShowBanner,
          fragmentBanner, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
