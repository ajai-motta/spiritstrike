package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzexy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzevb implements zzexy {
    private final Integer zza;

    public zzevb(Integer num) {
        this.zza = num;
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Integer num = this.zza;
        zzcxq zzcxqVar = (zzcxq) obj;
        if (num != null) {
            zzcxqVar.zza.putInt("dspct", Math.min(num.intValue(), 20));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public /* synthetic */ void zzb(Object obj) {
        zzexy.CC.$default$zzb(this, obj);
    }
}
