package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzamd implements zzakd {
    private final List zza;
    private final long[] zzb;
    private final long[] zzc;

    public zzamd(List list) {
        this.zza = Collections.unmodifiableList(new ArrayList(list));
        int size = list.size();
        this.zzb = new long[size + size];
        for (int i = 0; i < list.size(); i++) {
            zzalt zzaltVar = (zzalt) list.get(i);
            long[] jArr = this.zzb;
            int i2 = i + i;
            jArr[i2] = zzaltVar.zzb;
            jArr[i2 + 1] = zzaltVar.zzc;
        }
        long[] jArr2 = this.zzb;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.zzc = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // com.google.android.gms.internal.ads.zzakd
    public final int zza() {
        return this.zzc.length;
    }

    @Override // com.google.android.gms.internal.ads.zzakd
    public final long zzb(int i) {
        zzgmd.zza(i >= 0);
        long[] jArr = this.zzc;
        zzgmd.zza(i < jArr.length);
        return jArr[i];
    }

    @Override // com.google.android.gms.internal.ads.zzakd
    public final List zzc(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            List list = this.zza;
            if (i >= list.size()) {
                break;
            }
            long[] jArr = this.zzb;
            int i2 = i + i;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                zzalt zzaltVar = (zzalt) list.get(i);
                zzcm zzcmVar = zzaltVar.zza;
                if (zzcmVar.zze == -3.4028235E38f) {
                    arrayList2.add(zzaltVar);
                } else {
                    arrayList.add(zzcmVar);
                }
            }
            i++;
        }
        Collections.sort(arrayList2, zzamc.zza);
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            zzcl zzclVarZza = ((zzalt) arrayList2.get(i3)).zza.zza();
            zzclVarZza.zzf((-1) - i3, 1);
            arrayList.add(zzclVarZza.zzr());
        }
        return arrayList;
    }
}
