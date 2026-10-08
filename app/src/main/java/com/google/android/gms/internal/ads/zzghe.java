package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.function.Function;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzghe implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;
    private final zzifq zzc;

    private zzghe(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
        this.zzc = zzifqVar3;
    }

    public static zzghe zza(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3) {
        return new zzghe(zzifqVar, zzifqVar2, zzifqVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        File file = (File) this.zza.zzb();
        zzfzi zzfziVar = (zzfzi) this.zzb.zzb();
        final zzgjd zzgjdVar = (zzgjd) this.zzc.zzb();
        return zzfziVar.zzb(file, new byte[0], new Function() { // from class: com.google.android.gms.internal.ads.zzggx
            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                zzgjdVar.zzd(15310, (Throwable) obj);
                return new byte[0];
            }
        });
    }
}
