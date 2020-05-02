package com.example.deezer_api.control;

import com.bumptech.glide.Glide;
import com.example.deezer_api.model.PlayList;
import com.example.deezer_api.model.Track;
import com.example.deezer_api.util.Constants;
import com.example.deezer_api.util.HTTPSWebUtilDomi;
import com.example.deezer_api.view.PlayListActivity;
import com.google.gson.Gson;

public class PlayListController implements HTTPSWebUtilDomi.OnResponseListener {

    private PlayListActivity playListActivity;
    private PlayList playList;
    private Track[] trackList;
    private HTTPSWebUtilDomi util;
    private int flag;

    public PlayListController(PlayListActivity playListActivity) {
        this.playListActivity = playListActivity;
        this.util = new HTTPSWebUtilDomi();
        this.util.setListener(this);
        loadPlayList(playListActivity.getPlayList().getId());
    }

    @Override
    public void onResponse(int callbackID, String response) {
        Gson gson = new Gson();
        if (callbackID == Constants.PLAYLIST_CALLBACK) {
            this.playList = gson.fromJson(response, PlayList.class);
            loadView();
            loadTracks(playList.getTracks().getData());
        } else if (callbackID == Constants.TRACK_CALLBACK) {
            Track track = gson.fromJson(response, Track.class);
            trackList[flag] = track;
            flag++;
            playListActivity.runOnUiThread(
                    () -> {
                        playListActivity.getAdapter().addTrack(track);
                    }
            );
        }
    }

    public void loadView() {
        playListActivity.runOnUiThread(
                () -> {
                    playListActivity.getPlayListNameTv().setText(playList.getTitle());
                    playListActivity.getNumTracksTV().setText("Tracks: " + playList.getNb_tracks());
                    Glide.with(playListActivity).load(playList.getPicture_big()).centerCrop().into(playListActivity.getBanner());
                    playListActivity.getPlayListDescriptionTv().setText(playList.getDescription());
                }
        );
    }

    public void loadPlayList(long id) {
        new Thread(
                () -> {
                    util.GETrequest(Constants.PLAYLIST_CALLBACK, "https://api.deezer.com/playlist/" + id);
                }
        ).start();
    }

    public void loadTrack(long id) {
        new Thread(
                () -> {
                    util.GETrequest(Constants.TRACK_CALLBACK, "https://api.deezer.com/track/" + id);
                }
        ).start();
    }

    public void loadTracks(Track[] data) {
        trackList = new Track[data.length];
        flag = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                loadTrack(data[i].getId());
            }
        }
    }
}
