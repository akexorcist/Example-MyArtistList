package com.akexorcist.customlayoutmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> categoryList = new ArrayList<>();
        categoryList.add("Artist");
        categoryList.add("Album");
        categoryList.add("Genre");
        categoryList.add("Year");
        categoryList.add("Volume");
        categoryList.add("Company");

        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("Ake");
        nameList.add("Chai");
        nameList.add("Bin");
        nameList.add("Trust");
        nameList.add("Nine");
        nameList.add("Chin");
        nameList.add("New");
        nameList.add("Boom");
        nameList.add("Neung");
        nameList.add("Mink");
        nameList.add("Maew");
        nameList.add("Non");
        nameList.add("Kom");
        nameList.add("Keng");
        nameList.add("O");
        nameList.add("Oh");
        nameList.add("Ohm");
        nameList.add("Orn");
        nameList.add("Da");
        nameList.add("Dow");

        RecyclerView rvName = (RecyclerView) findViewById(R.id.rv_name);
        GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (position >= 3) ? 1 : 3;
            }
        });
        rvName.setLayoutManager(manager);
        ArtistAdapter adapter = new ArtistAdapter(categoryList, nameList);
        rvName.setAdapter(adapter);

    }
}
