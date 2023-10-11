package com.example.resourcesdemo.test;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.resourcesdemo.R;
import com.example.resourcesdemo.utils.ninepatch.NinePatchChunk1;
import com.example.resourcesdemo.utils.ninepatch2.NinePatchChunk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 本地加载.9图片
 * /data/data/0/com.example.resourcesdemo/files/
 */
public class TestActivity extends AppCompatActivity {

    private TextView tvTest1;
    private TextView tvTest2;
    private TextView tvTest3;
    private TextView tvTest4;
    private TextView tvTest5;
    private TextView tvTest6;
    private TextView tvTest7;
    private String filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        filePath = getFilesDir().getPath(); // /data/user/0/com.example.resourcesdemo/files
        tvTest1 = findViewById(R.id.tv_test1);
        tvTest2 = findViewById(R.id.tv_test2);
        tvTest3 = findViewById(R.id.tv_test3);
        tvTest4 = findViewById(R.id.tv_test4);
        tvTest5 = findViewById(R.id.tv_test5);
        tvTest6 = findViewById(R.id.tv_test6);
        tvTest7 = findViewById(R.id.tv_test7);
    }

//    private String url1 = "https://twww.ayomet.com/public/images/vip/vip_chat.png"; // 原始图片
    private String url1 = "https://twww.ayomet.com/public/svga/test/cptest/CP4.png";

    /**
     * 网络加载资源，这里测试的是原始资源
     * 由于代码逻辑需要NinePatch.isNinePatchChunk(chunk)才进行设置背景，所以点这个没有任何效果
     * @param v
     */
    public void onTest1(View v) {
        loadDian9Tu1(this, tvTest1, url1);
    }

    public void loadDian9Tu1(Context context, View view, String imgUrl) {
        if (context == null) {
            return;
        }
        if (context instanceof Activity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                if (((Activity) context).isDestroyed()) {
                    return;
                }
            }
        }
        Glide.with(context)
                .asFile()
                .load(imgUrl)
                .into(new CustomTarget<File>() {
                    @Override
                    public void onResourceReady(@NonNull File resource, @Nullable Transition<? super File> transition) {
                        try {
                            FileInputStream is = new FileInputStream(resource);
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inDensity = DisplayMetrics.DENSITY_XHIGH;
                            setNinePathImage1(context, view, BitmapFactory.decodeStream(is, null, options));
                            is.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
    }

    public void setNinePathImage1(Context context, View view, Bitmap bitmap) {
        if (bitmap == null)
            return;
        byte[] chunk = bitmap.getNinePatchChunk();
//        if (NinePatch.isNinePatchChunk(chunk)) {
            final NinePatchDrawable patchy =
                    NinePatchChunk1.create9PatchDrawable(
                            TestActivity.this,
                            bitmap,
                            null);
                view.setBackground(patchy);
//        }
    }


//    private String url2 = "https://twww.ayomet.com/public/images/vip/vip_chat_2.png"; // aapt处理过的图片
    private String url2 = "https://twww.ayomet.com/public/svga/test/cptest/CP4.png";

    /**
     * 网络加载资源，这里测试的是使用aapt改过的资源
     * 这个能看到实际效果
     * @param v
     */
    public void onTest2(View v) {
        loadDian9Tu2(this, tvTest2, url2);
    }

    private void loadDian9Tu2(Context context, View view, String imgUrl) {
        if (context == null) {
            return;
        }
        if (context instanceof Activity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                if (((Activity) context).isDestroyed()) {
                    return;
                }
            }
        }
        Glide.with(context)
                .asFile()
                .load(imgUrl)
                .into(new CustomTarget<File>() {
                    @Override
                    public void onResourceReady(@NonNull File resource, @Nullable Transition<? super File> transition) {
                        try {

                            FileInputStream is = new FileInputStream(resource);
                            saveFile(resource, getBubblePath());
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inDensity = DisplayMetrics.DENSITY_XHIGH;
                            setNinePathImage2(context, view, BitmapFactory.decodeStream(is, null, options));
                            is.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
    }

    /**
     * 返回气泡路径，如果没有会创建路径
     */
    private String getBubblePath() {
        String path = filePath +  File.separator + "bubble";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }

    private void setNinePathImage2(Context context, View view, Bitmap bitmap) {
        if (bitmap == null)
            return;
        byte[] chunk = bitmap.getNinePatchChunk();
        if (NinePatch.isNinePatchChunk(chunk)) {
            NinePatchDrawable patchy = new NinePatchDrawable(getApplicationContext().getResources(), bitmap, chunk, NinePatchChunk.deserialize(chunk).mPaddings, null);
            view.setBackground(patchy);
        }
    }

    private void saveFile(File source, String path) {
        try {
            copyFile(source, new File(path + File.separator  + "vip_chat_2.9.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if (!sourceFile.exists()) {
            return;
        }

        FileChannel sourceChannel = null;
        FileChannel destChannel = null;

        try {
            sourceChannel = new FileInputStream(sourceFile).getChannel();
            destChannel = new FileOutputStream(destFile).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(), destChannel);
        } finally {
            if (sourceChannel != null) {
                sourceChannel.close();
            }
            if (destChannel != null) {
                destChannel.close();
            }
        }
    }

    /**
     * 从上一步保存的文件中加载.9进行显示
     * @param v
     */
    public void onTest3(View v) {
        setNinePathImage3(this, tvTest3, BitmapFactory.decodeFile(getBubblePath() + File.separator + "vip_chat_2.9.png"));
    }

    private void setNinePathImage3(Context context, View view, Bitmap bitmap) {
        if (bitmap == null)
            return;
        byte[] chunk = bitmap.getNinePatchChunk();
        if (NinePatch.isNinePatchChunk(chunk)) {
            NinePatchDrawable patchy = new NinePatchDrawable(getApplicationContext().getResources(), bitmap, chunk, NinePatchChunk.deserialize(chunk).mPaddings, null);
            view.setBackground(patchy);
        }
    }

    private Drawable mDrawable;

    /**
     * 测试资源公用
     * @param v
     */
    public void onTest4(View v) {
        loadDian9Tu4(this, tvTest4, url2);
    }

    public void loadDian9Tu4(Context context, View view, String imgUrl) {
        if (context == null) {
            return;
        }
        if (context instanceof Activity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                if (((Activity) context).isDestroyed()) {
                    return;
                }
            }
        }
        Glide.with(context)
                .asFile()
                .load(imgUrl)
                .into(new CustomTarget<File>() {
                    @Override
                    public void onResourceReady(@NonNull File resource, @Nullable Transition<? super File> transition) {
                        try {
                            FileInputStream is = new FileInputStream(resource);
                            setNinePathImage4(context, view, BitmapFactory.decodeStream(is));
                            is.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
    }

    public void setNinePathImage4(Context context, View view, Bitmap bitmap) {
        if (bitmap == null)
            return;
        byte[] chunk = bitmap.getNinePatchChunk();
        if (NinePatch.isNinePatchChunk(chunk)) {
            mDrawable =
                    NinePatchChunk1.create9PatchDrawable(
                            TestActivity.this,
                            bitmap,
                            null);
            view.setBackground(mDrawable);
        }
    }

    /**
     * 测试资源公用
     * @param v
     */
    public void onTest5(View v) {
        tvTest5.setBackground(mDrawable);
    }

    /**
     * 测试资源公用
     * @param v
     */
    public void onTest6(View v) {
        tvTest6.setBackground(mDrawable);
    }

    /**
     * 测试资源公用
     * @param v
     */
    public void onTest7(View v) {
        tvTest7.setBackground(mDrawable);
    }

}




