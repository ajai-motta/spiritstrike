package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfje {
    private final zzfiw zza;
    private final ListenableFuture zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public zzfje(final zzfic zzficVar, final zzfiv zzfivVar, final zzfiw zzfiwVar) {
        this.zza = zzfiwVar;
        this.zzb = zzgui.zzh(zzgui.zzj(zzfivVar.zza(zzfiwVar), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzfjd
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc(zzfivVar, zzficVar, zzfiwVar, (zzfil) obj);
            }
        }, zzfiwVar.zza()), Exception.class, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzfjb
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzd(zzfivVar, (Exception) obj);
            }
        }, zzfiwVar.zza());
    }

    public final synchronized void zza(zzguf zzgufVar) {
        zzfiw zzfiwVar = this.zza;
        zzgui.zzr(zzgui.zzj(this.zzb, zzfjc.zza, zzfiwVar.zza()), zzgufVar, zzfiwVar.zza());
    }

    public final synchronized ListenableFuture zzb(zzfiw zzfiwVar) {
        if (!this.zzd && !this.zzc) {
            zzfiw zzfiwVar2 = this.zza;
            if (zzfiwVar2.zzb() != null && zzfiwVar.zzb() != null && zzfiwVar2.zzb().equals(zzfiwVar.zzb())) {
                this.zzc = true;
                return this.zzb;
            }
        }
        return null;
    }

    final /* synthetic */ ListenableFuture zzc(zzfiv zzfivVar, zzfic zzficVar, zzfiw zzfiwVar, zzfil zzfilVar) {
        ListenableFuture listenableFutureZza;
        synchronized (this) {
            this.zzd = true;
            zzfivVar.zzb(zzfilVar);
            if (this.zzc) {
                listenableFutureZza = zzgui.zza(new zzfiu(zzfilVar, zzfiwVar));
            } else {
                zzficVar.zzb(zzfiwVar.zzb(), zzfilVar);
                listenableFutureZza = zzgui.zza(null);
            }
        }
        return listenableFutureZza;
    }

    final /* synthetic */ ListenableFuture zzd(zzfiv zzfivVar, Exception exc) {
        synchronized (this) {
            this.zzd = true;
            throw exc;
        }
    }
}
