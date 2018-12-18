package com.ivy.android.mvpexampleone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ivy.android.mvpexampleone.model.Movie;
import com.ivy.android.mvpexampleone.model.MovieInteractorImpl;
import com.ivy.android.mvpexampleone.presentor.MoviePresentor;
import com.ivy.android.mvpexampleone.presentor.MoviePresentorImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieActivity extends AppCompatActivity implements MovieView {


    @BindView(R.id.button)
    Button imageButton;

    @BindView(R.id.list)
    RecyclerView recyclerView;

    @BindView(R.id.textView)
    TextView textNoDataFound;

    MoviePresentor moviePresentor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        moviePresentor = new MoviePresentorImpl(new MovieInteractorImpl(getResources().getString(R.string.default_account_id)));
        moviePresentor.bindView(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moviePresentor.performSearch();
            }
        });
    }



    public void updateUi(List<Movie> movies) {
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        moviePresentor.unbindView();
    }
}
