package com.ravi.weatherapp.view;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.ravi.weatherapp.R;

public class FirstFragmentDirections {
  private FirstFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionFirstFragmentToSecondFragment() {
    return new ActionOnlyNavDirections(R.id.action_FirstFragment_to_SecondFragment);
  }
}
