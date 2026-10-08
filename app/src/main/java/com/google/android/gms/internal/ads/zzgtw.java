package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgtw extends zzgtk {
    private zzgtv zza;

    zzgtw(zzgpa zzgpaVar, boolean z, Executor executor, Callable callable) {
        super(zzgpaVar, z, false);
        this.zza = new zzgtu(this, callable, executor);
        zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgtk
    final void zzA(int i) {
        super.zzA(i);
        if (i == 1) {
            this.zza = null;
        }
    }

    final /* synthetic */ void zzD(zzgtv zzgtvVar) {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgtb
    protected final void zzi() {
        zzgtv zzgtvVar = this.zza;
        if (zzgtvVar != null) {
            zzgtvVar.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgtk
    final void zzw(int i, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzgtk
    final void zzx() {
        zzgtv zzgtvVar = this.zza;
        if (zzgtvVar != null) {
            zzgtvVar.zze();
        }
    }
}
