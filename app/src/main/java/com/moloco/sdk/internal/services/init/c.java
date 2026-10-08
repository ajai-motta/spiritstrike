package com.moloco.sdk.internal.services.init;

import com.moloco.sdk.Init;
import com.moloco.sdk.internal.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class c {
    public static final int c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v<Init.SDKInitResponse, j> f2361a;
    public final String b;

    public c(v<Init.SDKInitResponse, j> sdkInitResult, String fetchType) {
        Intrinsics.checkNotNullParameter(sdkInitResult, "sdkInitResult");
        Intrinsics.checkNotNullParameter(fetchType, "fetchType");
        this.f2361a = sdkInitResult;
        this.b = fetchType;
    }

    public final v<Init.SDKInitResponse, j> a() {
        return this.f2361a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.b;
    }

    public final v<Init.SDKInitResponse, j> d() {
        return this.f2361a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual(this.f2361a, cVar.f2361a) && Intrinsics.areEqual(this.b, cVar.b);
    }

    public int hashCode() {
        return (this.f2361a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "FetchState(sdkInitResult=" + this.f2361a + ", fetchType=" + this.b + ')';
    }

    public final c a(v<Init.SDKInitResponse, j> sdkInitResult, String fetchType) {
        Intrinsics.checkNotNullParameter(sdkInitResult, "sdkInitResult");
        Intrinsics.checkNotNullParameter(fetchType, "fetchType");
        return new c(sdkInitResult, fetchType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ c a(c cVar, v vVar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            vVar = cVar.f2361a;
        }
        if ((i & 2) != 0) {
            str = cVar.b;
        }
        return cVar.a(vVar, str);
    }
}
