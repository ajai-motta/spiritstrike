package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2675pT implements AnonymousClass24 {
    public final float A00;
    public final float A01;
    public final float A02;
    public final float A03;
    public final float A04;
    public final float A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final int A09;
    public final int A0A;
    public final int A0B;
    public final Bitmap A0C;
    public final Layout.Alignment A0D;
    public final Layout.Alignment A0E;
    public final CharSequence A0F;
    public final boolean A0G;
    public static String[] A0H = {"KUNE", "raA8kdJusqhSRQUihDErH9yYSlb7Q0pc", "a1YC1OeN6dpIjzX6IUyhBFBaZFiOBPar", "NtybfxE4AhM4u1v", "wsqusZh9gWXwGZdOs5jqqsOsuYO68ouK", "hrWhj8FC8bQIQnfwmhsxP3BdiVuQ0H3H", "RcL5HtL", "cuPzI7wmuuTc6v"};
    public static final C2675pT A0J = new C09393o().A0G("").A0H();
    public static final String A0U = C5C.A0h(0);
    public static final String A0V = C5C.A0h(1);
    public static final String A0P = C5C.A0h(2);
    public static final String A0K = C5C.A0h(3);
    public static final String A0M = C5C.A0h(4);
    public static final String A0O = C5C.A0h(5);
    public static final String A0N = C5C.A0h(6);
    public static final String A0Q = C5C.A0h(7);
    public static final String A0R = C5C.A0h(8);
    public static final String A0X = C5C.A0h(9);
    public static final String A0W = C5C.A0h(10);
    public static final String A0T = C5C.A0h(11);
    public static final String A0L = C5C.A0h(12);
    public static final String A0Z = C5C.A0h(13);
    public static final String A0a = C5C.A0h(14);
    public static final String A0Y = C5C.A0h(15);
    public static final String A0S = C5C.A0h(16);
    public static final AnonymousClass23<C2675pT> A0I = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.pV
        @Override // com.facebook.ads.redexgen.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            return C2675pT.A00(bundle);
        }
    };

    public C2675pT(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z, int i5, int i6, float f6) {
        if (charSequence == null) {
            AbstractC09493y.A01(bitmap);
        } else {
            AbstractC09493y.A07(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.A0F = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.A0F = charSequence.toString();
        } else {
            this.A0F = null;
        }
        this.A0E = alignment;
        this.A0D = alignment2;
        this.A0C = bitmap;
        this.A01 = f;
        this.A07 = i;
        this.A06 = i2;
        this.A02 = f2;
        this.A08 = i3;
        this.A04 = f4;
        this.A00 = f5;
        this.A0G = z;
        this.A0B = i5;
        this.A09 = i4;
        this.A05 = f3;
        this.A0A = i6;
        this.A03 = f6;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.facebook.ads.redexgen.core.C2675pT A00(android.os.Bundle r5) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2675pT.A00(android.os.Bundle):com.facebook.ads.redexgen.X.pT");
    }

    public final C09393o A02() {
        return new C09393o(this);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2675pT c2675pT = (C2675pT) obj;
        if (TextUtils.equals(this.A0F, c2675pT.A0F) && this.A0E == c2675pT.A0E && this.A0D == c2675pT.A0D && (this.A0C != null ? !(c2675pT.A0C == null || !this.A0C.sameAs(c2675pT.A0C)) : c2675pT.A0C == null) && this.A01 == c2675pT.A01 && this.A07 == c2675pT.A07 && this.A06 == c2675pT.A06) {
            float f = this.A02;
            if (A0H[4].charAt(16) == 'F') {
                throw new RuntimeException();
            }
            A0H[6] = "OaHYrPsvOOcaJ1wPKUjhJjBsa";
            if (f == c2675pT.A02 && this.A08 == c2675pT.A08 && this.A04 == c2675pT.A04 && this.A00 == c2675pT.A00 && this.A0G == c2675pT.A0G && this.A0B == c2675pT.A0B && this.A09 == c2675pT.A09 && this.A05 == c2675pT.A05 && this.A0A == c2675pT.A0A && this.A03 == c2675pT.A03) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return CB.A00(this.A0F, this.A0E, this.A0D, this.A0C, Float.valueOf(this.A01), Integer.valueOf(this.A07), Integer.valueOf(this.A06), Float.valueOf(this.A02), Integer.valueOf(this.A08), Float.valueOf(this.A04), Float.valueOf(this.A00), Boolean.valueOf(this.A0G), Integer.valueOf(this.A0B), Integer.valueOf(this.A09), Float.valueOf(this.A05), Integer.valueOf(this.A0A), Float.valueOf(this.A03));
    }
}
