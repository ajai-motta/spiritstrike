package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhes {
    public static final /* synthetic */ int zza = 0;
    private static final zzheq zzc = zzher.zza;
    private static final zzhes zzd = zzd();
    private final Map zzb = new HashMap();

    public static zzhes zza() {
        return zzd;
    }

    private static zzhes zzd() {
        zzhes zzhesVar = new zzhes();
        try {
            zzhesVar.zzb(zzc, zzhej.class);
            return zzhesVar;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("unexpected error.", e);
        }
    }

    private final synchronized zzgvt zze(zzgwj zzgwjVar, @Nullable Integer num) throws GeneralSecurityException {
        zzheq zzheqVar;
        zzheqVar = (zzheq) this.zzb.get(zzgwjVar.getClass());
        if (zzheqVar == null) {
            String string = zzgwjVar.toString();
            StringBuilder sb = new StringBuilder(string.length() + 86);
            sb.append("Cannot create a new key for parameters ");
            sb.append(string);
            sb.append(": no key creator for this class was registered.");
            throw new GeneralSecurityException(sb.toString());
        }
        return zzheqVar.zza(zzgwjVar, num);
    }

    public final synchronized void zzb(zzheq zzheqVar, Class cls) throws GeneralSecurityException {
        Map map = this.zzb;
        zzheq zzheqVar2 = (zzheq) map.get(cls);
        if (zzheqVar2 != null && !zzheqVar2.equals(zzheqVar)) {
            String string = cls.toString();
            StringBuilder sb = new StringBuilder(string.length() + 60);
            sb.append("Different key creator for parameters class ");
            sb.append(string);
            sb.append(" already inserted");
            throw new GeneralSecurityException(sb.toString());
        }
        map.put(cls, zzheqVar);
    }

    public final zzgvt zzc(zzgwj zzgwjVar, @Nullable Integer num) throws GeneralSecurityException {
        return zze(zzgwjVar, num);
    }
}
