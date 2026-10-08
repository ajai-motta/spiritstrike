package com.inca.security.DexProtect;

/* JADX INFO: compiled from: fb */
/* JADX INFO: loaded from: classes.dex */
public class Binder {
    private static /* synthetic */ Object mApplication;
    private static /* synthetic */ int mCurrentABItype;

    public static int getABI() {
        return mCurrentABItype;
    }

    public static void setABI(int i) {
        mCurrentABItype = i;
    }

    public static void setReserved1(Object obj) {
        mApplication = obj;
    }

    public static Object getReserved1() {
        return mApplication;
    }
}
