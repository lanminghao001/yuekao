package com.example.lanminghao201812212;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lanminghao201812212.image.Image2;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Bean.ResultBean> list;

    public MyAdapter(Context context, List<Bean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }
//返回条目
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//listview优化
        ViewHolder view;
        if(convertView==null){
            convertView = View.inflate(context,R.layout.item,null);
            view = new ViewHolder();
            view.imageView = convertView.findViewById(R.id.shu_image);
            view.textView1 = convertView.findViewById(R.id.text1);
            view.textView2 = convertView.findViewById(R.id.text2);
            convertView.setTag(view);
        }else {
            view = (ViewHolder) convertView.getTag();
        }
        Bean.ResultBean bean = list.get(position);
        ImageLoader.getInstance().displayImage(bean.getImageUrl(),view.imageView,Image2.image());
        view.textView1.setText(bean.getName());
        view.textView2.setText(bean.getSummary());
        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView1;
        TextView textView2;
    }
}
