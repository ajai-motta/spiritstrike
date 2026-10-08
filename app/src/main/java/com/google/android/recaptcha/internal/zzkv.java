package com.google.android.recaptcha.internal;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkv implements zzkt {
    private final zzku zza;

    public zzkv(zzku zzkuVar, zzks zzksVar) {
        this.zza = zzkuVar;
    }

    private final zzzo zzb(String str, List list) throws zzdm {
        String str2 = str;
        if (str2.length() == 0) {
            throw new zzdm(3, 17, null);
        }
        try {
            zzkr zzkrVar = new zzkr(this.zza.zza(CollectionsKt.toLongArray(list)), 255L, zzkr.zza);
            StringBuilder sb = new StringBuilder(str.length());
            for (int i = 0; i < str2.length(); i++) {
                sb.append((char) UInt.m7514constructorimpl(UInt.m7514constructorimpl(str2.charAt(i)) ^ UInt.m7514constructorimpl((int) zzkrVar.zza())));
            }
            return zzzo.zzg(zzpp.zzh().zzj(sb.toString()));
        } catch (Exception e) {
            throw new zzdm(3, 18, e);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzkt
    public final zzzo zza(zzzq zzzqVar) throws zzdm {
        zzmf zzmfVarZzb = zzmf.zzb();
        zzzo zzzoVarZzb = zzb(zzzqVar.zzj(), zzzqVar.zzk());
        zzmfVarZzb.zzf();
        long jZza = zzmfVarZzb.zza(TimeUnit.MICROSECONDS);
        int i = zzco.zza;
        zzco.zza(zzcp.zza.zza(), jZza);
        return zzzoVarZzb;
    }
}
