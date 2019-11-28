package com.arctouch.codechallenge.home;

import com.arctouch.codechallenge.api.TmdbApi;
import com.arctouch.codechallenge.data.Cache;
import com.arctouch.codechallenge.model.ApiModel;
import com.arctouch.codechallenge.model.Genre;
import com.arctouch.codechallenge.model.Movie;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter {
    private HomeScreenFragment view;
    private ApiModel apiModel;
    private HomeAdapter homeAdapter;

    public HomePresenter(HomeScreenFragment view) {
        this.view = view;
        apiModel = new ApiModel();
    }

    public HomeAdapter getHomeAdapter() {
        apiModel.getApi().upcomingMovies(TmdbApi.API_KEY, TmdbApi.DEFAULT_LANGUAGE, 1L, TmdbApi.DEFAULT_REGION)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    for (Movie movie : response.results) {
                        movie.genres = new ArrayList<>();
                        for (Genre genre : Cache.getGenres()) {
                            if (movie.genreIds.contains(genre.id)) {
                                movie.genres.add(genre);
                            }
                        }
                    }
                    view.showList(true);
                    homeAdapter = new HomeAdapter(view.getActivity(), response.results);
                });
        return homeAdapter;
    }
}
