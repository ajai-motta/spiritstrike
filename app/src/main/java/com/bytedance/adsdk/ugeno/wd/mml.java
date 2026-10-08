package com.bytedance.adsdk.ugeno.wd;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes2.dex */
public final class mml {
    private static Context lnr;
    private static String qdl;
    private static Resources ud;

    public static void qdl(String str) {
        qdl = str;
    }

    private static String qdl(Context context) {
        if (qdl == null) {
            qdl = context.getPackageName();
        }
        return qdl;
    }

    private static int qdl(Context context, String str, String str2) {
        if (ud == null) {
            ud = context.getResources();
        }
        return ud.getIdentifier(str, str2, qdl(context));
    }

    public static int qdl(Context context, String str) {
        return qdl(context, str, "raw");
    }

    public static int ud(Context context, String str) {
        return qdl(context, str, "drawable");
    }
}
