package com.arctouch.codechallenge.details;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arctouch.codechallenge.R;
import com.arctouch.codechallenge.model.Movie;
import com.arctouch.codechallenge.util.MovieImageUrlBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailsScreenFragment extends Fragment {
    private View rootView;
    private ImageView backdropImageView;
    private TextView titleTextView;
    private TextView overviewTextView;
    private TextView genresTextView;
    private TextView releaseDateTextView;
    private  DetailsScreenPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.details_fragment, container, false);
            presenter = new DetailsScreenPresenter();
            initComponents();
            setComponents();
        }
        return rootView;
    }

    private void initComponents() {
        backdropImageView =  rootView.findViewById(R.id.backdropImageView);
        titleTextView = rootView.findViewById(R.id.titleTextView);
        overviewTextView = rootView.findViewById(R.id.overviewTextView);
        genresTextView = rootView.findViewById(R.id.genresTextView);
        releaseDateTextView = rootView.findViewById(R.id.releaseDateTextView);
    }

    private void setComponents() {
        MovieImageUrlBuilder movieImageUrlBuilder = new MovieImageUrlBuilder();
        if (!TextUtils.isEmpty(presenter.getBackdropPath())) {
            Glide.with(rootView)
                    .load(movieImageUrlBuilder.buildPosterUrl(presenter.getBackdropPath()))
                    .apply(new RequestOptions().placeholder(R.drawable.ic_image_placeholder))
                    .into(backdropImageView);
        }
        titleTextView.setText(presenter.getTitle());
        overviewTextView.setText(presenter.getOverview());
        genresTextView.setText(presenter.getGenres());
        releaseDateTextView.setText(presenter.getReleaseDate());
    }
}
