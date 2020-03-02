package com.example.datistesmemes;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MyViewModel extends ViewModel {
    private MutableLiveData<List<Meme>> memeListMutable;
    private List<Meme> memeList = new ArrayList<>();

    public LiveData<List<Meme>> getMemeList() {
        if(memeListMutable == null) {
            memeListMutable = new MutableLiveData<>();
            loadMeme();
        }

        return memeListMutable;
    }

    private void loadMeme() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.imgflip.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d("T", "AHHHHH");
        ImgflipService service = retrofit.create(ImgflipService.class);
        Call<ApiResponse> meme = service.listMeme();

        meme.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> memes, Response<ApiResponse> response) {
                memeListMutable.setValue(response.body().data.memes);
            }

            @Override
            public void onFailure(Call<ApiResponse> memeList, Throwable t) {
                Log.d("T", "onFailure");
            }
        });

    }
}