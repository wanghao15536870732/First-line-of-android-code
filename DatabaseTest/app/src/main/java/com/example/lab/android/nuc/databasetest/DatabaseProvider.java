package com.example.lab.android.nuc.databasetest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.widget.Switch;

public class DatabaseProvider extends ContentProvider {

    public static  final int Book_DIR = 0;

    public static  final int Book_ITEM = 1;

    public static  final int CATEGORY_DIR = 2;

    public static  final int CATEGORY_ITEM = 3;

    public static final String AUTHORITY = "com.example.databasetest.provider";

    private static UriMatcher uriMatcher;

    private MydatabaseHelper dbHelper;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY,"book",Book_DIR);
        uriMatcher.addURI(AUTHORITY,"book/#",Book_ITEM);
        uriMatcher.addURI(AUTHORITY,"category",CATEGORY_DIR);
        uriMatcher.addURI(AUTHORITY,"category",CATEGORY_ITEM);
    }

    @Override
    public boolean onCreate() {
        dbHelper = new MydatabaseHelper(getContext(),"BookStore.db",null,2);
        return true;
    }



    @Override
    public Uri insert(Uri uri, ContentValues values) {
//        添加数据
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Uri uriReturn = null;
        switch (uriMatcher.match(uri)){
            case Book_DIR:
            case Book_ITEM:
                long newBookId = db.insert("Book",null,values);
                uriReturn = Uri.parse("content://" + AUTHORITY + "/book/" + newBookId);
                break;
            case CATEGORY_DIR:
            case CATEGORY_ITEM:
                long newCategoryId = db.insert("Category",null,values);
                uriReturn = Uri.parse("content://" + AUTHORITY + "/category/" + newCategoryId);
                break;
            default:
                break;
        }
        return uriReturn;
    }



    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
//        查询数据
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = null;
        switch (uriMatcher.match(uri)){
            case Book_DIR:
                cursor = db.query("Book",projection,selection,selectionArgs,null,
                        null,sortOrder);
                break;
            case Book_ITEM:
                String BookId = uri.getPathSegments().get(1);
                cursor = db.query("Book",projection,"id = ?",new String[]{BookId},
                        null,null,sortOrder);
                break;
            case CATEGORY_DIR:
                cursor = db.query("Category",projection,selection,selectionArgs,null,
                        null,sortOrder);
                break;
            case CATEGORY_ITEM:
                String CategotyId = uri.getPathSegments().get(1);
                cursor = db.query("Book",projection,"id = ?",new String[]{CategotyId},
                        null,null,sortOrder);
                break;
            default:
              break;
        }
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int updatedRows = 0;
        switch (uriMatcher.match(uri)){
            case Book_DIR:
                updatedRows = db.update("Book",values,selection,selectionArgs);
                break;
            case Book_ITEM:
                String bookId = uri.getPathSegments().get(1);
                updatedRows = db.update("Book",values,"id = ?",new String[]
                        {bookId});
                break;
            case CATEGORY_DIR:
                updatedRows = db.update("Category",values,selection,selectionArgs);
                break;
            case CATEGORY_ITEM:
                String categoryId = uri.getPathSegments().get(1);
                updatedRows = db.update("Category",values,"id = ?",new String[]
                        {categoryId});
                break;
            default:
                break;
        }
        return updatedRows;
    }

    public DatabaseProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        //        删除数据
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int deleteRows = 0;
        switch(uriMatcher.match(uri)){
            case Book_DIR:
                deleteRows = db.delete("Book",selection,selectionArgs);
                break;
            case Book_ITEM:
                String BookId = uri.getPathSegments().get(1);
                deleteRows = db.delete("Book","id = ?",new String[]
                        {BookId});
                break;
            case CATEGORY_DIR:
                deleteRows = db.delete("Book",selection,selectionArgs);
                break;
            case CATEGORY_ITEM:
                String categoryId = uri.getPathSegments().get(1);
                deleteRows = db.delete("Category","id = ?",new String[]{categoryId});
                break;
            default:
                break;
        }
        return deleteRows;
    }

    @Override
    public String getType(Uri uri) {

        switch (uriMatcher.match(uri)){
            case Book_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.databasetest.provider.book";
            case Book_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.databasetest.provider.book";
            case CATEGORY_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.databasetest.provider.category";
            case CATEGORY_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.databasetest.provider.category";
        }
        return null;

    }
}
