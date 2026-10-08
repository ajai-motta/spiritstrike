package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhop implements zzhfv {
    private static final zzhop zza = new zzhop();
    private static final zzhfp zzb = zzhfp.zzd(zzhom.zza, zzhei.class, zzgwm.class);

    static void zzc() throws GeneralSecurityException {
        zzhey.zza().zzc(zza);
        zzhey.zza().zzb(zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzhfv
    public final Class zza() {
        return zzgwm.class;
    }

    @Override // com.google.android.gms.internal.ads.zzhfv
    public final Class zzb() {
        return zzgwm.class;
    }

    @Override // com.google.android.gms.internal.ads.zzhfv
    public final /* bridge */ /* synthetic */ Object zze(zzhed zzhedVar, zzhel zzhelVar, zzhfu zzhfuVar) throws GeneralSecurityException {
        zzhsz zzhszVarZzd;
        zzhfk zzhfkVar = new zzhfk();
        for (int i = 0; i < zzhedVar.zzd(); i++) {
            zzgwc zzgwcVarZze = ((zzgwe) zzhedVar).zze(i);
            if (zzgwcVarZze.zzb().equals(zzgvv.zza)) {
                zzgwm zzgwmVar = (zzgwm) zzhfuVar.zza(zzgwcVarZze);
                zzgvt zzgvtVarZza = zzgwcVarZze.zza();
                if (zzgvtVarZza instanceof zzhpr) {
                    zzhszVarZzd = ((zzhpr) zzgvtVarZza).zze();
                } else {
                    if (!(zzgvtVarZza instanceof zzhei)) {
                        String name = zzgvtVarZza.getClass().getName();
                        String strValueOf = String.valueOf(zzgvtVarZza.zza());
                        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 59 + String.valueOf(strValueOf).length());
                        sb.append("Cannot get output prefix for key of class ");
                        sb.append(name);
                        sb.append(" with parameters ");
                        sb.append(strValueOf);
                        throw new GeneralSecurityException(sb.toString());
                    }
                    zzhszVarZzd = ((zzhei) zzgvtVarZza).zzd();
                }
                zzhfkVar.zza(zzhszVarZzd, new zzhon(zzgwmVar, zzgwcVarZze.zzc()));
            }
        }
        return new zzhoo(zzhfkVar.zzb(), !zzhelVar.zza() ? zzhew.zza().zzb().zza(zzhedVar, zzhelVar, "public_key_verify", "verify") : zzhep.zza);
    }
}
