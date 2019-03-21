package ru.myproject.ws_homeapplication.ui.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Objects;

import ru.myproject.ws_homeapplication.R;
import ru.myproject.ws_homeapplication.model.Movie;

import static java.lang.String.valueOf;

public class InfoItemListFragment extends Fragment {

    private TextView text_rating,text_title,text_plot,text_year,text_number_item
            ,text_awards,text_actors,text_website;
    private ImageView image_poster_movie;

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_info_item_list, container, false);
        text_rating=v.findViewById(R.id.text_rating);
        text_title=v.findViewById(R.id.title);
        text_plot=v.findViewById(R.id.text_description_movie);
        image_poster_movie=v.findViewById(R.id.image_poster_movie);
        text_year=v.findViewById(R.id.year);
        text_number_item=v.findViewById(R.id.number_item);
        text_awards=v.findViewById(R.id.text_awards);
        text_actors=v.findViewById(R.id.text_actors);
        text_website=v.findViewById(R.id.text_website);
       // Linkify.addLinks(text_website, Linkify.WEB_URLS);
        Bundle bundle =getArguments();

        if(bundle!=null){
            Movie movie = (Movie) bundle.getSerializable("movie");
            assert movie != null;
            text_title.setText(movie.getTitle());
            text_year.setText(valueOf(movie.getYear()));
            text_number_item.setText("№"+ movie.getPosition());
            text_plot.setText(movie.getPlot());
            text_rating.setText(valueOf(movie.getRating()));
            image_poster_movie.setImageDrawable(getActivity().getDrawable(
                    Objects.requireNonNull(getActivity()).getResources().getIdentifier(
                            movie.getPoster(), "drawable", getActivity().getPackageName())));
            text_awards.setText(movie.getAward());
            text_actors.setText(movie.getActor());
            text_website.setText(movie.getWebsite());
        }


        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
