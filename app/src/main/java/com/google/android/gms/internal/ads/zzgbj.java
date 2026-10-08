package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgbj implements zzifh {
    private final zzifq zza;

    private zzgbj(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzgbj zza(zzifq zzifqVar) {
        return new zzgbj(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        DisplayMetrics displayMetrics = ((Context) this.zza.zzb()).getResources().getDisplayMetrics();
        zzifp.zzb(displayMetrics);
        return displayMetrics;
    }
}
