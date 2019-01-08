package com.ivy.android.mvpexampleone.model;

import android.app.Application;

import com.ivy.android.mvpexampleone.di.AppComponent;
import com.ivy.android.mvpexampleone.di.DaggerAppComponent;

public class App extends Application {
    private AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
    }
    public AppComponent getAppComponent() {
        return appComponent;
    }
}