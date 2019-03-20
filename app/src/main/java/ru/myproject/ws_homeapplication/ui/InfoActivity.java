package ru.myproject.ws_homeapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.myproject.ws_homeapplication.R;
import ru.myproject.ws_homeapplication.ui.fragments.ListMovieFragment;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ListMovieFragment listMovieFragment = new ListMovieFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, listMovieFragment)
                .commit();

    }
}
