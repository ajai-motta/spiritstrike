package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcrp implements zzifh {
    private final zzcrn zza;

    private zzcrp(zzcrn zzcrnVar) {
        this.zza = zzcrnVar;
    }

    public static zzcrp zzc(zzcrn zzcrnVar) {
        return new zzcrp(zzcrnVar);
    }

    public static View zzd(zzcrn zzcrnVar) {
        View viewZzb = zzcrnVar.zzb();
        zzifp.zzb(viewZzb);
        return viewZzb;
    }

    public final View zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
