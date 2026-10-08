package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzery implements zzeya {
    private final zzgus zza;
    private final Context zzb;

    public zzery(zzgus zzgusVar, Context context) {
        this.zza = zzgusVar;
        this.zzb = context;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzerx
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 13;
    }

    final /* synthetic */ zzerz zzc() {
        int i;
        int streamMaxVolume;
        AudioManager audioManager = (AudioManager) this.zzb.getSystemService("audio");
        float fZzb = com.google.android.gms.ads.internal.zzt.zzi().zzb();
        boolean zZzd = com.google.android.gms.ads.internal.zzt.zzi().zzd();
        if (audioManager == null) {
            return new zzerz(-1, false, false, -1, -1, -1, -1, -1, fZzb, zZzd, true);
        }
        int mode = audioManager.getMode();
        boolean zIsMusicActive = audioManager.isMusicActive();
        boolean zIsSpeakerphoneOn = audioManager.isSpeakerphoneOn();
        int streamVolume = audioManager.getStreamVolume(3);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlY)).booleanValue()) {
            int iZzk = com.google.android.gms.ads.internal.zzt.zzf().zzk(audioManager);
            streamMaxVolume = audioManager.getStreamMaxVolume(3);
            i = iZzk;
        } else {
            i = -1;
            streamMaxVolume = -1;
        }
        return new zzerz(mode, zIsMusicActive, zIsSpeakerphoneOn, streamVolume, i, streamMaxVolume, audioManager.getRingerMode(), audioManager.getStreamVolume(2), fZzb, zZzd, false);
    }
}
