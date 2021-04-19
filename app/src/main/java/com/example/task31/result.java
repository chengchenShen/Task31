package com.example.task31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {

    Intent intent;
    TextView Congratulations, scores;
    int fscore;
    Button restart, finish;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Congratulations = findViewById(R.id.message);
        scores = findViewById(R.id.score);
        restart = findViewById(R.id.restart);
        finish = findViewById(R.id.finish);

        intent = getIntent();
        name = intent.getStringExtra("name");
        int score = intent.getIntExtra("score", fscore);

        Congratulations.setText("Congratulations " + name);
        scores.setText(score + "/5");





        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(result.this, MainActivity.class);
                startActivity(intent);
                intent.putExtra("name",name.toString());
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }


}