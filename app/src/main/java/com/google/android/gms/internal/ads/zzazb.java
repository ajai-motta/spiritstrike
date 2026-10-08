package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzazb extends zzazr {
    private final zzaxv zzh;

    public zzazb(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i, int i2, zzaxv zzaxvVar) {
        super(zzaydVar, "sl6J6ogR1CQFBNHXqYqYlsoHhQEQ3GzqykotbgjuxxtAslvwVDD28XhO/FGDcWNY", "etPaLFHhmzrmC9guV7/txSJ19uqkwWx/gSnrE4vBCvs=", zzaucVar, i, 94);
        this.zzh = zzaxvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        int iIntValue = ((Integer) this.zze.invoke(null, this.zzh.zzb())).intValue();
        zzauc zzaucVar = this.zzd;
        synchronized (zzaucVar) {
            zzaucVar.zzaj(zzauo.zza(iIntValue));
        }
    }
}
