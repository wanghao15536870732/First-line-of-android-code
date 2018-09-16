package com.example.lab.android.nuc.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SlideCutListView.RemoveListener {

    private SlideCutListView slideCutListView;

    private ArrayAdapter<String> adapter;

    private List<String> dataSourceList = new ArrayList<String>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        slideCutListView = (SlideCutListView) findViewById(R.id.slideCutListView);
        slideCutListView.setRemoveListener(this);

        for (int i = 0; i < 20; i++) {
            dataSourceList.add("滑动删除" + i);
        }
        adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.list_view,dataSourceList);
        slideCutListView.setAdapter(adapter);
        slideCutListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, dataSourceList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //滑动删除之后的回调方法
    @Override
    public void removeItem(SlideCutListView.RemoveDirection direction, int position) {

        adapter.remove(adapter.getItem(position));
        switch (direction){
            case RIGHT:
                Toast.makeText(this, "向右删除", Toast.LENGTH_SHORT).show();
                break;
            case LEFT:
                Toast.makeText(this, "向左删除", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
    }
}
