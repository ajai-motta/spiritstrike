package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcvo implements com.google.android.gms.ads.internal.client.zza {
    private final zzcvs zza;
    private final zzfgn zzb;

    zzcvo(zzcvs zzcvsVar, zzfgn zzfgnVar) {
        this.zza = zzcvsVar;
        this.zzb = zzfgnVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        this.zza.zza(this.zzb.zzg);
    }
}
