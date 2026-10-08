package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1637Vm {
    public final AdErrorType A00;
    public final String A01;

    public C1637Vm(int i, String str) {
        this(AdErrorType.adErrorTypeFromCode(i), str);
    }

    public C1637Vm(AdErrorType adErrorType, String str) {
        str = TextUtils.isEmpty(str) ? adErrorType.getDefaultErrorMessage() : str;
        this.A00 = adErrorType;
        this.A01 = str;
    }

    public static C1637Vm A00(AdErrorType adErrorType) {
        return new C1637Vm(adErrorType, (String) null);
    }

    public static C1637Vm A01(AdErrorType adErrorType, String str) {
        return new C1637Vm(adErrorType, str);
    }

    public static C1637Vm A02(C1638Vn c1638Vn) {
        return new C1637Vm(c1638Vn.A00(), c1638Vn.A01());
    }

    public final AdErrorType A03() {
        return this.A00;
    }

    public final String A04() {
        return this.A01;
    }
}
