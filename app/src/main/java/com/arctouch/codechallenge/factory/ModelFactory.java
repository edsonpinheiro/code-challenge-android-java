package com.arctouch.codechallenge.factory;

import com.arctouch.codechallenge.model.MovieModel;

public class ModelFactory {
    private static MovieModel movieModel;

    public static MovieModel getMovieModel() {
        if (movieModel == null)
            movieModel = new MovieModel();
        return movieModel;
    }
}
