package com.google.android.recaptcha.internal;

import android.app.Application;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaz implements Function0 {
    public static final zzaz zza = new zzaz();

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws zzcg {
        int i = zzby.zza;
        Object objZzb = zzbx.zza().zzb(735120228);
        if (objZzb != null) {
            return (Application) objZzb;
        }
        throw new zzcg(zzce.zzb, zzcd.zzaA, null, null, 12, null);
    }
}
