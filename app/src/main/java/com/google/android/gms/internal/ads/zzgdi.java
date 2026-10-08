package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgdi extends zzgdh {
    private final Map zza;
    private final zzfyq zzb;

    zzgdi(zzauc zzaucVar, zzgcd zzgcdVar, zzfyq zzfyqVar, Map map, zzgjd zzgjdVar) {
        super("lJ67yAwBUtoZhasVqN11g6g6opAmTxjVxzUKxhl0fOhTr4nQH4cVWV7NJy0RD49z", "0isRm8IoYsyXMQyBCJPbREn4r5FwCMP2Q3k9zoXRqyk=", zzaucVar, zzgcdVar, zzgjdVar.zza(122));
        this.zza = map;
        this.zzb = zzfyqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdh
    protected final void zza(Method method, zzauc zzaucVar) throws IllegalAccessException, InvocationTargetException {
        Long[] lArr = new Long[9];
        Arrays.fill((Object[]) lArr, (Object) (-1L));
        Map map = this.zza;
        lArr[0] = (Long) zzgma.zza((Long) map.get("tcq"), -1L);
        lArr[1] = (Long) zzgma.zza((Long) map.get("tpq"), -1L);
        lArr[2] = (Long) zzgma.zza((Long) map.get("tcv"), -1L);
        lArr[3] = (Long) zzgma.zza((Long) map.get("tpv"), -1L);
        lArr[4] = (Long) zzgma.zza((Long) map.get("tchv"), -1L);
        lArr[5] = (Long) zzgma.zza((Long) map.get("tphv"), -1L);
        lArr[6] = (Long) zzgma.zza((Long) map.get("tcc"), -1L);
        lArr[7] = (Long) zzgma.zza((Long) map.get("tpc"), -1L);
        lArr[8] = (Long) zzgma.zza((Long) map.get("tst"), -1L);
        for (int i = 0; i < 9; i++) {
            if (lArr[i] == null) {
                lArr[i] = -1L;
            }
        }
        Long[] lArr2 = (Long[]) method.invoke("", lArr, Integer.valueOf(this.zzb.ordinal()));
        lArr2.getClass();
        Long[] lArr3 = lArr2;
        synchronized (zzaucVar) {
            zzaucVar.zzac(lArr3[0].longValue());
            zzaucVar.zzs(lArr3[1].longValue());
            zzaucVar.zzn(lArr3[2].longValue());
            zzaucVar.zzk(lArr3[3].longValue());
            zzaucVar.zzY(lArr3[4].longValue());
            zzaucVar.zzZ(lArr3[5].longValue());
            zzaucVar.zzF(lArr3[6].longValue());
            zzaucVar.zzG(lArr3[7].longValue());
        }
    }
}
