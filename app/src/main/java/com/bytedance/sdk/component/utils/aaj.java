package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import android.util.Log;
import io.ktor.sse.ServerSentEventKt;

/* JADX INFO: loaded from: classes3.dex */
public class aaj {
    private static boolean qdl = false;
    private static String ud = "";

    public static void qdl() {
        qdl = true;
    }

    public static void ud() {
        qdl = false;
    }

    public static void qdl(String str, String str2) {
        if (qdl && str2 != null) {
            Log.d(ud(str), str2);
        }
    }

    public static void qdl(String str, Object... objArr) {
        if (qdl && objArr != null) {
            Log.d(ud(str), qdl(objArr));
        }
    }

    public static void ud(String str, String str2) {
        if (qdl && str2 != null) {
            Log.i(ud(str), str2);
        }
    }

    public static void ud(String str, Object... objArr) {
        if (qdl && objArr != null) {
            Log.i(ud(str), qdl(objArr));
        }
    }

    public static void lnr(String str, String str2) {
        if (qdl && str2 != null) {
            Log.e(ud(str), str2);
        }
    }

    public static void lnr(String str, Object... objArr) {
        if (qdl && objArr != null) {
            Log.e(ud(str), qdl(objArr));
        }
    }

    public static void qdl(String str, String str2, Throwable th) {
        if (qdl) {
            if (str2 == null && th == null) {
                return;
            }
            Log.e(ud(str), str2, th);
        }
    }

    public static void qdl(String str) {
        ud = str;
    }

    private static String ud(String str) {
        if (TextUtils.isEmpty(ud)) {
            return str;
        }
        return qdl("[" + ud + "]-[" + str + "]");
    }

    private static String qdl(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            } else {
                sb.append(" null ");
            }
            sb.append(ServerSentEventKt.SPACE);
        }
        return sb.toString();
    }
}
