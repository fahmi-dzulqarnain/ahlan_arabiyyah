package com.midcores.ahlanarabiyyah.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.jaeger.library.StatusBarUtil;
import com.midcores.ahlanarabiyyah.R;
import com.midcores.ahlanarabiyyah.model.Topic;
import com.midcores.ahlanarabiyyah.recyclerviews.adapter.TopicAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Topic> topicList = new ArrayList<>();
    TopicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StatusBarUtil.setTransparent(this);
        //AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();

        RecyclerView recyclerView = findViewById(R.id.rvTopic);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new TopicAdapter(topicList);
        recyclerView.setAdapter(adapter);

        fillList();
    }

    private void fillList(){
        topicList.add(new Topic(1, "Perkenalan", "", R.drawable.icons_handshake, false));
        topicList.add(new Topic(2, "Kata Benda", "", R.drawable.icons8_apple_96, true));
        topicList.add(new Topic(3, "Kata Ganti", "", R.drawable.icons8_i_96, true));
        topicList.add(new Topic(1, "Kata Kerja", "", R.drawable.icons8_so_so_96, true));
        topicList.add(new Topic(2, "Perkenalan", "", R.drawable.icons_handshake, true));
        topicList.add(new Topic(3, "Kata Kerja", "", R.drawable.icons8_so_so_96, true));
        adapter.notifyDataSetChanged();
    }
}