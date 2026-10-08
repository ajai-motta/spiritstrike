package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzalk {
    public static zzall zza(zzall zzallVar, String[] strArr, Map map) {
        int length;
        int i = 0;
        if (zzallVar == null) {
            if (strArr == null) {
                return null;
            }
            int length2 = strArr.length;
            if (length2 == 1) {
                return (zzall) map.get(strArr[0]);
            }
            if (length2 > 1) {
                zzall zzallVar2 = new zzall();
                while (i < length2) {
                    zzallVar2.zzr((zzall) map.get(strArr[i]));
                    i++;
                }
                return zzallVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                zzallVar.zzr((zzall) map.get(strArr[0]));
                return zzallVar;
            }
            if (strArr != null && (length = strArr.length) > 1) {
                while (i < length) {
                    zzallVar.zzr((zzall) map.get(strArr[i]));
                    i++;
                }
            }
        }
        return zzallVar;
    }
}
