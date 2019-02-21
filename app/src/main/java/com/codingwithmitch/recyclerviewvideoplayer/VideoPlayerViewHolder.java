package com.codingwithmitch.recyclerviewvideoplayer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class VideoPlayerViewHolder extends RecyclerView.ViewHolder  {

//    PlayerView playerView;
    View media_container;
    TextView title, description;

    public VideoPlayerViewHolder(@NonNull View itemView) {
        super(itemView);
        media_container = itemView.findViewById(R.id.media_container);
        title = itemView.findViewById(R.id.title);
        description = itemView.findViewById(R.id.description);
//        playerView = itemView.findViewById(R.id.player_view);
    }
}














