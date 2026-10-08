package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgij implements zzgia, zzfzj {
    private final Context zza;
    private final zzgjd zzb;
    private final zzgus zzc;
    private final zzfxt zzd;
    private final AtomicBoolean zze = new AtomicBoolean(false);
    private ListenableFuture zzf = zzgui.zza(null);

    zzgij(Context context, zzgjd zzgjdVar, zzgus zzgusVar, zzfxt zzfxtVar) {
        this.zza = context;
        this.zzb = zzgjdVar;
        this.zzc = zzgusVar;
        this.zzd = zzfxtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzj
    public final ListenableFuture zza() {
        return (this.zze.getAndSet(true) || !this.zzd.zzc()) ? zzgui.zzb() : this.zzc.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgii
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zze();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzgia
    public final void zzb(Map map) {
        map.put("gs", this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzgia
    public final void zzc(Map map, Context context, View view) {
        map.put("gs", this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzgia
    public final void zzd(Map map) {
        map.put("gs", this.zzf);
    }

    final /* synthetic */ void zze() {
        ListenableFuture listenableFutureZzc = this.zzc.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzgih
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzf();
            }
        });
        this.zzb.zze(53, listenableFutureZzc);
        this.zzf = listenableFutureZzc;
    }

    final /* synthetic */ zzauz zzf() {
        Context context = this.zza;
        try {
            return zzfrz.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }
}
