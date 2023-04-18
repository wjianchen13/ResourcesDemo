package com.example.resourcesdemo.ninepatch;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resourcesdemo.R;

/**
 * 本地加载.9图片
 * /data/data/0/com.example.resourcesdemo/files/
 */
public class NinePatchActivity1 extends AppCompatActivity {

    private TextView tvTest1;
    private TextView tvTest2;
    private TextView tvTest3;
    private TextView tvTest4;
    private TextView tvTest5;
    private TextView tvTest6;
    private TextView tvTest7;
    private TextView tvTest8;
    private TextView tvTest9;
    private TextView tvTest10;
    private TextView tvTest11;
    private TextView tvTest12;

    /**
     * 是否使用原始图标测试
     */
    private boolean isUserOrigin = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninepatch1);
        tvTest1 = findViewById(R.id.tv_test1);
        tvTest2 = findViewById(R.id.tv_test2);
        tvTest3 = findViewById(R.id.tv_test3);
        tvTest4 = findViewById(R.id.tv_test4);
        tvTest5 = findViewById(R.id.tv_test5);
        tvTest6 = findViewById(R.id.tv_test6);
        tvTest7 = findViewById(R.id.tv_test7);
        tvTest8 = findViewById(R.id.tv_test8);
        tvTest9 = findViewById(R.id.tv_test9);
        tvTest10 = findViewById(R.id.tv_test10);
        tvTest11 = findViewById(R.id.tv_test11);
        tvTest12 = findViewById(R.id.tv_test12);
//        NinePatchManager.getInstance().loadAllNinePatch(this, new NinePatchManager.NinePatchListener() {
//            @Override
//            public void onFinish() {
//                System.out.println("==========================> load finish");
//            }
//        });
    }

    /**
     * test1
     * @param v
     */
    public void onTest1(View v) {
        tvTest1.setBackground(NinePatchManager.getInstance().getNinePatchDrawable(NinePatchActivity1.this, 1));
    }

    /**
     * test2
     * @param v
     */
    public void onTest2(View v) {
        tvTest2.setBackground(NinePatchManager.getInstance().getNinePatchDrawable(NinePatchActivity1.this, 1));
    }

    /**
     * test3
     * @param v
     */
    public void onTest3(View v) {
        tvTest3.setBackground(NinePatchManager.getInstance().getNinePatchDrawable(NinePatchActivity1.this, 1));
    }

    /**
     * test4
     * @param v
     */
    public void onTest4(View v) {
        tvTest4.setBackground(NinePatchManager.getInstance().getNinePatchDrawable(NinePatchActivity1.this, 1));
    }

    /**
     * test5
     * @param v
     */
    public void onTest5(View v) {
        tvTest5.setBackground(NinePatchManager.getInstance().getNinePatchDrawable(NinePatchActivity1.this, 1));
    }

    /**
     * test6
     * @param v
     */
    public void onTest6(View v) {
        tvTest6.setBackground(NinePatchManager.getInstance().getNinePatchDrawable(NinePatchActivity1.this, 1));
    }

    /**
     * test7
     * @param v
     */
    public void onTest7(View v) {
        tvTest7.setBackground(NinePatchManager.getInstance().getNinePatchDrawable(NinePatchActivity1.this, 2));
    }

    /**
     * test8
     * @param v
     */
    public void onTest8(View v) {
        tvTest8.setBackground(NinePatchManager.getInstance().getNinePatchDrawable(NinePatchActivity1.this, 3));
    }

    /**
     * test9
     * @param v
     */
    public void onTest9(View v) {
        tvTest9.setBackground(NinePatchManager.getInstance().getNinePatchDrawable(NinePatchActivity1.this, 4));
    }

    /**
     * test10
     * @param v
     */
    public void onTest10(View v) {
        tvTest10.setBackground(NinePatchManager.getInstance().getNinePatchDrawable(NinePatchActivity1.this, 5));
    }

    /**
     * test11
     * @param v
     */
    public void onTest11(View v) {
        tvTest11.setBackground(NinePatchManager.getInstance().getNinePatchDrawable(NinePatchActivity1.this, 6));
    }

    /**
     * test12
     * @param v
     */
    public void onTest12(View v) {
        tvTest12.setBackground(NinePatchManager.getInstance().getNinePatchDrawable(NinePatchActivity1.this, 6));
    }

}




