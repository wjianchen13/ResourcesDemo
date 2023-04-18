package com.example.resourcesdemo.drawable;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.resourcesdemo.R;

/**
 * 本地加载.9图片
 * /data/data/0/com.example.resourcesdemo/files/
 */
public class GetDrawableActivity extends AppCompatActivity {


    /**
     * 是否使用原始图标测试
     */
    private boolean isUserOrigin = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_drawable);

    }

    /**
     *
     * @param v
     */
    public void onTest1(View v) {
        Drawable d = ContextCompat.getDrawable(this, R.drawable.ic_test_drawable);
        System.out.println("=========================> d: " + d);
    }

    /**
     *
     * @param v
     */
    public void onTest2(View v) {
        Drawable d1 = ContextCompat.getDrawable(this, R.drawable.ic_test_drawable);
        System.out.println("=========================> d1: " + d1);
    }

    /**
     *
     * @param v
     */
    public void onTest3(View v) {

    }

    /**
     *
     * @param v
     */
    public void onTest4(View v) {

    }

    /**
     * 原始.9图片 添加处理
     * @param v
     */
    public void onTest5(View v) {

    }

    /**
     * 原始.9图片 重新生成
     * @param v
     */
    public void onTest6(View v) {

    }


}




