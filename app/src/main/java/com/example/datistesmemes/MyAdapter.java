package com.example.datistesmemes;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Meme> memes;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public ImageView imageView;
        public MyViewHolder(TextView t, ImageView v) {
            super(v);
            textView = t;
            imageView = v;
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
        MyViewHolder vh = new MyViewHolder(t,v);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(memes.get(position).url);
        Picasso.get().load(memes.get(position).url).into(holder.imageView);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return memes.size();
    }

}