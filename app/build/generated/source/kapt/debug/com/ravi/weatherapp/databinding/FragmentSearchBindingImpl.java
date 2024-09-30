package com.ravi.weatherapp.databinding;
import com.ravi.weatherapp.R;
import com.ravi.weatherapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSearchBindingImpl extends FragmentSearchBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.searchView, 1);
        sViewsWithIds.put(R.id.recyclerView, 2);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSearchBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private FragmentSearchBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (androidx.recyclerview.widget.RecyclerView) bindings[2]
            , (androidx.appcompat.widget.SearchView) bindings[1]
            );
        this.layoutSearch.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelBackgroundColor((androidx.lifecycle.LiveData<java.lang.Integer>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelBackgroundColor(androidx.lifecycle.LiveData<java.lang.Integer> ViewModelBackgroundColor, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
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
        int androidxDatabindingViewDataBindingSafeUnboxViewModelBackgroundColorGetValue = 0;
        com.ravi.weatherapp.viewModel.WeatherViewModel viewModel = mViewModel;
        java.lang.Integer viewModelBackgroundColorGetValue = null;
        androidx.lifecycle.LiveData<java.lang.Integer> viewModelBackgroundColor = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel != null) {
                    // read viewModel.backgroundColor
                    viewModelBackgroundColor = viewModel.getBackgroundColor();
                }
                updateLiveDataRegistration(0, viewModelBackgroundColor);


                if (viewModelBackgroundColor != null) {
                    // read viewModel.backgroundColor.getValue()
                    viewModelBackgroundColorGetValue = viewModelBackgroundColor.getValue();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.backgroundColor.getValue())
                androidxDatabindingViewDataBindingSafeUnboxViewModelBackgroundColorGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelBackgroundColorGetValue);
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            com.ravi.weatherapp.data.BindingAdaptersKt.setImageSrc(this.layoutSearch, androidxDatabindingViewDataBindingSafeUnboxViewModelBackgroundColorGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.backgroundColor
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}