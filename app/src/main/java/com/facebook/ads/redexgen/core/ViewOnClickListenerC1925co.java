package com.facebook.ads.redexgen.core;

import android.view.View;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.co, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1925co implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ C1328Ji A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 64);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.ETB, 19, Ascii.US, Ascii.EM, Ascii.ESC};
    }

    public ViewOnClickListenerC1925co(C1328Ji c1328Ji) {
        this.A00 = c1328Ji;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A0p(A00(0, 5, 62));
            if (this.A00.A0b.A0D() != null) {
                this.A00.A0b.A0D().ACQ();
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
