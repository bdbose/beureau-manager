package com.godu.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class data_display extends AppCompatActivity {

    private ListView listView;
    private ItemArrayAdapter itemArrayAdapter;

    Button abc, num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);
        listView = (ListView) findViewById(R.id.list);
        itemArrayAdapter = new ItemArrayAdapter(getApplicationContext(), R.layout.item);

        Parcelable state = listView.onSaveInstanceState();
        listView.setAdapter(itemArrayAdapter);
        listView.onRestoreInstanceState(state);

        final InputStream inputStream = getResources().openRawResource(R.raw.data);
        CSVFile csvFile = new CSVFile(inputStream);
        final List<String[]> datalist = csvFile.read();

        for (String[] scoreData : datalist) {
            itemArrayAdapter.add(scoreData);
        }
        datalist.clear();

        abc = findViewById(R.id.abc);


        abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sort();
            }
        });


    }

    public void sort() {

        listView = (ListView) findViewById(R.id.list);
        itemArrayAdapter = new ItemArrayAdapter(getApplicationContext(), R.layout.item);

        Parcelable state = listView.onSaveInstanceState();
        listView.setAdapter(itemArrayAdapter);
        listView.onRestoreInstanceState(state);

        final InputStream inputStream = getResources().openRawResource(R.raw.sortabc);
        CSVFile csvFile = new CSVFile(inputStream);
        final List<String[]> datalist1 = csvFile.read();

        for (String[] scoreData : datalist1) {
            itemArrayAdapter.add(scoreData);
        }
        }



}
