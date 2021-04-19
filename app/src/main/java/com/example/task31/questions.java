package com.example.task31;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class questions extends AppCompatActivity {

    private List<QuestionModel> questionsList;
    TextView Welcome,progress, question_title, question_content;
    ProgressBar progressBar;
    Button answer_one,answer_two,answer_three;
    Button submit;
    Intent intent;

    int totalquestions;
    int qCounter =0;
    int score =0;

    ColorStateList dfRbColor;
    boolean answered,
            one_pressed = false,
            two_pressed = false,
            three_pressed = false;

    private QuestionModel currentQuestion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Welcome = findViewById(R.id.Welcome);
        progress = findViewById(R.id.progress);
        question_title = findViewById(R.id.question_title);
        question_content = findViewById(R.id.question_content);
        progressBar = findViewById(R.id.progressBar);
        answer_one = findViewById(R.id.answer_one);
        answer_two = findViewById(R.id.answer_two);
        answer_three = findViewById(R.id.answer_three);
        submit = findViewById(R.id.submit);

        intent = getIntent();
        String name = intent.getStringExtra("name");
        Welcome.setText("Welcome," + name);

        questionsList = new ArrayList<>();

        addQuestions();
        totalquestions = questionsList.size();
        showNextQuestion();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered ==false){
                    if(one_pressed == true || two_pressed == true || three_pressed == true){
                        CheckAnswerOne();
                        submit.setText("Next");
                    }else{
                        Toast.makeText(questions.this, "Please, select an answer",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    answer_one.setBackgroundResource(R.drawable.button_unpressed);
                    answer_two.setBackgroundResource(R.drawable.button_unpressed);
                    answer_three.setBackgroundResource(R.drawable.button_unpressed);
                    showNextQuestion();
                }
            }
        });

        answer_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one_pressed = true;

            }
        });

        answer_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                two_pressed = true;

            }
        });

        answer_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                three_pressed = true;

            }
        });
    }


    private void CheckAnswerOne() {
        answered = true;
        if(one_pressed == true){
            two_pressed = false;
            three_pressed = false;
            if(answer_one.getText().equals(currentQuestion.getCorrectAnswerNo())){
                answer_one.setBackgroundResource(R.drawable.button_correct);
                score++;
            }
            else{
                answer_one.setBackgroundResource(R.drawable.button_wrong);
                if (answer_two.getText().equals(currentQuestion.getCorrectAnswerNo())) {
                    answer_two.setBackgroundResource(R.drawable.button_correct);
                }else {
                    answer_three.setBackgroundResource(R.drawable.button_correct);
                }
            }
        }else {
            CheckAnswerTwo();

        }
    }

    private void CheckAnswerTwo() {
        if(two_pressed == true){
            one_pressed = false;
            three_pressed = false;
            if(answer_two.getText().equals(currentQuestion.getCorrectAnswerNo())){
                answer_two.setBackgroundResource(R.drawable.button_correct);
                score++;
            }
            else{
                answer_two.setBackgroundResource(R.drawable.button_wrong);
                if (answer_one.getText().equals(currentQuestion.getCorrectAnswerNo())) {
                    answer_one.setBackgroundResource(R.drawable.button_correct);
                }else {
                    answer_three.setBackgroundResource(R.drawable.button_correct);
                }
            }
        }
        else{
            CheckAnswerThree();
        }
    }

    private void CheckAnswerThree() {

        if(three_pressed == true){
            one_pressed = false;
            two_pressed = false;
            if(answer_three.getText().equals(currentQuestion.getCorrectAnswerNo())){
                answer_three.setBackgroundResource(R.drawable.button_correct);
                score++;
            }
            else{
                answer_three.setBackgroundResource(R.drawable.button_wrong);
                if (answer_one.getText().equals(currentQuestion.getCorrectAnswerNo())) {
                    answer_one.setBackgroundResource(R.drawable.button_correct);
                }else {
                    answer_two.setBackgroundResource(R.drawable.button_correct);
                }
            }
        }
    }

    private void showNextQuestion() {

        if(qCounter < totalquestions){
            currentQuestion = questionsList.get(qCounter);
            question_title.setText(currentQuestion.getQuestion_title());
            question_content.setText(currentQuestion.getQuestion_content());
            answer_one.setText(currentQuestion.getOption1());
            answer_two.setText(currentQuestion.getOption2());
            answer_three.setText(currentQuestion.getOption3());

            qCounter++;
            submit.setText("Submit");
            answered =false;
            one_pressed = false;
            two_pressed = false;
            three_pressed = false;
            progressBar.setProgress(qCounter);
            progress.setText(qCounter+"/5");

        }else{
            intent.setClass(questions.this, result.class);
            intent.putExtra("score",score);
            startActivity(intent);
        }
    }

    private void addQuestions() {

        questionsList.add(new QuestionModel("Question One","What screen densities are Android using?","Low density","High density","All above","All above"));
        questionsList.add(new QuestionModel("Question Two","What method can be used to shut down an activity?","finish()","onDestory()","finishActivity()","finish()"));
        questionsList.add(new QuestionModel("Question Three","How can contentProvider being activated?","Intent","ContentResolver","SQLite","ContentResolver"));
        questionsList.add(new QuestionModel("Question Four","Android is developed specially for?","Laptops","Servers","Mobile devices","Mobile devices"));
        questionsList.add(new QuestionModel("Question Five","What does OHA stand for?","Open Host Application","Open Handset Application","Open Handset Alliance","Open Handset Alliance"));

    }
}