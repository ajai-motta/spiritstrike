package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaen {
    private static final zzaen zza = new zzaen(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzaen() {
        this(0, new int[8], new Object[8], true);
    }

    private zzaen(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzaen zzc() {
        return zza;
    }

    static zzaen zze(zzaen zzaenVar, zzaen zzaenVar2) {
        int i = zzaenVar.zzb + zzaenVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzaenVar.zzc, i);
        System.arraycopy(zzaenVar2.zzc, 0, iArrCopyOf, zzaenVar.zzb, zzaenVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzaenVar.zzd, i);
        System.arraycopy(zzaenVar2.zzd, 0, objArrCopyOf, zzaenVar.zzb, zzaenVar2.zzb);
        return new zzaen(i, iArrCopyOf, objArrCopyOf, true);
    }

    static zzaen zzf() {
        return new zzaen(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i) {
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
        if (obj == null || !(obj instanceof zzaen)) {
            return false;
        }
        zzaen zzaenVar = (zzaen) obj;
        int i = this.zzb;
        if (i == zzaenVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzaenVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzaenVar.zzd;
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

    public final int zza() {
        int iZzC;
        int iZzD;
        int iZzC2;
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
                    iZzC2 = zzzi.zzC(i5 << 3) + 8;
                } else if (i6 == 2) {
                    int i7 = i5 << 3;
                    zzyx zzyxVar = (zzyx) this.zzd[i3];
                    int iZzC3 = zzzi.zzC(i7);
                    int iZzd = zzyxVar.zzd();
                    iZzC2 = iZzC3 + zzzi.zzC(iZzd) + iZzd;
                } else if (i6 == 3) {
                    int iZzC4 = zzzi.zzC(i5 << 3);
                    iZzC = iZzC4 + iZzC4;
                    iZzD = ((zzaen) this.zzd[i3]).zza();
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(new zzacp("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.zzd[i3]).intValue();
                    iZzC2 = zzzi.zzC(i5 << 3) + 4;
                }
                i2 += iZzC2;
            } else {
                int i8 = i5 << 3;
                long jLongValue = ((Long) this.zzd[i3]).longValue();
                iZzC = zzzi.zzC(i8);
                iZzD = zzzi.zzD(jLongValue);
            }
            iZzC2 = iZzC + iZzD;
            i2 += iZzC2;
        }
        this.zze = i2;
        return i2;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzC = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2] >>> 3;
            zzyx zzyxVar = (zzyx) this.zzd[i2];
            int iZzC2 = zzzi.zzC(8);
            int iZzC3 = zzzi.zzC(16) + zzzi.zzC(i3);
            int iZzC4 = zzzi.zzC(24);
            int iZzd = zzyxVar.zzd();
            iZzC += iZzC2 + iZzC2 + iZzC3 + iZzC4 + zzzi.zzC(iZzd) + iZzd;
        }
        this.zze = iZzC;
        return iZzC;
    }

    final zzaen zzd(zzaen zzaenVar) {
        if (zzaenVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzaenVar.zzb;
        zzm(i);
        System.arraycopy(zzaenVar.zzc, 0, this.zzc, this.zzb, zzaenVar.zzb);
        System.arraycopy(zzaenVar.zzd, 0, this.zzd, this.zzb, zzaenVar.zzb);
        this.zzb = i;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzadn.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    final void zzj(int i, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    final void zzk(zzaez zzaezVar) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzaezVar.zzw(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzl(zzaez zzaezVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzaezVar.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzaezVar.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzaezVar.zzd(i4, (zzyx) obj);
                } else if (i3 == 3) {
                    zzaezVar.zzF(i4);
                    ((zzaen) obj).zzl(zzaezVar);
                    zzaezVar.zzh(i4);
                } else {
                    if (i3 != 5) {
                        throw new RuntimeException(new zzacp("Protocol message tag had invalid wire type."));
                    }
                    zzaezVar.zzk(i4, ((Integer) obj).intValue());
                }
            }
        }
    }
}
