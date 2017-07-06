package com.dmovies.diand.diandmovies;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.android.popmovies.R;

import model.Movie;


/**
 * Created by USER on 27/05/2017.
 */

public class Detail_Movie extends AppCompatActivity {


    private SQLiteDatabase mDb;

    final FragmentActivity c = this;
    private String id;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movie);

        Intent intent = getIntent();
        final Movie movie = (Movie) intent.getSerializableExtra("movie");
        Log.d("id", "" + intent.getLongExtra("id", 0));
        id = Long.toString(movie.id);
        Log.d("id", "" + id);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewtrailer);
        layoutManager = new LinearLayoutManager(c);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        TextView title = (TextView) findViewById(R.id.title);
        TextView year = (TextView) findViewById(R.id.year);
        TextView duration = (TextView) findViewById(R.id.durasi);
        TextView rating = (TextView) findViewById(R.id.rating);
        TextView deskripsi = (TextView) findViewById(R.id.deskripsi);
        ImageButton button = (ImageButton) findViewById(R.id.button);


        ImageView poster = (ImageView) findViewById(R.id.poster);
        title.setText(movie.original_title);
        Glide.with(this).load("http://image.tmdb.org/t/p/w500/" + movie.poster_image).into(poster);
        duration.setText(movie.original_language);
        year.setText(movie.release_date);
        rating.setText(movie.vote_average);
        deskripsi.setText(movie.overview);



    }


}

