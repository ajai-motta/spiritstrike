package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends l {
    public static final int o = z.a("Opus");
    public static final byte[] p = {79, 112, 117, 115, 72, 101, 97, 100};
    public boolean n;

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.l
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            this.n = false;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.l
    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        int i;
        byte[] bArr = nVar.f1472a;
        byte b = bArr[0];
        int i2 = b & 255;
        int i3 = b & 3;
        if (i3 != 0) {
            i = 2;
            if (i3 != 1 && i3 != 2) {
                i = bArr[1] & 63;
            }
        } else {
            i = 1;
        }
        int i4 = i2 >> 3;
        int i5 = i4 & 3;
        return (((long) this.i) * ((long) (i * (i4 >= 16 ? 2500 << i5 : i4 >= 12 ? 10000 << (i4 & 1) : i5 == 3 ? 60000 : 10000 << i5)))) / 1000000;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.l
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, long j, j jVar) {
        if (!this.n) {
            byte[] bArrCopyOf = Arrays.copyOf(nVar.f1472a, nVar.c);
            int i = bArrCopyOf[9] & 255;
            int i2 = ((bArrCopyOf[11] & 255) << 8) | (bArrCopyOf[10] & 255);
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(bArrCopyOf);
            arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) i2) * C.NANOS_PER_SECOND) / 48000).array());
            arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) 3840) * C.NANOS_PER_SECOND) / 48000).array());
            jVar.f1349a = com.fyber.inneractive.sdk.player.exoplayer2.o.a(null, MimeTypes.AUDIO_OPUS, -1, -1, i, OpusUtil.SAMPLE_RATE, arrayList, null, null);
            this.n = true;
            return true;
        }
        boolean z = nVar.b() == o;
        nVar.e(0);
        return z;
    }
}
