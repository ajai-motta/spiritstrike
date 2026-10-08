package com.google.android.gms.internal.ads;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.audio.OpusUtil;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzang {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean zza(com.google.android.gms.internal.ads.zzef r17, com.google.android.gms.internal.ads.zzane r18) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzang.zza(com.google.android.gms.internal.ads.zzef, com.google.android.gms.internal.ads.zzane):boolean");
    }

    public static zzanf zzb(zzef zzefVar) throws zzat {
        int iZzj;
        int i;
        char c;
        int i2;
        int iZzj2;
        char c2;
        int iZzj3 = zzefVar.zzj(8);
        int i3 = 5;
        int iZzj4 = zzefVar.zzj(5);
        if (iZzj4 != 31) {
            switch (iZzj4) {
                case 0:
                    iZzj = 96000;
                    break;
                case 1:
                    iZzj = 88200;
                    break;
                case 2:
                    iZzj = 64000;
                    break;
                case 3:
                    iZzj = OpusUtil.SAMPLE_RATE;
                    break;
                case 4:
                    iZzj = 44100;
                    break;
                case 5:
                    iZzj = 32000;
                    break;
                case 6:
                    iZzj = 24000;
                    break;
                case 7:
                    iZzj = 22050;
                    break;
                case 8:
                    iZzj = AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND;
                    break;
                case 9:
                    iZzj = 12000;
                    break;
                case 10:
                    iZzj = 11025;
                    break;
                case 11:
                    iZzj = 8000;
                    break;
                case 12:
                    iZzj = 7350;
                    break;
                case 13:
                case 14:
                default:
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzj4).length() + 32);
                    sb.append("Unsupported sampling rate index ");
                    sb.append(iZzj4);
                    throw zzat.zzc(sb.toString());
                case 15:
                    iZzj = 57600;
                    break;
                case 16:
                    iZzj = 51200;
                    break;
                case 17:
                    iZzj = MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND;
                    break;
                case 18:
                    iZzj = 38400;
                    break;
                case 19:
                    iZzj = 34150;
                    break;
                case 20:
                    iZzj = 28800;
                    break;
                case 21:
                    iZzj = 25600;
                    break;
                case 22:
                    iZzj = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
                    break;
                case 23:
                    iZzj = 19200;
                    break;
                case 24:
                    iZzj = 17075;
                    break;
                case 25:
                    iZzj = 14400;
                    break;
                case 26:
                    iZzj = 12800;
                    break;
                case 27:
                    iZzj = 9600;
                    break;
            }
        } else {
            iZzj = zzefVar.zzj(24);
        }
        int iZzj5 = zzefVar.zzj(3);
        int i4 = 1;
        if (iZzj5 == 0) {
            i = 768;
        } else if (iZzj5 == 1) {
            i = 1024;
        } else if (iZzj5 == 2 || iZzj5 == 3) {
            i = 2048;
        } else {
            if (iZzj5 != 4) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(iZzj5).length() + 36);
                sb2.append("Unsupported coreSbrFrameLengthIndex ");
                sb2.append(iZzj5);
                throw zzat.zzc(sb2.toString());
            }
            i = 4096;
        }
        if (iZzj5 == 0 || iZzj5 == 1) {
            c = 0;
        } else if (iZzj5 == 2) {
            c = 2;
        } else if (iZzj5 == 3) {
            c = 3;
        } else {
            if (iZzj5 != 4) {
                StringBuilder sb3 = new StringBuilder(String.valueOf(iZzj5).length() + 36);
                sb3.append("Unsupported coreSbrFrameLengthIndex ");
                sb3.append(iZzj5);
                throw zzat.zzc(sb3.toString());
            }
            c = 1;
        }
        zzefVar.zzh(2);
        zzc(zzefVar);
        int iZzj6 = zzefVar.zzj(5);
        int i5 = 0;
        int iZzf = 0;
        while (true) {
            int i6 = 16;
            if (i5 < iZzj6 + 1) {
                int iZzj7 = zzefVar.zzj(3);
                iZzf += zzf(zzefVar, 5, 8, 16) + 1;
                if ((iZzj7 == 0 || iZzj7 == 2) && zzefVar.zzi()) {
                    zzc(zzefVar);
                }
                i5++;
            } else {
                int iZzf2 = zzf(zzefVar, 4, 8, 16) + 1;
                zzefVar.zzg();
                int i7 = 0;
                while (true) {
                    double d = 2.0d;
                    if (i7 >= iZzf2) {
                        int i8 = iZzj3;
                        byte[] bArr = null;
                        if (zzefVar.zzi()) {
                            int iZzf3 = zzf(zzefVar, 2, 4, 8) + 1;
                            for (int i9 = 0; i9 < iZzf3; i9++) {
                                int iZzf4 = zzf(zzefVar, 4, 8, 16);
                                int iZzf5 = zzf(zzefVar, 4, 8, 16);
                                if (iZzf4 == 7) {
                                    int iZzj8 = zzefVar.zzj(4) + 1;
                                    zzefVar.zzh(4);
                                    byte[] bArr2 = new byte[iZzj8];
                                    for (int i10 = 0; i10 < iZzj8; i10++) {
                                        bArr2[i10] = (byte) zzefVar.zzj(8);
                                    }
                                    bArr = bArr2;
                                } else {
                                    zzefVar.zzh(iZzf5 * 8);
                                }
                            }
                        }
                        byte[] bArr3 = bArr;
                        switch (iZzj) {
                            case 14700:
                            case AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND /* 16000 */:
                                d = 3.0d;
                                break;
                            case 22050:
                            case 24000:
                                break;
                            case 29400:
                            case 32000:
                            case 58800:
                            case 64000:
                                d = 1.5d;
                                break;
                            case 44100:
                            case OpusUtil.SAMPLE_RATE /* 48000 */:
                            case 88200:
                            case 96000:
                                d = 1.0d;
                                break;
                            default:
                                StringBuilder sb4 = new StringBuilder(String.valueOf(iZzj).length() + 26);
                                sb4.append("Unsupported sampling rate ");
                                sb4.append(iZzj);
                                throw zzat.zzc(sb4.toString());
                        }
                        return new zzanf(i8, (int) (((double) iZzj) * d), (int) (((double) i) * d), bArr3, null);
                    }
                    int iZzj9 = zzefVar.zzj(2);
                    if (iZzj9 == 0) {
                        i2 = iZzj3;
                        zzd(zzefVar);
                        if (c > 0) {
                            zze(zzefVar);
                        }
                    } else if (iZzj9 != i4) {
                        if (iZzj9 == 3) {
                            zzf(zzefVar, 4, 8, i6);
                            int iZzf6 = zzf(zzefVar, 4, 8, i6);
                            if (zzefVar.zzi()) {
                                zzf(zzefVar, 8, i6, 0);
                            }
                            zzefVar.zzg();
                            if (iZzf6 > 0) {
                                zzefVar.zzh(iZzf6 * 8);
                            }
                        }
                        i2 = iZzj3;
                    } else {
                        if (zzd(zzefVar)) {
                            zzefVar.zzg();
                        }
                        if (c > 0) {
                            zze(zzefVar);
                            iZzj2 = zzefVar.zzj(2);
                            c2 = c;
                        } else {
                            iZzj2 = 0;
                            c2 = 0;
                        }
                        if (iZzj2 > 0) {
                            zzefVar.zzh(6);
                            int iZzj10 = zzefVar.zzj(2);
                            zzefVar.zzh(4);
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(i3);
                            }
                            if (iZzj2 == 2 || iZzj2 == 3) {
                                zzefVar.zzh(6);
                            }
                            if (iZzj10 == 2) {
                                zzefVar.zzg();
                            }
                        }
                        i2 = iZzj3;
                        int iFloor = ((int) Math.floor(Math.log(iZzf - 1) / Math.log(2.0d))) + 1;
                        int iZzj11 = zzefVar.zzj(2);
                        if (iZzj11 > 0 && zzefVar.zzi()) {
                            zzefVar.zzh(iFloor);
                        }
                        if (zzefVar.zzi()) {
                            zzefVar.zzh(iFloor);
                        }
                        if (c2 == 0 && iZzj11 == 0) {
                            zzefVar.zzg();
                        }
                    }
                    i7++;
                    iZzj3 = i2;
                    i3 = 5;
                    i4 = 1;
                    i6 = 16;
                }
            }
        }
    }

    private static void zzc(zzef zzefVar) {
        int iZzj;
        int iZzj2 = zzefVar.zzj(2);
        if (iZzj2 == 0) {
            zzefVar.zzh(6);
            return;
        }
        int iZzf = zzf(zzefVar, 5, 8, 16) + 1;
        if (iZzj2 == 1) {
            zzefVar.zzh(iZzf * 7);
            return;
        }
        if (iZzj2 == 2) {
            boolean zZzi = zzefVar.zzi();
            int i = true != zZzi ? 5 : 1;
            int i2 = true == zZzi ? 7 : 5;
            int i3 = true == zZzi ? 8 : 6;
            int i4 = 0;
            while (i4 < iZzf) {
                if (zzefVar.zzi()) {
                    zzefVar.zzh(7);
                    iZzj = 0;
                } else {
                    if (zzefVar.zzj(2) == 3 && zzefVar.zzj(i2) * i != 0) {
                        zzefVar.zzg();
                    }
                    iZzj = zzefVar.zzj(i3) * i;
                    if (iZzj != 0 && iZzj != 180) {
                        zzefVar.zzg();
                    }
                    zzefVar.zzg();
                }
                if (iZzj != 0 && iZzj != 180 && zzefVar.zzi()) {
                    i4++;
                }
                i4++;
            }
        }
    }

    private static boolean zzd(zzef zzefVar) {
        zzefVar.zzh(3);
        boolean zZzi = zzefVar.zzi();
        if (zZzi) {
            zzefVar.zzh(13);
        }
        return zZzi;
    }

    private static void zze(zzef zzefVar) {
        zzefVar.zzh(3);
        zzefVar.zzh(8);
        boolean zZzi = zzefVar.zzi();
        boolean zZzi2 = zzefVar.zzi();
        if (zZzi) {
            zzefVar.zzh(5);
        }
        if (zZzi2) {
            zzefVar.zzh(6);
        }
    }

    private static int zzf(zzef zzefVar, int i, int i2, int i3) {
        zzgmd.zza(Math.max(Math.max(i, i2), i3) <= 31);
        int i4 = (1 << i) - 1;
        int i5 = (1 << i2) - 1;
        zzeg$$ExternalSyntheticBackport0.m(zzeg$$ExternalSyntheticBackport0.m(i4, i5), 1 << i3);
        if (zzefVar.zzc() < i) {
            return -1;
        }
        int iZzj = zzefVar.zzj(i);
        if (iZzj != i4) {
            return iZzj;
        }
        if (zzefVar.zzc() < i2) {
            return -1;
        }
        int iZzj2 = zzefVar.zzj(i2);
        int i6 = iZzj + iZzj2;
        if (iZzj2 != i5) {
            return i6;
        }
        if (zzefVar.zzc() < i3) {
            return -1;
        }
        return i6 + zzefVar.zzj(i3);
    }
}
