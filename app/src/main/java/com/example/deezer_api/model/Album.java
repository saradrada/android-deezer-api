package com.example.deezer_api.model;

import java.io.Serializable;

public class Album implements Serializable {

    private Long id;
    private String title, cover, cover_big, release_date;

    public Album(Long id, String title, String cover, String cover_big, String release_date) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.cover_big = cover_big;
        this.release_date = release_date;
    }

    public Album() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }

    public String getCover_big() {
        return cover_big;
    }
}
