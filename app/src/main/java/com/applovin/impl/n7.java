package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class n7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f525a;
    private String b;
    private final String c = a(a5.l);
    private final String d = a(a5.m);
    private String e = (String) b5.a(a5.n, (Object) null, com.applovin.impl.sdk.k.o());
    private String f = (String) b5.a(a5.o, (Object) null, com.applovin.impl.sdk.k.o());

    public n7(com.applovin.impl.sdk.k kVar) {
        this.f525a = kVar;
        a(f());
    }

    private String f() {
        if (!((Boolean) this.f525a.a(y4.P3)).booleanValue()) {
            this.f525a.c(a5.k);
        }
        String str = (String) this.f525a.a(a5.k);
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        this.f525a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f525a.O().a("AppLovinSdk", "Using identifier (" + str + ") from previous session");
        }
        return str;
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.f;
    }

    public String e() {
        return this.b;
    }

    private String a(a5 a5Var) {
        String str = (String) b5.a(a5Var, (Object) null, com.applovin.impl.sdk.k.o());
        if (StringUtils.isValidString(str)) {
            return str;
        }
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        b5.b(a5Var, lowerCase, com.applovin.impl.sdk.k.o());
        return lowerCase;
    }

    public void b(String str) {
        this.e = str;
        b5.b(a5.n, str, com.applovin.impl.sdk.k.o());
    }

    public void c(String str) {
        this.f = str;
        b5.b(a5.o, str, com.applovin.impl.sdk.k.o());
    }

    public void a(String str) {
        if (((Boolean) this.f525a.a(y4.P3)).booleanValue()) {
            this.f525a.b(a5.k, str);
        }
        this.b = str;
        this.f525a.t().b(str, a());
    }

    public static String a(com.applovin.impl.sdk.k kVar) {
        a5 a5Var = a5.p;
        String str = (String) kVar.a(a5Var);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String strValueOf = String.valueOf(((int) (Math.random() * 100.0d)) + 1);
        kVar.b(a5Var, strValueOf);
        return strValueOf;
    }
}
