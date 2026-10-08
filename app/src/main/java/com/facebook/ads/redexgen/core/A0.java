package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.C;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class A0 extends AbstractC2610oQ {
    public static final int A00 = Float.floatToIntBits(Float.NaN);

    public static void A00(int i, ByteBuffer byteBuffer) {
        float pcm32BitFloat = (float) (((double) i) * 4.656612875245797E-10d);
        int floatBits = Float.floatToIntBits(pcm32BitFloat);
        if (floatBits == A00) {
            floatBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatBits);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2610oQ
    public final C09333i A09(C09333i c09333i) throws C09343j {
        int i = c09333i.A02;
        if (C5C.A14(i)) {
            if (i != 4) {
                return new C09333i(c09333i.A03, c09333i.A01, 4);
            }
            return C09333i.A05;
        }
        throw new C09343j(c09333i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC09353k
    public final void AHH(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferA00;
        int i = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int limit = iLimit - i;
        int position = this.A05.A02;
        switch (position) {
            case 536870912:
                int position2 = limit / 3;
                byteBufferA00 = A00(position2 * 4);
                while (i < iLimit) {
                    int position3 = byteBuffer.get(i);
                    int limit2 = (position3 & 255) << 8;
                    int position4 = i + 1;
                    int limit3 = limit2 | ((byteBuffer.get(position4) & 255) << 16);
                    int position5 = i + 2;
                    A00(limit3 | ((byteBuffer.get(position5) & 255) << 24), byteBufferA00);
                    i += 3;
                }
                break;
            case C.ENCODING_PCM_32BIT /* 805306368 */:
                byteBufferA00 = A00(limit);
                while (i < iLimit) {
                    int position6 = byteBuffer.get(i);
                    int limit4 = position6 & 255;
                    int position7 = i + 1;
                    int limit5 = limit4 | ((byteBuffer.get(position7) & 255) << 8);
                    int position8 = i + 2;
                    int limit6 = limit5 | ((byteBuffer.get(position8) & 255) << 16);
                    int position9 = i + 3;
                    A00(limit6 | ((byteBuffer.get(position9) & 255) << 24), byteBufferA00);
                    i += 4;
                }
                break;
            default:
                throw new IllegalStateException();
        }
        int position10 = byteBuffer.limit();
        byteBuffer.position(position10);
        byteBufferA00.flip();
    }
}
