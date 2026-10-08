package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzek implements zzdm {
    private static final List zza = new ArrayList(50);
    private final Handler zzb;

    public zzek(Handler handler) {
        this.zzb = handler;
    }

    static /* synthetic */ void zzn(zzej zzejVar) {
        List list = zza;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(zzejVar);
            }
        }
    }

    private static zzej zzo() {
        zzej zzejVar;
        List list = zza;
        synchronized (list) {
            zzejVar = list.isEmpty() ? new zzej(null) : (zzej) list.remove(list.size() - 1);
        }
        return zzejVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final Looper zza() {
        return this.zzb.getLooper();
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final boolean zzb(int i) {
        return this.zzb.hasMessages(1);
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final zzdl zzc(int i) {
        Handler handler = this.zzb;
        zzej zzejVarZzo = zzo();
        zzejVarZzo.zzb(handler.obtainMessage(i), this);
        return zzejVarZzo;
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final zzdl zzd(int i, Object obj) {
        Handler handler = this.zzb;
        zzej zzejVarZzo = zzo();
        zzejVarZzo.zzb(handler.obtainMessage(i, obj), this);
        return zzejVarZzo;
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final zzdl zze(int i, int i2, int i3) {
        Handler handler = this.zzb;
        zzej zzejVarZzo = zzo();
        zzejVarZzo.zzb(handler.obtainMessage(i, i2, i3), this);
        return zzejVarZzo;
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final zzdl zzf(int i, int i2, int i3, Object obj) {
        Handler handler = this.zzb;
        zzej zzejVarZzo = zzo();
        zzejVarZzo.zzb(handler.obtainMessage(31, 0, 0, obj), this);
        return zzejVarZzo;
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final boolean zzg(zzdl zzdlVar) {
        return ((zzej) zzdlVar).zzc(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final boolean zzh(int i) {
        return this.zzb.sendEmptyMessage(i);
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final boolean zzi(int i, int i2) {
        return this.zzb.sendEmptyMessageDelayed(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final boolean zzj(int i, long j) {
        return this.zzb.sendEmptyMessageAtTime(2, j);
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final void zzk(int i) {
        this.zzb.removeMessages(i);
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final void zzl(Object obj) {
        this.zzb.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final boolean zzm(Runnable runnable) {
        return this.zzb.post(runnable);
    }
}
