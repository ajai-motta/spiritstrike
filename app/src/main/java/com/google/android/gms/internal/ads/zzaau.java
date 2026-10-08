package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaau implements zzbs {
    private final zzbq zza = new zzaat(false);

    public zzaau(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzbs
    public final zzbu zza(Context context, zzi zziVar, zzl zzlVar, zzbt zzbtVar, Executor executor, long j, boolean z) {
        Constructor<?> constructor;
        Object[] objArr;
        try {
            constructor = Class.forName("androidx.media3.effect.SingleInputVideoGraph$Factory").getConstructor(zzbq.class);
            objArr = new Object[1];
        } catch (Exception e) {
            e = e;
        }
        try {
            objArr[0] = this.zza;
            return ((zzbs) constructor.newInstance(objArr)).zza(context, zziVar, zzlVar, zzbtVar, executor, 0L, false);
        } catch (Exception e2) {
            e = e2;
            throw new IllegalStateException(e);
        }
    }
}
