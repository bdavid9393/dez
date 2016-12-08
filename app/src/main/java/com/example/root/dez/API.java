package com.example.root.dez;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by root on 05.11.16.
 */

interface API {

    @GET("/search")
    Call<SearchResults> valami(
            @Query("q") String search,
            @Query("index") int PageIndex);





}