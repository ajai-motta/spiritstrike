package com.applovin.impl;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f552a = new a("Age Restricted User", a5.r);
    private static final a b = new a("Has User Consent", a5.q);
    private static final a c = new a("\"Do Not Sell\"", a5.s);

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f553a;
        private final a5 b;

        a(String str, a5 a5Var) {
            this.f553a = str;
            this.b = a5Var;
        }

        public Boolean b(Context context) {
            if (context != null) {
                return (Boolean) b5.a(this.b, (Object) null, context);
            }
            com.applovin.impl.sdk.o.h("AppLovinSdk", "Failed to get value for key: " + this.b);
            return null;
        }

        public String a() {
            return this.f553a;
        }

        public String a(Context context) {
            Boolean boolB = b(context);
            return boolB != null ? boolB.toString() : "No value set";
        }
    }

    public static a a() {
        return c;
    }

    public static a b() {
        return b;
    }

    public static a c() {
        return f552a;
    }

    public static boolean a(boolean z, Context context) {
        return a(a5.s, Boolean.valueOf(z), context);
    }

    public static boolean b(boolean z, Context context) {
        return a(a5.q, Boolean.valueOf(z), context);
    }

    public static String a(Context context) {
        return a(b, context) + a(c, context);
    }

    private static boolean a(a5 a5Var, Boolean bool, Context context) {
        if (context == null) {
            com.applovin.impl.sdk.o.h("AppLovinSdk", "Failed to update compliance value for key: " + a5Var);
            return false;
        }
        try {
            Boolean bool2 = (Boolean) b5.a(a5Var, (Object) null, context);
            b5.b(a5Var, bool, context);
            return bool2 == null || bool2 != bool;
        } catch (Throwable th) {
            com.applovin.impl.sdk.o.c("ComplianceManager", "Unable to update compliance", th);
            com.applovin.impl.sdk.k kVar = com.applovin.impl.sdk.k.D0;
            if (kVar != null) {
                kVar.D().a("ComplianceManager", "updateCompliance", th);
            }
            return false;
        }
    }

    private static String a(a aVar, Context context) {
        return "\n" + aVar.f553a + " - " + aVar.a(context);
    }
}
