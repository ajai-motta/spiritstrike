package com.facebook.ads.redexgen.core;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2610oQ implements InterfaceC09353k {
    public boolean A04;
    public ByteBuffer A02 = InterfaceC09353k.A00;
    public ByteBuffer A03 = InterfaceC09353k.A00;
    public C09333i A00 = C09333i.A05;
    public C09333i A01 = C09333i.A05;
    public C09333i A05 = C09333i.A05;
    public C09333i A06 = C09333i.A05;

    public abstract C09333i A09(C09333i c09333i) throws C09343j;

    public final ByteBuffer A00(int i) {
        if (this.A02.capacity() < i) {
            this.A02 = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.A02.clear();
        }
        this.A03 = this.A02;
        return this.A02;
    }

    public final boolean A01() {
        return this.A03.hasRemaining();
    }

    public void A0A() {
    }

    public void A0B() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC09353k
    public final C09333i A57(C09333i c09333i) throws C09343j {
        this.A00 = c09333i;
        this.A01 = A09(c09333i);
        return AAL() ? this.A01 : C09333i.A05;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC09353k
    public ByteBuffer A8d() {
        ByteBuffer byteBuffer = this.A03;
        ByteBuffer outputBuffer = InterfaceC09353k.A00;
        this.A03 = outputBuffer;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC09353k
    public boolean AAL() {
        return this.A01 != C09333i.A05;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC09353k
    public boolean AAP() {
        return this.A04 && this.A03 == InterfaceC09353k.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC09353k
    public final void AHG() {
        this.A04 = true;
        A0B();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC09353k
    public final void flush() {
        this.A03 = InterfaceC09353k.A00;
        this.A04 = false;
        this.A05 = this.A00;
        this.A06 = this.A01;
        A0A();
    }
}
