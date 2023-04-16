package com.example.resourcesdemo.ninepatch;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resourcesdemo.R;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 本地加载.9图片
 * /data/data/0/com.example.resourcesdemo/files/
 */
public class NinePatchActivity extends AppCompatActivity {

    private LinearLayout llytTest;
    private String path;
    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninepatch);
        llytTest = findViewById(R.id.llyt_test);
        tvTest = findViewById(R.id.tv_test);
        path = getFilesDir().getAbsolutePath() + File.separator + "ic_chat.9.png";
    }

    public void onTest1(View v) {
//        try {
//            Bitmap bitmap = BitmapFactory.decodeFile(path);
//
//            byte[] chunk = bitmap.getNinePatchChunk();
//            if (NinePatch.isNinePatchChunk(chunk)) {
//                NinePatchDrawable drawable = new NinePatchDrawable(bitmap, chunk, new Rect(), null);
//                tvTest.setBackgroundDrawable(drawable);
////                tvTest.setBack
//            } else {
//                BitmapDrawable drawable = new BitmapDrawable(bitmap);
//                tvTest.setBackgroundDrawable(drawable);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            Bitmap bitmap = BitmapFactory.decodeFile(path);

            byte[] chunk = bitmap.getNinePatchChunk();
            if (NinePatch.isNinePatchChunk(chunk)) {
                NinePatchDrawable drawable =  NinePatchBitmapFactory.create(bitmap, chunk, new Rect(), null);
                tvTest.setBackgroundDrawable(drawable);
//                tvTest.setBack
            } else {
                BitmapDrawable drawable = new BitmapDrawable(bitmap);
                tvTest.setBackgroundDrawable(drawable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}




