package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhii extends zzhil {
    private final zzhij zza;
    private final zzhtb zzb;

    private zzhii(zzhij zzhijVar, zzhtb zzhtbVar) {
        this.zza = zzhijVar;
        this.zzb = zzhtbVar;
    }

    public static zzhii zzc(zzhij zzhijVar, zzhtb zzhtbVar) throws GeneralSecurityException {
        if (zzhijVar.zzc() == zzhtbVar.zzd()) {
            return new zzhii(zzhijVar, zzhtbVar);
        }
        throw new GeneralSecurityException("Key size mismatch");
    }

    @Override // com.google.android.gms.internal.ads.zzhil, com.google.android.gms.internal.ads.zzgvt
    public final /* synthetic */ zzgwj zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgvt
    @Nullable
    public final Integer zzb() {
        throw null;
    }

    public final zzhtb zzd() {
        return this.zzb;
    }
}
