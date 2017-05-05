package com.appliaction.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Manandhar on 5/3/16.
 */
public class Decorator extends RecyclerView.ItemDecoration {

    private int Space;

    public  Decorator(int Space){
        this.Space=Space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left=Space;
        outRect.bottom=Space;
        outRect.right=Space;
        if(parent.getChildLayoutPosition(view)==0){
            outRect.top=Space;
        }
    }
}
