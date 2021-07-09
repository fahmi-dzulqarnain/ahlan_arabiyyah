package com.midcores.ahlanarabiyyah.recyclerviews.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.midcores.ahlanarabiyyah.R;
import com.midcores.ahlanarabiyyah.activities.QuizActivity;
import com.midcores.ahlanarabiyyah.model.Lesson;

import java.util.ArrayList;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.ViewHolder> {

    Context context;
    ArrayList<Lesson> lessonList;

    public LessonAdapter(ArrayList<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    @NonNull
    @Override
    public LessonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_lesson, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonAdapter.ViewHolder holder, int position) {
        Lesson lesson = lessonList.get(position);
        holder.txtTitle.setText(lesson.title);
        holder.txtWhatWillLearn.setText(lesson.whatWillLearn);
        holder.forClicked.setOnClickListener(v -> {
            context.startActivity(new Intent(context, QuizActivity.class));
            ((Activity) context).finish();
        });
    }

    @Override
    public int getItemCount() {
        return lessonList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTitle, txtWhatWillLearn;
        RelativeLayout forClicked;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtPelajaranTitle);
            txtWhatWillLearn = itemView.findViewById(R.id.txtWhatLearn);
            forClicked = itemView.findViewById(R.id.forClicked);
        }
    }
}