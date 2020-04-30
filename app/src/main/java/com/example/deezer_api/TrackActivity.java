package com.example.deezer_api;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TrackActivity extends AppCompatActivity {

    private View headerV;
    private TextView backTV;
    private ImageButton backIB;
    private ImageView songIV;
    private TextView songNameTV;
    private TextView artistNameTV;
    private TextView albumNameTV;
    private TextView durationTV;
    private Button listenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        headerV = findViewById(R.id.headerV);
        backTV = findViewById(R.id.backTV);
        backIB = findViewById(R.id.backIB);
        songIV = findViewById(R.id.songIV);
        songNameTV = findViewById(R.id.songNameTV);
        artistNameTV = findViewById(R.id.artistNameTV);
        albumNameTV = findViewById(R.id.albumNameTV);
        durationTV = findViewById(R.id.durationTV);
        listenBtn = findViewById(R.id.listenBtn);
    }
}
