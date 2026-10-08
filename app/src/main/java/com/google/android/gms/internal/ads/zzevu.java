package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.internal.ads.zzexy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzevu implements zzexy {
    public final Bundle zza;

    public zzevu(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = ((zzcxq) obj).zza;
        Bundle bundleZza = zzfhc.zza(bundle, DeviceRequestsHelper.DEVICE_INFO_DEVICE);
        bundleZza.putBundle("android_mem_info", this.zza);
        bundle.putBundle(DeviceRequestsHelper.DEVICE_INFO_DEVICE, bundleZza);
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public /* synthetic */ void zzb(Object obj) {
        zzexy.CC.$default$zzb(this, obj);
    }
}
