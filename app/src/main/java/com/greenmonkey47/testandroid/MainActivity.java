package com.greenmonkey47.testandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button addbtn = (Button) findViewById(R.id.addbtn);
        Button nextPageBtn = (Button) findViewById(R.id.button2);

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

    }
}