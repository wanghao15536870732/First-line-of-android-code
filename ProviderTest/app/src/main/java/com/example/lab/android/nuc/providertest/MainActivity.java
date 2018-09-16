package com.example.lab.android.nuc.providertest;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.lab.android.nuc.providertest.R.*;

public class MainActivity extends AppCompatActivity {

    private String newId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        Button addData = (Button) findViewById(id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                添加数据
                Uri uri = Uri.parse("content://com.example.databasetest.provider.book");
                ContentValues values = new ContentValues();
                values.put("name","A Clash of Kings");
                values.put("author","George Martin");
                values.put("pages",1040);
                values.put("price",55.55);
                Uri newUri = getContentResolver().insert(uri,values);
                newId = newUri.getPathSegments().get(1);
            }
        });
        Button queryData = (Button)findViewById(id.query_data);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                查询数据
                Uri uri = Uri.parse("content://com.example.databasetest.provider.book");
                Cursor cursor = getContentResolver().query(uri,null,null,null,null);
                if (cursor != null){
                    while (cursor.moveToNext()){
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Toast.makeText(MainActivity.this,"book name is " + name + ",book author is " + author + ",book pages is " + pages + ",book price is " + price,
                                Toast.LENGTH_LONG).show();
                    }
                    cursor.close();
                }
            }
        });
        Button updateData = (Button) findViewById(id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                更新数据
                Uri uri = Uri.parse("content://com.example.databasetest.provider.book/" + newId);
                ContentValues values = new ContentValues();
                values.put("name","A storm of Sword");
                values.put("pages",1216);
                values.put("price",24.05);
                getContentResolver().update(uri,values,null,null);
            }
        });
        Button deleteDate = (Button) findViewById(id.delete_data);
        deleteDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                删除数据
                Uri uri = Uri.parse("content://com.example.databasetest.provider,book/" + newId);
                getContentResolver().delete(uri,null,null);
            }
        });
    }
}
