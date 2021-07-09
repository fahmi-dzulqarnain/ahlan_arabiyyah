package com.midcores.ahlanarabiyyah.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public class Daos {
    @Dao
    public interface TopicDao {
        @Query("SELECT * FROM Topic")
        List<Entities.Topic> getAll();

        @Insert
        void insertAll(Entities.Topic... topics);

        @Delete
        void delete(Entities.Topic topic);
    }
    @Dao
    public interface QuestionDao {
        @Query("SELECT DISTINCT(lesson_num) FROM Question WHERE topic_id IN (:topicId)")
        List<Integer> loadAllByIds(int topicId);

        @Query("SELECT * FROM Question WHERE topic_id LIKE :topicId AND lesson_num LIKE :lessonNum LIMIT 1")
        List<Entities.Question> findByName(int topicId, int lessonNum);

        @Insert
        void insertAll(Entities.Question... questions);

        @Delete
        void delete(Entities.Question question);
    }
}
