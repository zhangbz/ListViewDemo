package com.example.janiszhang.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by janiszhang on 2016/3/5.
 * 使用convertView和ViewHolder进行优化
 */
public class MyAdapter extends ArrayAdapter<ListViewItem> {

    private int resourceId;

    public MyAdapter(Context context, int resource, List<ListViewItem> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ListViewItem item = getItem(position);//获取当前项的item实例
        //View view;
        ViewHolder viewHolder;
        if(convertView == null) {//判断是否缓存
            convertView = LayoutInflater.from(getContext()).inflate(resourceId,null);//通过LayoutInflater实例化布局
            viewHolder = new ViewHolder();
            viewHolder.itemImage = (ImageView) convertView.findViewById(R.id.item_image);
            viewHolder.itemNum = (TextView) convertView.findViewById(R.id.item_num);
            convertView.setTag(viewHolder);//将ViewHolder存储在View中
        } else {
            //view = convertView;
            viewHolder = (ViewHolder) convertView.getTag();//重新获取ViewHolder,通过tag找到缓存的布局
        }
        //设置布局中控件要显示的内容
        viewHolder.itemImage.setImageResource(item.getImgId());
        viewHolder.itemNum.setText(item.getNum()+"");

        return convertView;
    }

    class ViewHolder {
        ImageView itemImage;
        TextView itemNum;
    }
}
