package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzrc extends zzacf implements zzadm {
    private static final zzrc zza;
    private int zzd;
    private long zze;
    private zzz zzf;
    private zzah zzg;
    private byte zzh = 2;

    static {
        zzrc zzrcVar = new zzrc();
        zza = zzrcVar;
        zzacf.zzao(zzrc.class, zzrcVar);
    }

    private zzrc() {
    }

    public static zzrb zze() {
        return (zzrb) zza.zzZ();
    }

    public static zzrc zzg(InputStream inputStream, zzabq zzabqVar) throws IOException {
        return (zzrc) zzacf.zzaf(zza, inputStream, zzabqVar);
    }

    static /* synthetic */ void zzh(zzrc zzrcVar, zzz zzzVar) {
        zzzVar.getClass();
        zzrcVar.zzf = zzzVar;
        zzrcVar.zzd |= 2;
    }

    static /* synthetic */ void zzi(zzrc zzrcVar, zzah zzahVar) {
        zzahVar.getClass();
        zzrcVar.zzg = zzahVar;
        zzrcVar.zzd |= 4;
    }

    static /* synthetic */ void zzj(zzrc zzrcVar, long j) {
        zzrcVar.zzd |= 1;
        zzrcVar.zze = j;
    }

    public final long zza() {
        return this.zze;
    }

    public final zzz zzc() {
        zzz zzzVar = this.zzf;
        return zzzVar == null ? zzz.zzk() : zzzVar;
    }

    public final zzah zzd() {
        zzah zzahVar = this.zzg;
        return zzahVar == null ? zzah.zzf() : zzahVar;
    }

    public final boolean zzk() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzl() {
        return (this.zzd & 4) != 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzal(zza, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔂ\u0000\u0002ᔉ\u0001\u0003ᐉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzrc();
        }
        zzrd zzrdVar = null;
        if (i2 == 4) {
            return new zzrb(zzrdVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
