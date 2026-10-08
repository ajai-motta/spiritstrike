package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzexy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzera implements zzexy {
    private final String zza;
    private final boolean zzb;

    public zzera(String str, boolean z) {
        this.zza = str;
        this.zzb = z;
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        String str = this.zza;
        zzcxq zzcxqVar = (zzcxq) obj;
        if (str != null) {
            Bundle bundleZza = zzfhc.zza(zzcxqVar.zza, "pii");
            bundleZza.putString("afai", str);
            bundleZza.putBoolean("is_afai_lat", this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public /* synthetic */ void zzb(Object obj) {
        zzexy.CC.$default$zzb(this, obj);
    }
}
