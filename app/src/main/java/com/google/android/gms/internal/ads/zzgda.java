package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgda extends zzgdh {
    private final Context zza;

    zzgda(zzauc zzaucVar, zzgcd zzgcdVar, Context context, zzgjd zzgjdVar) {
        super("fPyGoeDuTUuDJV03GsNFpCGRO2J3Ui8HA6QvnuqOeQaxvLcgOY5Y2sf90BXpAioC", "znAIQ1vWTnsSA3nf0QmMCBs/bj4g6mmUyXonbfu9VUs=", zzaucVar, zzgcdVar, zzgjdVar.zza(119));
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzgdh
    protected final void zza(Method method, zzauc zzaucVar) throws IllegalAccessException, InvocationTargetException {
        Object[] objArr = (Object[]) method.invoke("", this.zza);
        objArr.getClass();
        Object[] objArr2 = objArr;
        synchronized (zzaucVar) {
            zzaucVar.zzc(((Long) objArr2[0]).longValue());
            zzaucVar.zzP(((Long) objArr2[1]).longValue());
        }
    }
}
