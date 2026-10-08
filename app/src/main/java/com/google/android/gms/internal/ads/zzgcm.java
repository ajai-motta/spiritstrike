package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgcm implements zzgdg {
    private final Map zza;
    private final zzauc zzb;
    private final zzgjb zzc;
    private final long zzd;

    zzgcm(zzauc zzaucVar, Map map, zzfxt zzfxtVar, zzgjd zzgjdVar) {
        this.zza = map;
        this.zzb = zzaucVar;
        this.zzc = zzgjdVar.zza(112);
        this.zzd = zzfxtVar.zzj();
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zza();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Void zza() throws Exception {
        zzauz zzauzVar;
        try {
            try {
                this.zzc.zza();
                ListenableFuture listenableFuture = (ListenableFuture) this.zza.get("gs");
                if (listenableFuture != null && (zzauzVar = (zzauz) listenableFuture.get(this.zzd, TimeUnit.MILLISECONDS)) != null) {
                    zzauc zzaucVar = this.zzb;
                    synchronized (zzaucVar) {
                        zzaucVar.zzad(zzauzVar.zzh());
                        zzaucVar.zzN(zzauzVar.zzd());
                    }
                }
            } catch (ClassCastException | InterruptedException | ExecutionException | TimeoutException e) {
                this.zzc.zzb(e);
            }
            this.zzc.zzc();
            return null;
        } catch (Throwable th) {
            this.zzc.zzc();
            throw th;
        }
    }
}
