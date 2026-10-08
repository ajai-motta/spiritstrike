package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhfq {
    private final Map zza;
    private final Map zzb;

    private zzhfq() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zzhfq zza(zzhfp zzhfpVar) throws GeneralSecurityException {
        if (zzhfpVar == null) {
            throw new NullPointerException("primitive constructor must be non-null");
        }
        zzhfr zzhfrVar = new zzhfr(zzhfpVar.zzb(), zzhfpVar.zzc(), null);
        Map map = this.zza;
        if (map.containsKey(zzhfrVar)) {
            zzhfp zzhfpVar2 = (zzhfp) map.get(zzhfrVar);
            if (!zzhfpVar2.equals(zzhfpVar) || !zzhfpVar.equals(zzhfpVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ".concat(zzhfrVar.toString()));
            }
        } else {
            map.put(zzhfrVar, zzhfpVar);
        }
        return this;
    }

    public final zzhfq zzb(zzhfv zzhfvVar) throws GeneralSecurityException {
        Map map = this.zzb;
        Class clsZza = zzhfvVar.zza();
        if (map.containsKey(clsZza)) {
            zzhfv zzhfvVar2 = (zzhfv) map.get(clsZza);
            if (!zzhfvVar2.equals(zzhfvVar) || !zzhfvVar.equals(zzhfvVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type".concat(clsZza.toString()));
            }
        } else {
            map.put(clsZza, zzhfvVar);
        }
        return this;
    }

    public final zzhft zzc() {
        return new zzhft(this, null);
    }

    final /* synthetic */ Map zzd() {
        return this.zza;
    }

    final /* synthetic */ Map zze() {
        return this.zzb;
    }

    /* synthetic */ zzhfq(zzhft zzhftVar, byte[] bArr) {
        this.zza = new HashMap(zzhftVar.zzd());
        this.zzb = new HashMap(zzhftVar.zze());
    }

    /* synthetic */ zzhfq(byte[] bArr) {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }
}
