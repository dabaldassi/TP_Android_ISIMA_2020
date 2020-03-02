package com.example.datistesmemes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        if(intent != null) {
            Bundle bundle = intent.getExtras();
            String name = bundle.getString("name");
            String url = bundle.getString("url");

            TextView tv = findViewById(R.id.meme_name);
            ImageView imageView = findViewById(R.id.meme_image);

            tv.setText(name);
            Picasso.get().load(url).into(imageView);
        }

    }
}
