package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhpo {
    static {
        int i = zzhlv.zza;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzhol.zzc();
        zzhop.zzc();
        zzhnj.zza(true);
        zzhpb.zza(true);
        zzhpn.zza(true);
        if (zzhcz.zza()) {
            return;
        }
        zzhnr.zza(true);
    }
}
