package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzxx {
    private final Spatializer zza;
    private final boolean zzb;
    private final Handler zzc;
    private final Spatializer.OnSpatializerStateChangedListener zzd;

    public final boolean zza() {
        return this.zzb;
    }

    public final boolean zzd(zzd zzdVar, zzv zzvVar) {
        int i;
        String str = zzvVar.zzo;
        if (Objects.equals(str, MimeTypes.AUDIO_E_AC3_JOC)) {
            i = zzvVar.zzG;
            if (i == 16) {
                i = 12;
            }
        } else if (Objects.equals(str, "audio/iamf")) {
            i = zzvVar.zzG;
            if (i == -1) {
                i = 6;
            }
        } else if (Objects.equals(str, MimeTypes.AUDIO_AC4)) {
            i = zzvVar.zzG;
            if (i == 18 || i == 21) {
                i = 24;
            }
        } else {
            i = zzvVar.zzG;
        }
        int iZzB = zzep.zzB(i);
        if (iZzB == 0) {
            return false;
        }
        AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(iZzB);
        int i2 = zzvVar.zzH;
        if (i2 != -1) {
            channelMask.setSampleRate(i2);
        }
        Spatializer spatializer = this.zza;
        spatializer.getClass();
        return spatializer.canBeSpatialized(zzdVar.zza(), channelMask.build());
    }

    public final void zze() {
        Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener;
        Handler handler;
        Spatializer spatializer = this.zza;
        if (spatializer == null || (onSpatializerStateChangedListener = this.zzd) == null || (handler = this.zzc) == null) {
            return;
        }
        spatializer.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
        handler.removeCallbacksAndMessages(null);
    }

    public zzxx(Context context, zzyi zzyiVar, Boolean bool) {
        AudioManager audioManagerZza = context == null ? null : zzcb.zza(context);
        if (audioManagerZza == null || (bool != null && bool.booleanValue())) {
            this.zza = null;
            this.zzb = false;
            this.zzc = null;
            this.zzd = null;
            return;
        }
        Spatializer spatializer = audioManagerZza.getSpatializer();
        this.zza = spatializer;
        this.zzb = spatializer.getImmersiveAudioLevel() != 0;
        zzxv zzxvVar = new zzxv(this, zzyiVar);
        this.zzd = zzxvVar;
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        final Handler handler = new Handler(looperMyLooper);
        this.zzc = handler;
        Objects.requireNonNull(handler);
        spatializer.addOnSpatializerStateChangedListener(new Executor() { // from class: com.google.android.gms.internal.ads.zzxw
            @Override // java.util.concurrent.Executor
            public final /* synthetic */ void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, zzxvVar);
    }

    public final boolean zzb() {
        Spatializer spatializer = this.zza;
        spatializer.getClass();
        return spatializer.isAvailable();
    }

    public final boolean zzc() {
        Spatializer spatializer = this.zza;
        spatializer.getClass();
        return spatializer.isEnabled();
    }
}
