package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzanw {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzem zza = new zzem(0);
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private final zzeg zzb = new zzeg();

    zzanw(int i) {
    }

    private final int zze(zzadb zzadbVar) {
        byte[] bArr = zzep.zzb;
        int length = bArr.length;
        this.zzb.zzb(bArr, 0);
        this.zzc = true;
        zzadbVar.zzl();
        return 0;
    }

    public final boolean zza() {
        return this.zzc;
    }

    public final int zzb(zzadb zzadbVar, zzaea zzaeaVar, int i) throws IOException {
        if (i <= 0) {
            zze(zzadbVar);
            return 0;
        }
        boolean z = this.zze;
        long j = C.TIME_UNSET;
        if (!z) {
            long jZzo = zzadbVar.zzo();
            int iMin = (int) Math.min(112800L, jZzo);
            long j2 = jZzo - ((long) iMin);
            if (zzadbVar.zzn() == j2) {
                zzeg zzegVar = this.zzb;
                zzegVar.zza(iMin);
                zzadbVar.zzl();
                zzadbVar.zzi(zzegVar.zzi(), 0, iMin);
                int iZzg = zzegVar.zzg();
                int iZze = zzegVar.zze();
                int i2 = iZze - 188;
                while (true) {
                    if (i2 < iZzg) {
                        break;
                    }
                    byte[] bArrZzi = zzegVar.zzi();
                    int i3 = -4;
                    int i4 = 0;
                    while (true) {
                        if (i3 > 4) {
                            break;
                        }
                        int i5 = (i3 * TsExtractor.TS_PACKET_SIZE) + i2;
                        if (i5 < iZzg || i5 >= iZze || bArrZzi[i5] != 71) {
                            i4 = 0;
                        } else {
                            i4++;
                            if (i4 == 5) {
                                long jZzb = zzaog.zzb(zzegVar, i2, i);
                                if (jZzb != C.TIME_UNSET) {
                                    j = jZzb;
                                    break;
                                }
                            }
                        }
                        i3++;
                    }
                    i2--;
                }
                this.zzg = j;
                this.zze = true;
                return 0;
            }
            zzaeaVar.zza = j2;
        } else {
            if (this.zzg == C.TIME_UNSET) {
                zze(zzadbVar);
                return 0;
            }
            if (this.zzd) {
                long j3 = this.zzf;
                if (j3 == C.TIME_UNSET) {
                    zze(zzadbVar);
                    return 0;
                }
                zzem zzemVar = this.zza;
                this.zzh = zzemVar.zzf(this.zzg) - zzemVar.zze(j3);
                zze(zzadbVar);
                return 0;
            }
            int iMin2 = (int) Math.min(112800L, zzadbVar.zzo());
            if (zzadbVar.zzn() == 0) {
                zzeg zzegVar2 = this.zzb;
                zzegVar2.zza(iMin2);
                zzadbVar.zzl();
                zzadbVar.zzi(zzegVar2.zzi(), 0, iMin2);
                int iZzg2 = zzegVar2.zzg();
                int iZze2 = zzegVar2.zze();
                while (true) {
                    if (iZzg2 >= iZze2) {
                        break;
                    }
                    if (zzegVar2.zzi()[iZzg2] == 71) {
                        long jZzb2 = zzaog.zzb(zzegVar2, iZzg2, i);
                        if (jZzb2 != C.TIME_UNSET) {
                            j = jZzb2;
                            break;
                        }
                    }
                    iZzg2++;
                }
                this.zzf = j;
                this.zzd = true;
                return 0;
            }
            zzaeaVar.zza = 0L;
        }
        return 1;
    }

    public final long zzc() {
        return this.zzh;
    }

    public final zzem zzd() {
        return this.zza;
    }
}
