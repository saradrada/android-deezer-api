package com.example.deezer_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private View headerV;
    private View searchV;
    private ImageView searchIV;
    private TextView searchTV;
    private TextView backTV;
    private ImageButton backIB;
    private RecyclerView listRV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        headerV = findViewById(R.id.headerV);
        searchV = findViewById(R.id.searchV);
        searchIV = findViewById(R.id.searchIV);
        searchTV = findViewById(R.id.searchTV);
        backTV = findViewById(R.id.backTV);
        backIB = findViewById(R.id.backIB);
        listRV = findViewById(R.id.listRV);
    }
}
