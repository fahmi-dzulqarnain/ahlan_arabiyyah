package com.midcores.ahlanarabiyyah.recyclerviews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.midcores.ahlanarabiyyah.R;
import com.midcores.ahlanarabiyyah.activities.QuizActivity;
import com.midcores.ahlanarabiyyah.helper.Constant;
import com.midcores.ahlanarabiyyah.model.AnswerOption;

import java.util.ArrayList;

import static com.midcores.ahlanarabiyyah.helper.Constant.countCorrect;
import static com.midcores.ahlanarabiyyah.helper.Constant.questions;

public class AnswerOptAdapter extends RecyclerView.Adapter<AnswerOptAdapter.ViewHolder> {

    Context context;
    ArrayList<AnswerOption> answerList;
    Button btnCheck;
    LinearProgressIndicator progress;
    int correctIndex;

    public AnswerOptAdapter(ArrayList<AnswerOption> answerList, int correct, Button btnCheck, LinearProgressIndicator progress) {
        this.answerList = answerList;
        this.btnCheck = btnCheck;
        this.progress = progress;
        this.correctIndex = correct;
    }

    @NonNull
    @Override
    public AnswerOptAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_answer_image, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerOptAdapter.ViewHolder holder, int position) {
        AnswerOption answerOpt = answerList.get(position);
        holder.txtAnswer.setText(answerOpt.txtAnswer);

        if (answerOpt.isClicked)
            holder.forClicked.setCardBackgroundColor(context.getResources().getColor(R.color.teal_700));
        else
            holder.forClicked.setCardBackgroundColor(context.getResources().getColor(R.color.cardview_dark_background));

        holder.forClicked.setOnClickListener(v -> {
            for (AnswerOption answer: answerList) {
                answer.isClicked = false;
            }
            answerList.get(position).isClicked = true;
            notifyDataSetChanged();
            btnCheck.setBackgroundColor(context.getResources().getColor(R.color.teal_700));

            btnCheck.setOnClickListener(v1 -> {
                if (position == correctIndex) countCorrect++;
                int progressNumber = (100 / questions.size()) * (Constant.index + 1);
                progress.setProgressCompat(progressNumber, true);
                Constant.index++;
                QuizActivity.loadFragment(context);
            });
        });
    }

    @Override
    public int getItemCount() {
        return answerList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtAnswer;
        CardView forClicked;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAnswer = itemView.findViewById(R.id.txtAnswer);
            forClicked = itemView.findViewById(R.id.cardAnswer);
        }
    }
}