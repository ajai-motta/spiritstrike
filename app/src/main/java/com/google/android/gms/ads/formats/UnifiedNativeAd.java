package com.google.android.gms.ads.formats;

import android.os.Bundle;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public abstract class UnifiedNativeAd {
    public abstract void performClick(Bundle bundle);

    public abstract boolean recordImpression(Bundle bundle);

    public abstract void reportTouchEvent(Bundle bundle);

    public abstract String zza();

    public abstract List zzb();

    public abstract String zzc();

    public abstract NativeAd.Image zzd();

    public abstract String zze();

    public abstract String zzf();

    public abstract Double zzg();

    public abstract String zzh();

    public abstract String zzi();

    @Deprecated
    public abstract VideoController zzj();

    public abstract Object zzk();
}
