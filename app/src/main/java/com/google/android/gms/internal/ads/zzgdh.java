package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzgdh implements zzgdg {
    private final String zza;
    private final String zzb;
    private final zzgcd zzc;
    private final zzauc zzd;
    private final zzgjb zze;

    public zzgdh(String str, String str2, zzauc zzaucVar, zzgcd zzgcdVar, zzgjb zzgjbVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzd = zzaucVar;
        this.zzc = zzgcdVar;
        this.zze = zzgjbVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        try {
            this.zze.zza();
            Method methodZzc = this.zzc.zzc(this.zza, this.zzb);
            if (methodZzc != null) {
                zza(methodZzc, this.zzd);
            }
            this.zze.zzc();
            return null;
        } catch (Throwable th) {
            try {
                this.zze.zzb(th);
                throw th;
            } catch (Throwable th2) {
                this.zze.zzc();
                throw th2;
            }
        }
    }

    protected abstract void zza(Method method, zzauc zzaucVar) throws IllegalAccessException, InvocationTargetException;
}
