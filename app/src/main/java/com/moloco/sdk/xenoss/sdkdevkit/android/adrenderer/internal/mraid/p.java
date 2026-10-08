package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes6.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2589a;
    public static final p b = new p("Portrait", 0);
    public static final p c = new p("Landscape", 1);
    public static final p d = new p("None", 2);
    public static final /* synthetic */ p[] e;
    public static final /* synthetic */ EnumEntries f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final p a(String str) {
            if (str != null) {
                int iHashCode = str.hashCode();
                if (iHashCode != 3387192) {
                    if (iHashCode != 729267099) {
                        if (iHashCode == 1430647483 && str.equals("landscape")) {
                            return p.c;
                        }
                    } else if (str.equals("portrait")) {
                        return p.b;
                    }
                } else if (str.equals("none")) {
                    return p.d;
                }
            }
            return null;
        }

        public a() {
        }
    }

    static {
        p[] pVarArrA = a();
        e = pVarArrA;
        f = EnumEntriesKt.enumEntries(pVarArrA);
        f2589a = new a(null);
    }

    public p(String str, int i) {
    }

    public static final /* synthetic */ p[] a() {
        return new p[]{b, c, d};
    }

    public static EnumEntries<p> b() {
        return f;
    }

    public static p valueOf(String str) {
        return (p) Enum.valueOf(p.class, str);
    }

    public static p[] values() {
        return (p[]) e.clone();
    }
}
