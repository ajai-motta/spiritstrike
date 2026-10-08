package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgcu extends zzgdh {
    private final zzfxt zza;

    zzgcu(zzauc zzaucVar, zzgcd zzgcdVar, zzfxt zzfxtVar, zzgjd zzgjdVar) {
        super("By5K9EmVfikEcCFMOZQd1jxZLLuKkdFWcNBLbmtQ/cGwaIFZzYRhON9QKnCD3h+X", "jO4sZLvDsqH0XT1pMychedS7fP8lDaqZlRwqYI2S90Y=", zzaucVar, zzgcdVar, zzgjdVar.zza(116));
        this.zza = zzfxtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdh
    protected final void zza(Method method, zzauc zzaucVar) throws IllegalAccessException, InvocationTargetException {
        Object[] objArr = (Object[]) method.invoke("", this.zza.zzb());
        objArr.getClass();
        Object[] objArr2 = objArr;
        synchronized (zzaucVar) {
            zzaucVar.zzb((String) objArr2[0]);
            zzaucVar.zzaa((String) objArr2[1]);
        }
    }
}
