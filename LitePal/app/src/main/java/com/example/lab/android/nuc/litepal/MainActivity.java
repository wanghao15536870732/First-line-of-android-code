package com.example.lab.android.nuc.litepal;

import android.database.Cursor;
import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用此方法就是依次简单的数据库操作
                 Connector.getDatabase();
            }
        });
        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(16.56);
                book.setPress("Unknow");
                book.save();
            }
        });
        Button updataData = (Button) findViewById(R.id.updata_data);
        updataData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Book book = new Book();
//                book.setName("The Lost System");
//                book.setAuthor("Dan Brown");
//                book.setPages(510);
//                book.setPrice(19.95);
//                book.setPress("Unknow");
//                book.save();
//                book.setPrice(10.99);
//                book.save();
                /*
                此时Litepal会发现当前的Book对象是存在的,因此不会在想数据库添加一条新数据，而是直接更新当前的数据
                但是这种更新方式只能对以储存的对象进行修改，限制性比较大
                 */
                Book book = new Book();
                book.setPrice(14.95);
                book.setPress("Anchor");
                book.updateAll("name = ? and author = ?","The Lost Symbol","Dan Brown");

            }
        });

        Button deleteButton = (Button) findViewById(R.id.delete_data);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                1.比较直接的删除方法：调用已储存对象的delete()方法即可
//                Book book = new Book();
//                book.delete();

//                2.调用DataSupport.deleteAll()方法进行删除

                DataSupport.deleteAll(Book.class,"price < ?","15");
            }
        });

        Button queryButton = (Button) findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                findAll()方法返回的是一个Book类型的List集合，
//                也就是说，不用像以前那样再通过Cursor对象去一行一行的去取值了
                List<Book> books = DataSupport.findAll(Book.class);

////              查询Book表中的第一条数据
//                Book firstBook = DataSupport.findFirst(Book.class);

////                查询Book表中的第二条数据
//                Book lastBook = DataSupport.findLast(Book.class);

////                select()方法用于指定查询的约束条件
////              查询name和author两列
//                List<Book> books  = DataSupport.select("name","author").find(Book.class);

////                where()方法对应了SQL当中的where关键字
//                List<Book> books = DataSupport.where("pages > ?","400").find(Book.class);


//                而且如果API都满足不了你的时候，LitePal仍然支持使用原生的SQL来查询
                Cursor c = DataSupport.findBySQL("select * from Book where pages > ? and price < ?","400","20");
//                返回的是一个Cursor对象，接下来需要老方法将数据一一取出】



//                然后通过数组的方式通过Log打印出来，即遍历List集合中的Book对象
                for (Book book: books){
                    Log.d("MainActivity","book name is " + book.getName());
                    Log.d("MainActivity","book author is " + book.getAuthor());
                    Log.d("MainActivity","book pages is " + book.getPages());
                    Log.d("MainActivity","book press is " + book.getPress());
                    Log.d("MainActivity","book price is " + book.getPrice());
                }
            }
        });
    }
}
