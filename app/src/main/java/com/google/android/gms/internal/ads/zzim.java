package com.google.android.gms.internal.ads;

import android.os.Build;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zzim extends zzbb {
    static {
        String str = zzep.zza;
        String strZza = zzglm.zza(Build.DEVICE);
        if (strZza.contains("emulator") || strZza.contains("emu64a") || strZza.contains("emu64x")) {
            return;
        }
        strZza.contains("generic");
    }

    void zzD(zzml zzmlVar);

    void zzE(zzml zzmlVar);

    int zzF();

    void zzG(zzuw zzuwVar);

    void zzH();
}
