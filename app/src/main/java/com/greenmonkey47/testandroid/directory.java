package com.greenmonkey47.testandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.greenmonkey47.testandroid.adapters.directoryAdapter;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

public class directory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);

        TextView directoryTV = (TextView) findViewById(R.id.directoryTV);
        ListView directoryLL = (ListView) findViewById(R.id.showll);

        Intent in = getIntent();
        String file_path = in.getStringExtra("FILE_PATH");
        Log.d("check", "onCreate: "+file_path);

        directoryLL.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(getApplicationContext(),directory.class);
                in.putExtra("FILE_PATH",adapterView.getItemAtPosition(i).toString());
                startActivity(in);
            }
        });
        if(file_path!=null){

            File dir = new File(file_path);
            File[] file_obj =  dir.listFiles();
            ArrayList<String> files = new ArrayList<String>();

            if(file_obj!=null) {
                for (File k : file_obj) {
                    files.add(k.getAbsolutePath());
                }
            }

            directoryTV.setText(file_path);
            directoryAdapter dA = new directoryAdapter(this,files);
            directoryLL.setAdapter(dA);

        }
    }
}