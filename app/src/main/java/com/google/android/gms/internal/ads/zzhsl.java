package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhsl implements zzhik {
    final zzhik zza;
    final zzhik zzb;

    /* synthetic */ zzhsl(zzhik zzhikVar, zzhik zzhikVar2, byte[] bArr) {
        this.zza = zzhikVar;
        this.zzb = zzhikVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhik
    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        return bArr.length <= 64 ? this.zza.zza(bArr, i) : this.zzb.zza(bArr, i);
    }
}
