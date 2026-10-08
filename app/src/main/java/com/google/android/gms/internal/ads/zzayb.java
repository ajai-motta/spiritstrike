package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzayb implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzayd zzb;

    zzayb(zzayd zzaydVar, int i, boolean z) {
        this.zza = i;
        Objects.requireNonNull(zzaydVar);
        this.zzb = zzaydVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzauz zzauzVarZza;
        int i = this.zza;
        zzayd zzaydVar = this.zzb;
        if (i > 0) {
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException unused) {
            }
        }
        try {
            Context context = zzaydVar.zza;
            zzauzVarZza = zzfrz.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
        } catch (Throwable unused2) {
            zzauzVarZza = null;
        }
        zzayd zzaydVar2 = this.zzb;
        zzaydVar2.zzs(zzauzVarZza);
        int i2 = this.zza;
        if (i2 < 4) {
            if (zzauzVarZza != null && zzauzVarZza.zza() && !zzauzVarZza.zzb().equals("0000000000000000000000000000000000000000000000000000000000000000") && zzauzVarZza.zzg() && zzauzVarZza.zzh().zza() && zzauzVarZza.zzh().zzb() != -2) {
                return;
            }
            zzaydVar2.zzp(i2 + 1, true);
        }
    }
}
