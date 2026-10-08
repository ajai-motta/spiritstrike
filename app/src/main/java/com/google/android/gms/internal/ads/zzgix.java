package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgix implements AppOpsManager.OnOpActiveChangedListener {
    final /* synthetic */ zzgiz zza;

    zzgix(zzgiz zzgizVar) {
        Objects.requireNonNull(zzgizVar);
        this.zza = zzgizVar;
    }

    @Override // android.app.AppOpsManager.OnOpActiveChangedListener
    public final void onOpActiveChanged(String str, int i, String str2, boolean z) {
        zzgiz zzgizVar = this.zza;
        synchronized (zzgizVar) {
            if (z) {
                zzgizVar.zzg(System.currentTimeMillis());
                zzgizVar.zzj(true);
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (zzgizVar.zzh() > 0 && jCurrentTimeMillis >= zzgizVar.zzh()) {
                    zzgizVar.zzi(jCurrentTimeMillis - zzgizVar.zzh());
                }
                zzgizVar.zzj(false);
            }
        }
    }
}
