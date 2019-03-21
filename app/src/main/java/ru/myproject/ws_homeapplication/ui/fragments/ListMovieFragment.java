package ru.myproject.ws_homeapplication.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.myproject.ws_homeapplication.R;
import ru.myproject.ws_homeapplication.ui.adapters.AdapterMovieList;

public class ListMovieFragment extends Fragment {

    private RecyclerView list_movies;
    private RecyclerView.Adapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_movie_fragment, container, false);

        list_movies = view.findViewById(R.id.movie_recycler_view);
        list_movies.setHasFixedSize(true);
        list_movies.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter =new AdapterMovieList(this);
        list_movies.setAdapter(mAdapter);


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
