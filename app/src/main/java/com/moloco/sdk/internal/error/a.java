package com.moloco.sdk.internal.error;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static final int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2047a;

    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final String a() {
        return this.f2047a;
    }

    public final String b() {
        return this.f2047a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && Intrinsics.areEqual(this.f2047a, ((a) obj).f2047a);
    }

    public int hashCode() {
        String str = this.f2047a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "ErrorMetadata(mtid=" + this.f2047a + ')';
    }

    public a(String str) {
        this.f2047a = str;
    }

    public final a a(String str) {
        return new a(str);
    }

    public /* synthetic */ a(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public static /* synthetic */ a a(a aVar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aVar.f2047a;
        }
        return aVar.a(str);
    }
}
