package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@ParametersAreNonnullByDefault
@Deprecated
public final class zzbfh {
    private final Map zza = new HashMap();
    private final zzbfj zzb;

    public zzbfh(zzbfj zzbfjVar) {
        this.zzb = zzbfjVar;
    }

    public final void zza(String str, zzbfg zzbfgVar) {
        this.zza.put(str, zzbfgVar);
    }

    public final void zzb(String str, String str2, long j) {
        Map map = this.zza;
        zzbfg zzbfgVar = (zzbfg) map.get(str2);
        String[] strArr = {str};
        if (zzbfgVar != null) {
            this.zzb.zzb(zzbfgVar, j, strArr);
        }
        map.put(str, new zzbfg(j, null, null));
    }

    public final zzbfj zzc() {
        return this.zzb;
    }
}
