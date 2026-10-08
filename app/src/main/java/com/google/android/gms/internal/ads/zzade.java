package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import java.io.EOFException;
import java.io.IOException;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzade {
    @Pure
    public static void zza(boolean z, String str) throws zzat {
        if (!z) {
            throw zzat.zzb(str, null);
        }
    }

    public static int zzb(zzadb zzadbVar, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int iZzg = zzadbVar.zzg(bArr, i + i3, i2 - i3);
            if (iZzg == -1) {
                break;
            }
            i3 += iZzg;
        }
        return i3;
    }

    public static boolean zzc(zzadb zzadbVar, byte[] bArr, int i, int i2) throws IOException {
        try {
            zzadbVar.zzc(bArr, i, i2);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean zzd(zzadb zzadbVar, int i) throws IOException {
        try {
            zzadbVar.zzf(i);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean zze(zzadb zzadbVar, byte[] bArr, int i, int i2, boolean z) throws IOException {
        try {
            return zzadbVar.zzh(bArr, 0, i2, z);
        } catch (EOFException e) {
            if (z) {
                return false;
            }
            throw e;
        }
    }

    public static int zzf(int i) {
        if (i == 20) {
            return 63750;
        }
        if (i == 30) {
            return DtsUtil.DTS_HD_MAX_RATE_BYTES_PER_SECOND;
        }
        switch (i) {
            case 5:
                return Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND;
            case 6:
                return Ac3Util.E_AC3_MAX_RATE_BYTES_PER_SECOND;
            case 7:
                return DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND;
            case 8:
                return DtsUtil.DTS_HD_MAX_RATE_BYTES_PER_SECOND;
            case 9:
                return MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND;
            case 10:
                return 100000;
            case 11:
                return AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND;
            case 12:
                return AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND;
            default:
                switch (i) {
                    case 14:
                        return Ac3Util.TRUEHD_MAX_RATE_BYTES_PER_SECOND;
                    case 15:
                        return 8000;
                    case 16:
                        return AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND;
                    case 17:
                        return Ac4Util.MAX_RATE_BYTES_PER_SECOND;
                    case 18:
                        return Ac3Util.E_AC3_MAX_RATE_BYTES_PER_SECOND;
                    default:
                        return C.RATE_UNSET_INT;
                }
        }
    }
}
