package com.gomfactory.adpie.sdk.util;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class MemUtil {
    public static final float BYTES_IN_MB = 1048576.0f;
    public static final String TAG = "MemUtil";
    private static boolean isMemoryError;

    public static float megabytesFree() {
        return megabytesAvailable() - (Runtime.getRuntime().totalMemory() / 1048576.0f);
    }

    public static float megabytesAvailable() {
        return Runtime.getRuntime().maxMemory() / 1048576.0f;
    }

    public static void printMemoryLog() {
        Runtime runtime = Runtime.getRuntime();
        long jMaxMemory = runtime.maxMemory();
        long j = runtime.totalMemory();
        long jFreeMemory = runtime.freeMemory();
        String str = TAG;
        Log.e(str, "--------------------------------------");
        Log.e(str, "max memory: " + (jMaxMemory / 1024) + " KB, total memory: " + (j / 1024) + " KB");
        Log.e(str, "free memory: " + (jFreeMemory / 1024) + " KB, alloc memory: " + ((j - jFreeMemory) / 1024) + " KB");
        Log.e(str, "++++++++++++++++++++++++++++++++++++++");
    }

    public static boolean isMemoryError() {
        return isMemoryError;
    }

    public static void setMemoryError(boolean z) {
        isMemoryError = z;
    }
}
