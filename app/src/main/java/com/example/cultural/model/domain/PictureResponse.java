package com.example.cultural.model.domain;

import java.util.List;

public class PictureResponse {
    public String url;
    public String date;
    public String title;
    public List<String> mpic_url;
    public List<String> mtitle;

    public PictureResponse(String url, String date, String title, List<String> mpic_url, List<String> mtitle) {
        this.url = url;
        this.date = date;
        this.title = title;
        this.mpic_url = mpic_url;
        this.mtitle = mtitle;
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

    public List<String> getMpic_url() {
        return mpic_url;
    }

    public void setMpic_url(List<String> mpic_url) {
        this.mpic_url = mpic_url;
    }

    public List<String> getMtitle() {
        return mtitle;
    }

    public void setMtitle(List<String> mtitle) {
        this.mtitle = mtitle;
    }

    @Override
    public String toString() {
        return "PictureResponse{" +
                "url='" + url + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", mpic_url=" + mpic_url +
                ", mtitle=" + mtitle +
                '}';
    }
}
