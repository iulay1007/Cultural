package com.example.cultural.model;

import com.example.cultural.model.domain.IntangibleCulturalHeritage;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {


    @GET("Article/Index/getProject.html?province=&rx_time=&type=&cate=&keywords=&category_id=16&limit=10&p=1/")
    Call<IntangibleCulturalHeritage> getIntangibleCulturalHeritage();

}
