package com.google.android.gms.tagmanager;

import android.util.Base64;
import android.util.Log;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbl extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zza.ENCODE.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.ARG0.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.NO_PADDING.toString();
    private static final String zzd = com.google.android.gms.internal.gtm.zzb.INPUT_FORMAT.toString();
    private static final String zze = com.google.android.gms.internal.gtm.zzb.OUTPUT_FORMAT.toString();

    public zzbl() {
        super(zza, zzb);
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        byte[] bArrDecode;
        String strEncodeToString;
        com.google.android.gms.internal.gtm.zzap zzapVar = (com.google.android.gms.internal.gtm.zzap) map.get(zzb);
        if (zzapVar == null || zzapVar == zzfp.zza()) {
            return zzfp.zza();
        }
        String strZzm = zzfp.zzm(zzfp.zzk(zzapVar));
        com.google.android.gms.internal.gtm.zzap zzapVar2 = (com.google.android.gms.internal.gtm.zzap) map.get(zzd);
        String strZzm2 = zzapVar2 == null ? "text" : zzfp.zzm(zzfp.zzk(zzapVar2));
        com.google.android.gms.internal.gtm.zzap zzapVar3 = (com.google.android.gms.internal.gtm.zzap) map.get(zze);
        String strZzm3 = zzapVar3 == null ? "base16" : zzfp.zzm(zzfp.zzk(zzapVar3));
        com.google.android.gms.internal.gtm.zzap zzapVar4 = (com.google.android.gms.internal.gtm.zzap) map.get(zzc);
        int i = 2;
        if (zzapVar4 != null && zzfp.zzf(zzfp.zzk(zzapVar4)).booleanValue()) {
            i = 3;
        }
        try {
            if ("text".equals(strZzm2)) {
                bArrDecode = strZzm.getBytes();
            } else if ("base16".equals(strZzm2)) {
                bArrDecode = zzp.zzb(strZzm);
            } else if ("base64".equals(strZzm2)) {
                bArrDecode = Base64.decode(strZzm, i);
            } else {
                if (!"base64url".equals(strZzm2)) {
                    Log.e("GoogleTagManager", "Encode: unknown input format: " + strZzm2);
                    return zzfp.zza();
                }
                bArrDecode = Base64.decode(strZzm, i | 8);
            }
            if ("base16".equals(strZzm3)) {
                strEncodeToString = zzp.zza(bArrDecode);
            } else if ("base64".equals(strZzm3)) {
                strEncodeToString = Base64.encodeToString(bArrDecode, i);
            } else {
                if (!"base64url".equals(strZzm3)) {
                    Log.e("GoogleTagManager", "Encode: unknown output format: ".concat(String.valueOf(strZzm3)));
                    return zzfp.zza();
                }
                strEncodeToString = Base64.encodeToString(bArrDecode, i | 8);
            }
            return zzfp.zzb(strEncodeToString);
        } catch (IllegalArgumentException unused) {
            Log.e("GoogleTagManager", "Encode: invalid input:");
            return zzfp.zza();
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return true;
    }
}
