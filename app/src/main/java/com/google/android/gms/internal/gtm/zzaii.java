package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaii extends zzacc implements zzadm {
    private static final zzaii zzd;
    private byte zze = 2;

    static {
        zzaii zzaiiVar = new zzaii();
        zzd = zzaiiVar;
        zzacf.zzao(zzaii.class, zzaiiVar);
    }

    private zzaii() {
    }

    public static zzaii zze() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zze);
        }
        zzaih zzaihVar = null;
        if (i2 == 2) {
            return zzal(zzd, "\u0003\u0000", null);
        }
        if (i2 == 3) {
            return new zzaii();
        }
        if (i2 == 4) {
            return new zzaig(zzaihVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zze = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
