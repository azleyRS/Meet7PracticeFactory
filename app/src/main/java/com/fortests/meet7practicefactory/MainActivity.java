package com.fortests.meet7practicefactory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<ItemTypes> mData = new ArrayList<>();
        mData.add(ItemTypes.ITEM1);
        mData.add(ItemTypes.ITEM2);
        mData.add(ItemTypes.ITEM3);
        mData.add(ItemTypes.ITEM4);

        mAdapter = new MyAdapter(mData);
        mRecyclerView.setAdapter(mAdapter);
    }
}
