package com.androiddesdecero.musica.service;

import com.androiddesdecero.musica.Feed;
import com.androiddesdecero.musica.Music;
import com.androiddesdecero.musica.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by albertopalomarrobledo on 14/2/19.
 */

public interface Client {

    @GET("/api/v1/us/apple-music/top-songs/all/10/explicit.json")
    Call<Music> getMusic();
}
