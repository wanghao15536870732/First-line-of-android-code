package com.example.lab.android.nuc.databasetest;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class MydatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_BOOK = "create table Book("
            + "id integer primary key autoincrement,"
            + "author text,"
            + "price real,"
            + "pages integer,"
            + "name text)";
//    添加一个Category表用于记录图书的分类
    public static final String CREATE_CATEGORY = "create teble Category("
            + "id integer primary key autoincrement,"
            + "category_name text,"
            + "category_code integer)";

    private Context mcontext;

    public MydatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mcontext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);

    }

//    运行一下点击按钮，发现无论怎样点击Create database按钮，MyDatabaseHelper中的omCreate()方法都不会再次执行
//    解决问题的办法就是先卸载此软件，再次重新运行，这是的BookStore.db这个数据库已经不存在了，再次点击按钮就会再次创建这个库


//    另一个办法就是使用SQLiteOpenHelper的升级功能就可以轻松的解决这个问题

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists Book");

        db.execSQL("drop table if exists Catagory");

        onCreate(db);

    }
}
