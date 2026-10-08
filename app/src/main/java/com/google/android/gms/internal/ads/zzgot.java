package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzgot {
    private static final zzgot zza = new zzgor();
    private static final zzgot zzb = new zzgos(-1);
    private static final zzgot zzc = new zzgos(1);

    /* synthetic */ zzgot(byte[] bArr) {
    }

    public static zzgot zzg() {
        return zza;
    }

    public abstract zzgot zza(Object obj, Object obj2, Comparator comparator);

    public abstract zzgot zzb(int i, int i2);

    public abstract zzgot zzc(boolean z, boolean z2);

    public abstract zzgot zzd(boolean z, boolean z2);

    public abstract int zze();
}
