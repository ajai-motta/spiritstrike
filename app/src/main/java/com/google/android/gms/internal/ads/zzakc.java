package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzakc {
    public static void zza(zzakd zzakdVar, zzakh zzakhVar, zzdg zzdgVar) {
        for (int i = 0; i < zzakdVar.zza(); i++) {
            long jZzb = zzakdVar.zzb(i);
            List listZzc = zzakdVar.zzc(jZzb);
            if (!listZzc.isEmpty()) {
                if (i == zzakdVar.zza() - 1) {
                    throw new IllegalStateException();
                }
                long jZzb2 = zzakdVar.zzb(i + 1) - zzakdVar.zzb(i);
                if (jZzb2 > 0) {
                    zzdgVar.zza(new zzaka(listZzc, jZzb, jZzb2));
                }
            }
        }
    }
}
