package com.example.janiszhang.listviewdemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ListView;

/**
 * Created by janiszhang on 2016/3/6.
 * 添加弹性效果
 */
public class MyListView extends ListView {
    //初始可拉动Y轴方向距离
    private static final int MAX_Y_OVERSCROLL_DISTANCE = 100;
    //上下文环境
    private Context mContext;
    //实际可上下拉动Y轴上的距离
    private int mMaxYOverscrollDistance;

    public MyListView(Context context) {
        super(context);
        mContext = context;
        initBounceListView();
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initBounceListView();
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initBounceListView();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
        initBounceListView();
    }

    private void initBounceListView() {
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        float density = displayMetrics.density;
        mMaxYOverscrollDistance = (int) (density * MAX_Y_OVERSCROLL_DISTANCE);
    }



    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        //实现的本质是在这里动态改变了maxOverScrollY的值
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxYOverscrollDistance, isTouchEvent);
    }
}
