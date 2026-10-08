package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgvh extends zzgtz implements RunnableFuture {
    private volatile zzgup zza;

    zzgvh(zzgtp zzgtpVar) {
        this.zza = new zzgvf(this, zzgtpVar);
    }

    static zzgvh zze(Runnable runnable, Object obj) {
        return new zzgvh(Executors.callable(runnable, obj));
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzgup zzgupVar = this.zza;
        if (zzgupVar != null) {
            zzgupVar.run();
        }
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgtb
    protected final void zzc() {
        zzgup zzgupVar;
        if (zzj() && (zzgupVar = this.zza) != null) {
            zzgupVar.zzh();
        }
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgtb
    protected final String zzd() {
        zzgup zzgupVar = this.zza;
        if (zzgupVar == null) {
            return super.zzd();
        }
        String string = zzgupVar.toString();
        StringBuilder sb = new StringBuilder(string.length() + 7);
        sb.append("task=[");
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }

    zzgvh(Callable callable) {
        this.zza = new zzgvg(this, callable);
    }
}
