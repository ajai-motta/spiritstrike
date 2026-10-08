package com.fyber.inneractive.sdk.player.exoplayer2.decoder;

import android.media.MediaCodec;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f1280a;
    public int[] b;
    public int[] c;
    public final MediaCodec.CryptoInfo d;
    public final a e;

    public b() {
        int i = z.f1480a;
        MediaCodec.CryptoInfo cryptoInfo = i >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.d = cryptoInfo;
        this.e = i >= 24 ? new a(cryptoInfo) : null;
    }

    public final void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2) {
        this.b = iArr;
        this.c = iArr2;
        this.f1280a = bArr2;
        int i2 = z.f1480a;
        if (i2 >= 16) {
            MediaCodec.CryptoInfo cryptoInfo = this.d;
            cryptoInfo.numSubSamples = i;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr;
            cryptoInfo.iv = bArr2;
            cryptoInfo.mode = 1;
            if (i2 >= 24) {
                a.a(this.e);
            }
        }
    }
}
