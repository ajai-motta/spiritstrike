package com.google.android.gms.internal.ads;

import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzavv implements PackageManager.OnChecksumsReadyListener {
    final zzgvb zza = zzgvb.zze();

    @Override // android.content.pm.PackageManager.OnChecksumsReadyListener
    public final void onChecksumsReady(List list) {
        int size;
        int i;
        if (list == null) {
            this.zza.zza("");
            return;
        }
        try {
            size = list.size();
        } catch (Throwable unused) {
        }
        for (i = 0; i < size; i++) {
            ApkChecksum apkChecksum = (ApkChecksum) list.get(i);
            if (apkChecksum.getType() == 8) {
                zzgvb zzgvbVar = this.zza;
                zzgrz zzgrzVarZzi = zzgrz.zzn().zzi();
                byte[] value = apkChecksum.getValue();
                zzgvbVar.zza(zzgrzVarZzi.zzj(value, 0, value.length));
                return;
            }
            this.zza.zza("");
        }
        this.zza.zza("");
    }
}
