package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgcs extends zzgdh {
    private final Context zza;

    zzgcs(zzauc zzaucVar, zzgcd zzgcdVar, Context context, zzgjd zzgjdVar) {
        super("BhNDAdNbKVCXLou3UwS6SQycA6O/T9ZMbr2NWffNFtsRs3WScUuYHsaYRJ0jHvCA", "oaC5CLMjwUmi/i48MFPdrATPzdM8HcSPBi81Io4IqyU=", zzaucVar, zzgcdVar, zzgjdVar.zza(115));
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzgdh
    protected final void zza(Method method, zzauc zzaucVar) throws IllegalAccessException, InvocationTargetException {
        int i = 1;
        Object[] objArr = (Object[]) method.invoke("", this.zza);
        objArr.getClass();
        Object[] objArr2 = objArr;
        synchronized (zzaucVar) {
            zzaucVar.zzO(((Integer) objArr2[0]).intValue());
            zzaucVar.zzd(((Integer) objArr2[1]).intValue());
            zzaucVar.zze(((Integer) objArr2[2]).intValue());
            zzaucVar.zzab(((Integer) objArr2[3]).intValue());
            Boolean bool = (Boolean) objArr2[4];
            if (bool == null) {
                zzaucVar.zzaf(3);
            } else {
                zzaucVar.zzaf(true != bool.booleanValue() ? 1 : 2);
            }
            Boolean bool2 = (Boolean) objArr2[5];
            if (bool2 == null) {
                zzaucVar.zzae(3);
            } else {
                if (true == bool2.booleanValue()) {
                    i = 2;
                }
                zzaucVar.zzae(i);
            }
        }
    }
}
