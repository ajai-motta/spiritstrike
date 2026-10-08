package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzahl {
    private final zzeg zza = new zzeg(8);
    private int zzb;

    private final long zzb(zzadb zzadbVar) throws IOException {
        int i;
        zzeg zzegVar = this.zza;
        zzacr zzacrVar = (zzacr) zzadbVar;
        int i2 = 0;
        zzacrVar.zzh(zzegVar.zzi(), 0, 1, false);
        int i3 = zzegVar.zzi()[0] & 255;
        if (i3 == 0) {
            return Long.MIN_VALUE;
        }
        int i4 = 128;
        int i5 = 0;
        while (true) {
            i = i5 + 1;
            if ((i3 & i4) != 0) {
                break;
            }
            i4 >>= 1;
            i5 = i;
        }
        int i6 = i3 & (~i4);
        zzacrVar.zzh(zzegVar.zzi(), 1, i5, false);
        while (i2 < i5) {
            i2++;
            i6 = (zzegVar.zzi()[i2] & 255) + (i6 << 8);
        }
        this.zzb += i;
        return i6;
    }

    public final boolean zza(zzadb zzadbVar) throws IOException {
        long jZzo = zzadbVar.zzo();
        long j = 1024;
        if (jZzo != -1 && jZzo <= 1024) {
            j = jZzo;
        }
        zzeg zzegVar = this.zza;
        zzacr zzacrVar = (zzacr) zzadbVar;
        zzacrVar.zzh(zzegVar.zzi(), 0, 4, false);
        this.zzb = 4;
        for (long jZzz = zzegVar.zzz(); jZzz != 440786851; jZzz = ((jZzz << 8) & (-256)) | ((long) (zzegVar.zzi()[0] & 255))) {
            int i = (int) j;
            int i2 = this.zzb + 1;
            this.zzb = i2;
            if (i2 == i) {
                return false;
            }
            zzacrVar.zzh(zzegVar.zzi(), 0, 1, false);
        }
        long jZzb = zzb(zzadbVar);
        long j2 = this.zzb;
        if (jZzb != Long.MIN_VALUE) {
            long j3 = j2 + jZzb;
            if (jZzo == -1 || j3 < jZzo) {
                while (true) {
                    long j4 = this.zzb;
                    if (j4 < j3) {
                        if (zzb(zzadbVar) == Long.MIN_VALUE) {
                            return false;
                        }
                        long jZzb2 = zzb(zzadbVar);
                        if (jZzb2 < 0) {
                            return false;
                        }
                        if (jZzb2 != 0) {
                            int i3 = (int) jZzb2;
                            zzacrVar.zzj(i3, false);
                            this.zzb += i3;
                        }
                    } else if (j4 == j3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
