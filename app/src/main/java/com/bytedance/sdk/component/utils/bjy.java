package com.bytedance.sdk.component.utils;

/* JADX INFO: loaded from: classes3.dex */
public class bjy {
    private static String lnr = "";
    private static boolean qdl = false;
    private static int ud = 4;

    public static void qdl(String str) {
        lnr = str;
    }

    public static void qdl(int i) {
        ud = i;
    }

    public static boolean qdl() {
        return ud <= 3;
    }

    public static void ud() {
        qdl = true;
        qdl(3);
    }

    public static void lnr() {
        qdl = false;
        qdl(7);
    }

    public static boolean mml() {
        return qdl;
    }
}
