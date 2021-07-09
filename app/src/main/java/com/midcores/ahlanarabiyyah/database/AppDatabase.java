package com.midcores.ahlanarabiyyah.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Entities.Question.class, Entities.Topic.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract Daos.QuestionDao questionDao();
    public abstract Daos.TopicDao topicDao();
}
