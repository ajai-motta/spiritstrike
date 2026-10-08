package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.i9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2251i9 implements InterfaceC1469Ou {
    private C1470Ov A00(InterfaceC1468Ot interfaceC1468Ot) {
        return (C1470Ov) interfaceC1468Ot.A7E();
    }

    public final void A01(InterfaceC1468Ot interfaceC1468Ot) {
        if (!interfaceC1468Ot.A9R()) {
            interfaceC1468Ot.AJl(0, 0, 0, 0);
            return;
        }
        float fA8S = A8S(interfaceC1468Ot);
        float fA8r = A8r(interfaceC1468Ot);
        float elevation = AbstractC1472Ox.A00(fA8S, fA8r, interfaceC1468Ot.A8q());
        int vPadding = (int) Math.ceil(elevation);
        float elevation2 = AbstractC1472Ox.A01(fA8S, fA8r, interfaceC1468Ot.A8q());
        int iCeil = (int) Math.ceil(elevation2);
        interfaceC1468Ot.AJl(vPadding, iCeil, vPadding, iCeil);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1469Ou
    public final ColorStateList A71(InterfaceC1468Ot interfaceC1468Ot) {
        return A00(interfaceC1468Ot).A05();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1469Ou
    public final float A7v(InterfaceC1468Ot interfaceC1468Ot) {
        return interfaceC1468Ot.A7F().getElevation();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1469Ou
    public final float A8S(InterfaceC1468Ot interfaceC1468Ot) {
        return A00(interfaceC1468Ot).A03();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1469Ou
    public final float A8X(InterfaceC1468Ot interfaceC1468Ot) {
        return A8r(interfaceC1468Ot) * 2.0f;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1469Ou
    public final float A8Y(InterfaceC1468Ot interfaceC1468Ot) {
        return A8r(interfaceC1468Ot) * 2.0f;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1469Ou
    public final float A8r(InterfaceC1468Ot interfaceC1468Ot) {
        return A00(interfaceC1468Ot).A04();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1469Ou
    public final void AAE() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1469Ou
    public final void AAG(InterfaceC1468Ot interfaceC1468Ot, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        C1470Ov background = new C1470Ov(colorStateList, f);
        interfaceC1468Ot.AJK(background);
        View view = interfaceC1468Ot.A7F();
        view.setClipToOutline(true);
        view.setElevation(f2);
        AJX(interfaceC1468Ot, f3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1469Ou
    public final void ADP(InterfaceC1468Ot interfaceC1468Ot) {
        AJX(interfaceC1468Ot, A8S(interfaceC1468Ot));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1469Ou
    public final void AFT(InterfaceC1468Ot interfaceC1468Ot) {
        AJX(interfaceC1468Ot, A8S(interfaceC1468Ot));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1469Ou
    public final void AJJ(InterfaceC1468Ot interfaceC1468Ot, ColorStateList colorStateList) {
        A00(interfaceC1468Ot).A08(colorStateList);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1469Ou
    public final void AJP(InterfaceC1468Ot interfaceC1468Ot, float f) {
        interfaceC1468Ot.A7F().setElevation(f);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1469Ou
    public final void AJX(InterfaceC1468Ot interfaceC1468Ot, float f) {
        A00(interfaceC1468Ot).A07(f, interfaceC1468Ot.A9R(), interfaceC1468Ot.A8q());
        A01(interfaceC1468Ot);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1469Ou
    public final void AJj(InterfaceC1468Ot interfaceC1468Ot, float f) {
        A00(interfaceC1468Ot).A06(f);
    }
}
