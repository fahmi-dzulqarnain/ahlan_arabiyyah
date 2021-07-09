package com.midcores.ahlanarabiyyah.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.midcores.ahlanarabiyyah.R;
import com.midcores.ahlanarabiyyah.fragments.ImageQuizFragment;
import com.midcores.ahlanarabiyyah.fragments.OptionQuizFragment;
import com.midcores.ahlanarabiyyah.fragments.TranslateQuizFragment;
import com.midcores.ahlanarabiyyah.helper.Constant;
import com.midcores.ahlanarabiyyah.model.AnswerImage;
import com.midcores.ahlanarabiyyah.model.Question;

import java.util.ArrayList;

import static com.midcores.ahlanarabiyyah.helper.Constant.bottomSheetBehavior;
import static com.midcores.ahlanarabiyyah.helper.Constant.fragments;
import static com.midcores.ahlanarabiyyah.helper.Constant.questions;
import static com.midcores.ahlanarabiyyah.helper.Constant.quizActivity;

public class QuizActivity extends AppCompatActivity {

    static LinearProgressIndicator progress;
    TextView txtDescription, txtDescription2, txtAnswer, txtMeaning;
    TextView[] arrayText;
    FrameLayout bottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ImageView cancelQuiz = findViewById(R.id.btnCancelQuiz);
        Button btnCheck = findViewById(R.id.btnCheck);
        Button btnNext = findViewById(R.id.btnNext);
        bottomSheet = findViewById(R.id.bottomSheetContainer);
        txtDescription = findViewById(R.id.txtDescription);
        txtDescription2 = findViewById(R.id.txtDescription2);
        txtAnswer = findViewById(R.id.txtAnswer);
        txtMeaning = findViewById(R.id.txtMeaning);
        arrayText = new TextView[]{ txtDescription, txtDescription2, txtAnswer, txtMeaning };
        progress = findViewById(R.id.progress_horizontal);
        quizActivity = this;
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        bottomSheetBehavior.setPeekHeight(0, true);

        addQuestions();
        addFragmentQuestion(btnCheck, btnNext);
        loadFragment(this);

        cancelQuiz.setOnClickListener(v -> showDialog());
    }

    private void addQuestions(){
        questions.clear();
        questions.add(new Question("Apa Bahasa Arab \"Dokter\"?", "طبيب", "طالب", "مدرس", "مهندس",
                R.drawable.doctor,
                R.drawable.learner,
                R.drawable.teacher,
                R.drawable.engineer, false, "image", 0));

        questions.add(new Question("Apa Bahasa Arab \"Pelajar\"?", "مهندس", "طبيب", "مدرس", "طالب",
                R.drawable.engineer,
                R.drawable.doctor,
                R.drawable.teacher,
                R.drawable.learner, false, "image", 3));

        questions.add(new Question("Apa Bahasa Arab \"Guru\"?", "مهندس", "مدرس", "طالب", "طبيب",
                R.drawable.engineer,
                R.drawable.teacher,
                R.drawable.learner,
                R.drawable.doctor, false, "image", 1));

        questions.add(new Question("Apa Bahasa Arab \"Arsitek\"?", "مهندس", "مدرس", "طالب", "طبيب",
                R.drawable.engineer,
                R.drawable.teacher,
                R.drawable.learner,
                R.drawable.doctor, false, "image", 0));
    }

    private void addFragmentQuestion(Button btnCheck, Button btnNext){
        for (Question question: questions) {
            String type = question.type;
            ArrayList<AnswerImage> answerImages = new ArrayList<>();
            answerImages.add(new AnswerImage(question.answer1, question.img1, false));
            answerImages.add(new AnswerImage(question.answer2, question.img2, false));
            answerImages.add(new AnswerImage(question.answer3, question.img3, false));
            answerImages.add(new AnswerImage(question.answer4, question.img4, false));

            switch (type){
                case "image": fragments.add(new ImageQuizFragment(question.question, answerImages,
                        question.correctIndex, btnCheck, btnNext, progress, arrayText, bottomSheet)); break;
                case "option": fragments.add(new OptionQuizFragment()); break;
                case "translate": fragments.add(new TranslateQuizFragment()); break;
            }
        }
    }

    public static void loadFragment(Context context){
        int index = Constant.index;
        if (index < fragments.size()){
            FragmentTransaction fragmentTransaction = quizActivity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.quizContainer, fragments.get(index));
            fragmentTransaction.commit();
        } else {
            context.startActivity(new Intent(context, FinishedActivity.class));
            quizActivity.finish();
        }
    }

    public static void showBottomSheet(Context context){
        bottomSheetBehavior.setPeekHeight(Math.round(
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                        300f, context.getResources().getDisplayMetrics())), true);
    }

    private void showDialog(){
        AlertDialog.Builder mDialog = new AlertDialog.Builder(this)
                .setTitle("Konfirmasi Keluar")
                .setMessage("Yakin ingin membatalkan quiz? Progrees tidak akan disimpan")
                .setCancelable(false)
                .setPositiveButton("Tidak", (dialog, which) -> dialog.dismiss())
                .setNegativeButton("Ya", (dialog, which) -> finish());
        mDialog.show();
    }
}