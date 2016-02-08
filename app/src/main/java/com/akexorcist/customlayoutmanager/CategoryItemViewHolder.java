package com.akexorcist.customlayoutmanager;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Akexorcist on 2/8/2016 AD.
 */
public class CategoryItemViewHolder extends RecyclerView.ViewHolder {
    TextView tvCategory;

    public CategoryItemViewHolder(View itemView) {
        super(itemView);
        tvCategory = (TextView) itemView.findViewById(R.id.tv_category);
    }
}
