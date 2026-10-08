package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhdw {
    private static final Logger zza = Logger.getLogger(zzhdw.class.getName());
    private static final zzhdw zzd = new zzhdw();
    private final ConcurrentMap zzb = new ConcurrentHashMap();
    private final ConcurrentMap zzc = new ConcurrentHashMap();

    public static zzhdw zza() {
        return zzd;
    }

    private final synchronized zzgvu zzg(String str) throws GeneralSecurityException {
        ConcurrentMap concurrentMap;
        concurrentMap = this.zzb;
        if (!concurrentMap.containsKey(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 98);
            sb.append("No key manager found for key type ");
            sb.append(str);
            sb.append(", see https://developers.google.com/tink/faq/registration_errors");
            throw new GeneralSecurityException(sb.toString());
        }
        return (zzgvu) concurrentMap.get(str);
    }

    private final synchronized void zzh(zzgvu zzgvuVar, boolean z, boolean z2) throws GeneralSecurityException {
        String strZzb = zzgvuVar.zzb();
        if (z2) {
            ConcurrentMap concurrentMap = this.zzc;
            if (concurrentMap.containsKey(strZzb) && !((Boolean) concurrentMap.get(strZzb)).booleanValue()) {
                throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(strZzb));
            }
        }
        ConcurrentMap concurrentMap2 = this.zzb;
        zzgvu zzgvuVar2 = (zzgvu) concurrentMap2.get(strZzb);
        if (zzgvuVar2 != null && !zzgvuVar2.getClass().equals(zzgvuVar.getClass())) {
            zza.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "insertKeyManager", "Attempted overwrite of a registered key manager for key type ".concat(strZzb));
            throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", strZzb, zzgvuVar2.getClass().getName(), zzgvuVar.getClass().getName()));
        }
        concurrentMap2.putIfAbsent(strZzb, zzgvuVar);
        this.zzc.put(strZzb, Boolean.valueOf(z2));
    }

    public final synchronized void zzb(zzgvu zzgvuVar, boolean z) throws GeneralSecurityException {
        zzf(zzgvuVar, 1, z);
    }

    public final zzgvu zzc(String str, Class cls) throws GeneralSecurityException {
        zzgvu zzgvuVarZzg = zzg(str);
        if (zzgvuVarZzg.zzc().equals(cls)) {
            return zzgvuVarZzg;
        }
        String name = cls.getName();
        String strValueOf = String.valueOf(zzgvuVarZzg.getClass());
        String string = zzgvuVarZzg.zzc().toString();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 53 + String.valueOf(strValueOf).length() + 23 + string.length());
        sb.append("Primitive type ");
        sb.append(name);
        sb.append(" not supported by key manager of type ");
        sb.append(strValueOf);
        sb.append(", which only supports: ");
        sb.append(string);
        throw new GeneralSecurityException(sb.toString());
    }

    public final zzgvu zzd(String str) throws GeneralSecurityException {
        return zzg(str);
    }

    public final boolean zze(String str) {
        return ((Boolean) this.zzc.get(str)).booleanValue();
    }

    public final synchronized void zzf(zzgvu zzgvuVar, int i, boolean z) throws GeneralSecurityException {
        if (!zzhcy.zza(i)) {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
        zzh(zzgvuVar, false, z);
    }
}
