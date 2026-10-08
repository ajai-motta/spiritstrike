package com.google.android.gms.ads.rewarded;

import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzex;
import com.google.android.gms.ads.internal.client.zzfb;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.preload.PreloadCallbackV2;
import com.google.android.gms.ads.preload.PreloadConfiguration;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class RewardedAdPreloader {
    private RewardedAdPreloader() {
    }

    public static boolean destroy(String str) {
        zzfb zzfbVarZza = zza();
        if (zzfbVarZza == null) {
            return false;
        }
        return zzfbVarZza.zzf(str);
    }

    public static void destroyAll() {
        zzfb zzfbVarZza = zza();
        if (zzfbVarZza != null) {
            zzfbVarZza.zzg();
        }
    }

    public static PreloadConfiguration getConfiguration(String str) {
        zzfb zzfbVarZza = zza();
        if (zzfbVarZza == null) {
            return null;
        }
        return zzfbVarZza.zzi(str);
    }

    public static Map<String, PreloadConfiguration> getConfigurations() {
        zzfb zzfbVarZza = zza();
        return zzfbVarZza == null ? new HashMap() : zzfbVarZza.zzh();
    }

    public static int getNumAdsAvailable(String str) {
        zzfb zzfbVarZza = zza();
        if (zzfbVarZza == null) {
            return 0;
        }
        return zzfbVarZza.zze(str);
    }

    public static boolean isAdAvailable(String str) {
        zzfb zzfbVarZza = zza();
        if (zzfbVarZza == null) {
            return false;
        }
        return zzfbVarZza.zzd(str);
    }

    public static RewardedAd pollAd(String str) {
        zzfb zzfbVarZza = zza();
        if (zzfbVarZza == null) {
            return null;
        }
        return zzfbVarZza.zza(str);
    }

    public static boolean start(String str, PreloadConfiguration preloadConfiguration) {
        zzfb zzfbVarZza = zza();
        if (zzfbVarZza == null) {
            return false;
        }
        return zzfbVarZza.zzc(str, preloadConfiguration);
    }

    private static zzfb zza() {
        zzfb zzfbVar = (zzfb) zzex.zzb().zza(AdFormat.REWARDED);
        if (zzfbVar == null) {
            zzo.zzl("Failed to get a preloader. Call MobileAds.initialize() prior to calling preload APIs.", null);
        }
        return zzfbVar;
    }

    public static boolean start(String str, PreloadConfiguration preloadConfiguration, PreloadCallbackV2 preloadCallbackV2) {
        zzfb zzfbVarZza = zza();
        if (zzfbVarZza == null) {
            return false;
        }
        return zzfbVarZza.zzb(str, preloadConfiguration, preloadCallbackV2);
    }
}
