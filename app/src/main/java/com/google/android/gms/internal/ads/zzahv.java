package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzahv implements zzahu {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;
    private final int zze;

    private zzahv(long[] jArr, long[] jArr2, long j, long j2, long j3, int i) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j;
        this.zzd = j3;
        this.zze = i;
    }

    public static zzahv zzd(long j, long j2, zzadw zzadwVar, zzeg zzegVar) {
        long jMax;
        int iZzs;
        zzegVar.zzk(6);
        int iZzB = zzegVar.zzB();
        long j3 = zzadwVar.zzc;
        long j4 = iZzB;
        if (zzegVar.zzB() <= 0) {
            return null;
        }
        long jZzr = zzep.zzr((((long) r4) * ((long) zzadwVar.zzg)) - 1, zzadwVar.zzd);
        int iZzt = zzegVar.zzt();
        int iZzt2 = zzegVar.zzt();
        int iZzt3 = zzegVar.zzt();
        zzegVar.zzk(2);
        long j5 = j2 + ((long) zzadwVar.zzc);
        long[] jArr = new long[iZzt];
        long[] jArr2 = new long[iZzt];
        for (int i = 0; i < iZzt; i++) {
            jArr[i] = (((long) i) * jZzr) / ((long) iZzt);
            jArr2[i] = j5;
            if (iZzt3 == 1) {
                iZzs = zzegVar.zzs();
            } else if (iZzt3 == 2) {
                iZzs = zzegVar.zzt();
            } else if (iZzt3 == 3) {
                iZzs = zzegVar.zzx();
            } else {
                if (iZzt3 != 4) {
                    return null;
                }
                iZzs = zzegVar.zzH();
            }
            j5 += ((long) iZzs) * ((long) iZzt2);
        }
        long j6 = j2 + j3;
        long j7 = j4 + j6;
        if (j != -1 && j != j7) {
            StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 27 + String.valueOf(j7).length());
            sb.append("VBRI data size mismatch: ");
            sb.append(j);
            sb.append(", ");
            sb.append(j7);
            zzdt.zzc("VbriSeeker", sb.toString());
        }
        if (j7 != j5) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(j7).length() + 43 + String.valueOf(j5).length() + 28);
            sb2.append("VBRI bytes and ToC mismatch (using max): ");
            sb2.append(j7);
            sb2.append(", ");
            sb2.append(j5);
            sb2.append("\nSeeking will be inaccurate.");
            zzdt.zzc("VbriSeeker", sb2.toString());
            jMax = Math.max(j7, j5);
        } else {
            jMax = j7;
        }
        return new zzahv(jArr, jArr2, jZzr, j6, jMax, zzadwVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        long[] jArr = this.zza;
        int iZzm = zzep.zzm(jArr, j, true, true);
        long j2 = jArr[iZzm];
        long[] jArr2 = this.zzb;
        zzaee zzaeeVar = new zzaee(j2, jArr2[iZzm]);
        if (zzaeeVar.zzb >= j || iZzm == jArr.length - 1) {
            return new zzaeb(zzaeeVar, zzaeeVar);
        }
        int i = iZzm + 1;
        return new zzaeb(zzaeeVar, new zzaee(jArr[i], jArr2[i]));
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final long zze(long j) {
        return this.zza[zzep.zzm(this.zzb, j, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final long zzf() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final int zzg() {
        return this.zze;
    }
}
