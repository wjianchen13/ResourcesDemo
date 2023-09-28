package com.example.resourcesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.resourcesdemo.drawable.GetDrawableActivity;
import com.example.resourcesdemo.net.NetActivity;
import com.example.resourcesdemo.ninepatch.NinePatchActivity;
import com.example.resourcesdemo.ninepatch.NinePatchActivity1;

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

    /**
     * 加载.9图片缓存
     * @param v
     */
    public void onTest2(View v) {
        startActivity(new Intent(this, NinePatchActivity1.class));
    }

    /**
     * 获取资源图片
     * @param v
     */
    public void onTest3(View v) {
        startActivity(new Intent(this, GetDrawableActivity.class));
    }

    /**
     * 网络加载
     * @param v
     */
    public void onTest4(View v) {
        startActivity(new Intent(this, NetActivity.class));
    }


}