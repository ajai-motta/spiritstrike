package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.Surface;
import com.google.android.exoplayer2.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaba {
    private final zzaaz zza;
    private final zzabf zzb;
    private boolean zzc;
    private long zzf;
    private boolean zzi;
    private boolean zzl;
    private boolean zzm;
    private int zzd = 0;
    private long zze = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private float zzj = 1.0f;
    private zzdc zzk = zzdc.zza;

    public zzaba(Context context, zzaaz zzaazVar, long j) {
        this.zza = zzaazVar;
        this.zzb = new zzabf(context);
    }

    private final void zzo(int i) {
        this.zzd = Math.min(this.zzd, i);
    }

    public final void zza(int i) {
        if (i == 0) {
            this.zzd = 1;
        } else if (i != 1) {
            zzo(2);
        } else {
            this.zzd = 0;
        }
    }

    public final void zzb() {
        this.zzc = true;
        this.zzf = zzep.zzq(this.zzk.zzb());
        this.zzb.zzb();
    }

    public final void zzc() {
        this.zzc = false;
        this.zzh = C.TIME_UNSET;
        this.zzb.zzh();
    }

    public final void zzd(Surface surface) {
        this.zzl = surface != null;
        this.zzm = false;
        this.zzb.zzc(surface);
        zzo(1);
    }

    public final void zze(float f) {
        this.zzb.zzf(f);
    }

    public final boolean zzf() {
        int i = this.zzd;
        this.zzd = 3;
        this.zzf = zzep.zzq(this.zzk.zzb());
        return i != 3;
    }

    public final void zzg(zzdc zzdcVar) {
        this.zzk = zzdcVar;
    }

    public final void zzh() {
        if (this.zzd == 0) {
            this.zzd = 1;
        }
    }

    public final boolean zzi(boolean z) {
        if (z && (this.zzd == 3 || (!this.zzl && this.zzm))) {
            this.zzh = C.TIME_UNSET;
            return true;
        }
        if (this.zzh == C.TIME_UNSET) {
            return false;
        }
        if (this.zzk.zzb() < this.zzh) {
            return true;
        }
        this.zzh = C.TIME_UNSET;
        return false;
    }

    public final void zzj(boolean z) {
        this.zzi = z;
        this.zzh = C.TIME_UNSET;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ba, code lost:
    
        if (r17 > 100000) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c5, code lost:
    
        if (r22 >= r26) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ca, code lost:
    
        if (r19.zzc != false) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzk(long r20, long r22, long r24, long r26, boolean r28, boolean r29, com.google.android.gms.internal.ads.zzaay r30) throws com.google.android.gms.internal.ads.zzib {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaba.zzk(long, long, long, long, boolean, boolean, com.google.android.gms.internal.ads.zzaay):int");
    }

    public final void zzl() {
        this.zzb.zzd();
        this.zzg = C.TIME_UNSET;
        this.zze = C.TIME_UNSET;
        zzo(1);
        this.zzh = C.TIME_UNSET;
    }

    public final void zzm(int i) {
        this.zzb.zza(i);
    }

    public final void zzn(float f) {
        zzgmd.zza(f > 0.0f);
        if (f == this.zzj) {
            return;
        }
        this.zzj = f;
        this.zzb.zze(f);
    }
}
