package com.tnkfactory.ad.pub;

import com.tnkfactory.ad.AdError;

/* JADX INFO: loaded from: classes6.dex */
public abstract /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f3119a;

    static {
        int[] iArr = new int[AdError.values().length];
        try {
            iArr[AdError.NO_ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[AdError.FAIL_NO_AD.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[AdError.FAIL_NO_IMAGE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[AdError.FAIL_TIMEOUT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr[AdError.FAIL_CANCELED.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr[AdError.FAIL_SHOW_BEFORE_LOAD.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr[AdError.FAIL_AD_FRAME.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr[AdError.FAIL_DUP_LOAD.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr[AdError.FAIL_DUP_SHOW.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr[AdError.FAIL_BANNER_HEIGHT_50DP.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr[AdError.FAIL_BANNER_HEIGHT_100DP.ordinal()] = 11;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr[AdError.FAIL_NO_PLACEMENT_ID.ordinal()] = 12;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            iArr[AdError.FAIL_INCORRECT_PLACEMENT.ordinal()] = 13;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            iArr[AdError.FAIL_SCREEN_ORIENTATION.ordinal()] = 14;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            iArr[AdError.FAIL_INVALID_STATE.ordinal()] = 15;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            iArr[AdError.FAIL_TEST_DEVICE_NOT_REGISTERED.ordinal()] = 16;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            iArr[AdError.FAIL_FINISHED_ACTIVITY.ordinal()] = 17;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            iArr[AdError.FAIL_SYSTEM.ordinal()] = 18;
        } catch (NoSuchFieldError unused18) {
        }
        f3119a = iArr;
    }
}
