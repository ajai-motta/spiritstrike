package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.audio.WavUtil;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1280Hl {
    public static int A00(int i, int i2) {
        switch (i) {
            case 1:
            case WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE /* 65534 */:
                return C5C.A03(i2);
            case 3:
                return i2 == 32 ? 4 : 0;
            default:
                return 0;
        }
    }
}
