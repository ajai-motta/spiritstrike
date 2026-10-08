package com.fyber.inneractive.sdk.dv;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f990a;

    static {
        int[] iArr = new int[UnitDisplayType.values().length];
        f990a = iArr;
        try {
            iArr[UnitDisplayType.INTERSTITIAL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f990a[UnitDisplayType.BANNER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f990a[UnitDisplayType.MRECT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f990a[UnitDisplayType.REWARDED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
