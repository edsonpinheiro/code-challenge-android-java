package com.arctouch.codechallenge.details;

import android.text.TextUtils;

import com.arctouch.codechallenge.model.Movie;

public class DetailsScreenPresenter {
    private Movie selectedMovie;

    public void setSelectedMovie(Movie movie) {
        selectedMovie = movie;
    }

    public String getBackdropPath() {
        return selectedMovie.backdropPath;
    }

    public String getTitle() {
        return selectedMovie.title;
    }

    public String getOverview() {
        return selectedMovie.overview;
    }

    public String getGenres() {
        return TextUtils.join(", ", selectedMovie.genres);
    }

    public String getReleaseDate() {
        return selectedMovie.releaseDate;
    }
}
