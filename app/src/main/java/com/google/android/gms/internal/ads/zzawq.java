package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzawq implements zzfti {
    final /* synthetic */ zzfrn zza;

    zzawq(zzaws zzawsVar, zzfrn zzfrnVar) {
        this.zza = zzfrnVar;
        Objects.requireNonNull(zzawsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfti
    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
