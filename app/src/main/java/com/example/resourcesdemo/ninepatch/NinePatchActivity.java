package com.example.resourcesdemo.ninepatch;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.resourcesdemo.R;
import com.example.resourcesdemo.ninepatch.ninepatch.NinePatchChunk1;

import java.io.File;

/**
 * 本地加载.9图片
 * /data/data/0/com.example.resourcesdemo/files/
 */
public class NinePatchActivity extends AppCompatActivity {

    private String aaptPath;
    private String originPath;

    /**
     * 表示经过了aapt处理过的.9图片名称
     */
    private String aaptFileName;

    /**
     * 表示原始的.9图片名称
     */
    private String originFileName;

    private TextView tvTest2;
    private TextView tvTest4;
    private TextView tvTest6;
    private TextView tvTest8;
    private TextView tvTest10;
    private TextView tvTest12;

    /**
     * 是否使用原始图标测试
     */
    private boolean isUserOrigin = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninepatch);
        tvTest2 = findViewById(R.id.tv_test2);
        tvTest4 = findViewById(R.id.tv_test4);
        tvTest6 = findViewById(R.id.tv_test6);
        tvTest8 = findViewById(R.id.tv_test8);
        tvTest10 = findViewById(R.id.tv_test10);
        tvTest12 = findViewById(R.id.tv_test12);
        aaptFileName = "vip_chat_2.9.png"; // 网络下载的
        originFileName = "vip_chat_2_o.9.png"; // 原始图片
        aaptPath = getFilesDir().getAbsolutePath() + File.separator + aaptFileName;
        originPath = getFilesDir().getAbsolutePath() + File.separator + originFileName;
    }

    /**
     * 使用aapt处理.9图片，上传到应用私有目录，这里加载出来的图标，拉升信息正常，但是内容区域丢失
     * @param v
     */
    public void onTest1(View v) {
        try {
            Bitmap bitmap = BitmapFactory.decodeFile(aaptPath);
            byte[] chunk = bitmap.getNinePatchChunk();
            if (NinePatch.isNinePatchChunk(chunk)) {
                NinePatchDrawable drawable = new NinePatchDrawable(getResources(), bitmap, chunk, new Rect(), null);
                tvTest2.setBackground(drawable);
            } else {
                BitmapDrawable drawable = new BitmapDrawable(getResources(), bitmap);
                tvTest2.setBackground(drawable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param v
     */
    public void onTest2(View v) {
        try {
            Bitmap bitmap = BitmapFactory.decodeFile(aaptPath);
            byte[] chunk = bitmap.getNinePatchChunk();
            if (NinePatch.isNinePatchChunk(chunk)) {
                NinePatchDrawable drawable = new NinePatchDrawable(getResources(), bitmap, chunk, NinePatchChunk.deserialize(chunk).mPaddings, null);
                tvTest4.setBackground(drawable);
            } else {
                BitmapDrawable drawable = new BitmapDrawable(getResources(), bitmap);
                tvTest4.setBackground(drawable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param v
     */
    public void onTest3(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    final NinePatchDrawable drawable =
                            NinePatchChunk1.create9PatchDrawable(
                                    NinePatchActivity.this,
                                    BitmapFactory.decodeFile(aaptPath),
                                    null);
                    new Handler(NinePatchActivity.this.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            tvTest6.setBackground(drawable);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 原始.9图片，上传到应用私有目录，这里加载出来的图标，拉升信息正常，但是内容区域丢失
     * @param v
     */
    public void onTest4(View v) {
        try {
            Bitmap bitmap = BitmapFactory.decodeFile(originPath);
            byte[] chunk = bitmap.getNinePatchChunk();
            if (NinePatch.isNinePatchChunk(chunk)) {
                NinePatchDrawable drawable = new NinePatchDrawable(getResources(), bitmap, chunk, new Rect(), null);
                tvTest8.setBackground(drawable);
            } else {
                BitmapDrawable drawable = new BitmapDrawable(getResources(), bitmap);
                tvTest8.setBackground(drawable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 原始.9图片 添加处理
     * @param v
     */
    public void onTest5(View v) {
        try {
            Bitmap bitmap = BitmapFactory.decodeFile(originPath);
            byte[] chunk = bitmap.getNinePatchChunk();
            if (NinePatch.isNinePatchChunk(chunk)) {
                NinePatchDrawable drawable = new NinePatchDrawable(getResources(), bitmap, chunk, NinePatchChunk.deserialize(chunk).mPaddings, null);
                tvTest10.setBackground(drawable);
            } else {
                BitmapDrawable drawable = new BitmapDrawable(getResources(), bitmap);
                tvTest10.setBackground(drawable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 原始.9图片 重新生成
     * @param v
     */
    public void onTest6(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final NinePatchDrawable drawable =
                            NinePatchChunk1.create9PatchDrawable(
                                    NinePatchActivity.this,
                                    BitmapFactory.decodeFile(originPath),
                                    null);
                    new Handler(NinePatchActivity.this.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            tvTest12.setBackground(drawable);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}




