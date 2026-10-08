package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes6.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f2440a = new i("VAST", 0);
    public static final i b = new i("MRAID", 1);
    public static final i c = new i("STATIC", 2);
    public static final /* synthetic */ i[] d;
    public static final /* synthetic */ EnumEntries e;

    static {
        i[] iVarArrA = a();
        d = iVarArrA;
        e = EnumEntriesKt.enumEntries(iVarArrA);
    }

    public i(String str, int i) {
    }

    public static final /* synthetic */ i[] a() {
        return new i[]{f2440a, b, c};
    }

    public static EnumEntries<i> b() {
        return e;
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) d.clone();
    }
}
