package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfwy extends zzfww {
    private static zzfwy zzd;

    private zzfwy(Context context) {
        super(context, "paidv2_id", "paidv2_creation_time", "PaidV2LifecycleImpl");
    }

    public static final zzfwy zzh(Context context) {
        zzfwy zzfwyVar;
        synchronized (zzfwy.class) {
            if (zzd == null) {
                zzd = new zzfwy(context);
            }
            zzfwyVar = zzd;
        }
        return zzfwyVar;
    }

    public final zzfwt zzi(long j, boolean z) throws IOException {
        synchronized (zzfwy.class) {
            if (this.zzc.zzc()) {
                return zza(null, null, j, z);
            }
            return new zzfwt();
        }
    }

    public final void zzj() throws IOException {
        synchronized (zzfwy.class) {
            if (zzg(false)) {
                zzc(false);
            }
        }
    }
}
