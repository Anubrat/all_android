package com.appliaction.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

/**
 * Created by Manandhar on 5/2/16.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private final LayoutInflater inflater;
    List<Information> data = Collections.emptyList();
    Context ctx;

    public CustomAdapter(Context ctx, List<Information> data) {
        inflater = LayoutInflater.from(ctx);
        this.data = data;
        this.ctx = ctx;
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
        holder.title.setText(current.textView);
        Picasso.with(ctx).load(current.imageView).into(holder.icon);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView views;
        TextView title;
        ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.textV);
            icon = (ImageView) itemView.findViewById(R.id.imageV);
            views = (CardView) itemView.findViewById(R.id.card);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.v("**%%%%","bsdf"+data);
                    Log.v("**%%%%",String.valueOf(getLayoutPosition()));
                    Intent myIntent=new Intent();
                    startIntent(myIntent);
                }
            });
        }

    }


}