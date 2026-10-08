package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzmc {
    final /* synthetic */ zzme zza;
    private final int zzb;
    private Object zzc;
    private int zzd;
    private int zze;
    private boolean zzf;
    private long zzg;

    public zzmc(zzme zzmeVar, int i) {
        Objects.requireNonNull(zzmeVar);
        this.zza = zzmeVar;
        this.zzb = i;
    }

    public final void zza() {
        long jZzt;
        zzme zzmeVar = this.zza;
        zzbf zzbfVarZzq = zzmeVar.zzw().zzq();
        Object objZzf = zzbfVarZzq.zzg() ? null : zzbfVarZzq.zzf(zzmeVar.zzw().zzr());
        zzbb zzbbVarZzw = zzmeVar.zzw();
        zzbb zzbbVarZzw2 = zzmeVar.zzw();
        zzbb zzbbVarZzw3 = zzmeVar.zzw();
        int iZzy = zzbbVarZzw.zzy();
        int iZzz = zzbbVarZzw2.zzz();
        long jZzu = zzbbVarZzw3.zzu();
        if (objZzf == null || iZzy != -1) {
            jZzt = iZzy != -1 ? zzmeVar.zzw().zzt() : -9223372036854775807L;
        } else {
            zzbfVarZzq.zzo(objZzf, zzmeVar.zzy());
            jZzu -= zzep.zzp(0L);
            jZzt = zzep.zzp(zzmeVar.zzy().zzd);
            iZzy = -1;
        }
        boolean zZza = zzmeVar.zzw().zza();
        if (!zZza || jZzt == C.TIME_UNSET || jZzu < jZzt) {
            zzmeVar.zzz().zzk(3);
            if (zZza && jZzt != C.TIME_UNSET) {
                zzmeVar.zzz().zzi(3, (int) Math.ceil((jZzt - jZzu) / zzmeVar.zzw().zzn().zzb));
            }
            this.zzf = false;
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzf && Objects.equals(objZzf, this.zzc) && iZzy == this.zzd && iZzz == this.zze) {
            long j = jElapsedRealtime - this.zzg;
            int i = this.zzb;
            if (j >= i) {
                zzmeVar.zzx().zzx(new zzmf(3, i));
                return;
            }
            return;
        }
        this.zzf = true;
        this.zzg = jElapsedRealtime;
        this.zzc = objZzf;
        this.zzd = iZzy;
        this.zze = iZzz;
        zzmeVar.zzz().zzk(3);
        zzmeVar.zzz().zzi(3, this.zzb);
    }
}
