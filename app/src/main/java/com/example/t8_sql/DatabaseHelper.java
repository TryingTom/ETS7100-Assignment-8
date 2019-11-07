package com.example.t8_sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "picture_table";
    private static final String COL_1 = "license";
    private static final String COL_2 = "owner";
    private static final String COL_3 = "url";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + COL_1 + " TEXT, " + COL_2  + " TEXT, " + COL_3 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData (String mOwner, String mLicense, String mURL){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, mOwner);
        Log.d(TAG, "addData: adding " + mOwner + " to " + TABLE_NAME);

        contentValues.put(COL_2, mLicense);
        Log.d(TAG, "addData: adding " + mLicense + " to " + TABLE_NAME);

        contentValues.put(COL_3, mURL);
        Log.d(TAG, "addData: adding " + mURL + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        // if data is inserted incorrectly, it'll give -1
        if (result == -1){
            return false;
        } else{
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }
}
