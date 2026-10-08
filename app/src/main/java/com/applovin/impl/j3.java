package com.applovin.impl;

import com.applovin.mediation.MaxAdFormat;

/* JADX INFO: loaded from: classes2.dex */
public class j3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f426a;
    private final MaxAdFormat b;

    public j3(String str, MaxAdFormat maxAdFormat) {
        this.f426a = str;
        this.b = maxAdFormat;
    }

    protected boolean a(Object obj) {
        return obj instanceof j3;
    }

    public String b() {
        return this.f426a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j3)) {
            return false;
        }
        j3 j3Var = (j3) obj;
        if (!j3Var.a(this)) {
            return false;
        }
        String strB = b();
        String strB2 = j3Var.b();
        if (strB != null ? !strB.equals(strB2) : strB2 != null) {
            return false;
        }
        MaxAdFormat maxAdFormatA = a();
        MaxAdFormat maxAdFormatA2 = j3Var.a();
        return maxAdFormatA != null ? maxAdFormatA.equals(maxAdFormatA2) : maxAdFormatA2 == null;
    }

    public int hashCode() {
        String strB = b();
        int iHashCode = strB == null ? 43 : strB.hashCode();
        MaxAdFormat maxAdFormatA = a();
        return ((iHashCode + 59) * 59) + (maxAdFormatA != null ? maxAdFormatA.hashCode() : 43);
    }

    public String toString() {
        return this.f426a + "-" + this.b.getLabel();
    }

    public MaxAdFormat a() {
        return this.b;
    }

    public static j3 a(String str) {
        String[] strArrSplit = str.split("-");
        return new j3(strArrSplit[0], MaxAdFormat.formatFromString(strArrSplit[1]));
    }
}
