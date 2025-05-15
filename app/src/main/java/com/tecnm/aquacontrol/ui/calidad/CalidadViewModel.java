package com.tecnm.aquacontrol.ui.calidad;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalidadViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CalidadViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}