package com.example.resourcesdemo.ninepatch;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.NinePatchDrawable;

import com.example.resourcesdemo.ninepatch.ninepatch.NinePatchChunk1;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class NinePatchManager {

    private static NinePatchManager INSTANCE = null;

    private Map<Integer, NinePatchDrawable> ninePatchMap = new HashMap<>();
    private String path;

    public static NinePatchManager getInstance() {
        if (INSTANCE == null) {
            synchronized (NinePatchManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NinePatchManager();
                }
            }
        }
        return INSTANCE;
    }

    private NinePatchManager() {

    }

    public void loadAllNinePatch(final Context context, NinePatchListener listener) {
        path = context.getFilesDir().getAbsolutePath() + File.separator + "vip_chat_";

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1; i <= 6; i ++) {
                    String realPath = path + i + ".9.png";
                    final NinePatchDrawable drawable =
                            NinePatchChunk1.create9PatchDrawable(
                                    context,
                                    BitmapFactory.decodeFile(realPath),
                                    null);
                    ninePatchMap.put(i, drawable);
                }
                if(listener != null)
                    listener.onFinish();
            }
        }).start();
    }

    public NinePatchDrawable getNinePatchDrawable(Context context, int id) {
        if(!ninePatchMap.containsKey(id)) {
            path = context.getFilesDir().getAbsolutePath() + File.separator + "vip_chat_";
            String realPath = path + id + ".9.png";
            final NinePatchDrawable drawable =
                    NinePatchChunk1.create9PatchDrawable(
                            context,
                            BitmapFactory.decodeFile(realPath),
                            null);
            ninePatchMap.put(id, drawable);
            return drawable;
        }
        return ninePatchMap.get(id);
    }


    public interface NinePatchListener {
        void onFinish();
    }
}
