package com.midcores.ahlanarabiyyah.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.midcores.ahlanarabiyyah.R;
import com.midcores.ahlanarabiyyah.model.Lesson;
import com.midcores.ahlanarabiyyah.model.Topic;
import com.midcores.ahlanarabiyyah.recyclerviews.adapter.LessonAdapter;

import java.util.ArrayList;

public class LessonActivity extends AppCompatActivity {

    ArrayList<Lesson> lessonList = new ArrayList<>();
    LessonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        StatusBarUtil.setTransparent(this);
        String topic = getIntent().getStringExtra("TOPIC");

        TextView txtTopic = findViewById(R.id.txtTopic);
        RecyclerView recyclerView = findViewById(R.id.rvLesson);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new LessonAdapter(lessonList);
        recyclerView.setAdapter(adapter);
        txtTopic.setText(topic);

        fillList();
    }

    private void fillList(){
        lessonList.add(new Lesson("Pelajaran 1", "آنا٫ مدرس٫ مهندس٫ عامل٫ موظف٫ طبيب", false));
        lessonList.add(new Lesson("Pelajaran 2", "آنا٫ مدرس٫ مهندس٫ عامل٫ موظف٫ طبيب", false));
        lessonList.add(new Lesson("Pelajaran 3", "آنا٫ مدرس٫ مهندس٫ عامل٫ موظف٫ طبيب", false));
        lessonList.add(new Lesson("Pelajaran 4", "آنا٫ مدرس٫ مهندس٫ عامل٫ موظف٫ طبيب", false));
        adapter.notifyDataSetChanged();
    }
}