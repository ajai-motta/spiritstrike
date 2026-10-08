package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhnm extends zzhpq {
    private final zzhns zza;
    private final zzhtb zzb;

    private zzhnm(zzhns zzhnsVar, zzhtb zzhtbVar) {
        this.zza = zzhnsVar;
        this.zzb = zzhtbVar;
    }

    public static zzhnm zzc(zzhns zzhnsVar, zzhtb zzhtbVar) throws GeneralSecurityException {
        if (zzhtbVar.zzd() == 32) {
            if (Arrays.equals(zzhnsVar.zzd().zzc(), zzhdj.zza(zzhdj.zzb(zzhtbVar.zzc(zzgvr.zza()))))) {
                return new zzhnm(zzhnsVar, zzhtbVar);
            }
            throw new GeneralSecurityException("Ed25519 keys mismatch");
        }
        int iZzd = zzhtbVar.zzd();
        StringBuilder sb = new StringBuilder(String.valueOf(iZzd).length() + 65);
        sb.append("Ed25519 key must be constructed with key of length 32 bytes, not ");
        sb.append(iZzd);
        throw new GeneralSecurityException(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzhpq, com.google.android.gms.internal.ads.zzgvt
    public final /* synthetic */ zzgwj zza() {
        return this.zza.zzf();
    }

    public final zzhnl zzd() {
        return this.zza.zzf();
    }

    public final zzhns zze() {
        return this.zza;
    }

    public final zzhtb zzf() {
        return this.zzb;
    }
}
