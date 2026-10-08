package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhhm implements zzhfv {
    private static final zzhhm zza = new zzhhm();
    private static final zzhfp zzb = zzhfp.zzd(zzhhj.zza, zzhei.class, zzgwi.class);

    zzhhm() {
    }

    static void zzc() throws GeneralSecurityException {
        zzhey.zza().zzc(zza);
        zzhey.zza().zzb(zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzhfv
    public final Class zza() {
        return zzgwi.class;
    }

    @Override // com.google.android.gms.internal.ads.zzhfv
    public final Class zzb() {
        return zzgwi.class;
    }

    @Override // com.google.android.gms.internal.ads.zzhfv
    public final /* bridge */ /* synthetic */ Object zze(zzhed zzhedVar, zzhel zzhelVar, zzhfu zzhfuVar) throws GeneralSecurityException {
        zzhem zzhemVar;
        zzhem zzhemVarZza;
        zzhsz zzhszVarZzd;
        zzhfk zzhfkVar = new zzhfk();
        for (int i = 0; i < zzhedVar.zzd(); i++) {
            zzgwc zzgwcVarZze = ((zzgwe) zzhedVar).zze(i);
            if (zzgwcVarZze.zzb().equals(zzgvv.zza)) {
                zzgwi zzgwiVar = (zzgwi) zzhfuVar.zza(zzgwcVarZze);
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
                zzhfkVar.zza(zzhszVarZzd, new zzhhk(zzgwiVar, zzgwcVarZze.zzc()));
            }
        }
        if (zzhelVar.zza()) {
            zzhemVar = zzhep.zza;
            zzhemVarZza = zzhemVar;
        } else {
            zzhen zzhenVarZzb = zzhew.zza().zzb();
            zzhem zzhemVarZza2 = zzhenVarZzb.zza(zzhedVar, zzhelVar, "mac", "compute");
            zzhemVarZza = zzhenVarZzb.zza(zzhedVar, zzhelVar, "mac", "verify");
            zzhemVar = zzhemVarZza2;
        }
        zzgwe zzgweVar = (zzgwe) zzhedVar;
        return new zzhhl(new zzhhk((zzgwi) zzhfuVar.zza(zzgweVar.zzc()), zzgweVar.zzc().zzc()), zzhfkVar.zzb(), zzhemVar, zzhemVarZza, null);
    }
}
