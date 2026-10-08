package com.google.android.recaptcha.internal;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public class zzmx {
    private final String zza;
    private final Class zzb;
    private final boolean zzc;

    protected zzmx(String str, Class cls, boolean z) {
        this(str, cls, z, true);
    }

    public static zzmx zza(String str, Class cls) {
        return new zzmx(str, cls, false, false);
    }

    public final String toString() {
        Class cls = this.zzb;
        return getClass().getName() + DomExceptionUtils.SEPARATOR + this.zza + "[" + cls.getName() + "]";
    }

    public final boolean zzb() {
        return this.zzc;
    }

    private zzmx(String str, Class cls, boolean z, boolean z2) {
        zzot.zzb(str);
        this.zza = str;
        this.zzb = cls;
        this.zzc = z;
        System.identityHashCode(this);
        for (int i = 0; i < 5; i++) {
        }
    }
}
