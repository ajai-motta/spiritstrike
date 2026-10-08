package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzfou {
    public static zzfou zze(zzfov zzfovVar, zzfow zzfowVar) {
        zzfqs.zza();
        return new zzfoy(zzfovVar, zzfowVar, UUID.randomUUID().toString());
    }

    public abstract void zza();

    public abstract void zzb(View view);

    public abstract void zzc();

    public abstract void zzd(View view, zzfpb zzfpbVar, String str);
}
