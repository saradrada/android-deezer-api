package com.example.deezer_api.control;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.deezer_api.R;
import com.example.deezer_api.model.Track;
import com.example.deezer_api.view.TrackActivity;

public class TrackController implements View.OnClickListener {

    private Track track;
    private TrackActivity trackActivity;

    public TrackController(TrackActivity trackActivity) {
        this.trackActivity = trackActivity;
        this.track = trackActivity.getTrack();
        trackActivity.getPlayBtn().setOnClickListener(this);
        loadView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.playBtn) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(track.getLink()));
            trackActivity.startActivity(i);
        }
    }

    private void loadView() {
        trackActivity.runOnUiThread(
                () -> {
                    trackActivity.getNameTV().setText(track.getTitle());
                    trackActivity.getArtistTV().setText(track.getArtist().getName());
                    trackActivity.getAlbumTV().setText(track.getAlbum().getTitle());
                    trackActivity.getDurationTV().setText(track.getDuration() + " seconds");
                    Glide.with(trackActivity).load(track.getAlbum().getCover_big()).centerCrop().into(trackActivity.getImage());
                }
        );
    }
}
