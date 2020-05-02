package com.example.deezer_api.control;

import android.view.View;

import com.example.deezer_api.R;
import com.example.deezer_api.model.ListAdapter;
import com.example.deezer_api.model.List;
import com.example.deezer_api.util.Constants;
import com.example.deezer_api.util.HTTPSWebUtilDomi;
import com.example.deezer_api.view.MainActivity;
import com.google.gson.Gson;

public class MainController implements View.OnClickListener, HTTPSWebUtilDomi.OnResponseListener {

    private MainActivity activity;
    private HTTPSWebUtilDomi util;
    private List list;

    public MainController(MainActivity activity) {
        this.activity = activity;
        this.util = new HTTPSWebUtilDomi();
        this.util.setListener(this);
        activity.getSearchBtn().setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.searchButton){
            String nameList = activity.getSearchPlaylistET().getText().toString();
            new Thread(
                    () -> {
                        util.GETrequest(Constants.SEARCH_CALLBACK, "https://api.deezer.com/search/playlist?q=" + nameList);
                    }
            ).start();
        }
    }

    @Override
    public void onResponse(int callbackID, String response) {
        if(callbackID == Constants.SEARCH_CALLBACK){
            Gson gson = new Gson();
            list = gson.fromJson(response, List.class);
            if (list.getData() != null) {
                activity.runOnUiThread(
                        () -> {
                            ListAdapter adapter = new ListAdapter(activity, list.getData());
                            activity.setAdapter(adapter);
                            activity.getRecyclerView().setAdapter(adapter);
                        }
                );
            }
        }
    }
}
