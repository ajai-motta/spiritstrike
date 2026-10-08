package com.google.android.gms.internal.ads;

import java.io.File;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzghd implements zzifh {
    private final zzifq zza;

    private zzghd(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzghd zza(zzifq zzifqVar) {
        return new zzghd(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new File(new File((File) this.zza.zzb(), "dgd"), "pcbc");
    }
}
