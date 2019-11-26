package com.arctouch.codechallenge.model;

import com.squareup.moshi.Json;

import java.util.List;
import java.util.Objects;

public class Movie {
    public int id;
    public String title;
    public String overview;
    public List<Genre> genres;
    @Json(name = "genre_ids")
    public List<Integer> genreIds;
    @Json(name = "poster_path")
    public String posterPath;
    @Json(name = "backdrop_path")
    public String backdropPath;
    @Json(name = "release_date")
    public String releaseDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (!Objects.equals(title, movie.title)) return false;
        if (!Objects.equals(overview, movie.overview))
            return false;
        if (!Objects.equals(genres, movie.genres)) return false;
        if (!Objects.equals(genreIds, movie.genreIds))
            return false;
        if (!Objects.equals(posterPath, movie.posterPath))
            return false;
        if (!Objects.equals(backdropPath, movie.backdropPath))
            return false;
        return Objects.equals(releaseDate, movie.releaseDate);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (overview != null ? overview.hashCode() : 0);
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        result = 31 * result + (genreIds != null ? genreIds.hashCode() : 0);
        result = 31 * result + (posterPath != null ? posterPath.hashCode() : 0);
        result = 31 * result + (backdropPath != null ? backdropPath.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", genres=" + genres +
                ", genreIds=" + genreIds +
                ", posterPath='" + posterPath + '\'' +
                ", backdropPath='" + backdropPath + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
