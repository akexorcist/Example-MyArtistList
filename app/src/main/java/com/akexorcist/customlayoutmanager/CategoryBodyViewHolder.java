package com.akexorcist.customlayoutmanager;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Akexorcist on 2/8/2016 AD.
 */
public class CategoryBodyViewHolder extends RecyclerView.ViewHolder {
    RecyclerView rvCategory;

    public CategoryBodyViewHolder(View itemView) {
        super(itemView);
        rvCategory = (RecyclerView) itemView.findViewById(R.id.rv_category);
    }
}
