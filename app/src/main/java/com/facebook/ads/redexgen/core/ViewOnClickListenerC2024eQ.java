package com.facebook.ads.redexgen.core;

import android.view.View;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC2024eQ implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ C2026eS A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 62);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.EM, Ascii.SYN, Ascii.DC2, Ascii.NAK, Ascii.SYN, 35};
    }

    public ViewOnClickListenerC2024eQ(C2026eS c2026eS) {
        this.A00 = c2026eS;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            if (this.A00.A0l == null) {
                return;
            }
            this.A00.A0l.A0E(A00(0, 6, 115));
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
