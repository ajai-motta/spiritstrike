package com.google.android.gms.tagmanager;

import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbu extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zza.HASH.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.ARG0.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.ALGORITHM.toString();
    private static final String zzd = com.google.android.gms.internal.gtm.zzb.INPUT_FORMAT.toString();

    public zzbu() {
        super(zza, zzb);
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        byte[] bArrZzb;
        com.google.android.gms.internal.gtm.zzap zzapVar = (com.google.android.gms.internal.gtm.zzap) map.get(zzb);
        if (zzapVar == null || zzapVar == zzfp.zza()) {
            return zzfp.zza();
        }
        String strZzm = zzfp.zzm(zzfp.zzk(zzapVar));
        com.google.android.gms.internal.gtm.zzap zzapVar2 = (com.google.android.gms.internal.gtm.zzap) map.get(zzc);
        String strZzm2 = zzapVar2 == null ? "MD5" : zzfp.zzm(zzfp.zzk(zzapVar2));
        com.google.android.gms.internal.gtm.zzap zzapVar3 = (com.google.android.gms.internal.gtm.zzap) map.get(zzd);
        String strZzm3 = zzapVar3 == null ? "text" : zzfp.zzm(zzfp.zzk(zzapVar3));
        if ("text".equals(strZzm3)) {
            bArrZzb = strZzm.getBytes();
        } else {
            if (!"base16".equals(strZzm3)) {
                Log.e("GoogleTagManager", "Hash: unknown input format: ".concat(String.valueOf(strZzm3)));
                return zzfp.zza();
            }
            bArrZzb = zzp.zzb(strZzm);
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(strZzm2);
            messageDigest.update(bArrZzb);
            return zzfp.zzb(zzp.zza(messageDigest.digest()));
        } catch (NoSuchAlgorithmException unused) {
            Log.e("GoogleTagManager", "Hash: unknown algorithm: ".concat(String.valueOf(strZzm2)));
            return zzfp.zza();
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return true;
    }
}
