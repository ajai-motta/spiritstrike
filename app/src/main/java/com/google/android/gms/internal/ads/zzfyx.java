package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfyx implements zzfyr {
    private final int zza;
    private final byte[] zzb;

    zzfyx(int i, byte[] bArr) {
        this.zza = i;
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzfyr
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfyr
    public final String zzb() throws IOException {
        return new String(this.zzb);
    }
}
