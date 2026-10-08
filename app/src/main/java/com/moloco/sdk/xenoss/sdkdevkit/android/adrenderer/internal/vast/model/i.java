package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes6.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f2827a = new i("Image", 0);
    public static final i b = new i("JS", 1);
    public static final /* synthetic */ i[] c;
    public static final /* synthetic */ EnumEntries d;

    static {
        i[] iVarArrA = a();
        c = iVarArrA;
        d = EnumEntriesKt.enumEntries(iVarArrA);
    }

    public i(String str, int i) {
    }

    public static final /* synthetic */ i[] a() {
        return new i[]{f2827a, b};
    }

    public static EnumEntries<i> b() {
        return d;
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) c.clone();
    }
}
