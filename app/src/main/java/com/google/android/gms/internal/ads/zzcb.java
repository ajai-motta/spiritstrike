package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcb {
    private static AudioManager zza;

    public static synchronized AudioManager zza(Context context) {
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            zza = null;
        }
        AudioManager audioManager = zza;
        if (audioManager != null) {
            return audioManager;
        }
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null && looperMyLooper != Looper.getMainLooper()) {
            final zzdf zzdfVar = new zzdf(zzdc.zza);
            zzcw.zza().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzca
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzcb.zzd(applicationContext, zzdfVar);
                }
            });
            zzdfVar.zzd();
            AudioManager audioManager2 = zza;
            audioManager2.getClass();
            return audioManager2;
        }
        AudioManager audioManager3 = (AudioManager) applicationContext.getSystemService("audio");
        zza = audioManager3;
        audioManager3.getClass();
        return audioManager3;
    }

    public static int zzb(AudioManager audioManager, zzbz zzbzVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            return audioManager.requestAudioFocus(zzbzVar.zzc());
        }
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListenerZzb = zzbzVar.zzb();
        zzbzVar.zza();
        return audioManager.requestAudioFocus(onAudioFocusChangeListenerZzb, 3, 1);
    }

    public static int zzc(AudioManager audioManager, zzbz zzbzVar) {
        return Build.VERSION.SDK_INT >= 26 ? audioManager.abandonAudioFocusRequest(zzbzVar.zzc()) : audioManager.abandonAudioFocus(zzbzVar.zzb());
    }

    static /* synthetic */ void zzd(Context context, zzdf zzdfVar) {
        zza = (AudioManager) context.getSystemService("audio");
        zzdfVar.zza();
    }
}
