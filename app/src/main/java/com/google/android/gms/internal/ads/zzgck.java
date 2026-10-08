package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgck extends zzgdh {
    private final Activity zza;
    private final View zzb;

    zzgck(zzauc zzaucVar, zzgcd zzgcdVar, View view, Activity activity, zzgjd zzgjdVar) {
        super("71irZxeyztMVPxtkZNjCXCWzc9uBzzqfxPgw1LkoaIGD1YWtoRaLj8ZtqyMHro2I", "sazFFsabItlse3qDY43b32ZnLCjQJ0+CJQYLaEeKmSw=", zzaucVar, zzgcdVar, zzgjdVar.zza(111));
        this.zzb = view;
        this.zza = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzgdh
    protected final void zza(Method method, zzauc zzaucVar) throws IllegalAccessException, InvocationTargetException {
        Object[] objArr = (Object[]) method.invoke("", this.zzb, this.zza);
        objArr.getClass();
        Object[] objArr2 = objArr;
        synchronized (zzaucVar) {
            zzaucVar.zzS(((Long) objArr2[0]).longValue());
            zzaucVar.zzT(((Long) objArr2[1]).longValue());
            zzaucVar.zzU((String) objArr2[2]);
        }
    }
}
