package com.ravi.weatherapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.ravi.weatherapp.databinding.ActivityWeatherBindingImpl;
import com.ravi.weatherapp.databinding.FragmentSearchBindingImpl;
import com.ravi.weatherapp.databinding.FragmentWeatherBindingImpl;
import com.ravi.weatherapp.databinding.SearchItemViewBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYWEATHER = 1;

  private static final int LAYOUT_FRAGMENTSEARCH = 2;

  private static final int LAYOUT_FRAGMENTWEATHER = 3;

  private static final int LAYOUT_SEARCHITEMVIEW = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.ravi.weatherapp.R.layout.activity_weather, LAYOUT_ACTIVITYWEATHER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.ravi.weatherapp.R.layout.fragment_search, LAYOUT_FRAGMENTSEARCH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.ravi.weatherapp.R.layout.fragment_weather, LAYOUT_FRAGMENTWEATHER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.ravi.weatherapp.R.layout.search_item_view, LAYOUT_SEARCHITEMVIEW);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYWEATHER: {
          if ("layout/activity_weather_0".equals(tag)) {
            return new ActivityWeatherBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_weather is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSEARCH: {
          if ("layout/fragment_search_0".equals(tag)) {
            return new FragmentSearchBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_search is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWEATHER: {
          if ("layout/fragment_weather_0".equals(tag)) {
            return new FragmentWeatherBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_weather is invalid. Received: " + tag);
        }
        case  LAYOUT_SEARCHITEMVIEW: {
          if ("layout/search_item_view_0".equals(tag)) {
            return new SearchItemViewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for search_item_view is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/activity_weather_0", com.ravi.weatherapp.R.layout.activity_weather);
      sKeys.put("layout/fragment_search_0", com.ravi.weatherapp.R.layout.fragment_search);
      sKeys.put("layout/fragment_weather_0", com.ravi.weatherapp.R.layout.fragment_weather);
      sKeys.put("layout/search_item_view_0", com.ravi.weatherapp.R.layout.search_item_view);
    }
  }
}
