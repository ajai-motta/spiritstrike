package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes6.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f2840a = new v("CreativeView", 0);
    public static final v b = new v("Start", 1);
    public static final v c = new v("FirstQuartile", 2);
    public static final v d = new v("Midpoint", 3);
    public static final v e = new v("ThirdQuartile", 4);
    public static final v f = new v("Complete", 5);
    public static final v g = new v("Mute", 6);
    public static final v h = new v("UnMute", 7);
    public static final v i = new v("Pause", 8);
    public static final v j = new v("Rewind", 9);
    public static final v k = new v("Resume", 10);
    public static final v l = new v("CloseLinear", 11);
    public static final v m = new v("Skip", 12);
    public static final v n = new v("Progress", 13);
    public static final /* synthetic */ v[] o;
    public static final /* synthetic */ EnumEntries p;

    static {
        v[] vVarArrA = a();
        o = vVarArrA;
        p = EnumEntriesKt.enumEntries(vVarArrA);
    }

    public v(String str, int i2) {
    }

    public static final /* synthetic */ v[] a() {
        return new v[]{f2840a, b, c, d, e, f, g, h, i, j, k, l, m, n};
    }

    public static EnumEntries<v> b() {
        return p;
    }

    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    public static v[] values() {
        return (v[]) o.clone();
    }
}
