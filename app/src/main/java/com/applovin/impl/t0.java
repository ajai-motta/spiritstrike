package com.applovin.impl;

import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v0;

/* JADX INFO: loaded from: classes2.dex */
public class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f675a = new StringBuilder();

    public void a(v0 v0Var, long j) {
        if (v0Var.d() == v0.b.DECISION) {
            return;
        }
        a(a(v0Var), j);
    }

    public void b() {
        a("Invalid Activity");
    }

    public String toString() {
        return this.f675a.toString();
    }

    public void b(String str) {
        a("Invalid state: " + str);
    }

    public void a(v0 v0Var, boolean z, long j) {
        a(a(v0Var) + ": " + z, j);
    }

    public void a() {
        this.f675a.setLength(0);
    }

    private void a(String str, long j) {
        a(str + " after " + j + "ms");
    }

    private void a(String str) {
        StringBuilder sb = this.f675a;
        sb.append(str);
        sb.append("\n");
    }

    private String a(v0 v0Var) {
        v0.b bVarD = v0Var.d();
        if (bVarD == v0.b.EVENT) {
            return ((y0) v0Var).g();
        }
        if (bVarD == v0.b.DECISION) {
            return StringUtils.emptyIfNull(v0Var.b());
        }
        return StringUtils.emptyIfNull(v0Var.e());
    }
}
