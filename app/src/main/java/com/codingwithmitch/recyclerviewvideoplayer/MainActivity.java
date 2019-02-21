package com.codingwithmitch.recyclerviewvideoplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.codingwithmitch.recyclerviewvideoplayer.models.MediaObject;
import com.codingwithmitch.recyclerviewvideoplayer.util.Resources;
import com.codingwithmitch.recyclerviewvideoplayer.util.Util;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public static final float LOWER_BOUND = 0.07f;
    public static final float UPPER_BOUND = 0.67f;
    public static final float ELLIPSES = 0.04f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        final VideoPlayerRecyclerAdapter adapter = new VideoPlayerRecyclerAdapter(
                new ArrayList<MediaObject>(Arrays.asList(Resources.MEDIA_OBJECTS)),
                Util.getScreenHeight(getWindowManager(), getResources())
        );

        recyclerView.addOnScrollListener(new MyOnScrollListener(Util.getScreenHeight(getWindowManager(), getResources())) {

            @Override
            public void isWithinRange(float deltaY, float screenHeight) {

                int n = 0;
                if(deltaY >= (screenHeight * UPPER_BOUND)){
                    n = (int) ((deltaY / screenHeight) + (1f - UPPER_BOUND));
                }
                adapter.setPositionInRange(n);
                Log.d(TAG, "isWithinRange: deltaY: " + deltaY);
                Log.d(TAG, "isWithinRange: n: " + n);

                boolean isWithinRange;
                if(n > 0){
                    isWithinRange = (deltaY > ((n - 1 + UPPER_BOUND) * screenHeight) && deltaY < ((n + LOWER_BOUND) * screenHeight));
                }
                else{
                    isWithinRange = (deltaY > 0) && (deltaY < LOWER_BOUND * screenHeight);
                }
                Log.d(TAG, "isWithinRange: is within range?: " + isWithinRange);
                adapter.setIsWithinRange(isWithinRange);
            }

        });

        recyclerView.setAdapter(adapter);
    }


}

















