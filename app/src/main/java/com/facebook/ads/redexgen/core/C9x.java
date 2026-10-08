package com.facebook.ads.redexgen.core;

import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9x, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C9x extends AbstractC2610oQ {
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public boolean A05;
    public byte[] A06 = C5C.A07;

    @Override // com.facebook.ads.redexgen.core.AbstractC2610oQ
    public final C09333i A09(C09333i c09333i) throws C09343j {
        if (c09333i.A02 == 2) {
            this.A05 = true;
            return (this.A03 == 0 && this.A02 == 0) ? C09333i.A05 : c09333i;
        }
        throw new C09343j(c09333i);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2610oQ
    public final void A0A() {
        if (this.A05) {
            this.A05 = false;
            this.A06 = new byte[this.A02 * super.A05.A00];
            this.A01 = this.A03 * super.A05.A00;
        }
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2610oQ
    public final void A0B() {
        if (this.A05) {
            if (this.A00 > 0) {
                this.A04 += (long) (this.A00 / super.A05.A00);
            }
            this.A00 = 0;
        }
    }

    public final long A0C() {
        return this.A04;
    }

    public final void A0D() {
        this.A04 = 0L;
    }

    public final void A0E(int i, int i2) {
        this.A03 = i;
        this.A02 = i2;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2610oQ, com.facebook.ads.redexgen.core.InterfaceC09353k
    public final ByteBuffer A8d() {
        if (super.AAP() && this.A00 > 0) {
            A00(this.A00).put(this.A06, 0, this.A00).flip();
            this.A00 = 0;
        }
        return super.A8d();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2610oQ, com.facebook.ads.redexgen.core.InterfaceC09353k
    public final boolean AAP() {
        return super.AAP() && this.A00 == 0;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC09353k
    public final void AHH(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int remaining = byteBuffer.limit();
        int i = remaining - iPosition;
        if (i == 0) {
            return;
        }
        int position = this.A01;
        int iMin = Math.min(i, position);
        long j = this.A04;
        int position2 = super.A05.A00;
        this.A04 = j + ((long) (iMin / position2));
        int position3 = this.A01;
        this.A01 = position3 - iMin;
        byteBuffer.position(iPosition + iMin);
        int position4 = this.A01;
        if (position4 > 0) {
            return;
        }
        int endBufferBytesToOutput = i - iMin;
        int limit = this.A00;
        int position5 = this.A06.length;
        int limit2 = (limit + endBufferBytesToOutput) - position5;
        ByteBuffer buffer = A00(limit2);
        int position6 = this.A00;
        int trimBytes = C5C.A07(limit2, 0, position6);
        buffer.put(this.A06, 0, trimBytes);
        int limit3 = C5C.A07(limit2 - trimBytes, 0, endBufferBytesToOutput);
        int position7 = byteBuffer.position();
        byteBuffer.limit(position7 + limit3);
        buffer.put(byteBuffer);
        byteBuffer.limit(remaining);
        int endBufferBytesToOutput2 = endBufferBytesToOutput - limit3;
        int position8 = this.A00;
        this.A00 = position8 - trimBytes;
        byte[] bArr = this.A06;
        byte[] bArr2 = this.A06;
        int position9 = this.A00;
        System.arraycopy(bArr, trimBytes, bArr2, 0, position9);
        byte[] bArr3 = this.A06;
        int position10 = this.A00;
        byteBuffer.get(bArr3, position10, endBufferBytesToOutput2);
        int position11 = this.A00;
        this.A00 = position11 + endBufferBytesToOutput2;
        buffer.flip();
    }
}
