package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcxs {
    private final zzfks zza;
    private final VersionInfoParcel zzb;
    private final ApplicationInfo zzc;
    private final String zzd;
    private final List zze;
    private final PackageInfo zzf;
    private final zzifb zzg;
    private final String zzh;
    private final zzeyd zzi;
    private final com.google.android.gms.ads.internal.util.zzg zzj;
    private final zzfgn zzk;
    private final int zzl;
    private final zzdeh zzm;

    zzcxs(zzfks zzfksVar, VersionInfoParcel versionInfoParcel, ApplicationInfo applicationInfo, String str, List list, PackageInfo packageInfo, zzifb zzifbVar, com.google.android.gms.ads.internal.util.zzg zzgVar, String str2, zzeyd zzeydVar, zzfgn zzfgnVar, zzdeh zzdehVar, int i) {
        this.zza = zzfksVar;
        this.zzb = versionInfoParcel;
        this.zzc = applicationInfo;
        this.zzd = str;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = zzifbVar;
        this.zzh = str2;
        this.zzi = zzeydVar;
        this.zzj = zzgVar;
        this.zzk = zzfgnVar;
        this.zzm = zzdehVar;
        this.zzl = i;
    }

    public final ListenableFuture zza(Bundle bundle) {
        this.zzm.zza();
        zzfkm zzfkmVar = zzfkm.SIGNALS;
        zzfks zzfksVar = this.zza;
        Objects.requireNonNull(zzfksVar);
        return zzfkd.zza(this.zzi.zza(new zzcxq(new Bundle(), new Bundle()), bundle, this.zzl == 2), zzfkmVar, zzfksVar).zzi();
    }

    public final ListenableFuture zzb() {
        final Bundle bundle = new Bundle();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcv)).booleanValue()) {
            Bundle bundle2 = this.zzk.zzt;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            bundle.putBoolean("ls", false);
        }
        final ListenableFuture listenableFutureZza = zza(bundle);
        return this.zza.zzb(zzfkm.REQUEST_PARCEL, listenableFutureZza, (ListenableFuture) this.zzg.zzb()).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzcxr
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc(listenableFutureZza, bundle);
            }
        }).zzi();
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ zzbxj zzc(ListenableFuture listenableFuture, Bundle bundle) {
        zzcxq zzcxqVar = (zzcxq) listenableFuture.get();
        Bundle bundle2 = zzcxqVar.zza;
        String str = (String) ((ListenableFuture) this.zzg.zzb()).get();
        boolean z = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhA)).booleanValue() && this.zzj.zzx();
        String str2 = this.zzh;
        PackageInfo packageInfo = this.zzf;
        List list = this.zze;
        return new zzbxj(bundle2, this.zzb, this.zzc, this.zzd, list, packageInfo, str, str2, null, null, z, this.zzk.zza(), bundle, zzcxqVar.zzb, this.zzl);
    }
}
