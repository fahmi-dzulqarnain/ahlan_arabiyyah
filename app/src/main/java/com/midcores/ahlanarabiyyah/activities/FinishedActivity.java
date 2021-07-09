package com.midcores.ahlanarabiyyah.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.midcores.ahlanarabiyyah.R;

import static com.midcores.ahlanarabiyyah.helper.Constant.countCorrect;

public class FinishedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished);

        TextView txtCorrect = findViewById(R.id.txtCorrect);
        String correct = countCorrect + " Soal Benar";
        txtCorrect.setText(correct);

        findViewById(R.id.btnKembali).setOnClickListener(v -> finish());
    }
}