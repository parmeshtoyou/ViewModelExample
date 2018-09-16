package com.example.parmeshmahore.viewmodelexample;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

public class UserViewModel extends ViewModel {

    private final MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

    public UserViewModel() {
        Log.d("VIEW-MODEL", "CONSTRUCTOR :" +Thread.currentThread().getName());
        new Thread() {
            @Override
            public void run() {
                Log.d("VIEW-MODEL", "RUN :" +Thread.currentThread().getName());
                for (int i = 0; i < 10; i++) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Log.d("VIEW-MODEL", "RUN2 :" +Thread.currentThread().getName());
                mutableLiveData.postValue("This message is coming from View Model");
            }
        }.start();
    }

    public MutableLiveData<String> getMutableLiveData() {
        return mutableLiveData;
    }
}