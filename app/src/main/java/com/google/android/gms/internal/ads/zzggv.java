package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzggv implements zzggu {
    private final zzfyz zza;
    private final zzfyz zzb;
    private final zzifb zzc;
    private final zzgjd zzd;

    zzggv(zzfyz zzfyzVar, zzfyz zzfyzVar2, zzifb zzifbVar, zzgjd zzgjdVar) {
        this.zza = zzfyzVar;
        this.zzb = zzfyzVar2;
        this.zzc = zzifbVar;
        this.zzd = zzgjdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzggu
    public final ListenableFuture zza() {
        ListenableFuture listenableFutureZzb = this.zza.zzb();
        this.zzd.zze(15302, listenableFutureZzb);
        return listenableFutureZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzggu
    public final ListenableFuture zzb(zzgaa zzgaaVar) {
        ListenableFuture listenableFutureZzc = this.zza.zzc(zzgaaVar);
        this.zzd.zze(15303, listenableFutureZzc);
        return listenableFutureZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzggu
    public final ListenableFuture zzc() {
        ListenableFuture listenableFutureZzb = this.zzb.zzb();
        this.zzd.zze(15304, listenableFutureZzb);
        return listenableFutureZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzggu
    public final ListenableFuture zzd(byte[] bArr) {
        ListenableFuture listenableFutureZzc = this.zzb.zzc(bArr);
        this.zzd.zze(15305, listenableFutureZzc);
        return listenableFutureZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzggu
    public final File zze() {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzggu
    public final ListenableFuture zzf(byte[] bArr) {
        ListenableFuture listenableFutureZzc = ((zzfyz) this.zzc.zzb()).zzc(bArr);
        this.zzd.zze(15307, listenableFutureZzc);
        return listenableFutureZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzggu
    public final File zzg() {
        return ((zzfyz) this.zzc.zzb()).zza();
    }
}
