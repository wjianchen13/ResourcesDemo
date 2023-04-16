package com.example.resourcesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.resourcesdemo.ninepatch.NinePatchActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 本地加载.9图片
     * @param v
     */
    public void onTest1(View v) {
        startActivity(new Intent(this, NinePatchActivity.class));
    }
}