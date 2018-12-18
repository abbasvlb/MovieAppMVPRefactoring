package com.ivy.android.mvpexampleone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ivy.android.mvpexampleone.model.ApiInterface;
import com.ivy.android.mvpexampleone.model.Movie;
import com.ivy.android.mvpexampleone.model.MovieResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieActivity extends AppCompatActivity {


    @BindView(R.id.button)
    Button imageButton;

    @BindView(R.id.list)
    RecyclerView recyclerView;

    @BindView(R.id.textView)
    TextView textNoDataFound;

    String BASE_URL = "https://api.themoviedb.org/3/";
    String API_KEY = "";

    ApiInterface apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        API_KEY = getResources().getString(R.string.default_account_id);
        // Configure Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                // Base URL can change for endpoints (dev, staging, live..)
                .baseUrl(BASE_URL)
                // Takes care of converting the JSON response into java objects
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         apiService =
                retrofit.create(ApiInterface.class);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });
    }

    private void performSearch() {
        Call<MovieResponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse>call, Response<MovieResponse> response) {
                List<Movie> movies = response.body().getResults();
                Log.d("MVP", "Number of movies received: " + movies.size());
                updateUi(movies);
            }

            @Override
            public void onFailure(Call<MovieResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e("MVP", t.toString());
                updateUi(null);
            }
        });
    }

    private void updateUi(List<Movie> movies) {
        if (movies == null || movies.isEmpty()) {
            // if no books found, show a message
            textNoDataFound.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            textNoDataFound.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));

        }

    }

}
