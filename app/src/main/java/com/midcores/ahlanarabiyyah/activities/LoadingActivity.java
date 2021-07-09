package com.midcores.ahlanarabiyyah.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.jaeger.library.StatusBarUtil;
import com.midcores.ahlanarabiyyah.R;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        StatusBarUtil.setTransparent(this);
        new Handler(Looper.myLooper()).postDelayed(() -> {
            startActivity(new Intent(LoadingActivity.this, MainActivity.class));
            finish();
        }, 1000);
    }
}