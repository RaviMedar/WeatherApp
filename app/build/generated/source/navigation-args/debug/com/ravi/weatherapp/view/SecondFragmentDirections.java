package com.ravi.weatherapp.view;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.ravi.weatherapp.R;

public class SecondFragmentDirections {
  private SecondFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSecondFragmentToFirstFragment() {
    return new ActionOnlyNavDirections(R.id.action_SecondFragment_to_FirstFragment);
  }
}
