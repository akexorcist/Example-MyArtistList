package com.akexorcist.customlayoutmanager;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Akexorcist on 2/8/2016 AD.
 */
public class HeaderViewHolder extends RecyclerView.ViewHolder {
    TextView tvHeader;

    public HeaderViewHolder(View itemView) {
        super(itemView);
        tvHeader = (TextView) itemView.findViewById(R.id.tv_header);
    }
}
