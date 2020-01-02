package com.arctouch.codechallenge.details;

import android.text.TextUtils;

import com.arctouch.codechallenge.factory.ModelFactory;
import com.arctouch.codechallenge.model.MovieModel;

public class DetailsScreenPresenter {
    private MovieModel movieModel;

    public DetailsScreenPresenter() {
        movieModel = ModelFactory.getMovieModel();
    }

    public String getBackdropPath() {
        return movieModel.getSelectedMovie().backdropPath;
    }

    public String getTitle() {
        return movieModel.getSelectedMovie().title;
    }

    public String getOverview() {
        return movieModel.getSelectedMovie().overview;
    }

    public String getGenres() {
        return TextUtils.join(", ", movieModel.getSelectedMovie().genres);
    }

    public String getReleaseDate() {
        return movieModel.getSelectedMovie().releaseDate;
    }
}
