package com.applovin.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class u2 implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f685a;
    private final String b;
    private final boolean c;
    private final e3 d;

    u2(String str, String str2, boolean z, e3 e3Var) {
        this.f685a = str;
        this.b = str2;
        this.c = z;
        this.d = e3Var;
    }

    public String a() {
        return this.b;
    }

    public List b() {
        List listL = this.d.l();
        return (listL == null || listL.isEmpty()) ? Collections.singletonList(this.f685a) : listL;
    }

    public String c() {
        return this.f685a;
    }

    public e3 d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        u2 u2Var = (u2) obj;
        String str = this.f685a;
        if (str == null ? u2Var.f685a != null : !str.equals(u2Var.f685a)) {
            return false;
        }
        String str2 = this.b;
        if (str2 == null ? u2Var.b == null : str2.equals(u2Var.b)) {
            return this.c == u2Var.c;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f685a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + (this.c ? 1 : 0);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(u2 u2Var) {
        return this.b.compareToIgnoreCase(u2Var.b);
    }
}
