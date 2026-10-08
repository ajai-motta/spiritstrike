package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.facebook.internal.NativeProtocol;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzedc implements zzebo {
    final /* synthetic */ zzedf zza;

    zzedc(zzedf zzedfVar) {
        Objects.requireNonNull(zzedfVar);
        this.zza = zzedfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebo
    public final void zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoS)).booleanValue()) {
            zzdvh zzdvhVarZza = this.zza.zzd().zza();
            zzdvhVarZza.zzc(NativeProtocol.WEB_DIALOG_ACTION, "ptard");
            zzdvhVarZza.zzc("ptard", AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
            zzdvhVarZza.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebo
    public final void zzb(RemoteException remoteException) {
        this.zza.zzc();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoT)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(remoteException, "Preconnect Remote");
        }
    }
}
