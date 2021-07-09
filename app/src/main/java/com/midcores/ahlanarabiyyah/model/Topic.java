package com.midcores.ahlanarabiyyah.model;

public class Topic {
    public int index;
    public String name;
    public String description;
    public int image;
    public boolean isLocked;

    public Topic(int index, String name, String description, int image, boolean isLocked) {
        this.index = index;
        this.name = name;
        this.description = description;
        this.image = image;
        this.isLocked = isLocked;
    }
}
