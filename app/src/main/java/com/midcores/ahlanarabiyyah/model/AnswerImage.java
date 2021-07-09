package com.midcores.ahlanarabiyyah.model;

public class AnswerImage {
    public String txtAnswer;
    public int imgAnswer;
    public boolean isClicked;

    public AnswerImage(String txtAnswer, int imgAnswer, boolean isClicked) {
        this.txtAnswer = txtAnswer;
        this.imgAnswer = imgAnswer;
        this.isClicked = isClicked;
    }
}
