package com.midcores.ahlanarabiyyah.recyclerviews.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.midcores.ahlanarabiyyah.R;
import com.midcores.ahlanarabiyyah.activities.LessonActivity;
import com.midcores.ahlanarabiyyah.model.Topic;

import java.util.ArrayList;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder> {

    Context context;
    ArrayList<Topic> topicList;

    public TopicAdapter(ArrayList<Topic> topicList) {
        this.topicList = topicList;
    }

    @NonNull
    @Override
    public TopicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_home_topic, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicAdapter.ViewHolder holder, int position) {
        Topic topic = topicList.get(position);
        holder.imgTopic.setImageResource(topic.image);
        holder.txtTopic.setText(topic.name);
        holder.forClicked.setOnClickListener(v -> {
            Intent intent = new Intent(context, LessonActivity.class);
            intent.putExtra("TOPIC", topic.name);
            context.startActivity(intent);
        });

        if (topic.index == 1){
            StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
            layoutParams.setFullSpan(true);
        }
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTopic;
        ImageView imgTopic;
        RelativeLayout forClicked, rootView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTopic = itemView.findViewById(R.id.txtTopic);
            imgTopic = itemView.findViewById(R.id.imgTopik);
            forClicked = itemView.findViewById(R.id.relativeImg);
            rootView = itemView.findViewById(R.id.rootView);
        }
    }
}