package com.midcores.ahlanarabiyyah.recyclerviews.adapter;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.midcores.ahlanarabiyyah.R;
import com.midcores.ahlanarabiyyah.activities.QuizActivity;
import com.midcores.ahlanarabiyyah.helper.Constant;
import com.midcores.ahlanarabiyyah.model.AnswerImage;

import java.util.ArrayList;

import static com.midcores.ahlanarabiyyah.helper.Constant.bottomSheetBehavior;
import static com.midcores.ahlanarabiyyah.helper.Constant.countCorrect;
import static com.midcores.ahlanarabiyyah.helper.Constant.questions;

public class AnswerImgAdapter extends RecyclerView.Adapter<AnswerImgAdapter.ViewHolder> {

    Context context;
    ArrayList<AnswerImage> answerList;
    TextView[] arrayText;
    Button btnCheck, btnNext;
    LinearProgressIndicator progress;
    FrameLayout bottomSheet;
    String meaningAnswer;
    int correctIndex;

    public AnswerImgAdapter(ArrayList<AnswerImage> answerList, int correct, Button btnCheck, String meaningAnswer,
                            Button btnNext, LinearProgressIndicator progress, TextView[] arrayText, FrameLayout bottomSheet) {
        this.answerList = answerList;
        this.btnCheck = btnCheck;
        this.btnNext = btnNext;
        this.progress = progress;
        this.correctIndex = correct;
        this.meaningAnswer = meaningAnswer;
        this.arrayText = arrayText;
        this.bottomSheet = bottomSheet;
    }

    @NonNull
    @Override
    public AnswerImgAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_answer_image, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerImgAdapter.ViewHolder holder, int position) {
        AnswerImage answerImage = answerList.get(position);
        holder.txtAnswer.setText(answerImage.txtAnswer);
        holder.imgAnswer.setImageResource(answerImage.imgAnswer);

//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
//            int count = (int)questions.stream().filter(p -> p.isCorrect).count();
//            progress.setProgressCompat((100 / questions.size()) * count, true);
//        }

        if (answerImage.isClicked)
            holder.forClicked.setCardBackgroundColor(context.getResources().getColor(R.color.teal_700));
        else
            holder.forClicked.setCardBackgroundColor(context.getResources().getColor(R.color.cardview_dark_background));

        holder.forClicked.setOnClickListener(v -> {
            for (AnswerImage answer: answerList) {
                answer.isClicked = false;
            }
            answerList.get(position).isClicked = true;
            notifyDataSetChanged();
            btnCheck.setBackgroundColor(context.getResources().getColor(R.color.teal_700));

            btnCheck.setOnClickListener(v1 -> {
                boolean isCorrect = false;
                if (position == correctIndex) isCorrect = true;

                if (isCorrect){
                    arrayText[0].setText(R.string.wah_jawabannya_benar);
                    bottomSheet.setBackgroundResource(R.drawable.rounded_teal);
                    countCorrect++;
                } else {
                    arrayText[0].setText(R.string.yah_masih_salah_deh);
                    bottomSheet.setBackgroundResource(R.drawable.rounded_red);
                }

                arrayText[2].setText(answerList.get(correctIndex).txtAnswer);
                arrayText[3].setText(meaningAnswer);
                QuizActivity.showBottomSheet(context);
            });
            btnNext.setOnClickListener(v2 -> {

                int progressNumber = (100 / questions.size()) * (Constant.index + 1);
                progress.setProgressCompat(progressNumber, true);
                bottomSheetBehavior.setPeekHeight(0, true);
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
        ImageView imgAnswer;
        CardView forClicked;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAnswer = itemView.findViewById(R.id.txtAnswer);
            imgAnswer = itemView.findViewById(R.id.imgAnswer);
            forClicked = itemView.findViewById(R.id.cardAnswer);
        }
    }
}