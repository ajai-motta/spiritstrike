package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.gms.internal.ads.zzada;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzafv implements zzada {
    private zzadd zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private zzafz zzg;
    private zzadb zzh;
    private zzaei zzi;
    private zzaiz zzj;
    private final zzeg zza = new zzeg(2);
    private long zzf = -1;

    private final int zzg(zzadb zzadbVar) throws IOException {
        zzeg zzegVar = this.zza;
        zzegVar.zza(2);
        ((zzacr) zzadbVar).zzh(zzegVar.zzi(), 0, 2, false);
        return zzegVar.zzt();
    }

    private final int zzh(zzadb zzadbVar) throws IOException {
        zzeg zzegVar = this.zza;
        zzegVar.zza(2);
        zzadbVar.zzi(zzegVar.zzi(), 0, 2);
        return zzegVar.zzt() - 2;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        int iZzh;
        if (zzg(zzadbVar) == 65496) {
            while (true) {
                int iZzg = zzg(zzadbVar);
                this.zzd = iZzg;
                if (iZzg == 65498 || (iZzh = zzh(zzadbVar)) < 0) {
                    break;
                }
                if (this.zzd != 65505) {
                    ((zzacr) zzadbVar).zzj(iZzh, false);
                } else {
                    zzeg zzegVar = this.zza;
                    zzegVar.zza(iZzh);
                    ((zzacr) zzadbVar).zzh(zzegVar.zzi(), 0, iZzh, false);
                    if (Objects.equals(zzegVar.zzM((char) 0), "http://ns.adobe.com/xap/1.0/") && zzafy.zzb(zzegVar.zzM((char) 0))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public /* synthetic */ List zzb() {
        return zzgpe.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        this.zzb = zzaddVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0198  */
    @Override // com.google.android.gms.internal.ads.zzada
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzd(com.google.android.gms.internal.ads.zzadb r26, com.google.android.gms.internal.ads.zzaea r27) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafv.zzd(com.google.android.gms.internal.ads.zzadb, com.google.android.gms.internal.ads.zzaea):int");
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public /* synthetic */ zzada zzf() {
        return zzada.CC.$default$zzf(this);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j2) {
        if (j == 0) {
            this.zzc = 0;
            this.zzj = null;
        } else if (this.zzc == 5) {
            zzaiz zzaizVar = this.zzj;
            zzaizVar.getClass();
            zzaizVar.zze(j, j2);
        }
    }

    private final void zzi() {
        zzadd zzaddVar = this.zzb;
        zzaddVar.getClass();
        zzaddVar.zzv();
        this.zzb.zzw(new zzaec(C.TIME_UNSET, 0L));
        this.zzc = 6;
    }
}
