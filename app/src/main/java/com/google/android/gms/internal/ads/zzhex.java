package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhex {
    private static final zzhex zzb = new zzhex();
    private final Map zza = new HashMap();

    zzhex() {
    }

    public static zzhex zza() {
        return zzb;
    }

    public final synchronized void zzb(String str, zzgwj zzgwjVar) throws GeneralSecurityException {
        Map map = this.zza;
        if (!map.containsKey(str)) {
            map.put(str, zzgwjVar);
            return;
        }
        if (((zzgwj) map.get(str)).equals(zzgwjVar)) {
            return;
        }
        String strValueOf = String.valueOf(map.get(str));
        String strValueOf2 = String.valueOf(zzgwjVar);
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 45 + String.valueOf(strValueOf).length() + 17 + String.valueOf(strValueOf2).length());
        sb.append("Parameters object with name ");
        sb.append(str);
        sb.append(" already exists (");
        sb.append(strValueOf);
        sb.append("), cannot insert ");
        sb.append(strValueOf2);
        throw new GeneralSecurityException(sb.toString());
    }

    public final synchronized zzgwj zzc(String str) throws GeneralSecurityException {
        Map map;
        map = this.zza;
        if (!map.containsKey("AES128_GCM")) {
            throw new GeneralSecurityException("Name AES128_GCM does not exist");
        }
        return (zzgwj) map.get("AES128_GCM");
    }

    public final synchronized void zzd(Map map) throws GeneralSecurityException {
        for (Map.Entry entry : map.entrySet()) {
            zzb((String) entry.getKey(), (zzgwj) entry.getValue());
        }
    }
}
