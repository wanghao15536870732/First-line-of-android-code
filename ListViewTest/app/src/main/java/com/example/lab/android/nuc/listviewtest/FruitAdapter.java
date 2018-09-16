package com.example.lab.android.nuc.listviewtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 王浩 on 2018/2/8.
 */

public class FruitAdapter extends ArrayAdapter<Fruit>{

    private int resourceId;

    public FruitAdapter(@NonNull Context context, int textViewResourceId, @NonNull List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);  //获取当前项的Fruit实例

        View view;
        ViewHolder viewHolder;
        //如果convertView 为null,则使用LayoutInflater去加载布局
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,
                    false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);//将ViewHolder储存在View中
        }else {//如果不为null，则对convertView 进行重用
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();//重新获取ViewHolder
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());


         //没有优化之前的代码
        //此方法没有应用到缓存
//        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,
//                false);

//        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
//        TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
//        fruitImage.setImageResource(fruit.getImageId());
//        fruitName.setText(fruit.getName());

        return view;
    }
    class ViewHolder{
        ImageView fruitImage;

        TextView fruitName;
    }
}
