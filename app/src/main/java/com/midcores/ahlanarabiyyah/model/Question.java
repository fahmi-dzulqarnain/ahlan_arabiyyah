package com.midcores.ahlanarabiyyah.model;

public class Question {
    public String question;
    public String answer1;
    public String answer2;
    public String answer3;
    public String answer4;
    public int img1;
    public int img2;
    public int img3;
    public int img4;
    public int correctIndex;
    public String type;
    public boolean isCorrect;

    public Question(String question, String answer1, String answer2, String answer3, String answer4,
                    int img1, int img2, int img3, int img4, boolean isCorrect, String type, int correctIndex) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.img4 = img4;
        this.correctIndex = correctIndex;
        this.isCorrect = isCorrect;
        this.type = type;
    }
}
