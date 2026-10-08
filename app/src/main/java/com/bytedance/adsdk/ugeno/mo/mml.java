package com.bytedance.adsdk.ugeno.mo;

import androidx.work.WorkInfo;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class mml {
    public static int qdl(boolean z, int i, int i2) {
        if (i2 == 0 || !z) {
            return i;
        }
        int i3 = i + WorkInfo.STOP_REASON_UNKNOWN;
        int iAbs = Math.abs(i3) % i2;
        return (i3 >= 0 || iAbs == 0) ? iAbs : i2 - iAbs;
    }

    public static boolean qdl(int i, Collection<?> collection) {
        return i >= 0 && i < collection.size();
    }
}
