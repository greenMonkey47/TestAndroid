package com.greenmonkey47.testandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class MainActivity extends AppCompatActivity {

    final int REQUEST_IMAGE_CAPTURE=1;
    String imagePath;
    Context cnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button addbtn = (Button) findViewById(R.id.addbtn);
        Button nextPageBtn = (Button) findViewById(R.id.button2);
        Button take_pic = (Button) findViewById(R.id.buttonclick);
        Button file_dir = (Button) findViewById(R.id.btnDirectory);
        cnt = this;


        file_dir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent send_file = new Intent(getApplicationContext(),directory.class);
                File main_file = Environment.getExternalStorageDirectory();

                send_file.putExtra("FILE_PATH",main_file.getAbsolutePath());
                startActivity(send_file);

            }
        });

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText num1 = (EditText) findViewById(R.id.editTextNumber1);
                EditText num2 = (EditText) findViewById(R.id.editTextNumber2);
                TextView result = (TextView) findViewById(R.id.textView2);
                int n1 = Integer.parseInt(num1.getText().toString());
                int n2 = Integer.parseInt(num2.getText().toString());

                result.setText( (n1+n2)+"");
            }
        });

        nextPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery_page = new Intent(getApplicationContext(),show_images.class);
                startActivity(gallery_page);
            }
        });

        take_pic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

                    File imgFileName = null;
                    try {
                        imgFileName = createFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Log.d("TEST", "onClick: "+imgFileName.getAbsolutePath());

                    if(imgFileName!=null) {
                        Uri photoURI = FileProvider.getUriForFile(cnt,
                                "com.greenmonkey47.testandroid",
                                imgFileName);

                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                    }
                }

            }
        });


    }

    private File createFile() throws IOException{

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "JPEG_" + timeStamp + "_";

        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        Log.d("TEST", "createFile: "+storageDir.getAbsolutePath());
        File image = File.createTempFile(fileName,".jpg",storageDir);
        imagePath = image.getAbsolutePath();
        return image;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView imageView = (ImageView)findViewById(R.id.iv_name);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            if (extras!=null) {
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                imageView.setImageBitmap(imageBitmap);
            }
        }
    }

}