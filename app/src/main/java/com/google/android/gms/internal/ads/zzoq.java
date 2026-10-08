package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzoq {
    final /* synthetic */ zzor zza;
    private final String zzb;
    private int zzc;
    private long zzd;
    private zzuu zze;
    private boolean zzf;
    private boolean zzg;

    public zzoq(zzor zzorVar, String str, int i, zzuu zzuuVar) {
        Objects.requireNonNull(zzorVar);
        this.zza = zzorVar;
        this.zzb = str;
        this.zzc = i;
        this.zzd = zzuuVar == null ? -1L : zzuuVar.zzd;
        if (zzuuVar == null || !zzuuVar.zzb()) {
            return;
        }
        this.zze = zzuuVar;
    }

    public final boolean zza(zzbf zzbfVar, zzbf zzbfVar2) {
        int i = this.zzc;
        if (i < zzbfVar.zza()) {
            zzor zzorVar = this.zza;
            zzbfVar.zzb(i, zzorVar.zzj(), 0L);
            for (int i2 = zzorVar.zzj().zzn; i2 <= zzorVar.zzj().zzo; i2++) {
                int iZze = zzbfVar2.zze(zzbfVar.zzf(i2));
                if (iZze != -1) {
                    i = zzbfVar2.zzd(iZze, zzorVar.zzk(), false).zzc;
                    break;
                }
            }
            i = -1;
        } else if (i >= zzbfVar2.zza()) {
            i = -1;
        }
        this.zzc = i;
        if (i == -1) {
            return false;
        }
        zzuu zzuuVar = this.zze;
        return zzuuVar == null || zzbfVar2.zze(zzuuVar.zza) != -1;
    }

    public final boolean zzb(int i, zzuu zzuuVar) {
        if (zzuuVar == null) {
            return i == this.zzc;
        }
        zzuu zzuuVar2 = this.zze;
        return zzuuVar2 == null ? !zzuuVar.zzb() && zzuuVar.zzd == this.zzd : zzuuVar.zzd == zzuuVar2.zzd && zzuuVar.zzb == zzuuVar2.zzb && zzuuVar.zzc == zzuuVar2.zzc;
    }

    public final void zzc(int i, zzuu zzuuVar) {
        if (this.zzd == -1 && i == this.zzc && zzuuVar != null) {
            zzor zzorVar = this.zza;
            long j = zzuuVar.zzd;
            if (j >= zzorVar.zzi()) {
                this.zzd = j;
            }
        }
    }

    public final boolean zzd(zzmj zzmjVar) {
        zzuu zzuuVar = zzmjVar.zzd;
        if (zzuuVar == null) {
            return this.zzc != zzmjVar.zzc;
        }
        long j = this.zzd;
        if (j == -1) {
            return false;
        }
        long j2 = zzuuVar.zzd;
        if (j2 > j) {
            return true;
        }
        if (this.zze == null) {
            return false;
        }
        zzbf zzbfVar = zzmjVar.zzb;
        int iZze = zzbfVar.zze(zzuuVar.zza);
        int iZze2 = zzbfVar.zze(this.zze.zza);
        zzuu zzuuVar2 = this.zze;
        if (j2 < zzuuVar2.zzd || iZze < iZze2) {
            return false;
        }
        if (iZze > iZze2) {
            return true;
        }
        if (!zzuuVar.zzb()) {
            int i = zzuuVar.zze;
            return i == -1 || i > zzuuVar2.zzb;
        }
        int i2 = zzuuVar.zzb;
        int i3 = zzuuVar.zzc;
        int i4 = zzuuVar2.zzb;
        if (i2 <= i4) {
            return i2 == i4 && i3 > zzuuVar2.zzc;
        }
        return true;
    }

    final /* synthetic */ String zze() {
        return this.zzb;
    }

    final /* synthetic */ int zzf() {
        return this.zzc;
    }

    final /* synthetic */ long zzg() {
        return this.zzd;
    }

    final /* synthetic */ zzuu zzh() {
        return this.zze;
    }

    final /* synthetic */ boolean zzi() {
        return this.zzf;
    }

    final /* synthetic */ void zzj(boolean z) {
        this.zzf = true;
    }

    final /* synthetic */ boolean zzk() {
        return this.zzg;
    }

    final /* synthetic */ void zzl(boolean z) {
        this.zzg = true;
    }
}
