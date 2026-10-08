package com.moloco.sdk.internal.mediators;

import com.adxcorp.util.ADXLogUtil;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2095a = new a("MAX", 0);
    public static final a b = new a("LevelPlay", 1);
    public static final a c = new a("X3MADS", 2);
    public static final a d = new a(ADXLogUtil.PLATFORM_ADMOB, 3);
    public static final a e = new a("Custom_MAX", 4);
    public static final a f = new a("Custom_LevelPlay", 5);
    public static final a g = new a("Custom_AdMob", 6);
    public static final /* synthetic */ a[] h;
    public static final /* synthetic */ EnumEntries i;

    static {
        a[] aVarArrA = a();
        h = aVarArrA;
        i = EnumEntriesKt.enumEntries(aVarArrA);
    }

    public a(String str, int i2) {
    }

    public static final /* synthetic */ a[] a() {
        return new a[]{f2095a, b, c, d, e, f, g};
    }

    public static EnumEntries<a> b() {
        return i;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) h.clone();
    }
}
