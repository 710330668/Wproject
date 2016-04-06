package com.android.wpf.db;

import android.provider.BaseColumns;

/**
 * Created by BunnyBlue on 12/17/15.
 */
class OrderTable implements BaseColumns {
    public static final String ORDER_INFO_TAB = "ORDER_INFO_TAB";
    public static final String ORDER_INFO_PROVIDER = "orderinfo";
    public static final String ORDER_ID = "orderId";
    public static final String TS = "ts";
    public static final String POINT_X = "x";
    public static final String POINT_Y = "y";
    public static final String takeType = "takeType";
    public static final String productType = "productType";
    public static final String carId = "carId";
    public static final String OBJECT = "obj";
    public static final String CREATE_ORDER_TABLE = "CREATE TABLE IF NOT EXISTS  " + ORDER_INFO_TAB + " (\"_id\" INTEGER PRIMARY KEY autoincrement," +
            "\"orderId\" TEXT UNIQUE," +
            "\"ts\" TEXT," +
            "\"x\" TEXT," +
            "\"y\" TEXT," +
            "\"productType\" TEXT," +
            "\"carId\" TEXT," +
            "\"takeType\" TEXT," +
            "\"obj\" blob);";
}
