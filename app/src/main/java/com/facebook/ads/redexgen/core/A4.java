package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class A4 implements InterfaceC09363l {
    public final C10929y A00;
    public final C2603oJ A01;
    public final InterfaceC09353k[] A02;

    public A4(InterfaceC09353k... interfaceC09353kArr) {
        this(interfaceC09353kArr, new C10929y(), new C2603oJ());
    }

    public A4(InterfaceC09353k[] interfaceC09353kArr, C10929y c10929y, C2603oJ c2603oJ) {
        this.A02 = new InterfaceC09353k[interfaceC09353kArr.length + 2];
        System.arraycopy(interfaceC09353kArr, 0, this.A02, 0, interfaceC09353kArr.length);
        this.A00 = c10929y;
        this.A01 = c2603oJ;
        this.A02[interfaceC09353kArr.length] = c10929y;
        this.A02[interfaceC09353kArr.length + 1] = c2603oJ;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC09363l
    public final C2704px A4F(C2704px c2704px) {
        this.A01.A02(c2704px.A01);
        this.A01.A01(c2704px.A00);
        return c2704px;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC09363l
    public final boolean A4G(boolean z) {
        this.A00.A0D(z);
        return z;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC09363l
    public final InterfaceC09353k[] A6z() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC09363l
    public final long A8U(long j) {
        return this.A01.A00(j);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC09363l
    public final long A98() {
        return this.A00.A0C();
    }
}
