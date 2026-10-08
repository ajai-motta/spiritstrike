package com.pgl.ssdk;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes6.dex */
public class a5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f3056a = 504;
    public static String b = null;
    public static String c = "";
    static boolean d;
    private static long e;
    private static Context f;

    public static void a(Context context, String str) {
        if (f == null) {
            f = context;
        }
        int i = f3056a;
        if (i == 102 || i == 202 || i == 200) {
            return;
        }
        e = System.currentTimeMillis();
        d = false;
        b = str;
        f3056a = 102;
        ar.b(new ao(context, 301, null));
    }

    public static void b() {
        Context context = f;
        if (context != null) {
            ar.b(new ao(context, 301, null));
            f3056a = 102;
            com.pgl.ssdk.ces.b bVarE = com.pgl.ssdk.ces.b.e();
            if (bVarE != null) {
                bVarE.a("");
            }
        }
    }

    public static synchronized String a() {
        if (TextUtils.isEmpty(c)) {
            c = (String) com.pgl.ssdk.ces.a.meta(303, f, null);
        }
        return c;
    }

    public static synchronized Object a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return com.pgl.ssdk.ces.a.meta(302, f, bArr);
    }
}
