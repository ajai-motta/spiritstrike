package com.bytedance.adsdk.qdl.ud.mzz;

/* JADX INFO: loaded from: classes.dex */
public class qdl {
    public static boolean lnr(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean mml(char c) {
        return '+' == c || '-' == c || '*' == c || '/' == c || '%' == c || '=' == c || '>' == c || '<' == c || '!' == c || '&' == c || '|' == c || '?' == c || ':' == c;
    }

    public static boolean qdl(char c) {
        return c == ' ';
    }

    public static boolean ud(char c) {
        if (c < 'A' || c > 'Z') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }
}
