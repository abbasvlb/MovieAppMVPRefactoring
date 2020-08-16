package com.ivy.android.mvpexampleone.appmodule;


import com.ivy.android.mvpexampleone.apiConnector.APIConnector;
import com.ivy.android.mvpexampleone.apiConnector.APIConnectorModule;
import com.ivy.android.mvpexampleone.screens.moviesListing.di.MovieComponent;
import com.ivy.android.mvpexampleone.screens.moviesListing.di.MovieModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Singleton
@Component(modules = {
        AppModule.class,
        APIConnectorModule.class})
public interface AppComponent {
    MovieComponent plus(MovieModule listingModule);
}
