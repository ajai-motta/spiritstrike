package com.pgl.ssdk;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes6.dex */
public class an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f3067a = -1;
    public static String b = null;
    private static String c = "api16-access-ttp.tiktokpangle.us";
    public static final String[] d = {"api16-access-ttp.tiktokpangle.us", "api16-access-ttp-b.tiktokpangle.us", "api16-access-ttp.tiktokpangle-b.us", "api16-access-ttp-b.tiktokpangle-b.us"};
    private static int e = Integer.MIN_VALUE;
    public static String f = "";

    public static String a() {
        return f3067a == 1 ? "VA" : "SG";
    }

    public static String b() {
        return f;
    }

    public static void a(int i) {
        f3067a = i;
    }

    public static void b(String str) {
        f = str;
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b = str;
    }

    public static void b(Context context) {
        if (TextUtils.isEmpty(b)) {
            au.a("updateIndex");
            int i = e;
            if (i < Integer.MAX_VALUE) {
                int i2 = i + 1;
                e = i2;
                ax.b(context, "domain_index", i2);
                return;
            }
            e = 0;
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        try {
            if (e == Integer.MIN_VALUE) {
                e = ax.a(context, "domain_index", 0);
            }
            String[] strArr = d;
            return strArr[e % strArr.length];
        } catch (Throwable unused) {
            return c;
        }
    }
}
