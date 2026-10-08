package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2337jk extends N3 {
    public static byte[] A02;

    @Nullable
    public final C2335ji A00;
    public final VA A01;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 26);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{70, 69, 74, 74, 65, 86};
    }

    public C2337jk(C2165gi c2165gi, N4 n4, C2110fp c2110fp, VA va, C2335ji c2335ji) {
        super(c2165gi, n4, c2110fp);
        this.A01 = va;
        this.A00 = c2335ji;
    }

    @Override // com.facebook.ads.redexgen.core.N3
    public final void A08(Map<String, String> map) {
        if (this.A00 != null && !TextUtils.isEmpty(this.A00.A7O())) {
            this.A02.A0F().A3L();
            AbstractC1449Oa.A02(this.A00.A0a(), AbstractC1685Xm.A00(A01(0, 6, 62)));
            this.A01.ABJ(this.A00.A7O(), map);
            if (C1615Up.A1A(this.A02)) {
                String string = AdPlacementType.MEDIUM_RECTANGLE.toString();
                C1661Wl c1661WlA00 = C1661Wl.A00(this.A02);
                String placementType = this.A00.A7O();
                c1661WlA00.A0E(string, placementType);
            }
        }
    }
}
