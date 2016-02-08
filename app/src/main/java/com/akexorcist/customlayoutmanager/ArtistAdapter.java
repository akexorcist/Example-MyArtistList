package com.akexorcist.customlayoutmanager;

import android.os.Handler;
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

    private ArrayList<String> nameList;
    private ArrayList<String> categoryList;

    private int headerScrollPosition = 0;

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
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (position == POSITION_CATEGORY_HEADER) {
            createCategoryHeader(viewHolder);
        } else if (position == POSITION_PERSON_HEADER) {
            createPersonHeader(viewHolder);
        } else if (position == POSITION_CATEGORY_BODY) {
            createCategoryItem(viewHolder);
        } else {
            createPersonItem(viewHolder, getPersonPosition(position));
        }
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    private int getPersonPosition(int rawPosition) {
        return rawPosition - 3;
    }

    public void createCategoryHeader(RecyclerView.ViewHolder viewHolder) {
        ((HeaderViewHolder) viewHolder).tvHeader.setText("Category List");
    }

    public void createPersonHeader(RecyclerView.ViewHolder viewHolder) {
        ((HeaderViewHolder) viewHolder).tvHeader.setText("Personal List");
    }

    public void createCategoryItem(RecyclerView.ViewHolder viewHolder) {
        CategoryAdapter adapter = new CategoryAdapter(categoryList);
        final RecyclerView rvCategory = ((CategoryBodyViewHolder) viewHolder).rvCategory;
        rvCategory.setLayoutManager(new LinearLayoutManager(rvCategory.getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvCategory.setAdapter(adapter);
        rvCategory.setLayoutFrozen(false);
        rvCategory.addOnScrollListener(onCategoryHeaderScrollListener);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int lastHeaderScrollPosition = headerScrollPosition;
                headerScrollPosition = 0;
                rvCategory.scrollBy(lastHeaderScrollPosition, 0);
                rvCategory.invalidate();
            }
        }, 1);
    }

    @Override
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        if(viewHolder instanceof CategoryBodyViewHolder) {
            ((CategoryBodyViewHolder) viewHolder).rvCategory.clearOnScrollListeners();
        }
        super.onViewDetachedFromWindow(viewHolder);
    }

    public void createPersonItem(RecyclerView.ViewHolder viewHolder, int position) {
        ((PersonViewHolder) viewHolder).tvPerson.setText(nameList.get(position));
    }

    private RecyclerView.OnScrollListener onCategoryHeaderScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            headerScrollPosition += dx;
        }
    };
}
