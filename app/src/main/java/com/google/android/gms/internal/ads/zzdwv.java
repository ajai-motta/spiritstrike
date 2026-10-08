package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdwv {
    private final zzbmx zza;

    zzdwv(zzbmx zzbmxVar) {
        this.zza = zzbmxVar;
    }

    private final void zzs(zzdwu zzdwuVar) throws RemoteException {
        String strZza = zzdwuVar.zza();
        String strConcat = "Dispatching AFMA event on publisher webview: ".concat(strZza);
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh(strConcat);
        this.zza.zzb(strZza);
    }

    public final void zza() throws RemoteException {
        zzs(new zzdwu(MobileAdsBridgeBase.initializeMethodName, null));
    }

    public final void zzb(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("creation", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("nativeObjectCreated");
        zzs(zzdwuVar);
    }

    public final void zzc(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("creation", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("nativeObjectNotCreated");
        zzs(zzdwuVar);
    }

    public final void zzd(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu(ReportUtil.INVENTORY_TYPE_INTERSTITIAL, null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onNativeAdObjectNotAvailable");
        zzs(zzdwuVar);
    }

    public final void zze(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu(ReportUtil.INVENTORY_TYPE_INTERSTITIAL, null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onAdLoaded");
        zzs(zzdwuVar);
    }

    public final void zzf(long j, int i) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu(ReportUtil.INVENTORY_TYPE_INTERSTITIAL, null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onAdFailedToLoad");
        zzdwuVar.zzd(Integer.valueOf(i));
        zzs(zzdwuVar);
    }

    public final void zzg(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu(ReportUtil.INVENTORY_TYPE_INTERSTITIAL, null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onAdOpened");
        zzs(zzdwuVar);
    }

    public final void zzh(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu(ReportUtil.INVENTORY_TYPE_INTERSTITIAL, null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onAdClicked");
        this.zza.zzb(zzdwuVar.zza());
    }

    public final void zzi(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu(ReportUtil.INVENTORY_TYPE_INTERSTITIAL, null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onAdClosed");
        zzs(zzdwuVar);
    }

    public final void zzj(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("rewarded", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onNativeAdObjectNotAvailable");
        zzs(zzdwuVar);
    }

    public final void zzk(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("rewarded", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onRewardedAdLoaded");
        zzs(zzdwuVar);
    }

    public final void zzl(long j, int i) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("rewarded", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onRewardedAdFailedToLoad");
        zzdwuVar.zzd(Integer.valueOf(i));
        zzs(zzdwuVar);
    }

    public final void zzm(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("rewarded", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onRewardedAdOpened");
        zzs(zzdwuVar);
    }

    public final void zzn(long j, int i) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("rewarded", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onRewardedAdFailedToShow");
        zzdwuVar.zzd(Integer.valueOf(i));
        zzs(zzdwuVar);
    }

    public final void zzo(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("rewarded", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onRewardedAdClosed");
        zzs(zzdwuVar);
    }

    public final void zzp(long j, zzbyl zzbylVar) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("rewarded", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onUserEarnedReward");
        zzdwuVar.zze(zzbylVar.zze());
        zzdwuVar.zzf(Integer.valueOf(zzbylVar.zzf()));
        zzs(zzdwuVar);
    }

    public final void zzq(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("rewarded", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onAdImpression");
        zzs(zzdwuVar);
    }

    public final void zzr(long j) throws RemoteException {
        zzdwu zzdwuVar = new zzdwu("rewarded", null);
        zzdwuVar.zzb(Long.valueOf(j));
        zzdwuVar.zzc("onAdClicked");
        zzs(zzdwuVar);
    }
}
