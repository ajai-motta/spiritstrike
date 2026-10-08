package com.google.android.recaptcha.internal;

import com.google.android.play.core.integrity.StandardIntegrityManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbl implements Function0 {
    public static final zzbl zza = new zzbl();

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws zzcg {
        int i = zzby.zza;
        Object objZzb = zzbx.zza().zzb(-800379174);
        if (objZzb != null) {
            return (StandardIntegrityManager) objZzb;
        }
        throw new zzcg(zzce.zzb, zzcd.zzaA, null, null, 12, null);
    }
}
