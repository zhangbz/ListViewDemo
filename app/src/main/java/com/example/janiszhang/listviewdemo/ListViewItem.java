package com.example.janiszhang.listviewdemo;

/**
 * Created by janiszhang on 2016/3/5.
 */
public class ListViewItem {
    private int mNum;
    private int mImgId;

    public ListViewItem(int num, int imgId) {
        mImgId = imgId;
        mNum = num;
    }

    public int getNum() {
        return mNum;
    }

    public int getImgId() {
        return mImgId;
    }
}
