package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeCustomFormatAd;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbuv {
    private final NativeCustomFormatAd.OnCustomFormatAdLoadedListener zza;
    private final NativeCustomFormatAd.OnCustomClickListener zzb;
    private NativeCustomFormatAd zzc;

    public zzbuv(NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
        this.zza = onCustomFormatAdLoadedListener;
        this.zzb = onCustomClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final synchronized NativeCustomFormatAd zzc(zzbjc zzbjcVar) {
        NativeCustomFormatAd nativeCustomFormatAd = this.zzc;
        if (nativeCustomFormatAd != null) {
            return nativeCustomFormatAd;
        }
        zzbuw zzbuwVar = new zzbuw(zzbjcVar);
        this.zzc = zzbuwVar;
        return zzbuwVar;
    }

    public final zzbjp zza() {
        return new zzbuu(this, null);
    }

    public final zzbjm zzb() {
        if (this.zzb == null) {
            return null;
        }
        return new zzbut(this, null);
    }

    final /* synthetic */ NativeCustomFormatAd.OnCustomFormatAdLoadedListener zzd() {
        return this.zza;
    }

    final /* synthetic */ NativeCustomFormatAd.OnCustomClickListener zze() {
        return this.zzb;
    }
}
