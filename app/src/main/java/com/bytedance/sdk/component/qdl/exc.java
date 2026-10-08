package com.bytedance.sdk.component.qdl;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
class exc {
    private static boolean qdl;

    static String qdl(Throwable th) {
        StringBuilder sb = new StringBuilder("{\"code\":");
        sb.append(th instanceof jtx ? ((jtx) th).qdl : 0);
        sb.append("}");
        return sb.toString();
    }

    static String qdl(String str, boolean z) {
        String strSubstring;
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        if (qdl && !z) {
            strSubstring = str.substring(1, str.length() - 1);
        } else {
            strSubstring = "";
        }
        String strConcat = "{\"code\":1,\"__data\":".concat(String.valueOf(str));
        if (!strSubstring.isEmpty()) {
            return strConcat + "," + strSubstring + "}";
        }
        return strConcat + "}";
    }

    static String qdl() {
        return "";
    }

    static void qdl(boolean z) {
        qdl = z;
    }
}
