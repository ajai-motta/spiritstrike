package com.applovin.impl;

import com.applovin.mediation.MaxError;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class d5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e5 f355a;
    private final String b;
    private final String c;
    private final String d;
    private final MaxError e;
    private final long f;
    private final long g;
    private final boolean h;

    public interface a {
        void a(d5 d5Var);
    }

    private d5(e5 e5Var, com.applovin.impl.mediation.h hVar, String str, MaxError maxError, long j, long j2) {
        this(e5Var, str, maxError, j, j2, hVar != null ? hVar.i() : null, hVar != null ? hVar.b() : null, false);
    }

    public static d5 a(e5 e5Var, com.applovin.impl.mediation.h hVar, String str, long j, long j2) {
        if (e5Var == null) {
            throw new IllegalArgumentException("No spec specified");
        }
        if (hVar != null) {
            return new d5(e5Var, hVar, str, null, j, j2);
        }
        throw new IllegalArgumentException("No adapterWrapper specified");
    }

    public long b() {
        return this.g;
    }

    public MaxError c() {
        return this.e;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.d;
    }

    public e5 f() {
        return this.f355a;
    }

    public boolean g() {
        return this.h;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SignalCollectionResult{mSignalProviderSpec=");
        sb.append(this.f355a);
        sb.append(", mSdkVersion='");
        sb.append(this.b);
        sb.append("', mAdapterVersion='");
        sb.append(this.c);
        sb.append("', mSignalDataLength='");
        String str = this.d;
        sb.append(str != null ? str.length() : 0);
        sb.append("', mErrorMessage=");
        MaxError maxError = this.e;
        sb.append(maxError != null ? maxError.getMessage() : "");
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    private d5(e5 e5Var, String str, MaxError maxError, long j, long j2, String str2, String str3, boolean z) {
        this.f355a = e5Var;
        this.d = str;
        this.e = maxError;
        this.f = j;
        this.g = j2;
        this.b = str2;
        this.c = str3;
        this.h = z;
    }

    public static d5 a(e5 e5Var, MaxError maxError) {
        return a(e5Var, (com.applovin.impl.mediation.h) null, maxError, -1L, -1L);
    }

    public static d5 a(e5 e5Var, com.applovin.impl.mediation.h hVar, MaxError maxError, long j, long j2) {
        if (e5Var != null) {
            return new d5(e5Var, hVar, null, maxError, j, j2);
        }
        throw new IllegalArgumentException("No spec specified");
    }

    public static d5 a(d5 d5Var) {
        return new d5(d5Var.f(), d5Var.e(), d5Var.c(), d5Var.f, d5Var.g, d5Var.d(), d5Var.a(), true);
    }

    public String a() {
        return this.c;
    }
}
