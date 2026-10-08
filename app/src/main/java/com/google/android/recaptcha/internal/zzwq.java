package com.google.android.recaptcha.internal;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzwq extends zzsn implements zztt {
    private static final zzwq zzb;
    private static volatile zzua zzd;
    private int zze;
    private zzsu zzf = zzB();
    private zzsu zzg = zzB();
    private zzvx zzh;

    static {
        zzwq zzwqVar = new zzwq();
        zzb = zzwqVar;
        zzsn.zzI(zzwq.class, zzwqVar);
    }

    private zzwq() {
    }

    static /* synthetic */ void zzM(zzwq zzwqVar, zzwn zzwnVar) {
        zzwnVar.getClass();
        zzsu zzsuVar = zzwqVar.zzf;
        if (!zzsuVar.zzc()) {
            zzwqVar.zzf = zzsn.zzC(zzsuVar);
        }
        zzwqVar.zzf.add(zzwnVar);
    }

    static /* synthetic */ void zzN(zzwq zzwqVar, zzxc zzxcVar) {
        zzxcVar.getClass();
        zzsu zzsuVar = zzwqVar.zzg;
        if (!zzsuVar.zzc()) {
            zzwqVar.zzg = zzsn.zzC(zzsuVar);
        }
        zzwqVar.zzg.add(zzxcVar);
    }

    public static zzwo zzi() {
        return (zzwo) zzb.zzq();
    }

    public static zzwq zzk(byte[] bArr) throws zzsx {
        return (zzwq) zzsn.zzx(zzb, bArr);
    }

    public final int zzf() {
        return this.zzf.size();
    }

    public final int zzg() {
        return this.zzg.size();
    }

    public final List zzl() {
        return this.zzf;
    }

    @Override // com.google.android.recaptcha.internal.zzsn
    protected final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002\u001b\u0003ဉ\u0000", new Object[]{"zze", "zzf", zzwn.class, "zzg", zzxc.class, "zzh"});
        }
        if (i2 == 3) {
            return new zzwq();
        }
        zzwp zzwpVar = null;
        if (i2 == 4) {
            return new zzwo(zzwpVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            throw null;
        }
        zzua zzsiVar = zzd;
        if (zzsiVar == null) {
            synchronized (zzwq.class) {
                zzsiVar = zzd;
                if (zzsiVar == null) {
                    zzsiVar = new zzsi(zzb);
                    zzd = zzsiVar;
                }
            }
        }
        return zzsiVar;
    }
}
