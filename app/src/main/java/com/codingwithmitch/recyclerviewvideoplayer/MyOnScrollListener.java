package com.codingwithmitch.recyclerviewvideoplayer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public abstract class MyOnScrollListener extends RecyclerView.OnScrollListener {

    private static final String TAG = "MyOnScrollListener";

    private float deltaY;
    private float screenHeight;

    public MyOnScrollListener(int screenHeight) {
        super();
        this.screenHeight = screenHeight;
    }

    @Override
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if(newState == RecyclerView.SCROLL_STATE_IDLE){
            Log.d(TAG, "onScrollStateChanged: IDLE.");
            isWithinRange(deltaY, screenHeight);
        }
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        Log.d(TAG, "onScrolled: deltaY: " + deltaY);
        deltaY = deltaY + dy;
    }

    public abstract void isWithinRange(float deltaY, float screenHeight);
}















