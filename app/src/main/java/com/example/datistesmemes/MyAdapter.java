package com.example.datistesmemes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Meme> memes;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public String name;
        public String url;
        public ImageView imageView;

        public MyViewHolder(ImageView v) {
            super(v);
            imageView = v;
            imageView.setOnClickListener(view -> {
                Intent intent = new Intent(view.getContext(), Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("url", url);

                intent.putExtras(bundle);

                view.getContext().startActivity(intent);
            });
        }
    }

    MyAdapter(List<Meme> memes) {
        this.memes = memes;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        ImageView v = new ImageView(parent.getContext());
        TextView t = new TextView(parent.getContext());

        v.setPadding(10,10,10,10);
        MyViewHolder vh = new MyViewHolder(v);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        // holder.textView.setText(memes.get(position).url);
        holder.name = memes.get(position).name;
        holder.url = memes.get(position).url;
        Picasso.get().load(memes.get(position).url).into(holder.imageView);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return memes.size();
    }

}