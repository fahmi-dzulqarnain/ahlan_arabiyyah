package com.midcores.ahlanarabiyyah.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class Entities {
    @Entity
    public static class Question {
        @PrimaryKey
        public int id;

        @ColumnInfo(name = "question")
        public String question;

        @ColumnInfo(name = "first_answer")
        public String first_answer;

        @ColumnInfo(name = "second_answer")
        public String second_answer;

        @ColumnInfo(name = "third_answer")
        public String third_answer;

        @ColumnInfo(name = "fourth_answer")
        public String fourth_answer;

        @ColumnInfo(name = "answer_index")
        public int answer_index;

        @ColumnInfo(name = "topic_id")
        public int topic_id;

        @ColumnInfo(name = "type")
        public String type;

        @ColumnInfo(name = "lesson_num")
        public int lesson_num;
    }

    @Entity
    public static class Lesson {
        @PrimaryKey
        public int lesson_num;

        @ColumnInfo(name = "what_will_learn")
        public String what_will_learn;

        @ColumnInfo(name = "is_locked")
        public boolean is_locked;
    }

    @Entity
    public static class Topic {
        @PrimaryKey
        public int topic_id;

        @ColumnInfo(name = "name")
        public String name;

        @ColumnInfo(name = "description")
        public String description;

        @ColumnInfo(name = "image")
        public int image;

        @ColumnInfo(name = "is_locked")
        public boolean is_locked;
    }
}