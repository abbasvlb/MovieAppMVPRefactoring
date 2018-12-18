package com.ivy.android.mvpexampleone.model;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieInteractorImpl implements MovieInteractor {

    private ApiInterface apiService;
    private String BASE_URL = "https://api.themoviedb.org/3/";
    private String API_KEY = "";

    public MovieInteractorImpl(String key){

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
    public Call<MovieResponse> fetch() {
        return apiService.getTopRatedMovies(API_KEY);

    }
}
