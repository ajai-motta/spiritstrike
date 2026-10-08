package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaqy implements zzaqp {
    final /* synthetic */ Context zza;
    private File zzb = null;

    zzaqy(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaqp
    public final File zza() {
        if (this.zzb == null) {
            this.zzb = new File(this.zza.getCacheDir(), "volley");
        }
        return this.zzb;
    }
}
