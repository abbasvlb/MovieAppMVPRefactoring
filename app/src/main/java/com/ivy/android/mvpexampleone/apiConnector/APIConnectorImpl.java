package com.ivy.android.mvpexampleone.apiConnector;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIConnectorImpl implements APIConnector {

    private ApiInterface apiService;
    private String BASE_URL = "https://api.themoviedb.org/3/";
    public String API_KEY = "";


    public APIConnectorImpl(String key){

        API_KEY = key;

        // Configure Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                // Base URL can change for endpoints (dev, staging, live..)
                .baseUrl(BASE_URL)
                // Takes care of converting the JSON response into java objects
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService =
                retrofit.create(ApiInterface.class);



    }

    @Override
    public ApiInterface getAPIService() {
        return apiService;
    }

    @Override
    public String getAPIkey() {
        return API_KEY;
    }
}
