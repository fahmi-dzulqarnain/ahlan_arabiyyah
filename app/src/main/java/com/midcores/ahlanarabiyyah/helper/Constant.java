package com.midcores.ahlanarabiyyah.helper;

import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.midcores.ahlanarabiyyah.activities.QuizActivity;
import com.midcores.ahlanarabiyyah.model.Question;

import java.io.Serializable;
import java.util.ArrayList;

public class Constant implements Serializable {
    public static int index = 0;
    public static int countCorrect = 0;
    public static QuizActivity quizActivity;
    public static BottomSheetBehavior bottomSheetBehavior;
    public static ArrayList<Fragment> fragments = new ArrayList<>();
    public static ArrayList<Question> questions = new ArrayList<>();
}
