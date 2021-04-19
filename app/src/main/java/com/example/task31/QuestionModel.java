package com.example.task31;

public class QuestionModel {
    private String question_title,question_content, option1,option2,option3,correctAnswer;


    public QuestionModel(String question_title, String question_content, String option1, String option2, String option3, String correctAnswer) {
        this.question_title = question_title;
        this.question_content = question_content;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion_title() {
        return question_title;
    }

    public void setQuestion_title(String question_title) {
        this.question_title = question_title;
    }

    public String getQuestion_content() {
        return question_content;
    }

    public void setQuestion_content(String question_content) {
        this.question_content = question_content;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getCorrectAnswerNo() {
        return correctAnswer;
    }

    public void setCorrectAnswerNo(String correctAnswerNo) {
        this.correctAnswer = correctAnswerNo;
    }
}
