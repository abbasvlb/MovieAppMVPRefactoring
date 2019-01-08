package com.ivy.android.mvpexampleone.presentor;

import android.util.Log;

import com.ivy.android.mvpexampleone.MovieView;
import com.ivy.android.mvpexampleone.model.Movie;
import com.ivy.android.mvpexampleone.model.MovieInteractor;
import com.ivy.android.mvpexampleone.model.MovieResponse;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePresentorImpl implements MoviePresentor {

    private MovieInteractor movieInteractor;
    private MovieView movieView;


    public MoviePresentorImpl(MovieInteractor movieInteractor){
        this.movieInteractor=movieInteractor;
    }

    public void bindView(MovieView movieView){
        this.movieView=movieView;
    }

    public void unbindView(){
        this.movieView = null;
    }

    @Override
    public void performSearch() {


        movieInteractor.fetch().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> movies = response.body().getResults();
                Log.d("MVP", "Number of movies received: " + movies.size());
                movieView.updateUi(movies);
            }

            @Override
            public void onFailure(Call<MovieResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e("MVP", t.toString());
                movieView.updateUi(null);
            }
        });
    }
}
