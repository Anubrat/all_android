package com.appliaction.newsportal;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Manandhar on 5/3/16.
 */
public class Decorator extends RecyclerView.ItemDecoration {
    int i;
    public Decorator(int i) {
        this.i=i;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.right=i;
        outRect.left=i;
        outRect.top=i;
        outRect.bottom=i;
    }
}
