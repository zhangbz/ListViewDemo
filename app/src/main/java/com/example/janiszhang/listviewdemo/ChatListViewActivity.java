package com.example.janiszhang.listviewdemo;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by janiszhang on 2016/3/7.
 */
public class ChatListViewActivity extends Activity{

    private ListView mChatListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_item_main);

        mChatListView = (ListView) findViewById(R.id.listview);

        ChatItemListViewBean bean1 = new ChatItemListViewBean();
        bean1.setType(0);
        bean1.setIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        bean1.setText("Hello how are you?");
        ChatItemListViewBean bean2 = new ChatItemListViewBean();
        bean2.setType(1);
        bean2.setIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        bean2.setText("Fine thank you, and you?");
        ChatItemListViewBean bean3 = new ChatItemListViewBean();
        bean3.setType(0);
        bean3.setIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        bean3.setText("I am fine too.");
        ChatItemListViewBean bean4 = new ChatItemListViewBean();
        bean4.setType(1);
        bean4.setIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        bean4.setText("Bye bye.");
        ChatItemListViewBean bean5 = new ChatItemListViewBean();
        bean5.setType(0);
        bean5.setIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        bean5.setText("See you");

        List<ChatItemListViewBean> data = new ArrayList<ChatItemListViewBean>();
//        data.add(bean1);
//        data.add(bean2);
//        data.add(bean3);
//        data.add(bean4);
//        data.add(bean5);
//        data.add(bean1);
        data.add(bean2);
        data.add(bean2);
        data.add(bean2);
        data.add(bean2);
        data.add(bean2);
        data.add(bean2);
        data.add(bean2);
        data.add(bean2);
        data.add(bean2);
        data.add(bean2);
        data.add(bean2);
        data.add(bean2);
        data.add(bean2);
        data.add(bean2);
        data.add(bean2);
        data.add(bean1);
        data.add(bean1);

//        data.add(bean3);
//        data.add(bean4);
//        data.add(bean5);
//        data.add(bean1);
//        data.add(bean2);
//        data.add(bean3);
//        data.add(bean4);
//        data.add(bean5);
        mChatListView.setAdapter(new ChatItemListViewAdapter(this, data));
    }
}
