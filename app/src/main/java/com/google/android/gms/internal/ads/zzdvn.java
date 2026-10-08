package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiParamDefaults;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiUrlBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdvn extends zzdvr {
    private final CsiParamDefaults zzf;

    public zzdvn(Executor executor, com.google.android.gms.ads.internal.util.client.zzu zzuVar, CsiParamDefaults csiParamDefaults, CsiUrlBuilder csiUrlBuilder, Context context) {
        super(executor, zzuVar, csiUrlBuilder, context);
        this.zzf = csiParamDefaults;
        csiParamDefaults.set(this.zza);
    }

    public final Map zza() {
        return new HashMap(this.zza);
    }
}
