package com.example.datistesmemes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ImgflipService {
    @GET("get_memes")
    Call<ApiResponse> listMeme();
}
