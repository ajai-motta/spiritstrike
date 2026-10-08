package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhfx implements zzhgb {
    private final zzhsz zza;
    private final zzhla zzb;

    private zzhfx(zzhla zzhlaVar, zzhsz zzhszVar) {
        this.zzb = zzhlaVar;
        this.zza = zzhszVar;
    }

    public static zzhfx zza(zzhla zzhlaVar) {
        return new zzhfx(zzhlaVar, zzhgi.zza(zzhlaVar.zza()));
    }

    public static zzhfx zzb(zzhla zzhlaVar) throws GeneralSecurityException {
        return new zzhfx(zzhlaVar, zzhgi.zzb(zzhlaVar.zza()));
    }

    public final zzhla zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhgb
    public final zzhsz zzf() {
        return this.zza;
    }
}
