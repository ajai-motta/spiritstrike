package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfwu {
    private static zzfwu zzb;
    final zzfwv zza;

    private zzfwu(Context context) {
        this.zza = zzfwv.zza(context);
    }

    public static final zzfwu zza(Context context) {
        zzfwu zzfwuVar;
        synchronized (zzfwu.class) {
            if (zzb == null) {
                zzb = new zzfwu(context);
            }
            zzfwuVar = zzb;
        }
        return zzfwuVar;
    }

    public final void zzb(boolean z) throws IOException {
        synchronized (zzfwu.class) {
            zzfwv zzfwvVar = this.zza;
            zzfwvVar.zzb("paidv2_publisher_option", Boolean.valueOf(z));
            if (!z) {
                zzfwvVar.zzf("paidv2_creation_time");
                zzfwvVar.zzf("paidv2_id");
                zzfwvVar.zzf("vendor_scoped_gpid_v2_id");
                zzfwvVar.zzf("vendor_scoped_gpid_v2_creation_time");
            }
        }
    }

    public final boolean zzc() {
        boolean zZze;
        synchronized (zzfwu.class) {
            zZze = this.zza.zze("paidv2_publisher_option", true);
        }
        return zZze;
    }

    public final void zzd(boolean z) throws IOException {
        synchronized (zzfwu.class) {
            this.zza.zzb("paidv2_user_option", Boolean.valueOf(z));
        }
    }

    public final boolean zze() {
        boolean zZze;
        synchronized (zzfwu.class) {
            zZze = this.zza.zze("paidv2_user_option", true);
        }
        return zZze;
    }
}
