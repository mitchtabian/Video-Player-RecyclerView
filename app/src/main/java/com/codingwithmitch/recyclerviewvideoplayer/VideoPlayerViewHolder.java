package com.codingwithmitch.recyclerviewvideoplayer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.codingwithmitch.recyclerviewvideoplayer.models.MediaObject;


public class VideoPlayerViewHolder extends RecyclerView.ViewHolder  {

    FrameLayout media_container;
    TextView title;
    ImageView thumbnail;
    ProgressBar progressBar;
    View parent;

    public VideoPlayerViewHolder(@NonNull View itemView) {
        super(itemView);
        parent = itemView;
        media_container = itemView.findViewById(R.id.media_container);
        thumbnail = itemView.findViewById(R.id.thumbnail);
        title = itemView.findViewById(R.id.title);
        progressBar = itemView.findViewById(R.id.progressBar);
    }

    public void onBind(MediaObject mediaObject, RequestManager requestManager) {
        parent.setTag(this);
        title.setText(mediaObject.getTitle());
        requestManager
                .load(mediaObject.getThumbnail())
                .into(thumbnail);
    }
}














