package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzdki implements zzblx {
    private final WeakReference zza;
    private final WeakReference zzb;

    /* synthetic */ zzdki(zzdkk zzdkkVar, View view, byte[] bArr) {
        this.zza = new WeakReference(zzdkkVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznV)).booleanValue()) {
            this.zzb = new WeakReference(view);
        } else {
            this.zzb = new WeakReference(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final void zza(Object obj, Map map) {
        zzdkk zzdkkVar = (zzdkk) this.zza.get();
        if (zzdkkVar == null) {
            return;
        }
        zzdkkVar.zzC().zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznV)).booleanValue()) {
            zzdkkVar.zzB((View) this.zzb.get());
        }
    }
}
