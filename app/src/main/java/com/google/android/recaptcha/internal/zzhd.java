package com.google.android.recaptcha.internal;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhd {
    public static final zzww zza(zzcs zzcsVar, zzcs zzcsVar2) {
        zzwu zzwuVarZzf = zzww.zzf();
        zzwuVarZzf.zzq(zzvl.zzb(zzcsVar.zzb()));
        zzwuVarZzf.zzr(zzvj.zza(zzcsVar.zza(TimeUnit.NANOSECONDS)));
        zzwuVarZzf.zze(zzvl.zzb(zzcsVar2.zzb()));
        zzwuVarZzf.zzf(zzvj.zza(zzcsVar2.zza(TimeUnit.NANOSECONDS)));
        return (zzww) zzwuVarZzf.zzk();
    }
}
