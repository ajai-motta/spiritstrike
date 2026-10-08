package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaqn {
    long zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final List zzh;

    static zzaqn zza(zzaqo zzaqoVar) throws IOException {
        if (zzaqq.zzi(zzaqoVar) != 538247942) {
            throw new IOException();
        }
        String strZzm = zzaqq.zzm(zzaqoVar);
        String strZzm2 = zzaqq.zzm(zzaqoVar);
        long jZzk = zzaqq.zzk(zzaqoVar);
        long jZzk2 = zzaqq.zzk(zzaqoVar);
        long jZzk3 = zzaqq.zzk(zzaqoVar);
        long jZzk4 = zzaqq.zzk(zzaqoVar);
        int iZzi = zzaqq.zzi(zzaqoVar);
        if (iZzi < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(iZzi).length() + 20);
            sb.append("readHeaderList size=");
            sb.append(iZzi);
            throw new IOException(sb.toString());
        }
        List listEmptyList = iZzi == 0 ? Collections.emptyList() : new ArrayList();
        for (int i = 0; i < iZzi; i++) {
            listEmptyList.add(new zzapm(zzaqq.zzm(zzaqoVar).intern(), zzaqq.zzm(zzaqoVar).intern()));
        }
        return new zzaqn(strZzm, strZzm2, jZzk, jZzk2, jZzk3, jZzk4, listEmptyList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    zzaqn(String str, zzapd zzapdVar) {
        String str2 = zzapdVar.zzb;
        long j = zzapdVar.zzc;
        long j2 = zzapdVar.zzd;
        long j3 = zzapdVar.zze;
        long j4 = zzapdVar.zzf;
        List arrayList = zzapdVar.zzh;
        if (arrayList == null) {
            Map map = zzapdVar.zzg;
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new zzapm((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(str, str2, j, j2, j3, j4, arrayList);
    }

    private zzaqn(String str, String str2, long j, long j2, long j3, long j4, List list) {
        this.zzb = str;
        this.zzc = true == "".equals(str2) ? null : str2;
        this.zzd = j;
        this.zze = j2;
        this.zzf = j3;
        this.zzg = j4;
        this.zzh = list;
    }
}
