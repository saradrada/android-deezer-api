package com.example.deezer_api.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.deezer_api.R;
import com.example.deezer_api.control.PlayListController;
import com.example.deezer_api.model.PlayList;
import com.example.deezer_api.model.TrackAdapter;

public class PlayListActivity extends AppCompatActivity {

    private PlayListController controller;
    private TrackAdapter adapter;

    private PlayList playList;
    private ListView listTable2;
    private ImageView banner;
    private TextView playListNameTv, playListDescriptionTv,numTracksTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        this.playList = (PlayList) getIntent().getExtras().getSerializable("playList");

        this.listTable2 = findViewById(R.id.listTable2);
        this.banner =  findViewById(R.id.banner);
        this.playListNameTv =  findViewById(R.id.playListNameTv);
        this.playListDescriptionTv =  findViewById(R.id.playListDescriptionTv);
        this.numTracksTV =  findViewById(R.id.numTracksTV);

        this.controller = new PlayListController(this);
        this.adapter = new TrackAdapter(this);
        this.listTable2.setAdapter(adapter);

    }

    public ImageView getBanner() {
        return banner;
    }

    public TextView getPlayListNameTv() {
        return playListNameTv;
    }

    public TextView getPlayListDescriptionTv() {
        return playListDescriptionTv;
    }

    public TextView getNumTracksTV() {
        return numTracksTV;
    }

    public PlayList getPlayList() {
        return playList;
    }

    public TrackAdapter getAdapter() {
        return adapter;
    }
}
