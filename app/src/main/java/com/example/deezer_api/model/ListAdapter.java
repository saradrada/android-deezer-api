package com.example.deezer_api.model;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.deezer_api.R;
import com.example.deezer_api.view.MainActivity;
import com.example.deezer_api.view.PlayListActivity;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolderList> {

    private MainActivity mainActivity;
    private PlayList[] playLists;

    public ListAdapter(MainActivity mainActivity, PlayList[] playLists) {
        this.mainActivity = mainActivity;
        this.playLists = playLists;
    }

    public PlayList[] getPlayLists() {
        return playLists;
    }

    @NonNull
    @Override
    public ViewHolderList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null, false);
        return new ViewHolderList(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderList holder, int position) {
        holder.setData(playLists[position]);
    }

    @Override
    public int getItemCount() {
        return playLists.length;
    }

    public class ViewHolderList extends RecyclerView.ViewHolder {

        TextView listNameTV, userNameTV, numItemsTV;
        ImageView trackImage;

        public ViewHolderList(@NonNull View itemView) {
            super(itemView);
            listNameTV = itemView.findViewById(R.id.nameTV);
            userNameTV = itemView.findViewById(R.id.artistTV);
            numItemsTV = itemView.findViewById(R.id.releaseTV);
            trackImage = itemView.findViewById(R.id.image);

        }

        public void setData(PlayList playList) {
                listNameTV.setText(playList.getTitle());
                userNameTV.setText("User: " + playList.getUser().getName());
                numItemsTV.setText("Tracks: " + playList.getNb_tracks());
                Glide.with(itemView).load(playList.getPicture()).centerCrop().into(trackImage);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(mainActivity, PlayListActivity.class);
                        i.putExtra("playList", playList);
                        mainActivity.startActivity(i);
                    }
                });
        }
    }
}
