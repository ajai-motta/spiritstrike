package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhgu implements zzhfv {
    private static final zzhgu zza = new zzhgu();

    private zzhgu() {
    }

    static void zzc() throws GeneralSecurityException {
        zzhey.zza().zzc(zza);
    }

    @Override // com.google.android.gms.internal.ads.zzhfv
    public final Class zza() {
        return zzhgs.class;
    }

    @Override // com.google.android.gms.internal.ads.zzhfv
    public final Class zzb() {
        return zzhgs.class;
    }

    @Override // com.google.android.gms.internal.ads.zzhfv
    public final /* bridge */ /* synthetic */ Object zze(zzhed zzhedVar, zzhel zzhelVar, zzhfu zzhfuVar) throws GeneralSecurityException {
        zzhsz zzhszVarZzd;
        zzgwe zzgweVar = (zzgwe) zzhedVar;
        zzgwc zzgwcVarZzc = zzgweVar.zzc();
        zzhfk zzhfkVar = new zzhfk();
        for (int i = 0; i < zzhedVar.zzd(); i++) {
            zzgwc zzgwcVarZze = zzgweVar.zze(i);
            if (zzgwcVarZze.zzb().equals(zzgvv.zza)) {
                zzhgs zzhgsVar = (zzhgs) zzhfuVar.zza(zzgwcVarZze);
                zzgvt zzgvtVarZza = zzgwcVarZze.zza();
                if (zzgvtVarZza instanceof zzhhh) {
                    zzhszVarZzd = ((zzhhh) zzgvtVarZza).zze();
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
                zzhfkVar.zza(zzhszVarZzd, zzhgsVar);
            }
        }
        return new zzhgt(zzhfkVar.zzb(), (zzhgs) zzhfuVar.zza(zzgwcVarZzc), null);
    }
}
