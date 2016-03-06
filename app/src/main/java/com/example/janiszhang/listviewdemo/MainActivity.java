package com.example.janiszhang.listviewdemo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ListViewItem> mListViewData = new ArrayList<ListViewItem>();
    private int mNum = 30;
    private MyAdapter mMyAdapter;
    private MyListView mListView;
    private int mScaledTouchSlop;
    private float mFirstY;
    private float mCurrentY;
    private int direction;
    private boolean mShow;
    private Animator mAnimator;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        //获取系统认为的最低滑动距离
        mScaledTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mListView = (MyListView) findViewById(R.id.listview);

        //给ListView添加一个HeaderView,避免第一个Item被Toolbar遮挡
        View header = new View(this);
        header.setLayoutParams(new AbsListView.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT,
                (int) getResources().getDimension(R.dimen.abc_action_bar_default_height_material)));//使用abc_action_bar_default_height_material属性获取系统ActionBar的高度
        mListView.addHeaderView(header);

        mListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mFirstY = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        mCurrentY = event.getY();
                        if(mCurrentY - mFirstY > mScaledTouchSlop) {
                            direction = 0;//down
                        } else {
                            direction = 1;//up
                        }
                        if (direction == 1) {
                            if(mShow){
                                toolbarAnim(1);//show
                                mShow = !mShow;
                            }
                        } else {
                            if(!mShow) {
                                toolbarAnim(0);//hide
                                mShow = !mShow;
                            }
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return false;
            }
        });

        mMyAdapter = new MyAdapter(MainActivity.this, R.layout.item_layout, mListViewData);
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

    private void toolbarAnim(int flag) {
        if (mAnimator != null && mAnimator.isRunning()) {
            mAnimator.cancel();
        }
        if (flag == 0) {
            mAnimator = ObjectAnimator.ofFloat(mToolbar, "translationY", mToolbar.getTranslationY(),0);
        } else {
            mAnimator = ObjectAnimator.ofFloat(mToolbar, "translationY", mToolbar.getTranslationY(), -mToolbar.getHeight());
        }
        mAnimator.start();
    }

    private void initData() {
        for (int i = 0; i < mNum; i++) {
            mListViewData.add(new ListViewItem(i, R.mipmap.ic_launcher));
        }
    }
}
