package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2424lC extends H2 {
    public C2424lC(AnonymousClass53 anonymousClass53, long j, long j2) {
        super(new C2522mz(), new C2425lD(anonymousClass53), j, 0L, j + 1, 0L, j2, 188L, 1000);
    }

    public static int A00(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255);
    }
}
