package com.programming.android.sdu.externallibraryexercise;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by grzegorzbaczek on 07/03/2018.
 */

public class RandomPicturesAdapter extends RecyclerView.Adapter<RandomPicturesAdapter.ViewHolder> {
    private Map<Integer, String> mDataset = new HashMap<>();
    private Context context;

    public  class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public ViewHolder(View v) {
            super(v);
            imageView = v.findViewById(R.id.ivCell);
        }
    }

    public RandomPicturesAdapter(Context context){
        this.context = context;
    }

    @Override
    public RandomPicturesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String urlToCall = String.format("https://picsum.photos/500/500?image=%d", position);
        Glide.with(context).clear(holder.imageView);
        Glide.with(context).load(urlToCall).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return 50;
    }
}
