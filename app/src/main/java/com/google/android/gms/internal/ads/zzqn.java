package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.os.Build;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzqn {
    private final Context zza;
    private Boolean zzb;

    public zzqn() {
        this(null);
    }

    public zzqn(Context context) {
        this.zza = context == null ? null : context.getApplicationContext();
    }

    public final zzpl zza(zzv zzvVar, zzd zzdVar) {
        int i;
        boolean zBooleanValue;
        zzvVar.getClass();
        zzdVar.getClass();
        if (Build.VERSION.SDK_INT < 29 || (i = zzvVar.zzH) == -1) {
            return zzpl.zza;
        }
        Context context = this.zza;
        Boolean bool = this.zzb;
        boolean z = false;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            if (context != null) {
                String parameters = zzcb.zza(context).getParameters("offloadVariableRateSupported");
                this.zzb = Boolean.valueOf(parameters != null && parameters.equals("offloadVariableRateSupported=1"));
            } else {
                this.zzb = false;
            }
            zBooleanValue = this.zzb.booleanValue();
        }
        String str = zzvVar.zzo;
        str.getClass();
        int iZzh = zzas.zzh(str, zzvVar.zzk);
        if (iZzh == 0 || Build.VERSION.SDK_INT < zzep.zzD(iZzh)) {
            return zzpl.zza;
        }
        int iZzB = zzep.zzB(zzvVar.zzG);
        if (iZzB == 0) {
            return zzpl.zza;
        }
        try {
            AudioFormat audioFormatZzC = zzep.zzC(i, iZzB, iZzh);
            if (Build.VERSION.SDK_INT < 31) {
                if (!AudioManager.isOffloadedPlaybackSupported(audioFormatZzC, zzdVar.zza())) {
                    return zzpl.zza;
                }
                zzpk zzpkVar = new zzpk();
                zzpkVar.zza(true);
                zzpkVar.zzc(zBooleanValue);
                return zzpkVar.zzd();
            }
            int playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormatZzC, zzdVar.zza());
            if (playbackOffloadSupport == 0) {
                return zzpl.zza;
            }
            zzpk zzpkVar2 = new zzpk();
            if (Build.VERSION.SDK_INT > 32 && playbackOffloadSupport == 2) {
                z = true;
            }
            zzpkVar2.zza(true);
            zzpkVar2.zzb(z);
            zzpkVar2.zzc(zBooleanValue);
            return zzpkVar2.zzd();
        } catch (IllegalArgumentException unused) {
            return zzpl.zza;
        }
    }
}
