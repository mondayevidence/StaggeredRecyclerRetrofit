package com.retrocalls;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    //insert api key
    public static String API_KEY = "insert api key";

    @GET("popular")
    Call<ImageResponses> getPopularImages(@Query("api_key") String apiKey);

}
