package com.example.deezer_api.model;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.deezer_api.R;
import com.example.deezer_api.view.PlayListActivity;
import com.example.deezer_api.view.TrackActivity;

import java.util.ArrayList;

public class TrackAdapter extends BaseAdapter {

    private PlayListActivity playListActivity;
    private ArrayList<Track> tracks;

    public TrackAdapter(PlayListActivity playListActivity) {
        this.playListActivity = playListActivity;
        tracks = new ArrayList<>();
    }

    public void addTrack(Track track){
        tracks.add(track);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return tracks.size();
    }

    @Override
    public Object getItem(int position) {
        return tracks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.row,null,false);

        try {
            TextView rawNameTV = row.findViewById(R.id.nameTV);
            TextView rawArtistTV = row.findViewById(R.id.artistTV);
            TextView rawReleaseTV = row.findViewById(R.id.releaseTV);
            ImageView rawImage = row.findViewById(R.id.image);

            rawNameTV.setText(tracks.get(position).getTitle());
            rawArtistTV.setText(tracks.get(position).getArtist().getName());
            rawReleaseTV.setText(tracks.get(position).getRelease_date());

            Glide.with(row).load(tracks.get(position).getAlbum().getCover()).centerCrop().into(rawImage);

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(playListActivity, TrackActivity.class);
                    i.putExtra("track",tracks.get(position));
                    playListActivity.startActivity(i);
                }
            });
        }catch (Exception e){
        }

        return row;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

}
