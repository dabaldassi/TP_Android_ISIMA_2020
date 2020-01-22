package com.example.datistesmemes;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyViewModel model = ViewModelProviders.of(this).get(MyViewModel.class);

        model.getMemeList().observe(this, new Observer<List<Meme>>() {
            @Override
            public void onChanged(List<Meme> memes) {
                Log.d("C", "Changed");
            }
        });

        /*TextView t = findViewById(R.id.lbl);
        t.setText(str);*/


    }
}

