package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhzd {
    private static final zzhzd zza = new zzhzd(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzhzd() {
        this(0, new int[8], new Object[8], true);
    }

    private zzhzd(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzhzd zza() {
        return zza;
    }

    static zzhzd zzb() {
        return new zzhzd();
    }

    static zzhzd zzc(zzhzd zzhzdVar, zzhzd zzhzdVar2) {
        int i = zzhzdVar.zzb + zzhzdVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzhzdVar.zzc, i);
        System.arraycopy(zzhzdVar2.zzc, 0, iArrCopyOf, zzhzdVar.zzb, zzhzdVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzhzdVar.zzd, i);
        System.arraycopy(zzhzdVar2.zzd, 0, objArrCopyOf, zzhzdVar.zzb, zzhzdVar2.zzb);
        return new zzhzd(i, iArrCopyOf, objArrCopyOf, true);
    }

    private final void zzn(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhzd)) {
            return false;
        }
        zzhzd zzhzdVar = (zzhzd) obj;
        int i = this.zzb;
        if (i == zzhzdVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzhzdVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzhzdVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = ((i2 * 31) + i3) * 31;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public final void zzd() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zze() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    final void zzf(zzhzr zzhzrVar) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzhzrVar.zzv(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzg(zzhzr zzhzrVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzhzrVar.zzc(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzhzrVar.zzj(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzhzrVar.zzn(i4, (zzhvi) obj);
                } else if (i3 == 3) {
                    zzhzrVar.zzt(i4);
                    ((zzhzd) obj).zzg(zzhzrVar);
                    zzhzrVar.zzu(i4);
                } else {
                    if (i3 != 5) {
                        throw new RuntimeException(new zzhxc("Protocol message tag had invalid wire type."));
                    }
                    zzhzrVar.zzk(i4, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final int zzh() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzA = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2] >>> 3;
            zzhvi zzhviVar = (zzhvi) this.zzd[i2];
            int iZzA2 = zzhvt.zzA(8);
            int iZzA3 = zzhvt.zzA(16) + zzhvt.zzA(i3);
            int iZzA4 = zzhvt.zzA(24);
            int iZzc = zzhviVar.zzc();
            iZzA += iZzA2 + iZzA2 + iZzA3 + iZzA4 + zzhvt.zzA(iZzc) + iZzc;
        }
        this.zze = iZzA;
        return iZzA;
    }

    public final int zzi() {
        int iZzA;
        int iZzB;
        int iZzA2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.zzd[i3]).longValue();
                    iZzA2 = zzhvt.zzA(i5 << 3) + 8;
                } else if (i6 == 2) {
                    int i7 = i5 << 3;
                    zzhvi zzhviVar = (zzhvi) this.zzd[i3];
                    int iZzA3 = zzhvt.zzA(i7);
                    int iZzc = zzhviVar.zzc();
                    iZzA2 = iZzA3 + zzhvt.zzA(iZzc) + iZzc;
                } else if (i6 == 3) {
                    int iZzA4 = zzhvt.zzA(i5 << 3);
                    iZzA = iZzA4 + iZzA4;
                    iZzB = ((zzhzd) this.zzd[i3]).zzi();
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(new zzhxc("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.zzd[i3]).intValue();
                    iZzA2 = zzhvt.zzA(i5 << 3) + 4;
                }
                i2 += iZzA2;
            } else {
                int i8 = i5 << 3;
                long jLongValue = ((Long) this.zzd[i3]).longValue();
                iZzA = zzhvt.zzA(i8);
                iZzB = zzhvt.zzB(jLongValue);
            }
            iZzA2 = iZzA + iZzB;
            i2 += iZzA2;
        }
        this.zze = i2;
        return i2;
    }

    final void zzj(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzhyb.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    final void zzk(int i, Object obj) {
        zze();
        zzn(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    final boolean zzl(int i, zzhvn zzhvnVar) throws IOException {
        int iZza;
        zze();
        int i2 = i & 7;
        if (i2 == 0) {
            zzk(i, Long.valueOf(zzhvnVar.zzg()));
            return true;
        }
        if (i2 == 1) {
            zzk(i, Long.valueOf(zzhvnVar.zzi()));
            return true;
        }
        if (i2 == 2) {
            zzk(i, zzhvnVar.zzn());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                zzhvnVar.zzI();
                return false;
            }
            if (i2 != 5) {
                throw new zzhxc("Protocol message tag had invalid wire type.");
            }
            zzk(i, Integer.valueOf(zzhvnVar.zzj()));
            return true;
        }
        zzhzd zzhzdVar = new zzhzd();
        do {
            iZza = zzhvnVar.zza();
            if (iZza == 0) {
                break;
            }
        } while (zzhzdVar.zzl(iZza, zzhvnVar));
        zzhvnVar.zzb(4 | ((i >>> 3) << 3));
        zzk(i, zzhzdVar);
        return true;
    }

    final zzhzd zzm(zzhzd zzhzdVar) {
        if (zzhzdVar.equals(zza)) {
            return this;
        }
        zze();
        int i = this.zzb + zzhzdVar.zzb;
        zzn(i);
        System.arraycopy(zzhzdVar.zzc, 0, this.zzc, this.zzb, zzhzdVar.zzb);
        System.arraycopy(zzhzdVar.zzd, 0, this.zzd, this.zzb, zzhzdVar.zzb);
        this.zzb = i;
        return this;
    }
}
