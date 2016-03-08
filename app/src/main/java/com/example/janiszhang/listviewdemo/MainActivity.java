package com.example.janiszhang.listviewdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button mMultipleListViewButton;
    private Button mChatListViewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMultipleListViewButton = (Button) findViewById(R.id.button_multiple_list_view);
        mMultipleListViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MultipleListViewActivity.class));
            }
        });

        mChatListViewButton = (Button) findViewById(R.id.button_chat_list_view);
        mChatListViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ChatListViewActivity.class));
            }
        });
    }

}
