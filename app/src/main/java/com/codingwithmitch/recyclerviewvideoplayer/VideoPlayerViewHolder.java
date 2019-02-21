package com.codingwithmitch.recyclerviewvideoplayer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.android.exoplayer2.ui.PlayerView;

public class VideoPlayerViewHolder extends RecyclerView.ViewHolder  {

    View media_container;
    TextView title, description;

    public VideoPlayerViewHolder(@NonNull View itemView) {
        super(itemView);
        media_container = itemView.findViewById(R.id.media_container);
        title = itemView.findViewById(R.id.title);
        description = itemView.findViewById(R.id.description);
    }
}














