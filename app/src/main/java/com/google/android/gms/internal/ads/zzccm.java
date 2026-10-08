package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzccm implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzccv zzb;

    zzccm(zzccv zzccvVar, MediaPlayer mediaPlayer) {
        this.zza = mediaPlayer;
        Objects.requireNonNull(zzccvVar);
        this.zzb = zzccvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzccv zzccvVar = this.zzb;
        zzccvVar.zzs(this.zza);
        if (zzccvVar.zzt() != null) {
            zzccvVar.zzt().zzb();
        }
    }
}
