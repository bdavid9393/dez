package com.example.root.dez;
import com.example.root.dez.Model.SearchAnswer;
import com.example.root.dez.Model.TrackAnswer;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by root on 05.11.16.
 */

public interface API {

    @GET("/search/album")
    Call<SearchAnswer> CallSearch(
            @Query("q") String search,
            @Query("index") int PageIndex);

   @GET("/album/{id}/tracks")
   Call<TrackAnswer> CallTracks(@Path("id") int id);








}