package com.ivy.android.mvpexampleone.appmodule;

import android.app.Application;

import com.ivy.android.mvpexampleone.screens.moviesListing.di.AppComponent;
import com.ivy.android.mvpexampleone.screens.moviesListing.di.DaggerAppComponent;

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