package com.fyber.inneractive.sdk.ui;

import com.fyber.inneractive.sdk.ui.IFyberAdIdentifier;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1641a;

    static {
        int[] iArr = new int[IFyberAdIdentifier.Corner.values().length];
        f1641a = iArr;
        try {
            iArr[IFyberAdIdentifier.Corner.TOP_LEFT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1641a[IFyberAdIdentifier.Corner.TOP_RIGHT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f1641a[IFyberAdIdentifier.Corner.BOTTOM_LEFT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f1641a[IFyberAdIdentifier.Corner.BOTTOM_RIGHT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
