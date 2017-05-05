package com.appliaction.newsportal;


import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Collections;
import java.util.List;

import static com.appliaction.newsportal.R.layout.activity_design;

/**
 * Created by Manandhar on 5/3/16.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private final LayoutInflater inflater;
    List<Information> data = Collections.emptyList();

    public CustomAdapter(Context ctx, List<Information> value) {
        inflater = LayoutInflater.from(ctx);
        this.data = value;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_design, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        YoYo.with(Techniques.FlipInX).duration(700).playOn(holder.views);
        Information current = data.get(position);
        holder.title.setText(current.Name);
        holder.image.setImageResource(current.Image);
        holder.heading.setText(current.Heading);
        holder.image.setBackgroundColor(Color.RED);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,heading;
        ImageView image;

        CardView views;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_text);
            heading = (TextView) itemView.findViewById(R.id.heading);
            image = (ImageView) itemView.findViewById(R.id.thumb_img);
            views=(CardView)itemView.findViewById(R.id.card);

        }
    }
}
