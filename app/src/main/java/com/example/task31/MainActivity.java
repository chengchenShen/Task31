package com.example.task31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_start;
    EditText nameinput;
    Intent intent;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.btn_start);
        nameinput = findViewById(R.id.nameinput);


        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameinput.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter your name!", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, questions.class);
                    intent.putExtra("name",nameinput.getText().toString());
                    startActivity(intent);
                }
            }
        });
        intent = getIntent();
        name = intent.getStringExtra("name");

        nameinput.setText (name);
    }
}