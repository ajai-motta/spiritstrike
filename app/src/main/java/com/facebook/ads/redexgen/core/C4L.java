package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4L, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C4L extends EF {
    public static String[] A0F = {"r3hDWnB1R9y4pEiKAURNp99h2b", "kj3t6dP2tWSOfb61zMSBvgjhGLqlygll", "", "sX8uIgx32JWe8q5WuLHBMtkPG7d", "ZlH8xHdCAMZsgB23qoj", "6lejLSjHGD", "XsRzuVWfX96s5Dei3zwO9zjz9s6FXTfu", "pCK0u"};
    public int A00;
    public C2039eg A01;
    public boolean A02;
    public final UN<C4K> A03;
    public final UN<C4B> A04;
    public final UN<E3> A05;
    public final UN<C4A> A06;
    public final UN<C1190Dy> A07;
    public final UN<C1188Dw> A08;
    public final UN<C1187Dv> A09;
    public final UN<C1182Dq> A0A;
    public final UN<C1181Dp> A0B;
    public final C1202Ek A0C;
    public final E0 A0D;
    public final AbstractC1183Dr A0E;

    public C4L(C2165gi c2165gi, VA va, C1202Ek c1202Ek, String str) {
        this(c2165gi, va, c1202Ek, str, 0, 0, false, null, null);
    }

    public C4L(C2165gi c2165gi, VA va, C1202Ek c1202Ek, String str, int i, int i2, boolean z, Bundle bundle, Map<String, String> map) {
        super(c2165gi, va, c1202Ek, str, !c1202Ek.A0m(), i, i2, z, bundle, map, new EE(c2165gi, c1202Ek));
        this.A0E = new AbstractC1183Dr() { // from class: com.facebook.ads.redexgen.X.4M
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.core.UN
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C1184Ds c1184Ds) {
                this.A00.A0f();
            }
        };
        this.A08 = new EQ(this);
        this.A04 = new EO(this);
        this.A05 = new EN(this);
        this.A06 = new EM(this);
        this.A03 = new EL(this);
        this.A07 = new EK(this);
        this.A0A = new EJ(this);
        this.A0B = new EI(this);
        this.A09 = new C1195Ed(this);
        this.A0D = new E0() { // from class: com.facebook.ads.redexgen.X.4N
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.core.UN
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(E1 e1) {
                this.A00.A00 = this.A00.A0C.getDuration();
            }
        };
        this.A02 = false;
        this.A0C = c1202Ek;
        this.A0C.getEventBus().A03(this.A0E, this.A06, this.A08, this.A05, this.A04, this.A03, this.A07, this.A0A, this.A0B, this.A0D, this.A09);
        if (C1615Up.A2u(c2165gi)) {
            this.A01 = new C2039eg(c1202Ek, str, z, null);
        }
    }

    public C4L(C2165gi c2165gi, VA va, C1202Ek c1202Ek, String str, Bundle bundle, Map<String, String> extraParams) {
        this(c2165gi, va, c1202Ek, str, 0, 0, false, bundle, extraParams);
    }

    @Override // com.facebook.ads.redexgen.core.EF
    public final void A0n(EnumC2043ek enumC2043ek, Map<String, String> map) {
        super.A0n(enumC2043ek, map);
        if (this.A01 != null && enumC2043ek == EnumC2043ek.A09) {
            Map<String, String> params = this.A01.A06();
            String[] strArr = A0F;
            if (strArr[0].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            A0F[2] = "tc9";
            map.putAll(params);
        }
    }

    public final void A0p() {
        ET et = new ET(this);
        if (this.A0C.A0q()) {
            Y4.A00(et);
            return;
        }
        C1202Ek c1202Ek = this.A0C;
        String[] strArr = A0F;
        if (strArr[4].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        A0F[1] = "nFCp2DExxe9bklz52WjNRol8ULAuMoj6";
        c1202Ek.getStateHandler().post(et);
    }
}
