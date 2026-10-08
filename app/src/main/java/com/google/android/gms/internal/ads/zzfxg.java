package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfxg implements zzifh {
    private final zzifq zza;

    private zzfxg(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzfxg zza(zzifq zzifqVar) {
        return new zzfxg(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        File dir = ((Context) this.zza.zzb()).getDir("yqzdkcache", 0);
        zzifp.zzb(dir);
        return dir;
    }
}
