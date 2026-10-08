package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbrf;
import com.google.android.gms.internal.ads.zzbrj;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class LiteSdkInfo extends zzcx {
    public LiteSdkInfo(Context context) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public zzbrj getAdapterCreator() {
        return new zzbrf();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public zzfc getLiteSdkVersion() {
        return new zzfc(ModuleDescriptor.MODULE_VERSION, ModuleDescriptor.MODULE_VERSION, "24.7.0");
    }
}
