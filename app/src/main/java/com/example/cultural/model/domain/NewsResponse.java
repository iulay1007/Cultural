package com.example.cultural.model.domain;

public class NewsResponse {
    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getMcontent() {
        return mcontent;
    }

    public void setMcontent(String mcontent) {
        this.mcontent = mcontent;
    }

    public NewsResponse(String mtitle, String pic_url, String mcontent) {
        this.mtitle = mtitle;
        this.pic_url = pic_url;
        this.mcontent = mcontent;
    }

    public String mtitle;
    public String pic_url;
    public String mcontent;

}
