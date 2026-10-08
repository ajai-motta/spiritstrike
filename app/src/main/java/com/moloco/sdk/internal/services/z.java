package com.moloco.sdk.internal.services;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes6.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f2402a = new z("SILENT", 0);
    public static final z b = new z("VIBRATE", 1);
    public static final z c = new z("NORMAL", 2);
    public static final /* synthetic */ z[] d;
    public static final /* synthetic */ EnumEntries e;

    static {
        z[] zVarArrA = a();
        d = zVarArrA;
        e = EnumEntriesKt.enumEntries(zVarArrA);
    }

    public z(String str, int i) {
    }

    public static final /* synthetic */ z[] a() {
        return new z[]{f2402a, b, c};
    }

    public static EnumEntries<z> b() {
        return e;
    }

    public static z valueOf(String str) {
        return (z) Enum.valueOf(z.class, str);
    }

    public static z[] values() {
        return (z[]) d.clone();
    }
}
