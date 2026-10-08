package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzazj extends zzazr {
    private final StackTraceElement[] zzh;

    public zzazj(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzaydVar, "ffEAQyBH71yR4B2obQT/Qgb3Fo0ajWwFYmmZt2nfIS2fjNh6ir76IWAmhSUkzxpD", "s+erUKEK0AKg0XrZCH85OEIt0v0u2CGPZAaj/S6Q0Yk=", zzaucVar, i, 45);
        this.zzh = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        StackTraceElement[] stackTraceElementArr = this.zzh;
        if (stackTraceElementArr != null) {
            zzaxu zzaxuVar = new zzaxu((String) this.zze.invoke(null, stackTraceElementArr));
            zzauc zzaucVar = this.zzd;
            synchronized (zzaucVar) {
                zzaucVar.zzC(zzaxuVar.zza.longValue());
                if (zzaxuVar.zzb.booleanValue()) {
                    zzaucVar.zzag(true != zzaxuVar.zzc.booleanValue() ? 2 : 1);
                } else {
                    zzaucVar.zzag(3);
                }
            }
        }
    }
}
