package com.bytedance.sdk.openadsdk.utils;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class ljh {
    public static boolean qdl() {
        if (Build.VERSION.SDK_INT < 33) {
            return Build.VERSION.SDK_INT >= 32 && qdl("T", Build.VERSION.CODENAME);
        }
        return true;
    }

    public static boolean qdl(String str, String str2) {
        return !"REL".equals(str2) && str2.toUpperCase(Locale.ROOT).compareTo(str.toUpperCase(Locale.ROOT)) >= 0;
    }
}
