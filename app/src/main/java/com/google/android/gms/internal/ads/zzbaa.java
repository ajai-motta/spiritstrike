package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public enum zzbaa implements zzhws {
    UNSUPPORTED(0),
    ARM7(2),
    X86(4),
    ARM64(5),
    X86_64(6),
    RISCV64(7),
    UNKNOWN(999);

    private final int zzh;

    zzbaa(int i) {
        this.zzh = i;
    }

    public static zzbaa zzb(int i) {
        if (i == 0) {
            return UNSUPPORTED;
        }
        if (i == 2) {
            return ARM7;
        }
        if (i == 999) {
            return UNKNOWN;
        }
        if (i == 4) {
            return X86;
        }
        if (i == 5) {
            return ARM64;
        }
        if (i == 6) {
            return X86_64;
        }
        if (i != 7) {
            return null;
        }
        return RISCV64;
    }

    public static zzhwu zzc() {
        return zzazz.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzhws
    public final int zza() {
        return this.zzh;
    }
}
