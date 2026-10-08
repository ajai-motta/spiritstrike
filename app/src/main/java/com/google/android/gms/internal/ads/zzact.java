package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzact implements zzacu {
    static final /* synthetic */ zzact zza = new zzact();

    private /* synthetic */ zzact() {
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final /* synthetic */ Constructor zza() {
        int i = zzacw.zza;
        if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
            return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(zzada.class).getConstructor(Integer.TYPE);
        }
        return null;
    }
}
