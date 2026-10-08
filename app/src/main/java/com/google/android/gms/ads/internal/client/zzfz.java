package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.VideoController;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfz extends zzef {
    private final VideoController.VideoLifecycleCallbacks zza;

    public zzfz(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zza = videoLifecycleCallbacks;
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zze() {
        this.zza.onVideoStart();
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzf() {
        this.zza.onVideoPlay();
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzg() {
        this.zza.onVideoPause();
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzh() {
        this.zza.onVideoEnd();
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzi(boolean z) {
        this.zza.onVideoMute(z);
    }
}
