package com.androidlearn.digiandroid.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.androidlearn.digiandroid.di.User;
import com.androidlearn.digiandroid.models.Users;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "myDatabase.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public List<Users> getUsersList() {

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from tbl_users", null);
        List<Users> usersList = new ArrayList<>();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String family = cursor.getString(2);
            String phoneNumber = cursor.getString(3);

            Users users = new Users(id, name, family, phoneNumber);
            usersList.add(users);
        }
        return usersList;

    }
}
