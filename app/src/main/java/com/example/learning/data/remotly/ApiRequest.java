package com.example.learning.data.remotly;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRequest {

    @GET("api/quotes")
    public Call<QuotesResponse> getQuotes();

    @GET("api/feelings")
    public Call<FeelingsResponse> getFeelings();

    @POST("api/user/login")
    public Call<LoginResponse> postLogin(@Body @NonNull LoginBody body);
}
