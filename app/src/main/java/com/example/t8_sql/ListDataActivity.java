package com.example.t8_sql;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListDataActivity extends AppCompatActivity {
    private static final String TAG = "ListDataActivity";

    DatabaseHelper mDatabaseHelper;

    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listtemplate);
        mListView = (ListView) findViewById(R.id.listView);
        mDatabaseHelper = new DatabaseHelper(this);

        populateListView();
    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying Data in the ListView");

        Cursor data = mDatabaseHelper.getData();

        ArrayList<Picture> listData = new ArrayList<>();
        while(data.moveToNext()){
            // go through the database and add to ArrayList
            /*
            listData.add(data.getString(0),data.getString(1), data.getString(2));

            // get owner
            listData.add(data.getString(1));
            // get url
            listData.add(data.getString(2));
            */
            // though can't because Picture doesn't want that
        }

        ownAdapter adapter =  new ownAdapter(this, R.layout.listtemplate, listData);

        mListView.setAdapter(adapter);

    }
}

