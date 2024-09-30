package com.ravi.weatherapp.databinding;
import com.ravi.weatherapp.R;
import com.ravi.weatherapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentWeatherBindingImpl extends FragmentWeatherBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.searchButton, 6);
        sViewsWithIds.put(R.id.refreshButton, 7);
        sViewsWithIds.put(R.id.cityButton, 8);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentWeatherBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private FragmentWeatherBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 7
            , (com.google.android.material.button.MaterialButton) bindings[8]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.TextView) bindings[1]
            , (android.widget.ProgressBar) bindings[5]
            , (android.widget.ImageButton) bindings[7]
            , (android.widget.ImageButton) bindings[6]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[2]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[3]
            );
        this.layoutWeather.setTag(null);
        this.localTimeTextView.setTag(null);
        this.progressBar.setTag(null);
        this.statusImageView.setTag(null);
        this.statusTextView.setTag(null);
        this.temperatureTextView.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x100L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel == variableId) {
            setViewModel((com.ravi.weatherapp.viewModel.WeatherViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.ravi.weatherapp.viewModel.WeatherViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x80L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelImgSrc((androidx.lifecycle.LiveData<java.lang.Integer>) object, fieldId);
            case 1 :
                return onChangeViewModelTimeVisibility((androidx.lifecycle.LiveData<java.lang.Boolean>) object, fieldId);
            case 2 :
                return onChangeViewModelLocalTime((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeViewModelProgressVisibility((androidx.lifecycle.LiveData<java.lang.Boolean>) object, fieldId);
            case 4 :
                return onChangeViewModelStatus((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeViewModelTemperature((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 6 :
                return onChangeViewModelBackgroundColor((androidx.lifecycle.LiveData<java.lang.Integer>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelImgSrc(androidx.lifecycle.LiveData<java.lang.Integer> ViewModelImgSrc, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelTimeVisibility(androidx.lifecycle.LiveData<java.lang.Boolean> ViewModelTimeVisibility, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelLocalTime(androidx.lifecycle.LiveData<java.lang.String> ViewModelLocalTime, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelProgressVisibility(androidx.lifecycle.LiveData<java.lang.Boolean> ViewModelProgressVisibility, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelStatus(androidx.lifecycle.LiveData<java.lang.String> ViewModelStatus, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelTemperature(androidx.lifecycle.LiveData<java.lang.String> ViewModelTemperature, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelBackgroundColor(androidx.lifecycle.LiveData<java.lang.Integer> ViewModelBackgroundColor, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        int androidxDatabindingViewDataBindingSafeUnboxViewModelImgSrcGetValue = 0;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelTimeVisibilityGetValue = false;
        int androidxDatabindingViewDataBindingSafeUnboxViewModelBackgroundColorGetValue = 0;
        androidx.lifecycle.LiveData<java.lang.Integer> viewModelImgSrc = null;
        java.lang.Integer viewModelImgSrcGetValue = null;
        androidx.lifecycle.LiveData<java.lang.Boolean> viewModelTimeVisibility = null;
        java.lang.Boolean viewModelProgressVisibilityGetValue = null;
        java.lang.String localTimeTextViewAndroidStringLocalTimeViewModelLocalTime = null;
        androidx.lifecycle.LiveData<java.lang.String> viewModelLocalTime = null;
        androidx.lifecycle.LiveData<java.lang.Boolean> viewModelProgressVisibility = null;
        java.lang.String viewModelTemperatureGetValue = null;
        androidx.lifecycle.LiveData<java.lang.String> viewModelStatus = null;
        java.lang.Integer viewModelBackgroundColorGetValue = null;
        java.lang.String viewModelLocalTimeGetValue = null;
        int viewModelProgressVisibilityViewVISIBLEViewGONE = 0;
        java.lang.Boolean viewModelTimeVisibilityGetValue = null;
        androidx.lifecycle.LiveData<java.lang.String> viewModelTemperature = null;
        java.lang.String viewModelStatusGetValue = null;
        com.ravi.weatherapp.viewModel.WeatherViewModel viewModel = mViewModel;
        androidx.lifecycle.LiveData<java.lang.Integer> viewModelBackgroundColor = null;
        int viewModelTimeVisibilityViewVISIBLEViewGONE = 0;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelProgressVisibilityGetValue = false;

        if ((dirtyFlags & 0x1ffL) != 0) {


            if ((dirtyFlags & 0x181L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.imgSrc
                        viewModelImgSrc = viewModel.getImgSrc();
                    }
                    updateLiveDataRegistration(0, viewModelImgSrc);


                    if (viewModelImgSrc != null) {
                        // read viewModel.imgSrc.getValue()
                        viewModelImgSrcGetValue = viewModelImgSrc.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.imgSrc.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxViewModelImgSrcGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelImgSrcGetValue);
            }
            if ((dirtyFlags & 0x182L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.timeVisibility
                        viewModelTimeVisibility = viewModel.getTimeVisibility();
                    }
                    updateLiveDataRegistration(1, viewModelTimeVisibility);


                    if (viewModelTimeVisibility != null) {
                        // read viewModel.timeVisibility.getValue()
                        viewModelTimeVisibilityGetValue = viewModelTimeVisibility.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.timeVisibility.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxViewModelTimeVisibilityGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelTimeVisibilityGetValue);
                if((dirtyFlags & 0x182L) != 0) {
                    if(androidxDatabindingViewDataBindingSafeUnboxViewModelTimeVisibilityGetValue) {
                            dirtyFlags |= 0x1000L;
                    }
                    else {
                            dirtyFlags |= 0x800L;
                    }
                }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.timeVisibility.getValue()) ? View.VISIBLE : View.GONE
                    viewModelTimeVisibilityViewVISIBLEViewGONE = ((androidxDatabindingViewDataBindingSafeUnboxViewModelTimeVisibilityGetValue) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
            if ((dirtyFlags & 0x184L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.localTime
                        viewModelLocalTime = viewModel.getLocalTime();
                    }
                    updateLiveDataRegistration(2, viewModelLocalTime);


                    if (viewModelLocalTime != null) {
                        // read viewModel.localTime.getValue()
                        viewModelLocalTimeGetValue = viewModelLocalTime.getValue();
                    }


                    // read @android:string/local_time
                    localTimeTextViewAndroidStringLocalTimeViewModelLocalTime = localTimeTextView.getResources().getString(R.string.local_time, viewModelLocalTimeGetValue);
            }
            if ((dirtyFlags & 0x188L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.progressVisibility
                        viewModelProgressVisibility = viewModel.getProgressVisibility();
                    }
                    updateLiveDataRegistration(3, viewModelProgressVisibility);


                    if (viewModelProgressVisibility != null) {
                        // read viewModel.progressVisibility.getValue()
                        viewModelProgressVisibilityGetValue = viewModelProgressVisibility.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.progressVisibility.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxViewModelProgressVisibilityGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelProgressVisibilityGetValue);
                if((dirtyFlags & 0x188L) != 0) {
                    if(androidxDatabindingViewDataBindingSafeUnboxViewModelProgressVisibilityGetValue) {
                            dirtyFlags |= 0x400L;
                    }
                    else {
                            dirtyFlags |= 0x200L;
                    }
                }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.progressVisibility.getValue()) ? View.VISIBLE : View.GONE
                    viewModelProgressVisibilityViewVISIBLEViewGONE = ((androidxDatabindingViewDataBindingSafeUnboxViewModelProgressVisibilityGetValue) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
            if ((dirtyFlags & 0x190L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.status
                        viewModelStatus = viewModel.getStatus();
                    }
                    updateLiveDataRegistration(4, viewModelStatus);


                    if (viewModelStatus != null) {
                        // read viewModel.status.getValue()
                        viewModelStatusGetValue = viewModelStatus.getValue();
                    }
            }
            if ((dirtyFlags & 0x1a0L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.temperature
                        viewModelTemperature = viewModel.getTemperature();
                    }
                    updateLiveDataRegistration(5, viewModelTemperature);


                    if (viewModelTemperature != null) {
                        // read viewModel.temperature.getValue()
                        viewModelTemperatureGetValue = viewModelTemperature.getValue();
                    }
            }
            if ((dirtyFlags & 0x1c0L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.backgroundColor
                        viewModelBackgroundColor = viewModel.getBackgroundColor();
                    }
                    updateLiveDataRegistration(6, viewModelBackgroundColor);


                    if (viewModelBackgroundColor != null) {
                        // read viewModel.backgroundColor.getValue()
                        viewModelBackgroundColorGetValue = viewModelBackgroundColor.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.backgroundColor.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxViewModelBackgroundColorGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelBackgroundColorGetValue);
            }
        }
        // batch finished
        if ((dirtyFlags & 0x1c0L) != 0) {
            // api target 1

            com.ravi.weatherapp.data.BindingAdaptersKt.setImageSrc(this.layoutWeather, androidxDatabindingViewDataBindingSafeUnboxViewModelBackgroundColorGetValue);
        }
        if ((dirtyFlags & 0x182L) != 0) {
            // api target 1

            this.localTimeTextView.setVisibility(viewModelTimeVisibilityViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x184L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.localTimeTextView, localTimeTextViewAndroidStringLocalTimeViewModelLocalTime);
        }
        if ((dirtyFlags & 0x188L) != 0) {
            // api target 1

            this.progressBar.setVisibility(viewModelProgressVisibilityViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x181L) != 0) {
            // api target 1

            com.ravi.weatherapp.data.BindingAdaptersKt.setImageSrc(this.statusImageView, androidxDatabindingViewDataBindingSafeUnboxViewModelImgSrcGetValue);
        }
        if ((dirtyFlags & 0x190L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.statusTextView, viewModelStatusGetValue);
        }
        if ((dirtyFlags & 0x1a0L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.temperatureTextView, viewModelTemperatureGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.imgSrc
        flag 1 (0x2L): viewModel.timeVisibility
        flag 2 (0x3L): viewModel.localTime
        flag 3 (0x4L): viewModel.progressVisibility
        flag 4 (0x5L): viewModel.status
        flag 5 (0x6L): viewModel.temperature
        flag 6 (0x7L): viewModel.backgroundColor
        flag 7 (0x8L): viewModel
        flag 8 (0x9L): null
        flag 9 (0xaL): androidx.databinding.ViewDataBinding.safeUnbox(viewModel.progressVisibility.getValue()) ? View.VISIBLE : View.GONE
        flag 10 (0xbL): androidx.databinding.ViewDataBinding.safeUnbox(viewModel.progressVisibility.getValue()) ? View.VISIBLE : View.GONE
        flag 11 (0xcL): androidx.databinding.ViewDataBinding.safeUnbox(viewModel.timeVisibility.getValue()) ? View.VISIBLE : View.GONE
        flag 12 (0xdL): androidx.databinding.ViewDataBinding.safeUnbox(viewModel.timeVisibility.getValue()) ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}