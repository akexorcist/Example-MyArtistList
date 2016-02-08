package com.akexorcist.customlayoutmanager;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Akexorcist on 2/8/2016 AD.
 */
public class PersonViewHolder extends RecyclerView.ViewHolder {
    TextView tvPerson;

    public PersonViewHolder(View itemView) {
        super(itemView);
        tvPerson = (TextView) itemView.findViewById(R.id.tv_person);
    }
}
