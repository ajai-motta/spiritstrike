package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzayu extends zzazr {
    private final long zzh;

    public zzayu(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, long j, int i, int i2) {
        super(zzaydVar, "6Tbgi6IQESKZikJOpZcClcVJxza1rhAf3nfasZu/vDcTd3loITpTNbH23xjyLA5L", "g107GCb4k6+PXON8scRHoxvRnyAK9ZOpFHjKTWKkbXc=", zzaucVar, i, 25);
        this.zzh = j;
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        long jLongValue = ((Long) this.zze.invoke(null, new Object[0])).longValue();
        zzauc zzaucVar = this.zzd;
        synchronized (zzaucVar) {
            zzaucVar.zzac(jLongValue);
            long j = this.zzh;
            if (j != 0) {
                zzaucVar.zzk(jLongValue - j);
                zzaucVar.zzn(j);
            }
        }
    }
}
