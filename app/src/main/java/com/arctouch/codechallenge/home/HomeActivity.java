package com.arctouch.codechallenge.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.arctouch.codechallenge.R;
import com.arctouch.codechallenge.api.TmdbApi;
import com.arctouch.codechallenge.base.BaseActivity;
import com.arctouch.codechallenge.data.Cache;
import com.arctouch.codechallenge.details.DetailsScreenFragment;
import com.arctouch.codechallenge.model.Genre;
import com.arctouch.codechallenge.model.Movie;

import java.util.ArrayList;
import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HomeActivity extends BaseActivity {

    private FrameLayout frameLayout;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        this.frameLayout = findViewById(R.id.frameLayout);
//        this.recyclerView = findViewById(R.id.recyclerView);
//        this.progressBar = findViewById(R.id.progressBar);

        openFragment(new HomeScreenFragment());

//        api.upcomingMovies(TmdbApi.API_KEY, TmdbApi.DEFAULT_LANGUAGE, 1L, TmdbApi.DEFAULT_REGION)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(response -> {
//                    for (Movie movie : response.results) {
//                        movie.genres = new ArrayList<>();
//                        for (Genre genre : Cache.getGenres()) {
//                            if (movie.genreIds.contains(genre.id)) {
//                                movie.genres.add(genre);
//                            }
//                        }
//                    }
//
////                    recyclerView.setAdapter(new HomeAdapter(response.results));
//                    progressBar.setVisibility(View.GONE);
//                });
    }

    public void openFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .addToBackStack(null)
                .commit();
    }
}
