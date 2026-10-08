package com.google.android.gms.tagmanager;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzct extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zza.JOINER.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.ARG0.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.ITEM_SEPARATOR.toString();
    private static final String zzd = com.google.android.gms.internal.gtm.zzb.KEY_VALUE_SEPARATOR.toString();
    private static final String zze = com.google.android.gms.internal.gtm.zzb.ESCAPE.toString();

    public zzct() {
        super(zza, zzb);
    }

    private static final void zzc(Set set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    private static final String zzd(String str, int i, Set set) {
        int i2 = i - 1;
        if (i2 == 1) {
            try {
                return zzfs.zza(str);
            } catch (UnsupportedEncodingException e) {
                Log.e("GoogleTagManager", "Joiner: unsupported encoding", e);
                return str;
            }
        }
        if (i2 != 2) {
            return str;
        }
        String strReplace = str.replace("\\", "\\\\");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String string = ((Character) it.next()).toString();
            strReplace = strReplace.replace(string, "\\".concat(String.valueOf(string)));
        }
        return strReplace;
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        int i;
        com.google.android.gms.internal.gtm.zzap zzapVar = (com.google.android.gms.internal.gtm.zzap) map.get(zzb);
        if (zzapVar == null) {
            return zzfp.zza();
        }
        com.google.android.gms.internal.gtm.zzap zzapVar2 = (com.google.android.gms.internal.gtm.zzap) map.get(zzc);
        String strZzm = zzapVar2 != null ? zzfp.zzm(zzfp.zzk(zzapVar2)) : "";
        com.google.android.gms.internal.gtm.zzap zzapVar3 = (com.google.android.gms.internal.gtm.zzap) map.get(zzd);
        String strZzm2 = zzapVar3 != null ? zzfp.zzm(zzfp.zzk(zzapVar3)) : "=";
        com.google.android.gms.internal.gtm.zzap zzapVar4 = (com.google.android.gms.internal.gtm.zzap) map.get(zze);
        HashSet hashSet = null;
        boolean z = true;
        if (zzapVar4 != null) {
            String strZzm3 = zzfp.zzm(zzfp.zzk(zzapVar4));
            if ("url".equals(strZzm3)) {
                i = 2;
            } else {
                if (!"backslash".equals(strZzm3)) {
                    Log.e("GoogleTagManager", "Joiner: unsupported escape type: ".concat(String.valueOf(strZzm3)));
                    return zzfp.zza();
                }
                hashSet = new HashSet();
                zzc(hashSet, strZzm);
                zzc(hashSet, strZzm2);
                hashSet.remove('\\');
                i = 3;
            }
        } else {
            i = 1;
        }
        StringBuilder sb = new StringBuilder();
        int iZzO = zzapVar.zzO();
        if (iZzO == 2) {
            for (com.google.android.gms.internal.gtm.zzap zzapVar5 : zzapVar.zzr()) {
                if (!z) {
                    sb.append(strZzm);
                }
                sb.append(zzd(zzfp.zzm(zzfp.zzk(zzapVar5)), i, hashSet));
                z = false;
            }
        } else if (iZzO != 3) {
            sb.append(zzd(zzfp.zzm(zzfp.zzk(zzapVar)), i, hashSet));
        } else {
            for (int i2 = 0; i2 < zzapVar.zzc(); i2++) {
                if (i2 > 0) {
                    sb.append(strZzm);
                }
                String strZzm4 = zzfp.zzm(zzfp.zzk(zzapVar.zzk(i2)));
                String strZzm5 = zzfp.zzm(zzfp.zzk(zzapVar.zzl(i2)));
                sb.append(zzd(strZzm4, i, hashSet));
                sb.append(strZzm2);
                sb.append(zzd(strZzm5, i, hashSet));
            }
        }
        return zzfp.zzb(sb.toString());
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return true;
    }
}
