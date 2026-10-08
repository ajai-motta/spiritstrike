package com.bytedance.sdk.openadsdk.multipro.mml;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.qdl;
import com.bytedance.sdk.openadsdk.core.tvp;
import com.bytedance.sdk.openadsdk.core.yt;

/* JADX INFO: loaded from: classes3.dex */
public class mml {
    private static boolean qdl() {
        return yt.qdl() == null;
    }

    private static String ud(String str) {
        return TextUtils.isEmpty(str) ? "tt_sp" : str;
    }

    public static void qdl(String str, String str2, Boolean bool) {
        if (qdl()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            qdl.qdl(ud(str), str2, bool);
        } else {
            qdl(ud(str), str2, bool);
        }
    }

    public static void qdl(String str, String str2, Long l) {
        if (qdl()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            qdl.qdl(ud(str), str2, l);
        } else {
            qdl(ud(str), str2, l);
        }
    }

    public static void qdl(String str, String str2, String str3) {
        if (qdl()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            qdl.qdl(ud(str), str2, str3);
        } else {
            qdl(ud(str), str2, str3);
        }
    }

    public static void qdl(String str, String str2, Integer num) {
        if (qdl()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            qdl.qdl(ud(str), str2, num);
        } else {
            qdl(ud(str), str2, num);
        }
    }

    public static int qdl(String str, String str2, int i) {
        if (qdl()) {
            return i;
        }
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            return qdl.qdl(ud(str), str2, i);
        }
        return qdl.qdl(yt.qdl(), ud(str), str2, i);
    }

    public static boolean qdl(String str, String str2, boolean z) {
        if (qdl()) {
            return z;
        }
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            return qdl.qdl(ud(str), str2, z);
        }
        return qdl.qdl(yt.qdl(), ud(str), str2, z);
    }

    public static long qdl(String str, String str2, long j) {
        if (qdl()) {
            return j;
        }
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            return qdl.qdl(ud(str), str2, j);
        }
        return qdl.qdl(yt.qdl(), ud(str), str2, j);
    }

    public static String ud(String str, String str2, String str3) {
        if (qdl()) {
            return str3;
        }
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            return qdl.ud(ud(str), str2, str3);
        }
        return qdl.qdl(yt.qdl(), ud(str), str2, str3);
    }

    public static void qdl(String str, String str2) {
        if (qdl()) {
            return;
        }
        try {
            if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
                qdl.ud(ud(str), str2);
            } else {
                ud.ud(yt.qdl(), ud(str), str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void qdl(String str) {
        if (qdl()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            qdl.qdl(ud(str));
        } else {
            ud.ud(yt.qdl(), ud(str));
        }
    }

    private static <T> void qdl(String str, String str2, T t) {
        String strQdl = qdl.qdl(str, str2);
        if (tvp.wd(strQdl)) {
            qdl.lnr lnrVarUd = com.bytedance.sdk.component.qdl.qdl(yt.qdl(), ud(strQdl)).ud();
            ud.qdl(lnrVarUd, str2, (Object) t);
            lnrVarUd.apply();
        } else {
            SharedPreferences sharedPreferencesQdl = ud.qdl(yt.qdl(), ud(strQdl));
            if (sharedPreferencesQdl == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesQdl.edit();
            ud.qdl(editorEdit, str2, t);
            editorEdit.apply();
        }
    }
}
