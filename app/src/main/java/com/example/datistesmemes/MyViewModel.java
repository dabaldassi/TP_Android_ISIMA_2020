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
import retrofit2.http.GET;


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
                .baseUrl("https://api.imgflip.com/get_memes")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ImgflipService service = retrofit.create(ImgflipService.class);
        Call<List<Meme>> meme = service.listMeme();
        meme.enqueue(new Callback<List<Meme>>() {
            @Override
            public void onResponse(Call<List<Meme>> memes, Response<List<Meme>> response) {
                Log.d("T", response.message());
            }

            @Override
            public void onFailure(Call<List<Meme>> memeList, Throwable t) {

            }
        });
    }
}