package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzayo extends zzazr {
    public zzayo(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i, int i2) {
        super(zzaydVar, "zPJzhz1QtGvdwoq8b/etTeYWv9LDeLRPadnOSNl7lohby1/0Z3YfZB4nvs0ev2QM", "fVJK5Q/FtQnQT4sQUZztmOn3k4N5bqyd4pz/QTy2bEo=", zzaucVar, i, 89);
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        String str = (String) this.zze.invoke(null, new Object[0]);
        zzauc zzaucVar = this.zzd;
        synchronized (zzaucVar) {
            zzaucVar.zzaa(str);
        }
    }
}
