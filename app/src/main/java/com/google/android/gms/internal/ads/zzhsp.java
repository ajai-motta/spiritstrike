package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhsp implements zzgwi {
    private static final byte[] zza = {0};
    private final zzhik zzb;
    private final int zzc;
    private final byte[] zzd;
    private final byte[] zze;

    private zzhsp(zzhgk zzhgkVar) throws GeneralSecurityException {
        this.zzb = zzhsm.zzb(zzhii.zzc(zzhij.zzb(zzhgkVar.zzf().zzc()), zzhgkVar.zzd()));
        this.zzc = zzhgkVar.zzf().zzd();
        this.zzd = zzhgkVar.zze().zzc();
        if (zzhgkVar.zzf().zzf().equals(zzhgq.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public static zzgwi zza(zzhgk zzhgkVar) throws GeneralSecurityException {
        return new zzhsp(zzhgkVar);
    }

    public static zzgwi zzb(zzhgw zzhgwVar) throws GeneralSecurityException {
        return new zzhsp(zzhgwVar);
    }

    public final byte[] zzc(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2 = this.zze;
        return bArr2.length > 0 ? zzhrm.zza(this.zzd, this.zzb.zza(zzhrm.zza(bArr, bArr2), this.zzc)) : zzhrm.zza(this.zzd, this.zzb.zza(bArr, this.zzc));
    }

    private zzhsp(zzhgw zzhgwVar) throws GeneralSecurityException {
        String strValueOf = String.valueOf(zzhgwVar.zzf().zzg());
        String.valueOf(strValueOf);
        String strValueOf2 = String.valueOf(strValueOf);
        this.zzb = new zzhso("HMAC".concat(strValueOf2), new SecretKeySpec(zzhgwVar.zzd().zzc(zzgvr.zza()), "HMAC"));
        this.zzc = zzhgwVar.zzf().zzd();
        this.zzd = zzhgwVar.zze().zzc();
        if (zzhgwVar.zzf().zzf().equals(zzhhe.zzc)) {
            this.zze = Arrays.copyOf(zza, 1);
        } else {
            this.zze = new byte[0];
        }
    }

    public zzhsp(zzhik zzhikVar, int i) throws GeneralSecurityException {
        this.zzb = zzhikVar;
        this.zzc = i;
        this.zzd = new byte[0];
        this.zze = new byte[0];
        zzhikVar.zza(new byte[0], i);
    }
}
