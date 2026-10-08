package com.google.android.gms.tagmanager;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzau implements Runnable {
    final /* synthetic */ List zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzaz zzc;

    zzau(zzaz zzazVar, List list, long j) {
        this.zza = list;
        this.zzb = j;
        this.zzc = zzazVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzl(this.zza, this.zzb);
    }
}
