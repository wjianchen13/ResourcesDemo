package com.example.resourcesdemo.utils.ninepatch2;

import android.graphics.Rect;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 这个工具需要使用aapt修改.9图片，然后再用该类进行处理，才可以显示.9图片的效果，处理的流程参考下面链接
 * https://blog.csdn.net/tabactivity/article/details/50513187
 * https://stackoverflow.com/questions/11065996/ninepatchdrawable-does-not-get-padding-from-chunk
 */
public class NinePatchChunk {

    public static final int NO_COLOR = 0x00000001;
    public static final int TRANSPARENT_COLOR = 0x00000000;

    public final Rect mPaddings = new Rect();

    public int mDivX[];
    public int mDivY[];
    public int mColor[];

    private static void readIntArray(final int[] data, final ByteBuffer buffer) {
        for (int i = 0, n = data.length; i < n; ++i)
            data[i] = buffer.getInt();
    }

    private static void checkDivCount(final int length) {
        if (length == 0 || (length & 0x01) != 0)
            throw new RuntimeException("invalid nine-patch: " + length);
    }

    public static NinePatchChunk deserialize(final byte[] data) {
        final ByteBuffer byteBuffer =
                ByteBuffer.wrap(data).order(ByteOrder.nativeOrder());

        if (byteBuffer.get() == 0) return null; // is not serialized

        final NinePatchChunk chunk = new NinePatchChunk();
        chunk.mDivX = new int[byteBuffer.get()];
        chunk.mDivY = new int[byteBuffer.get()];
        chunk.mColor = new int[byteBuffer.get()];

        checkDivCount(chunk.mDivX.length);
        checkDivCount(chunk.mDivY.length);

        // skip 8 bytes
        byteBuffer.getInt();
        byteBuffer.getInt();

        chunk.mPaddings.left = byteBuffer.getInt();
        chunk.mPaddings.right = byteBuffer.getInt();
        chunk.mPaddings.top = byteBuffer.getInt();
        chunk.mPaddings.bottom = byteBuffer.getInt();

        // skip 4 bytes
        byteBuffer.getInt();

        readIntArray(chunk.mDivX, byteBuffer);
        readIntArray(chunk.mDivY, byteBuffer);
        readIntArray(chunk.mColor, byteBuffer);

        return chunk;
    }
}