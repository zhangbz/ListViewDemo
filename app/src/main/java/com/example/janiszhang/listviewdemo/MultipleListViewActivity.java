package com.example.janiszhang.listviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MultipleListViewActivity extends Activity {


    private ArrayList<ListViewItem> mListViewData = new ArrayList<ListViewItem>();
    private int mNum = 30;
    private MyAdapter mMyAdapter;
    private MyListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_list_view);
        initData();
        mListView = (MyListView) findViewById(R.id.listview);

        mMyAdapter = new MyAdapter(MultipleListViewActivity.this, R.layout.item_layout, mListViewData);
        mListView.setAdapter(mMyAdapter);
        mListView.setEmptyView(findViewById(R.id.empty_view));
        mListView.setSelection(5);
        Button bt_add = (Button) findViewById(R.id.bt_add);
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListViewData.add(new ListViewItem(mNum++, R.mipmap.ic_launcher));
                mMyAdapter.notifyDataSetChanged();
                mListView.setSelection(mNum - 1);
            }
        });
    }

    private void initData() {
        for (int i = 0; i < mNum; i++) {
            mListViewData.add(new ListViewItem(i, R.mipmap.ic_launcher));
        }
    }
}
