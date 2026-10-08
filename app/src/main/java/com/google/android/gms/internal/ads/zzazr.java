package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzazr implements Callable {
    protected final zzayd zza;
    protected final String zzb;
    protected final String zzc;
    protected final zzauc zzd;
    protected Method zze;
    protected final int zzf;
    protected final int zzg;

    public zzazr(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i, int i2) {
        getClass().getSimpleName();
        this.zza = zzaydVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzaucVar;
        this.zzf = i;
        this.zzg = i2;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        int i;
        try {
            long jNanoTime = System.nanoTime();
            zzayd zzaydVar = this.zza;
            Method methodZzo = zzaydVar.zzo(this.zzb, this.zzc);
            this.zze = methodZzo;
            if (methodZzo == null) {
                return null;
            }
            zza();
            zzawu zzawuVarZzh = zzaydVar.zzh();
            if (zzawuVarZzh == null || (i = this.zzf) == Integer.MIN_VALUE) {
                return null;
            }
            zzawuVarZzh.zza(this.zzg, i, (System.nanoTime() - jNanoTime) / 1000, null, null);
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected abstract void zza() throws IllegalAccessException, InvocationTargetException;
}
