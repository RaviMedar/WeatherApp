package com.ravi.weatherapp.view;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class WeatherFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private WeatherFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private WeatherFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static WeatherFragmentArgs fromBundle(@NonNull Bundle bundle) {
    WeatherFragmentArgs __result = new WeatherFragmentArgs();
    bundle.setClassLoader(WeatherFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("cityName")) {
      String cityName;
      cityName = bundle.getString("cityName");
      if (cityName == null) {
        throw new IllegalArgumentException("Argument \"cityName\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("cityName", cityName);
    } else {
      throw new IllegalArgumentException("Required argument \"cityName\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static WeatherFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    WeatherFragmentArgs __result = new WeatherFragmentArgs();
    if (savedStateHandle.contains("cityName")) {
      String cityName;
      cityName = savedStateHandle.get("cityName");
      if (cityName == null) {
        throw new IllegalArgumentException("Argument \"cityName\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("cityName", cityName);
    } else {
      throw new IllegalArgumentException("Required argument \"cityName\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getCityName() {
    return (String) arguments.get("cityName");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("cityName")) {
      String cityName = (String) arguments.get("cityName");
      __result.putString("cityName", cityName);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("cityName")) {
      String cityName = (String) arguments.get("cityName");
      __result.set("cityName", cityName);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    WeatherFragmentArgs that = (WeatherFragmentArgs) object;
    if (arguments.containsKey("cityName") != that.arguments.containsKey("cityName")) {
      return false;
    }
    if (getCityName() != null ? !getCityName().equals(that.getCityName()) : that.getCityName() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getCityName() != null ? getCityName().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "WeatherFragmentArgs{"
        + "cityName=" + getCityName()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull WeatherFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String cityName) {
      if (cityName == null) {
        throw new IllegalArgumentException("Argument \"cityName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("cityName", cityName);
    }

    @NonNull
    public WeatherFragmentArgs build() {
      WeatherFragmentArgs result = new WeatherFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setCityName(@NonNull String cityName) {
      if (cityName == null) {
        throw new IllegalArgumentException("Argument \"cityName\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("cityName", cityName);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public String getCityName() {
      return (String) arguments.get("cityName");
    }
  }
}
