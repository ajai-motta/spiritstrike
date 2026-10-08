package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzwe {
    private final zzyv zza;
    private final zzeg zzb = new zzeg(32);
    private zzwd zzc;
    private zzwd zzd;
    private zzwd zze;
    private long zzf;

    public zzwe(zzyv zzyvVar) {
        this.zza = zzyvVar;
        zzwd zzwdVar = new zzwd(0L, 65536);
        this.zzc = zzwdVar;
        this.zzd = zzwdVar;
        this.zze = zzwdVar;
    }

    private final int zzi(int i) {
        zzwd zzwdVar = this.zze;
        if (zzwdVar.zzc == null) {
            zzyt zzytVarZza = this.zza.zza();
            zzwd zzwdVar2 = new zzwd(this.zze.zzb, 65536);
            zzwdVar.zzc = zzytVarZza;
            zzwdVar.zzd = zzwdVar2;
        }
        return Math.min(i, (int) (this.zze.zzb - this.zzf));
    }

    private final void zzj(int i) {
        long j = this.zzf + ((long) i);
        this.zzf = j;
        zzwd zzwdVar = this.zze;
        if (j == zzwdVar.zzb) {
            this.zze = zzwdVar.zzd;
        }
    }

    private static zzwd zzk(zzwd zzwdVar, zzhh zzhhVar, zzwf zzwfVar, zzeg zzegVar) {
        zzwd zzwdVarZzm;
        if (zzhhVar.zzk()) {
            long j = zzwfVar.zzb;
            int iZzt = 1;
            zzegVar.zza(1);
            zzwd zzwdVarZzm2 = zzm(zzwdVar, j, zzegVar.zzi(), 1);
            long j2 = j + 1;
            byte b = zzegVar.zzi()[0];
            int i = b & 128;
            int i2 = b & 127;
            zzhe zzheVar = zzhhVar.zzb;
            byte[] bArr = zzheVar.zza;
            if (bArr == null) {
                zzheVar.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            boolean z = i != 0;
            zzwdVarZzm = zzm(zzwdVarZzm2, j2, zzheVar.zza, i2);
            long j3 = j2 + ((long) i2);
            if (z) {
                zzegVar.zza(2);
                zzwdVarZzm = zzm(zzwdVarZzm, j3, zzegVar.zzi(), 2);
                j3 += 2;
                iZzt = zzegVar.zzt();
            }
            int i3 = iZzt;
            int[] iArr = zzheVar.zzd;
            if (iArr == null || iArr.length < i3) {
                iArr = new int[i3];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzheVar.zze;
            if (iArr3 == null || iArr3.length < i3) {
                iArr3 = new int[i3];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i4 = i3 * 6;
                zzegVar.zza(i4);
                zzwdVarZzm = zzm(zzwdVarZzm, j3, zzegVar.zzi(), i4);
                j3 += (long) i4;
                zzegVar.zzh(0);
                for (int i5 = 0; i5 < i3; i5++) {
                    iArr2[i5] = zzegVar.zzt();
                    iArr4[i5] = zzegVar.zzH();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzwfVar.zza - ((int) (j3 - zzwfVar.zzb));
            }
            zzael zzaelVar = zzwfVar.zzc;
            String str = zzep.zza;
            zzheVar.zza(i3, iArr2, iArr4, zzaelVar.zzb, zzheVar.zza, zzaelVar.zza, zzaelVar.zzc, zzaelVar.zzd);
            long j4 = zzwfVar.zzb;
            int i6 = (int) (j3 - j4);
            zzwfVar.zzb = j4 + ((long) i6);
            zzwfVar.zza -= i6;
        } else {
            zzwdVarZzm = zzwdVar;
        }
        if (!zzhhVar.zze()) {
            zzhhVar.zzj(zzwfVar.zza);
            return zzl(zzwdVarZzm, zzwfVar.zzb, zzhhVar.zzc, zzwfVar.zza);
        }
        zzegVar.zza(4);
        zzwd zzwdVarZzm3 = zzm(zzwdVarZzm, zzwfVar.zzb, zzegVar.zzi(), 4);
        int iZzH = zzegVar.zzH();
        zzwfVar.zzb += 4;
        zzwfVar.zza -= 4;
        zzhhVar.zzj(iZzH);
        zzwd zzwdVarZzl = zzl(zzwdVarZzm3, zzwfVar.zzb, zzhhVar.zzc, iZzH);
        zzwfVar.zzb += (long) iZzH;
        int i7 = zzwfVar.zza - iZzH;
        zzwfVar.zza = i7;
        ByteBuffer byteBuffer = zzhhVar.zzf;
        if (byteBuffer == null || byteBuffer.capacity() < i7) {
            zzhhVar.zzf = ByteBuffer.allocate(i7);
        } else {
            zzhhVar.zzf.clear();
        }
        return zzl(zzwdVarZzl, zzwfVar.zzb, zzhhVar.zzf, zzwfVar.zza);
    }

    private static zzwd zzl(zzwd zzwdVar, long j, ByteBuffer byteBuffer, int i) {
        zzwd zzwdVarZzn = zzn(zzwdVar, j);
        while (i > 0) {
            int iMin = Math.min(i, (int) (zzwdVarZzn.zzb - j));
            byteBuffer.put(zzwdVarZzn.zzc.zza, zzwdVarZzn.zzb(j), iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == zzwdVarZzn.zzb) {
                zzwdVarZzn = zzwdVarZzn.zzd;
            }
        }
        return zzwdVarZzn;
    }

    private static zzwd zzm(zzwd zzwdVar, long j, byte[] bArr, int i) {
        zzwd zzwdVarZzn = zzn(zzwdVar, j);
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (zzwdVarZzn.zzb - j));
            System.arraycopy(zzwdVarZzn.zzc.zza, zzwdVarZzn.zzb(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == zzwdVarZzn.zzb) {
                zzwdVarZzn = zzwdVarZzn.zzd;
            }
        }
        return zzwdVarZzn;
    }

    private static zzwd zzn(zzwd zzwdVar, long j) {
        while (j >= zzwdVar.zzb) {
            zzwdVar = zzwdVar.zzd;
        }
        return zzwdVar;
    }

    public final void zza() {
        zzwd zzwdVar = this.zzc;
        if (zzwdVar.zzc != null) {
            this.zza.zzc(zzwdVar);
            zzwdVar.zzc();
        }
        this.zzc.zza(0L, 65536);
        zzwd zzwdVar2 = this.zzc;
        this.zzd = zzwdVar2;
        this.zze = zzwdVar2;
        this.zzf = 0L;
        this.zza.zzd();
    }

    public final void zzb() {
        this.zzd = this.zzc;
    }

    public final void zzc(zzhh zzhhVar, zzwf zzwfVar) {
        this.zzd = zzk(this.zzd, zzhhVar, zzwfVar, this.zzb);
    }

    public final void zzd(zzhh zzhhVar, zzwf zzwfVar) {
        zzk(this.zzd, zzhhVar, zzwfVar, this.zzb);
    }

    public final void zze(long j) {
        zzwd zzwdVar;
        if (j != -1) {
            while (true) {
                zzwdVar = this.zzc;
                if (j < zzwdVar.zzb) {
                    break;
                }
                this.zza.zzb(zzwdVar.zzc);
                this.zzc = this.zzc.zzc();
            }
            if (this.zzd.zza < zzwdVar.zza) {
                this.zzd = zzwdVar;
            }
        }
    }

    public final long zzf() {
        return this.zzf;
    }

    public final int zzg(zzj zzjVar, int i, boolean z) throws IOException {
        int iZzi = zzi(i);
        zzwd zzwdVar = this.zze;
        int iZza = zzjVar.zza(zzwdVar.zzc.zza, zzwdVar.zzb(this.zzf), iZzi);
        if (iZza != -1) {
            zzj(iZza);
            return iZza;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final void zzh(zzeg zzegVar, int i) {
        while (i > 0) {
            int iZzi = zzi(i);
            zzwd zzwdVar = this.zze;
            zzegVar.zzm(zzwdVar.zzc.zza, zzwdVar.zzb(this.zzf), iZzi);
            i -= iZzi;
            zzj(iZzi);
        }
    }
}
