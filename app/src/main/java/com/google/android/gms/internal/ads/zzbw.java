package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbw {
    private AudioManager.OnAudioFocusChangeListener zza;
    private Handler zzb;
    private zzd zzc = zzd.zza;

    public zzbw(int i) {
    }

    public final zzbw zza(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
        this.zza = onAudioFocusChangeListener;
        this.zzb = handler;
        return this;
    }

    public final zzbw zzb(zzd zzdVar) {
        this.zzc = zzdVar;
        return this;
    }

    public final zzbz zzc() {
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.zza;
        if (onAudioFocusChangeListener == null) {
            throw new IllegalStateException("Can't build an AudioFocusRequestCompat instance without a listener");
        }
        Handler handler = this.zzb;
        handler.getClass();
        return new zzbz(1, onAudioFocusChangeListener, handler, this.zzc, false);
    }
}
