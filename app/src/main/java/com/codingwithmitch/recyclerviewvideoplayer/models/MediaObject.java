package com.codingwithmitch.recyclerviewvideoplayer.models;

public class MediaObject {

    private String title;
    private String media_url;
    private String description;
    private String playback_state;

    public MediaObject(String title, String media_url, String description, String playback_state) {
        this.title = title;
        this.media_url = media_url;
        this.description = description;
        this.playback_state = playback_state;
    }

    public MediaObject() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedia_url() {
        return media_url;
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlayback_state() {
        return playback_state;
    }

    public void setPlayback_state(String playback_state) {
        this.playback_state = playback_state;
    }
}










