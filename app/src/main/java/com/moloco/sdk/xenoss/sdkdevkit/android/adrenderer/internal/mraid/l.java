package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes6.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f2585a = new l("SkipOrClose", 0);
    public static final l b = new l(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.y, 1);
    public static final /* synthetic */ l[] c;
    public static final /* synthetic */ EnumEntries d;

    static {
        l[] lVarArrA = a();
        c = lVarArrA;
        d = EnumEntriesKt.enumEntries(lVarArrA);
    }

    public l(String str, int i) {
    }

    public static final /* synthetic */ l[] a() {
        return new l[]{f2585a, b};
    }

    public static EnumEntries<l> b() {
        return d;
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) c.clone();
    }
}
