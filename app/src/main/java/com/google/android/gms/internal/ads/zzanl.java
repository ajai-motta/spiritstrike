package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzanl extends zzacm {
    public zzanl(zzem zzemVar, long j, long j2) {
        super(new zzach(), new zzank(zzemVar, null), j, 0L, j + 1, 0L, j2, 188L, 1000);
    }

    static /* synthetic */ int zzh(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }
}
