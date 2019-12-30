package com.arctouch.codechallenge.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.arctouch.codechallenge.R;

public class HomeScreenFragment extends Fragment {
    private View rootView;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private HomePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.home_screen_fragment, container, false);
            presenter = new HomePresenter(this);
            configComponents();
            presenter.downloadUpcomingMovies();
        }
        return rootView;
    }

    private void configComponents() {
        recyclerView = rootView.findViewById(R.id.recyclerView);
        progressBar = rootView.findViewById(R.id.progressBar);
    }

    public void populateRecyclerView(HomeAdapter homeAdapter) {
        recyclerView.setAdapter(homeAdapter);
    }

    public void showList() {
        progressBar.setVisibility(View.GONE);
    }

}
