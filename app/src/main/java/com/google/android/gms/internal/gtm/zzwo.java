package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzwo extends zzacf implements zzadm {
    private static final zzwo zza;
    private int zzd;
    private zzwr zze;
    private byte zzf = 2;

    static {
        zzwo zzwoVar = new zzwo();
        zza = zzwoVar;
        zzacf.zzao(zzwo.class, zzwoVar);
    }

    private zzwo() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzf);
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001ᐉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzwo();
        }
        zzwp zzwpVar = null;
        if (i2 == 4) {
            return new zzwn(zzwpVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzf = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
