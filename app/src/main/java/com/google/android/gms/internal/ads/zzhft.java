package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhft {
    private final Map zza;
    private final Map zzb;

    /* synthetic */ zzhft(zzhfq zzhfqVar, byte[] bArr) {
        this.zza = new HashMap(zzhfqVar.zzd());
        this.zzb = new HashMap(zzhfqVar.zze());
    }

    public static zzhfq zza() {
        return new zzhfq(null);
    }

    public final Object zzb(zzgvt zzgvtVar, Class cls) throws GeneralSecurityException {
        zzhfr zzhfrVar = new zzhfr(zzgvtVar.getClass(), cls, null);
        Map map = this.zza;
        if (map.containsKey(zzhfrVar)) {
            return ((zzhfp) map.get(zzhfrVar)).zza(zzgvtVar);
        }
        String string = zzhfrVar.toString();
        StringBuilder sb = new StringBuilder(string.length() + 102);
        sb.append("No PrimitiveConstructor for ");
        sb.append(string);
        sb.append(" available, see https://developers.google.com/tink/faq/registration_errors");
        throw new GeneralSecurityException(sb.toString());
    }

    public final Object zzc(zzhed zzhedVar, zzhel zzhelVar, Class cls) throws GeneralSecurityException {
        Map map = this.zzb;
        if (!map.containsKey(cls)) {
            throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
        }
        final zzhfv zzhfvVar = (zzhfv) map.get(cls);
        return zzhfvVar.zze(zzhedVar, zzhelVar, new zzhfu() { // from class: com.google.android.gms.internal.ads.zzhfs
            @Override // com.google.android.gms.internal.ads.zzhfu
            public final /* synthetic */ Object zza(zzgwc zzgwcVar) {
                return this.zza.zzb(zzgwcVar.zza(), zzhfvVar.zzb());
            }
        });
    }

    final /* synthetic */ Map zzd() {
        return this.zza;
    }

    final /* synthetic */ Map zze() {
        return this.zzb;
    }
}
