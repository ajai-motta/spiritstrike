package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzanm {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzem zza = new zzem(0);
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private final zzeg zzb = new zzeg();

    zzanm() {
    }

    public static long zze(zzeg zzegVar) {
        int iZzg = zzegVar.zzg();
        if (zzegVar.zzd() < 9) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[9];
        zzegVar.zzm(bArr, 0, 9);
        zzegVar.zzh(iZzg);
        byte b = bArr[0];
        if ((b & 196) != 68) {
            return C.TIME_UNSET;
        }
        byte b2 = bArr[2];
        if ((b2 & 4) != 4) {
            return C.TIME_UNSET;
        }
        byte b3 = bArr[4];
        if ((b3 & 4) != 4 || (bArr[5] & 1) != 1 || (bArr[8] & 3) != 3) {
            return C.TIME_UNSET;
        }
        long j = b;
        long j2 = b2;
        long j3 = (248 & j2) >> 3;
        long j4 = (j2 & 3) << 13;
        return j4 | ((bArr[1] & 255) << 20) | ((j & 3) << 28) | (((j & 56) >> 3) << 30) | (j3 << 15) | ((((long) bArr[3]) & 255) << 5) | ((((long) b3) & 248) >> 3);
    }

    private final int zzf(zzadb zzadbVar) {
        byte[] bArr = zzep.zzb;
        int length = bArr.length;
        this.zzb.zzb(bArr, 0);
        this.zzc = true;
        zzadbVar.zzl();
        return 0;
    }

    private static final int zzg(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public final boolean zza() {
        return this.zzc;
    }

    public final zzem zzb() {
        return this.zza;
    }

    public final int zzc(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        boolean z = this.zze;
        long j = C.TIME_UNSET;
        if (!z) {
            long jZzo = zzadbVar.zzo();
            int iMin = (int) Math.min(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, jZzo);
            long j2 = jZzo - ((long) iMin);
            if (zzadbVar.zzn() != j2) {
                zzaeaVar.zza = j2;
                return 1;
            }
            zzeg zzegVar = this.zzb;
            zzegVar.zza(iMin);
            zzadbVar.zzl();
            zzadbVar.zzi(zzegVar.zzi(), 0, iMin);
            int iZzg = zzegVar.zzg();
            int iZze = zzegVar.zze() - 4;
            while (true) {
                if (iZze < iZzg) {
                    break;
                }
                if (zzg(zzegVar.zzi(), iZze) == 442) {
                    zzegVar.zzh(iZze + 4);
                    long jZze = zze(zzegVar);
                    if (jZze != C.TIME_UNSET) {
                        j = jZze;
                        break;
                    }
                }
                iZze--;
            }
            this.zzg = j;
            this.zze = true;
        } else {
            if (this.zzg == C.TIME_UNSET) {
                zzf(zzadbVar);
                return 0;
            }
            if (this.zzd) {
                long j3 = this.zzf;
                if (j3 == C.TIME_UNSET) {
                    zzf(zzadbVar);
                    return 0;
                }
                zzem zzemVar = this.zza;
                this.zzh = zzemVar.zzf(this.zzg) - zzemVar.zze(j3);
                zzf(zzadbVar);
                return 0;
            }
            int iMin2 = (int) Math.min(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, zzadbVar.zzo());
            if (zzadbVar.zzn() != 0) {
                zzaeaVar.zza = 0L;
                return 1;
            }
            zzeg zzegVar2 = this.zzb;
            zzegVar2.zza(iMin2);
            zzadbVar.zzl();
            zzadbVar.zzi(zzegVar2.zzi(), 0, iMin2);
            int iZzg2 = zzegVar2.zzg();
            int iZze2 = zzegVar2.zze();
            while (true) {
                if (iZzg2 >= iZze2 - 3) {
                    break;
                }
                if (zzg(zzegVar2.zzi(), iZzg2) == 442) {
                    zzegVar2.zzh(iZzg2 + 4);
                    long jZze2 = zze(zzegVar2);
                    if (jZze2 != C.TIME_UNSET) {
                        j = jZze2;
                        break;
                    }
                }
                iZzg2++;
            }
            this.zzf = j;
            this.zzd = true;
        }
        return 0;
    }

    public final long zzd() {
        return this.zzh;
    }
}
