package com.ivy.android.mvpexampleone.apiConnector;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class APIConnectorModule {
    @Provides
    @Singleton
    public APIConnector providesAPIConnector(){
        return new APIConnectorImpl("4c87c0fa03d00ee500e08763b0432f65");
    }
}
