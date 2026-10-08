package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioRouting;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzrb {
    private final AudioTrack zza;
    private final zzpj zzb;
    private final Handler zzc;
    private AudioRouting.OnRoutingChangedListener zzd = new AudioRouting.OnRoutingChangedListener() { // from class: com.google.android.gms.internal.ads.zzra
        @Override // android.media.AudioRouting.OnRoutingChangedListener
        public final /* synthetic */ void onRoutingChanged(AudioRouting audioRouting) {
            this.zza.zzb(audioRouting);
        }
    };

    public zzrb(AudioTrack audioTrack, zzpj zzpjVar) {
        this.zza = audioTrack;
        this.zzb = zzpjVar;
        Handler handler = new Handler(Looper.myLooper());
        this.zzc = handler;
        audioTrack.addOnRoutingChangedListener(this.zzd, handler);
    }

    final /* synthetic */ void zzb(final AudioRouting audioRouting) {
        if (this.zzd == null) {
            return;
        }
        zzcw.zza().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqy
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzc(audioRouting);
            }
        });
    }

    final /* synthetic */ void zzc(AudioRouting audioRouting) {
        final AudioDeviceInfo routedDevice = audioRouting.getRoutedDevice();
        if (routedDevice != null) {
            this.zzc.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqz
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzd(routedDevice);
                }
            });
        }
    }

    final /* synthetic */ void zzd(AudioDeviceInfo audioDeviceInfo) {
        if (this.zzd == null) {
            return;
        }
        this.zzb.zzc(audioDeviceInfo);
    }

    public final void zza() {
        AudioRouting.OnRoutingChangedListener onRoutingChangedListener = this.zzd;
        onRoutingChangedListener.getClass();
        this.zza.removeOnRoutingChangedListener(onRoutingChangedListener);
        this.zzd = null;
    }
}
