package com.google.android.gms.ads.interstitial;

import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzep;
import com.google.android.gms.ads.internal.client.zzex;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.preload.PreloadCallbackV2;
import com.google.android.gms.ads.preload.PreloadConfiguration;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class InterstitialAdPreloader {
    private InterstitialAdPreloader() {
    }

    public static boolean destroy(String str) {
        zzep zzepVarZza = zza();
        if (zzepVarZza == null) {
            return false;
        }
        return zzepVarZza.zzf(str);
    }

    public static void destroyAll() {
        zzep zzepVarZza = zza();
        if (zzepVarZza != null) {
            zzepVarZza.zzg();
        }
    }

    public static PreloadConfiguration getConfiguration(String str) {
        zzep zzepVarZza = zza();
        if (zzepVarZza == null) {
            return null;
        }
        return zzepVarZza.zzi(str);
    }

    public static Map<String, PreloadConfiguration> getConfigurations() {
        zzep zzepVarZza = zza();
        return zzepVarZza == null ? new HashMap() : zzepVarZza.zzh();
    }

    public static int getNumAdsAvailable(String str) {
        zzep zzepVarZza = zza();
        if (zzepVarZza == null) {
            return 0;
        }
        return zzepVarZza.zze(str);
    }

    public static boolean isAdAvailable(String str) {
        zzep zzepVarZza = zza();
        if (zzepVarZza == null) {
            return false;
        }
        return zzepVarZza.zzd(str);
    }

    public static InterstitialAd pollAd(String str) {
        zzep zzepVarZza = zza();
        if (zzepVarZza == null) {
            return null;
        }
        return zzepVarZza.zza(str);
    }

    public static boolean start(String str, PreloadConfiguration preloadConfiguration) {
        zzep zzepVarZza = zza();
        if (zzepVarZza == null) {
            return false;
        }
        return zzepVarZza.zzc(str, preloadConfiguration);
    }

    private static zzep zza() {
        zzep zzepVar = (zzep) zzex.zzb().zza(AdFormat.INTERSTITIAL);
        if (zzepVar == null) {
            zzo.zzi("Failed to get a preloader. Call MobileAds.initialize() prior to calling preload APIs.");
        }
        return zzepVar;
    }

    public static boolean start(String str, PreloadConfiguration preloadConfiguration, PreloadCallbackV2 preloadCallbackV2) {
        zzep zzepVarZza = zza();
        if (zzepVarZza == null) {
            return false;
        }
        return zzepVarZza.zzb(str, preloadConfiguration, preloadCallbackV2);
    }
}
