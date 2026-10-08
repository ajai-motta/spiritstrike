package com.google.android.recaptcha.internal;

import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzh {
    public static final zzcg zza(Exception exc, zzcg zzcgVar) {
        return exc instanceof TimeoutCancellationException ? new zzcg(zzce.zzb, zzcd.zzb, exc.getMessage(), null, 8, null) : exc instanceof zzcg ? (zzcg) exc : zzcgVar;
    }
}
