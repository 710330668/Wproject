package com.android.wpf.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by BunnyBlue on 12/17/15.
 */
class SqliteHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "localdb";
    private static final int DB_VERSION = 3;

    public SqliteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(OrderTable.CREATE_ORDER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
