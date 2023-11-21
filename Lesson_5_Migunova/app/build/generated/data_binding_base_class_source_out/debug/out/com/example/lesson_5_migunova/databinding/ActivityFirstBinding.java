// Generated by view binder compiler. Do not edit!
package com.example.lesson_5_migunova.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.lesson_5_migunova.R;
import com.google.android.material.button.MaterialButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityFirstBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialButton buttonForFourth;

  @NonNull
  public final MaterialButton buttonForSecond;

  private ActivityFirstBinding(@NonNull ConstraintLayout rootView,
      @NonNull MaterialButton buttonForFourth, @NonNull MaterialButton buttonForSecond) {
    this.rootView = rootView;
    this.buttonForFourth = buttonForFourth;
    this.buttonForSecond = buttonForSecond;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityFirstBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityFirstBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_first, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityFirstBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonForFourth;
      MaterialButton buttonForFourth = ViewBindings.findChildViewById(rootView, id);
      if (buttonForFourth == null) {
        break missingId;
      }

      id = R.id.buttonForSecond;
      MaterialButton buttonForSecond = ViewBindings.findChildViewById(rootView, id);
      if (buttonForSecond == null) {
        break missingId;
      }

      return new ActivityFirstBinding((ConstraintLayout) rootView, buttonForFourth,
          buttonForSecond);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}