package com.example.ahsannaveed.alliedapaiconsuming;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiConsuming {
    String BASE_URL="https://el.alliedschools.edu.pk/api/ApiCall/GetData/";

    @GET("?id=88e4ad01-3049-bf81-b2c9-c5bd393e345c:S")
    Call<List<ApiModel>> getData();


}
