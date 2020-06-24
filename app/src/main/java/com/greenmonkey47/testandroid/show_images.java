package com.greenmonkey47.testandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.greenmonkey47.testandroid.adapters.ImageAdapter;

import java.lang.reflect.Array;

public class show_images extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_images);

        GridView gallery = (GridView) findViewById(R.id.gridView);
        String[] ar = {"check","check2","check3","check4","check5"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.grid_text,ar);
        ImageAdapter adapter1 = new ImageAdapter(this,R.layout.image_view,ar);
        gallery.setAdapter(adapter1);
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),show_item_text.class);

                intent.putExtra("com.greenmonkey47.testandroid.IMG_IDX",i);
                startActivity(intent);
            }
        });
    }
}