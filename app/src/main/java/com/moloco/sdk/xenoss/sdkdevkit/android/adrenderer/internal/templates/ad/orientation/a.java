package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0452a f2627a;
    public static final a b = new a("Portrait", 0);
    public static final a c = new a("Landscape", 1);
    public static final a d = new a("None", 2);
    public static final /* synthetic */ a[] e;
    public static final /* synthetic */ EnumEntries f;

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.a$a, reason: collision with other inner class name */
    public static final class C0452a {
        public /* synthetic */ C0452a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a(String str) {
            if (str != null) {
                int iHashCode = str.hashCode();
                if (iHashCode != 3387192) {
                    if (iHashCode != 729267099) {
                        if (iHashCode == 1430647483 && str.equals("landscape")) {
                            return a.c;
                        }
                    } else if (str.equals("portrait")) {
                        return a.b;
                    }
                } else if (str.equals("none")) {
                    return a.d;
                }
            }
            return null;
        }

        public C0452a() {
        }
    }

    static {
        a[] aVarArrA = a();
        e = aVarArrA;
        f = EnumEntriesKt.enumEntries(aVarArrA);
        f2627a = new C0452a(null);
    }

    public a(String str, int i) {
    }

    public static final /* synthetic */ a[] a() {
        return new a[]{b, c, d};
    }

    public static EnumEntries<a> b() {
        return f;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) e.clone();
    }
}
