package com.example.cultural.model.domain;

import java.util.List;

public class HeritageResponse {
    public String title;
    public String mtype;
    public String cate;
    public String province;
    public String protect_unit;
    public List<String> info;
    public String content;

    public HeritageResponse(String title, String mtype, String cate, String province, String protect_unit, List<String> info, String content) {
        this.title = title;
        this.mtype = mtype;
        this.cate = cate;
        this.province = province;
        this.protect_unit = protect_unit;
        this.info = info;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProtect_unit() {
        return protect_unit;
    }

    public void setProtect_unit(String protect_unit) {
        this.protect_unit = protect_unit;
    }

    public List<String> getInfo() {
        return info;
    }

    public void setInfo(List<String> info) {
        this.info = info;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
