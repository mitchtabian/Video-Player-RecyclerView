package com.codingwithmitch.recyclerviewvideoplayer;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.codingwithmitch.recyclerviewvideoplayer.models.MediaObject;

import java.util.ArrayList;

import static com.codingwithmitch.recyclerviewvideoplayer.MainActivity.ELLIPSES;
import static com.codingwithmitch.recyclerviewvideoplayer.MainActivity.UPPER_BOUND;

public class VideoPlayerRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "adapter";

    private static final int ON = 0;
    private static final int OFF = 1;

    private ArrayList<MediaObject> mediaObjects;
    private boolean isWithinRange;
    private int positionInRange;
    private int screenHeight, descriptionHeight;


    public VideoPlayerRecyclerAdapter(ArrayList<MediaObject> mediaObjects, int screenHeight) {
        this.mediaObjects = mediaObjects;
        positionInRange = 0;
        this.screenHeight = screenHeight;
        setDescriptionHeight();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new VideoPlayerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_video_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        int viewType = getItemViewType(i);
        switch (viewType){
            case ON:{
                if(isWithinRange){
                    Log.d(TAG, "onBindViewHolder: position: " + i);
                    if(positionInRange == i){
                        setViews(((VideoPlayerViewHolder)viewHolder), i, "ON");
                    }
                    else{
                        setViews(((VideoPlayerViewHolder)viewHolder),  i, "OFF");
                    }
                }
                else{
                    setViews(((VideoPlayerViewHolder)viewHolder), i, "OFF");
                }
                break;
            }
            case OFF:{
                setViews(((VideoPlayerViewHolder)viewHolder),  i, "OFF");
                break;
            }
            default:{
                setViews(((VideoPlayerViewHolder)viewHolder),  i, "OFF");
                break;
            }
        }
    }

    private void setViews(VideoPlayerViewHolder viewHolder, int position, String state){
        if(state.equals("ON")){
            viewHolder.media_container.setBackgroundColor(Color.GREEN);
        }
        else if(state.equals("OFF")){
            viewHolder.media_container.setBackgroundColor(Color.GRAY);
        }
        viewHolder.title.setText(mediaObjects.get(position).getTitle());
        viewHolder.description.setText(mediaObjects.get(position).getDescription());
//
//        Log.d(TAG, "setViews: line count: " + viewHolder.description.getLineCount());
//        Log.d(TAG, "setViews: line height: " + viewHolder.description.getLineHeight());
//        Log.d(TAG, "setViews: decription height: " + descriptionHeight);
//        Log.d(TAG, "setViews: " + (descriptionHeight / viewHolder.description.getLineHeight()));

        if(viewHolder.description.getLineCount() > (descriptionHeight / viewHolder.description.getLineHeight())){
            viewHolder.description.setMaxLines((descriptionHeight / viewHolder.description.getLineHeight()) - 1);
        }
    }

    @Override
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        if(holder.getAdapterPosition() >= 0){
            mediaObjects.get(holder.getAdapterPosition()).setPlayback_state("ON");
        }
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if(holder.getAdapterPosition() >= 0){
            mediaObjects.get(holder.getAdapterPosition()).setPlayback_state("OFF");
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(mediaObjects.get(position).getPlayback_state().equals("OFF")){
            return OFF;
        }
        return ON;
    }

    @Override
    public int getItemCount() {
        return mediaObjects.size();
    }

    public void setIsWithinRange(boolean isWithinRange){
        this.isWithinRange = isWithinRange;
        notifyDataSetChanged();
    }
    public void setPositionInRange(int position){
        Log.d(TAG, "setPositionInRange: " + position);
        positionInRange = position;
    }

    private void setDescriptionHeight(){
        descriptionHeight = (int) (screenHeight * (1 - UPPER_BOUND));
    }
}














