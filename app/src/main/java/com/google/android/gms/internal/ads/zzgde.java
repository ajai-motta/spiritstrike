package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgde extends zzgdh {
    private static final Long zza = -1L;
    private final zzfyq zzb;
    private final Context zzc;
    private final Map zzd;

    zzgde(zzauc zzaucVar, zzgcd zzgcdVar, zzfyq zzfyqVar, Context context, Map map, zzgjd zzgjdVar) {
        super("3U4DEAJT9Pq66npH/ZEsiPizUaU6oaGuzbq27Rp3Iz/R6ssq6OsViFqc+1XsG+SQ", "oHImj5OTIs8LNvX9EwNQkQ3bSJ9XioOM1m8VTLsnF8I=", zzaucVar, zzgcdVar, zzgjdVar.zza(121));
        this.zzb = zzfyqVar;
        this.zzc = context;
        this.zzd = map;
    }

    @Override // com.google.android.gms.internal.ads.zzgdh
    protected final void zza(Method method, zzauc zzaucVar) throws IllegalAccessException, InvocationTargetException {
        zzfyq zzfyqVar = this.zzb;
        Object[] objArr = (Object[]) method.invoke("", Integer.valueOf(zzfyqVar.ordinal()), this.zzc, zzgma.zza(this.zzd.get("up"), true));
        objArr.getClass();
        Object[] objArr2 = objArr;
        synchronized (zzaucVar) {
            if (zzfyqVar == zzfyq.QUERY) {
                Object obj = objArr2[0];
                Long l = zza;
                zzaucVar.zzq(((Long) zzgma.zza(obj, l)).longValue());
                zzaucVar.zzr(((Long) zzgma.zza(objArr2[1], l)).longValue());
            }
            zzaucVar.zzg(((Long) objArr2[2]).longValue());
            zzaucVar.zzQ(((Long) objArr2[3]).longValue());
        }
    }
}
