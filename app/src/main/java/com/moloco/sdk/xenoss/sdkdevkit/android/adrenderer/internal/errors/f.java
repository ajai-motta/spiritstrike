package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes6.dex */
public final class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f2518a = new f("NATIVE_AD_ORTB_RESPONSE_NULL_ERROR", 0);
    public static final f b = new f("NATIVE_AD_IMAGE_ASSET_MEDIA_FETCH_ERROR", 1);
    public static final f c = new f("NATIVE_AD_IMAGE_PREPARE_ASSET_UNKNOWN_ERROR", 2);
    public static final f d = new f("NATIVE_AD_VIDEO_ASSET_MEDIA_NOT_ENOUGH_ERROR", 3);
    public static final f e = new f("NATIVE_AD_VIDEO_ASSET_MEDIA_FETCH_ERROR", 4);
    public static final /* synthetic */ f[] f;
    public static final /* synthetic */ EnumEntries g;

    static {
        f[] fVarArrB = b();
        f = fVarArrB;
        g = EnumEntriesKt.enumEntries(fVarArrB);
    }

    public f(String str, int i) {
    }

    public static final /* synthetic */ f[] b() {
        return new f[]{f2518a, b, c, d, e};
    }

    public static EnumEntries<f> c() {
        return g;
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f.clone();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c
    public String a() {
        return name();
    }
}
