package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzays extends zzazr {
    public zzays(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i, int i2) {
        super(zzaydVar, "0k0HoJtCvAtrnTz0UbiSqrs0BGKzSTMoo+ZxCfyJrLcMn8tbsvf/NG2/ui2bKbWP", "z6GzXqyR8kvBYJKVLhMc9mqmsbq6ZkNeWqgTkONnpqg=", zzaucVar, i, 5);
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzauc zzaucVar = this.zzd;
        zzaucVar.zzd(-1L);
        zzaucVar.zze(-1L);
        int[] iArr = (int[]) this.zze.invoke(null, this.zza.zzb());
        synchronized (zzaucVar) {
            zzaucVar.zzd(iArr[0]);
            zzaucVar.zze(iArr[1]);
            int i = iArr[2];
            if (i != Integer.MIN_VALUE) {
                zzaucVar.zzO(i);
            }
        }
    }
}
