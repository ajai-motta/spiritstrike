package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaoi {
    private final List zza;
    private final String zzb = MimeTypes.VIDEO_MP2T;
    private final zzaem[] zzc;
    private final zzfq zzd;

    public zzaoi(List list, String str) {
        this.zza = list;
        this.zzc = new zzaem[list.size()];
        zzfq zzfqVar = new zzfq(new zzfp() { // from class: com.google.android.gms.internal.ads.zzaoh
            @Override // com.google.android.gms.internal.ads.zzfp
            public final /* synthetic */ void zza(long j, zzeg zzegVar) {
                this.zza.zzc(j, zzegVar);
            }
        });
        this.zzd = zzfqVar;
        zzfqVar.zza(3);
    }

    public final void zza(zzadd zzaddVar, zzaoe zzaoeVar) {
        int i = 0;
        while (true) {
            zzaem[] zzaemVarArr = this.zzc;
            if (i >= zzaemVarArr.length) {
                return;
            }
            zzaoeVar.zza();
            zzaem zzaemVarZzu = zzaddVar.zzu(zzaoeVar.zzb(), 3);
            zzv zzvVar = (zzv) this.zza.get(i);
            String str = zzvVar.zzo;
            boolean z = true;
            if (!MimeTypes.APPLICATION_CEA608.equals(str) && !MimeTypes.APPLICATION_CEA708.equals(str)) {
                z = false;
            }
            zzgmd.zzf(z, "Invalid closed caption MIME type provided: %s", str);
            zzt zztVar = new zzt();
            zztVar.zza(zzaoeVar.zzc());
            zztVar.zzl(this.zzb);
            zztVar.zzm(str);
            zztVar.zzf(zzvVar.zze);
            zztVar.zze(zzvVar.zzd);
            zztVar.zzJ(zzvVar.zzL);
            zztVar.zzp(zzvVar.zzr);
            zzaemVarZzu.zzu(zztVar.zzM());
            zzaemVarArr[i] = zzaemVarZzu;
            i++;
        }
    }

    public final void zzb(long j, zzeg zzegVar) {
        if (zzegVar.zzd() < 9) {
            return;
        }
        int iZzB = zzegVar.zzB();
        int iZzB2 = zzegVar.zzB();
        int iZzs = zzegVar.zzs();
        if (iZzB == 434 && iZzB2 == 1195456820 && iZzs == 3) {
            this.zzd.zzc(j, zzegVar);
        }
    }

    final /* synthetic */ void zzc(long j, zzeg zzegVar) {
        zzacn.zzb(j, zzegVar, this.zzc);
    }
}
