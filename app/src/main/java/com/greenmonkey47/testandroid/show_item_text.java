package com.greenmonkey47.testandroid;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class show_item_text extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item_text);
        Intent in = getIntent();

        int idx = in.getIntExtra("com.greenmonkey47.testandroid.IMG_IDX",-1);
        if(idx!=-1) {

            TextView tv = (TextView) findViewById(R.id.textViewItem);
            tv.setText("Image open in index "+idx);

        }
    }
}