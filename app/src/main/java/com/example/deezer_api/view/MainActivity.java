package com.example.deezer_api.view;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deezer_api.R;
import com.example.deezer_api.control.MainController;
import com.example.deezer_api.model.ListAdapter;

public class MainActivity extends AppCompatActivity {

    private MainController controller;
    private EditText searchPlaylistET;
    private ImageButton searchButton;
    private RecyclerView recyclerView;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.searchPlaylistET = findViewById(R.id.searchPlaylistET);
        this.searchButton = findViewById(R.id.searchButton);

        this.controller = new MainController(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

    }

    public EditText getSearchPlaylistET() {
        return searchPlaylistET;
    }

    public void setSearchPlaylistET(EditText searchPlaylistET) {
        this.searchPlaylistET = searchPlaylistET;
    }

    public ImageButton getSearchBtn() {
        return searchButton;
    }

    public void setSearchBtn(ImageButton searchButton) {
        this.searchButton = searchButton;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public ListAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(ListAdapter adapter) {
        this.adapter = adapter;
    }
}
