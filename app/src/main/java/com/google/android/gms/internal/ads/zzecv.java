package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzecv {
    private final zzgus zza;
    private final zzeca zzb;
    private final zzifb zzc;

    public zzecv(zzgus zzgusVar, zzeca zzecaVar, zzifb zzifbVar) {
        this.zza = zzgusVar;
        this.zzb = zzecaVar;
        this.zzc = zzifbVar;
    }

    private final ListenableFuture zzg(final zzbxj zzbxjVar, zzecl zzeclVar, final zzecl zzeclVar2, final zzgtq zzgtqVar) {
        ListenableFuture listenableFutureZzh;
        String str = zzbxjVar.zzd;
        com.google.android.gms.ads.internal.zzt.zzc();
        if (com.google.android.gms.ads.internal.util.zzs.zzG(str)) {
            listenableFutureZzh = zzgui.zzc(new zzecj(1));
        } else {
            listenableFutureZzh = zzgui.zzh(zzeclVar.zza(zzbxjVar), ExecutionException.class, zzecu.zza, this.zza);
        }
        zzgus zzgusVar = this.zza;
        return (zzgua) zzgui.zzh((zzgua) zzgui.zzj((zzgua) zzgui.zzj(zzgua.zzw(listenableFutureZzh), zzecn.zza, zzgusVar), zzgtqVar, zzgusVar), zzecj.class, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzeco
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc(zzeclVar2, zzbxjVar, zzgtqVar, (zzecj) obj);
            }
        }, zzgusVar);
    }

    public final ListenableFuture zza(final zzbxj zzbxjVar) {
        zzgtq zzgtqVar = new zzgtq() { // from class: com.google.android.gms.internal.ads.zzecp
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                String str = new String(zzgsd.zza((InputStream) obj), StandardCharsets.UTF_8);
                zzbxj zzbxjVar2 = zzbxjVar;
                zzbxjVar2.zzj = str;
                return zzgui.zza(zzbxjVar2);
            }
        };
        final zzeca zzecaVar = this.zzb;
        Objects.requireNonNull(zzecaVar);
        return zzg(zzbxjVar, new zzecl() { // from class: com.google.android.gms.internal.ads.zzecm
            @Override // com.google.android.gms.internal.ads.zzecl
            public final /* synthetic */ ListenableFuture zza(zzbxj zzbxjVar2) {
                return zzecaVar.zza(zzbxjVar2);
            }
        }, new zzecl() { // from class: com.google.android.gms.internal.ads.zzecq
            @Override // com.google.android.gms.internal.ads.zzecl
            public final /* synthetic */ ListenableFuture zza(zzbxj zzbxjVar2) {
                return this.zza.zzd(zzbxjVar2);
            }
        }, zzgtqVar);
    }

    public final ListenableFuture zzb(zzbxj zzbxjVar) {
        return zzg(zzbxjVar, new zzecl() { // from class: com.google.android.gms.internal.ads.zzecs
            @Override // com.google.android.gms.internal.ads.zzecl
            public final /* synthetic */ ListenableFuture zza(zzbxj zzbxjVar2) {
                return this.zza.zze(zzbxjVar2);
            }
        }, new zzecl() { // from class: com.google.android.gms.internal.ads.zzect
            @Override // com.google.android.gms.internal.ads.zzecl
            public final /* synthetic */ ListenableFuture zza(zzbxj zzbxjVar2) {
                return this.zza.zzf(zzbxjVar2);
            }
        }, zzecr.zza);
    }

    final /* synthetic */ ListenableFuture zzc(zzecl zzeclVar, zzbxj zzbxjVar, zzgtq zzgtqVar, zzecj zzecjVar) {
        return zzgui.zzj(zzeclVar.zza(zzbxjVar), zzgtqVar, this.zza);
    }

    final /* synthetic */ ListenableFuture zzd(zzbxj zzbxjVar) {
        return ((zzeea) this.zzc.zzb()).zzc(zzbxjVar, Binder.getCallingUid());
    }

    final /* synthetic */ ListenableFuture zze(zzbxj zzbxjVar) {
        return this.zzb.zzd(zzbxjVar.zzh);
    }

    final /* synthetic */ ListenableFuture zzf(zzbxj zzbxjVar) {
        return ((zzeea) this.zzc.zzb()).zzd(zzbxjVar.zzh);
    }
}
