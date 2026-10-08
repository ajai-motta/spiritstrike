package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzeer {
    private final zzeen zza;
    private final zzgus zzb;

    public zzeer(zzeen zzeenVar, zzgus zzgusVar) {
        this.zza = zzeenVar;
        this.zzb = zzgusVar;
    }

    public final void zza(zzfjx zzfjxVar) {
        final zzeen zzeenVar = this.zza;
        Objects.requireNonNull(zzeenVar);
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.ads.zzeeq
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return zzeenVar.getWritableDatabase();
            }
        };
        zzgus zzgusVar = this.zzb;
        zzgui.zzr(zzgusVar.zzc(callable), new zzeep(this, zzfjxVar), zzgusVar);
    }
}
