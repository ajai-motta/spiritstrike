package com.google.android.gms.internal.gtm;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzui {
    private final String zza;
    private final Class zzb;
    private final boolean zzc;

    protected zzui(String str, Class cls, boolean z) {
        this(str, cls, z, true);
    }

    public static zzui zza(String str, Class cls) {
        return new zzui(str, cls, false, false);
    }

    public final String toString() {
        Class cls = this.zzb;
        return getClass().getName() + DomExceptionUtils.SEPARATOR + this.zza + "[" + cls.getName() + "]";
    }

    public final boolean zzb() {
        return this.zzc;
    }

    private zzui(String str, Class cls, boolean z, boolean z2) {
        zzwe.zzb(str);
        this.zza = str;
        this.zzb = cls;
        this.zzc = z;
        System.identityHashCode(this);
        for (int i = 0; i < 5; i++) {
        }
    }
}
