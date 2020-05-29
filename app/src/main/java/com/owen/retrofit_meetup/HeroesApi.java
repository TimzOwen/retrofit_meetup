package com.owen.retrofit_meetup;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HeroesApi {

    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")

    Call<List<Heroes>> getHeroes();
}
