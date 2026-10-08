package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdm extends Exception {
    private final Throwable zza;
    private final zzys zzb;
    private final int zzc;
    private final int zzd;

    public zzdm(int i, int i2, Throwable th) {
        this.zzc = i;
        this.zzd = i2;
        this.zza = th;
        zzys zzysVarZzf = zzyt.zzf();
        zzysVarZzf.zzq(i2);
        zzysVarZzf.zzr(i);
        this.zzb = zzysVarZzf;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.zza;
    }

    public final zzys zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzd;
    }
}
