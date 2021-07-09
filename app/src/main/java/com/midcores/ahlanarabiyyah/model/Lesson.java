package com.midcores.ahlanarabiyyah.model;

public class Lesson {
    public String title;
    public String whatWillLearn;
    public boolean isLocked;

    public Lesson(String title, String whatWillLearn, boolean isLocked) {
        this.title = title;
        this.whatWillLearn = whatWillLearn;
        this.isLocked = isLocked;
    }
}
