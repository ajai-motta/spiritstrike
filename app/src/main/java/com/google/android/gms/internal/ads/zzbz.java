package com.google.android.gms.internal.ads;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbz {
    private final AudioManager.OnAudioFocusChangeListener zzb;
    private final Handler zzc;
    private final zzd zzd;
    private final Object zzf;
    private final int zza = 1;
    private final boolean zze = false;

    zzbz(int i, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler, zzd zzdVar, boolean z) {
        this.zzc = handler;
        this.zzd = zzdVar;
        if (Build.VERSION.SDK_INT < 26) {
            this.zzb = new zzby(onAudioFocusChangeListener, handler);
        } else {
            this.zzb = onAudioFocusChangeListener;
        }
        this.zzf = Build.VERSION.SDK_INT >= 26 ? new AudioFocusRequest.Builder(1).setAudioAttributes(zzdVar.zza()).setWillPauseWhenDucked(false).setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler).build() : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbz)) {
            return false;
        }
        zzbz zzbzVar = (zzbz) obj;
        int i = zzbzVar.zza;
        boolean z = zzbzVar.zze;
        return Objects.equals(this.zzb, zzbzVar.zzb) && Objects.equals(this.zzc, zzbzVar.zzc) && Objects.equals(this.zzd, zzbzVar.zzd);
    }

    public final int hashCode() {
        return Objects.hash(1, this.zzb, this.zzc, this.zzd, false);
    }

    public final zzd zza() {
        return this.zzd;
    }

    public final AudioManager.OnAudioFocusChangeListener zzb() {
        return this.zzb;
    }

    final AudioFocusRequest zzc() {
        Object obj = this.zzf;
        obj.getClass();
        return (AudioFocusRequest) obj;
    }
}
