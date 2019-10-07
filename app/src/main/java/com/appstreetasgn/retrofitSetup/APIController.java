package com.appstreetasgn.retrofitSetup;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIController {

    static final String BASE_URL = "https://github-trending-api.now.sh/";

    public static GithubAPI getApiBase() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit.create(GithubAPI.class);
    }
}