package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfwz {
    private static zzfwz zzb;
    final zzfwv zza;

    private zzfwz(Context context) {
        this.zza = zzfwv.zza(context);
        zzfwu.zza(context);
    }

    public static final zzfwz zza(Context context) {
        zzfwz zzfwzVar;
        synchronized (zzfwz.class) {
            if (zzb == null) {
                zzb = new zzfwz(context);
            }
            zzfwzVar = zzb;
        }
        return zzfwzVar;
    }

    public final void zzb(zzfwt zzfwtVar) throws IOException {
        synchronized (zzfwz.class) {
            zzfwv zzfwvVar = this.zza;
            zzfwvVar.zzf("vendor_scoped_gpid_v2_id");
            zzfwvVar.zzf("vendor_scoped_gpid_v2_creation_time");
        }
    }
}
