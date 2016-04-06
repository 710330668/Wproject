package com.android.wpf.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

public class AppContentProvider extends ContentProvider {
    private static final int ALL_ORDERS = 1;
    private static final int SINGLE_ORDER = 2;
    private static final int GET_LAST_COUNT_5 = 3;
    // authority is the symbolic name of your provider
    // To avoid conflicts with other providers, you should use
    // Internet domain ownership (in reverse) as the basis of your provider authority.
    private static final String AUTHORITY = "com.rrs.client.android";
    // create content URIs from the authority by appending path to database table
    public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/" + OrderTable.ORDER_INFO_PROVIDER);
    // a content URI pattern matches content URIs using wildcard characters:
    // *: Matches a string of any valid characters of any length.
    // #: Matches a string of numeric characters of any length.
    private static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, OrderTable.ORDER_INFO_PROVIDER, ALL_ORDERS);
        uriMatcher.addURI(AUTHORITY, OrderTable.ORDER_INFO_PROVIDER + "/last", GET_LAST_COUNT_5);
        uriMatcher.addURI(AUTHORITY, OrderTable.ORDER_INFO_PROVIDER + "/getone", SINGLE_ORDER);
        // uri.getPath()
    }

    SqliteHelper dbHelper;

    public AppContentProvider() {
    }

    // system calls onCreate() when it starts up the provider.
    @Override
    public boolean onCreate() {
        // get access to the database helper
        dbHelper = new SqliteHelper(getContext());
        return true;
    }

    //Return the MIME type corresponding to a content URI
    @Override
    public String getType(Uri uri) {

        return null;
    }

    // The insert() method adds a new row to the appropriate table, using the values
    // in the ContentValues argument. If a column name is not in the ContentValues argument,
    // you may want to provide a default value for it either in your provider code or in
    // your database schema.
    @Override
    public Uri insert(Uri uri, ContentValues values) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        switch (uriMatcher.match(uri)) {
            case ALL_ORDERS:
                //do nothing
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
        long id = -1;
        try {
            id = db.insert(OrderTable.ORDER_INFO_TAB, null, values);
            getContext().getContentResolver().notifyChange(uri, null);
        } catch (Exception e) {

        }

        return Uri.parse(CONTENT_URI + "/" + id);
    }

    // The query() method must return a Cursor object, or if it fails,
    // throw an Exception. If you are using an SQLite database as your data storage,
    // you can simply return the Cursor returned by one of the query() methods of the
    // SQLiteDatabase class. If the query does not match any rows, you should return a
    // Cursor instance whose getCount() method returns 0. You should return null only
    // if an internal error occurred during the query process.
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(OrderTable.ORDER_INFO_TAB);


        switch (uriMatcher.match(uri)) {
            case ALL_ORDERS:
                //do nothing
                break;
            case SINGLE_ORDER:
                String id = uri.getQueryParameter(OrderTable.ORDER_ID);
                queryBuilder.appendWhere(OrderTable.ORDER_ID + "=\"" + id + "\"");
                break;
            case GET_LAST_COUNT_5:

                Cursor cursor = db.query(OrderTable.ORDER_INFO_TAB, null, null, null, null, null, "_id" + " DESC", "5");
                return cursor;

            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri + " " + uri.getPath());
        }

        Cursor cursor = queryBuilder.query(db, projection, selection,
                selectionArgs, null, null, sortOrder);
        return cursor;

    }

    // The delete() method deletes rows based on the seletion or if an id is
    // provided then it deleted a single row. The methods returns the numbers
    // of records delete from the database. If you choose not to delete the data
    // physically then just update a flag here.
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        switch (uriMatcher.match(uri)) {
            case ALL_ORDERS:
                //do nothing
                break;
            case SINGLE_ORDER:
                String id = uri.getPathSegments().get(1);
                selection = OrderTable.ORDER_ID + "=" + id
                        + (!TextUtils.isEmpty(selection) ?
                        " AND (" + selection + ')' : "");
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
        int deleteCount = db.delete(OrderTable.ORDER_INFO_TAB, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return deleteCount;
    }

    // The update method() is same as delete() which updates multiple rows
    // based on the selection or a single row if the row id is provided. The
    // update method returns the number of updated rows.
    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        switch (uriMatcher.match(uri)) {
            case ALL_ORDERS:
                //do nothing
                break;
            case SINGLE_ORDER:
                String id = uri.getPathSegments().get(1);
                selection = OrderTable.ORDER_ID + "=" + id
                        + (!TextUtils.isEmpty(selection) ?
                        " AND (" + selection + ')' : "");
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
        int updateCount = db.update(OrderTable.ORDER_INFO_TAB, values, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return updateCount;
    }
}
