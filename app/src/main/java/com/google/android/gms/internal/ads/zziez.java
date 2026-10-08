package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zziez {
    public static zziez zzb(Class cls) {
        return System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik") ? new zzieu(cls.getSimpleName()) : new zziew(cls.getSimpleName());
    }

    public abstract void zza(String str);
}
