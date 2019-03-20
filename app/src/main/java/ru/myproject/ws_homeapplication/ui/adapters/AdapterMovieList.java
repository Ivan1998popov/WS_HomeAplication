package ru.myproject.ws_homeapplication.ui.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import ru.myproject.ws_homeapplication.R;
import ru.myproject.ws_homeapplication.model.Movie;
import ru.myproject.ws_homeapplication.ui.fragments.ListMovieFragment;

public class AdapterMovieList extends  RecyclerView.Adapter<AdapterMovieList.MyViewHolder> {

    private  ListMovieFragment mListMovieFragment;
    private List<Movie> mMovies = new ArrayList<>();

    private String[] actors;
    private String[] plot;
    private String[] awards;
    private String[] title;
    private String[] poster;
    private String[] website;
    private String[] rating;
    private int[] year;


    public AdapterMovieList(ListMovieFragment fragment){
        mListMovieFragment=fragment;
        actors= Objects.requireNonNull(fragment.getActivity()).getResources().getStringArray(R.array.actors);
        plot= Objects.requireNonNull(fragment.getActivity()).getResources().getStringArray(R.array.plot);
        awards= Objects.requireNonNull(fragment.getActivity()).getResources().getStringArray(R.array.awards);
        title= Objects.requireNonNull(fragment.getActivity()).getResources().getStringArray(R.array.title);
        poster= Objects.requireNonNull(fragment.getActivity()).getResources().getStringArray(R.array.poster);
        website= Objects.requireNonNull(fragment.getActivity()).getResources().getStringArray(R.array.website);
        rating=  fragment.getActivity().getResources().getStringArray(R.array.rating);
        year= Objects.requireNonNull(fragment.getActivity()).getResources().getIntArray(R.array.year);
        for (int i = 0; i <title.length ; i++) {
            mMovies.add(new Movie(title[i],year[i],actors[i],plot[i],awards[i],
                    poster[i],website[i], Float.parseFloat(rating[i])));
        }
        Collections.sort(mMovies,Movie.sMovieComparator);



    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView text_rating,text_title,text_plot;
        private ImageView image_poster_movie;

        public MyViewHolder(View v) {
            super(v);
            text_rating=v.findViewById(R.id.text_rating);
            text_title=v.findViewById(R.id.title);
            text_plot=v.findViewById(R.id.text_description_movie);
            image_poster_movie=v.findViewById(R.id.image_poster_movie);
        }
    }

    @NonNull
    @Override
    public AdapterMovieList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_movie_recyclerview, viewGroup, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMovieList.MyViewHolder holder, int i) {

        Movie movie = mMovies.get(i);
        holder.text_title.setText(movie.getTitle());
        holder.text_plot.setText(movie.getPlot());
        holder.text_rating.setText(String.valueOf(movie.getRating()));
        holder.image_poster_movie.setImageDrawable(mListMovieFragment.getActivity().getDrawable(
                Objects.requireNonNull(mListMovieFragment.getActivity()).getResources().getIdentifier(
                        movie.getPoster(), "drawable", mListMovieFragment.getActivity().getPackageName())));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }
}
