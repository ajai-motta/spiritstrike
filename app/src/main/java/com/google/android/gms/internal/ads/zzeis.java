package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzeis extends zzbsv {
    final /* synthetic */ zzeit zza;
    private final zzehn zzb;

    /* synthetic */ zzeis(zzeit zzeitVar, zzehn zzehnVar, byte[] bArr) {
        Objects.requireNonNull(zzeitVar);
        this.zza = zzeitVar;
        this.zzb = zzehnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsw
    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zza.zzd((View) ObjectWrapper.unwrap(iObjectWrapper));
        ((zzeiz) this.zzb.zzc).zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbsw
    public final void zzf(String str) throws RemoteException {
        ((zzeiz) this.zzb.zzc).zzw(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbsw
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzeiz) this.zzb.zzc).zzx(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbsw
    public final void zzh(zzbrs zzbrsVar) throws RemoteException {
        this.zza.zze(zzbrsVar);
        ((zzeiz) this.zzb.zzc).zzj();
    }
}
