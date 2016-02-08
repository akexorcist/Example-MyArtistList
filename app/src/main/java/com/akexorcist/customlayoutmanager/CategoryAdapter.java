package com.akexorcist.customlayoutmanager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Akexorcist on 2/8/2016 AD.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryItemViewHolder> {
    ArrayList<String> categoryList = new ArrayList<>();

    public CategoryAdapter(ArrayList<String> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public CategoryItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_category_item, parent, false);
        return new CategoryItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryItemViewHolder holder, int position) {
        holder.tvCategory.setText(categoryList.get(position));
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
