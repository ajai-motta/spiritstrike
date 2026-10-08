package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzwy extends zzacf implements zzadm {
    public static final zzace zza;
    private static final zzwy zzd;

    static {
        zzwy zzwyVar = new zzwy();
        zzd = zzwyVar;
        zzacf.zzao(zzwy.class, zzwyVar);
        zza = zzacf.zzab(zzxd.zzc(), null, null, 330, zzaex.INT32, false, Integer.class);
    }

    private zzwy() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        zzxe zzxeVar = null;
        if (i2 == 2) {
            return zzal(zzd, "\u0001\u0000", null);
        }
        if (i2 == 3) {
            return new zzwy();
        }
        if (i2 == 4) {
            return new zzwx(zzxeVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        throw null;
    }
}
