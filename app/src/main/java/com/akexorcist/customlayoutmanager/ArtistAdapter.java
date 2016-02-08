package com.akexorcist.customlayoutmanager;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Akexorcist on 2/8/2016 AD.
 */
public class ArtistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int POSITION_CATEGORY_HEADER = 0;
    public static final int POSITION_CATEGORY_BODY = 1;
    public static final int POSITION_PERSON_HEADER = 2;
    public static final int POSITION_PERSON_BODY = 3;

    ArrayList<String> nameList;
    ArrayList<String> categoryList;

    public ArtistAdapter(ArrayList<String> categoryList, ArrayList<String> nameList) {
        this.nameList = nameList;
        this.categoryList = categoryList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == POSITION_CATEGORY_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_header, parent, false);
            return new HeaderViewHolder(view);
        } else if (viewType == POSITION_CATEGORY_BODY) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_category_body, parent, false);
            return new CategoryBodyViewHolder(view);
        } else if (viewType == POSITION_PERSON_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_header, parent, false);
            return new HeaderViewHolder(view);
        } else if (viewType == POSITION_PERSON_BODY) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_person_item, parent, false);
            return new PersonViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == POSITION_CATEGORY_HEADER) {
            return POSITION_CATEGORY_HEADER;
        } else if (position == POSITION_CATEGORY_BODY) {
            return POSITION_CATEGORY_BODY;
        } else if (position == POSITION_PERSON_HEADER) {
            return POSITION_PERSON_HEADER;
        }
        return POSITION_PERSON_BODY;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == POSITION_CATEGORY_HEADER) {
            ((HeaderViewHolder) holder).tvHeader.setText("Category List");
        } else if (position == POSITION_PERSON_HEADER) {
            ((HeaderViewHolder) holder).tvHeader.setText("Personal List");
        } else if (position == POSITION_CATEGORY_BODY) {
            CategoryAdapter adapter = new CategoryAdapter(categoryList);
            RecyclerView rvCategory = ((CategoryBodyViewHolder) holder).rvCategory;
            rvCategory.setAdapter(adapter);
            rvCategory.setLayoutManager(new LinearLayoutManager(rvCategory.getContext(), LinearLayoutManager.HORIZONTAL, false));
        } else {
            ((PersonViewHolder) holder).tvPerson.setText(nameList.get(getPersonPosition(position)));
        }
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    private int getPersonPosition(int rawPosition) {
        return rawPosition - 3;
    }
}
