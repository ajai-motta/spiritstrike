package com.bytedance.sdk.openadsdk.utils;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class wd {
    private static long lnr = 0;
    static int qdl = -1;
    static float ud;

    private static void qdl(Intent intent) {
        if (intent.getIntExtra("status", -1) == 2) {
            qdl = 1;
        } else {
            qdl = 0;
        }
        ud = (intent.getIntExtra("level", -1) * 100) / intent.getIntExtra("scale", -1);
    }

    public static qdl qdl() {
        if (lnr == 0 || SystemClock.elapsedRealtime() - lnr > 60000) {
            Intent intentRegisterReceiver = com.bytedance.sdk.openadsdk.core.yt.qdl().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            Log.d("BatteryDataWatcher", "obtainCurrentState: registerReceiver result is ".concat(String.valueOf(intentRegisterReceiver)));
            if (intentRegisterReceiver != null) {
                qdl(intentRegisterReceiver);
                lnr = SystemClock.elapsedRealtime();
            }
        }
        qdl qdlVar = new qdl(qdl, ud);
        int i = qdlVar.qdl;
        float f = qdlVar.ud;
        return qdlVar;
    }

    public static class qdl {
        public final int qdl;
        public final float ud;

        public qdl(int i, float f) {
            this.qdl = i;
            this.ud = f;
        }
    }
}
