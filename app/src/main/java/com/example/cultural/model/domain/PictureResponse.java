package com.example.cultural.model.domain;

public class PictureResponse {
    public String url;
    public String date;
    public String title;

    public PictureResponse(String url, String date, String title) {
        this.url = url;
        this.date = date;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
