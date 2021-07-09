package com.midcores.ahlanarabiyyah.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.midcores.ahlanarabiyyah.R;
import com.midcores.ahlanarabiyyah.model.AnswerImage;
import com.midcores.ahlanarabiyyah.recyclerviews.adapter.AnswerImgAdapter;

import java.util.ArrayList;

public class ImageQuizFragment extends Fragment {

    String question;
    int correct;
    ArrayList<AnswerImage> answerImages;
    TextView[] arrayText;
    Button btnCheck, btnNext;
    LinearProgressIndicator progress;
    FrameLayout bottomSheet;

    public ImageQuizFragment(String question, ArrayList<AnswerImage> answerImages, int correct, Button btnCheck,
                             Button btnNext, LinearProgressIndicator progress, TextView[] arrayText, FrameLayout bottomSheet) {
        this.question = question;
        this.answerImages = answerImages;
        this.arrayText = arrayText;
        this.btnCheck = btnCheck;
        this.btnNext = btnNext;
        this.progress = progress;
        this.correct = correct;
        this.bottomSheet = bottomSheet;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_quiz, container, false);

        TextView txtQuestion = view.findViewById(R.id.txtQuestion);
        RecyclerView rvAnswer = view.findViewById(R.id.rvAnswer);
        btnCheck.setOnClickListener(null);
        btnCheck.setBackgroundColor(getResources().getColor(R.color.cardview_dark_background));

        String meaningAnswer = question.split("\"")[1];
        AnswerImgAdapter adapter = new AnswerImgAdapter(answerImages, correct, btnCheck, meaningAnswer, btnNext, progress, arrayText, bottomSheet);
        rvAnswer.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvAnswer.setAdapter(adapter);
        txtQuestion.setText(question);

        return view;
    }
}