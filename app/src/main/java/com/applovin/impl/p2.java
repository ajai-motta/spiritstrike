package com.applovin.impl;

/* JADX INFO: loaded from: classes2.dex */
public class p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f554a;
    private String b;
    private int c;
    private int d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f555a;
        private String b;
        private int c;
        private int d;

        a() {
        }

        public p2 a() {
            return new p2(this.f555a, this.b, this.c, this.d);
        }

        public a b(int i) {
            this.c = i;
            return this;
        }

        public String toString() {
            return "LicenseVerificationObject.LicenseVerificationObjectBuilder(signedData=" + this.f555a + ", signature=" + this.b + ", responseCode=" + this.c + ", nonce=" + this.d + ")";
        }

        public a a(int i) {
            this.d = i;
            return this;
        }

        public a b(String str) {
            this.f555a = str;
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }
    }

    p2(String str, String str2, int i, int i2) {
        this.f554a = str;
        this.b = str2;
        this.c = i;
        this.d = i2;
    }

    protected boolean a(Object obj) {
        return obj instanceof p2;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.c;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.f554a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p2)) {
            return false;
        }
        p2 p2Var = (p2) obj;
        if (!p2Var.a(this) || c() != p2Var.c() || b() != p2Var.b()) {
            return false;
        }
        String strE = e();
        String strE2 = p2Var.e();
        if (strE != null ? !strE.equals(strE2) : strE2 != null) {
            return false;
        }
        String strD = d();
        String strD2 = p2Var.d();
        return strD != null ? strD.equals(strD2) : strD2 == null;
    }

    public int hashCode() {
        int iC = ((c() + 59) * 59) + b();
        String strE = e();
        int iHashCode = (iC * 59) + (strE == null ? 43 : strE.hashCode());
        String strD = d();
        return (iHashCode * 59) + (strD != null ? strD.hashCode() : 43);
    }

    public String toString() {
        return "LicenseVerificationObject(signedData=" + e() + ", signature=" + d() + ", responseCode=" + c() + ", nonce=" + b() + ")";
    }

    public static a a() {
        return new a();
    }
}
