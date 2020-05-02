package com.example.deezer_api.model;

public class List {

    private PlayList[] data;
    private long total;
    private String next;

    public List(PlayList[] data, long total, String next) {
        this.data = data;
        this.total = total;
        this.next = next;
    }

    public List() {
    }

    public PlayList[] getData() {
        return data;
    }
}
