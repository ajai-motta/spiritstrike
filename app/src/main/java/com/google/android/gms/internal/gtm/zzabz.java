package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzabz implements zzadj {
    private static final zzabz zza = new zzabz();

    private zzabz() {
    }

    public static zzabz zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzadj
    public final zzadi zzb(Class cls) {
        if (!zzacf.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
        try {
            return (zzadi) zzacf.zzad(cls.asSubclass(zzacf.class)).zzb(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzadj
    public final boolean zzc(Class cls) {
        return zzacf.class.isAssignableFrom(cls);
    }
}
