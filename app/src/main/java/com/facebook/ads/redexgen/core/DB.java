package com.facebook.ads.redexgen.core;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class DB implements InterfaceC2079fK {
    public static byte[] A06;
    public ValueAnimator A00;
    public EnumC2078fJ A01 = EnumC2078fJ.A04;
    public final int A02;
    public final int A03;
    public final int A04;
    public final View A05;

    static {
        A05();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 16);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A06 = new byte[]{49, 32, Base64.padSymbol, 49, 6, 42, 41, 42, 55};
    }

    public DB(View view, int i, int i2, int i3) {
        this.A02 = i;
        this.A05 = view;
        this.A04 = i2;
        this.A03 = i3;
    }

    private void A06(int i, int i2) {
        this.A01 = i == this.A04 ? EnumC2078fJ.A03 : EnumC2078fJ.A05;
        this.A00 = ObjectAnimator.ofInt((TextView) this.A05, A04(0, 9, 85), i, i2);
        this.A00.setEvaluator(new ArgbEvaluator());
        this.A00.setDuration(this.A02);
        this.A00.addListener(new C2085fQ(this, i, i2));
        this.A00.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(int i, int i2, boolean z) {
        if (z) {
            A06(i, i2);
        } else {
            ((TextView) this.A05).setTextColor(i2);
            this.A01 = i2 == this.A03 ? EnumC2078fJ.A02 : EnumC2078fJ.A04;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2079fK
    public final void A4A(boolean z, boolean z2) {
        int endColor = z2 ? this.A03 : this.A04;
        int startColor = z2 ? this.A04 : this.A03;
        A07(endColor, startColor, z);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2079fK
    public final EnumC2078fJ A9B() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2079fK
    public final void cancel() {
        if (this.A00 != null) {
            this.A00.cancel();
        }
    }
}
