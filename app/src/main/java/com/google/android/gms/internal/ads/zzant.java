package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzant {
    private final List zza;
    private final zzaem[] zzc;
    private final String zzb = MimeTypes.VIDEO_MP2T;
    private final zzfq zzd = new zzfq(new zzfp() { // from class: com.google.android.gms.internal.ads.zzans
        @Override // com.google.android.gms.internal.ads.zzfp
        public final /* synthetic */ void zza(long j, zzeg zzegVar) {
            this.zza.zzf(j, zzegVar);
        }
    });

    public zzant(List list, String str) {
        this.zza = list;
        this.zzc = new zzaem[list.size()];
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
            String strZzc = zzvVar.zza;
            if (strZzc == null) {
                strZzc = zzaoeVar.zzc();
            }
            zzt zztVar = new zzt();
            zztVar.zza(strZzc);
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

    public final void zzb(int i) {
        this.zzd.zza(i);
    }

    public final void zzc(long j, zzeg zzegVar) {
        this.zzd.zzc(j, zzegVar);
    }

    public final void zzd() {
        this.zzd.zze();
    }

    public final void zze() {
        this.zzd.zze();
    }

    final /* synthetic */ void zzf(long j, zzeg zzegVar) {
        zzacn.zza(j, zzegVar, this.zzc);
    }
}
