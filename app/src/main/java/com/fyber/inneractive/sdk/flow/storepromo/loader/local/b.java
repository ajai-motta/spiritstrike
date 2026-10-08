package com.fyber.inneractive.sdk.flow.storepromo.loader.local;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1105a;

    static {
        int[] iArr = new int[com.fyber.inneractive.sdk.flow.storepromo.model.b.values().length];
        f1105a = iArr;
        try {
            iArr[com.fyber.inneractive.sdk.flow.storepromo.model.b.RATING_ICON.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1105a[com.fyber.inneractive.sdk.flow.storepromo.model.b.ICON.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f1105a[com.fyber.inneractive.sdk.flow.storepromo.model.b.SCREENSHOT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f1105a[com.fyber.inneractive.sdk.flow.storepromo.model.b.VIDEO.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
