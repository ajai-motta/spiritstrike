package com.google.android.recaptcha.internal;

import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhk {
    private final zzhh zza;
    private final String zzb = UUID.randomUUID().toString();

    public zzhk(zzhh zzhhVar) {
        this.zza = zzhhVar;
    }

    public final zzhh zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
