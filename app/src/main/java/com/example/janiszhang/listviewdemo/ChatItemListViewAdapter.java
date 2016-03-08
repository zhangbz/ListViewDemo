package com.example.janiszhang.listviewdemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by janiszhang on 2016/3/8.
 */
public class ChatItemListViewAdapter extends BaseAdapter{

    private List<ChatItemListViewBean> mData;
    private LayoutInflater mInflater;

    public ChatItemListViewAdapter(Context context, List<ChatItemListViewBean> data) {
        mData = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        Log.i("zhangbz", "getItemViewType");
        ChatItemListViewBean bean = mData.get(position);
        return bean.getType();//super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return 2;//super.getViewTypeCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            Log.i("zhangbz", "convertView == null");
            if(getItemViewType(position) == 0) {
                Log.i("zhangbz", "type == 0");
                    holder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.chat_item_itemin,null);
                    holder.icon = (ImageView) convertView.findViewById(R.id.icon_in);
                    holder.text = (TextView) convertView.findViewById(R.id.text_in);
                } else {
                Log.i("zhangbz", "type == 1");
                    holder = new ViewHolder();
                    convertView = mInflater.inflate(R.layout.chat_item_itemout, null);
                    holder.icon = (ImageView) convertView.findViewById(R.id.icon_out);
                    holder.text = (TextView) convertView.findViewById(R.id.text_out);
                }
                convertView.setTag(holder);
        } else {
            Log.i("zhangbz", "convertView != null");
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text.setText(mData.get(position).getText());
        holder.icon.setImageBitmap(mData.get(position).getIcon());
        return  convertView;
    }

    public final class ViewHolder{
        public ImageView icon;
        public TextView text;
    }
//    @Override
//    public int getCount() {
//        return 0;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        return null;
//    }


}
