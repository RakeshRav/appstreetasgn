package com.appstreetasgn.retrofitSetup;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GithubAPI {

    @GET("/developers")
    Call<ResponseBody> getReposList(@Query("language") String language, @Query("since") String durationType);
}