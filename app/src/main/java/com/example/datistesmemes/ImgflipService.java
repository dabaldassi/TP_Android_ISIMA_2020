package com.example.datistesmemes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ImgflipService {
    @GET("/")
    Call<List<Meme>> listMeme();
}
