package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.work.WorkInfo;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaik {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb;

    static {
        String str = zzep.zza;
        zzb = "OpusHead".getBytes(StandardCharsets.UTF_8);
    }

    public static int zza(int i) {
        return (i >> 24) & 255;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:565:0x0bc5  */
    /* JADX WARN: Removed duplicated region for block: B:566:0x0bc7  */
    /* JADX WARN: Removed duplicated region for block: B:603:0x0d54  */
    /* JADX WARN: Removed duplicated region for block: B:605:0x0d59  */
    /* JADX WARN: Removed duplicated region for block: B:615:0x0dc7  */
    /* JADX WARN: Removed duplicated region for block: B:616:0x0dfb  */
    /* JADX WARN: Removed duplicated region for block: B:625:0x023d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0196  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List zzb(com.google.android.gms.internal.ads.zzeu r76, com.google.android.gms.internal.ads.zzads r77, long r78, com.google.android.gms.internal.ads.zzq r80, boolean r81, boolean r82, com.google.android.gms.internal.ads.zzglu r83, boolean r84) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 3596
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaik.zzb(com.google.android.gms.internal.ads.zzeu, com.google.android.gms.internal.ads.zzads, long, com.google.android.gms.internal.ads.zzq, boolean, boolean, com.google.android.gms.internal.ads.zzglu, boolean):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzap zzc(com.google.android.gms.internal.ads.zzev r14) {
        /*
            Method dump skipped, instruction units count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaik.zzc(com.google.android.gms.internal.ads.zzev):com.google.android.gms.internal.ads.zzap");
    }

    public static zzey zzd(zzeg zzegVar) {
        long jZzD;
        long jZzD2;
        zzegVar.zzh(8);
        if (zza(zzegVar.zzB()) == 0) {
            jZzD = zzegVar.zzz();
            jZzD2 = zzegVar.zzz();
        } else {
            jZzD = zzegVar.zzD();
            jZzD2 = zzegVar.zzD();
        }
        return new zzey(jZzD, jZzD2, zzegVar.zzz());
    }

    public static zzap zze(zzeu zzeuVar) {
        zzes zzesVar;
        zzev zzevVarZzc = zzeuVar.zzc(Atom.TYPE_hdlr);
        zzev zzevVarZzc2 = zzeuVar.zzc(Atom.TYPE_keys);
        zzev zzevVarZzc3 = zzeuVar.zzc(Atom.TYPE_ilst);
        if (zzevVarZzc != null && zzevVarZzc2 != null && zzevVarZzc3 != null && zzi(zzevVarZzc.zza) == 1835299937) {
            zzeg zzegVar = zzevVarZzc2.zza;
            zzegVar.zzh(12);
            int iZzB = zzegVar.zzB();
            String[] strArr = new String[iZzB];
            for (int i = 0; i < iZzB; i++) {
                int iZzB2 = zzegVar.zzB();
                zzegVar.zzk(4);
                strArr[i] = zzegVar.zzK(iZzB2 - 8, StandardCharsets.UTF_8);
            }
            zzeg zzegVar2 = zzevVarZzc3.zza;
            zzegVar2.zzh(8);
            ArrayList arrayList = new ArrayList();
            while (zzegVar2.zzd() > 8) {
                int iZzg = zzegVar2.zzg() + zzegVar2.zzB();
                int iZzB3 = zzegVar2.zzB() - 1;
                if (iZzB3 < 0 || iZzB3 >= iZzB) {
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzB3).length() + 41);
                    sb.append("Skipped metadata with unknown key index: ");
                    sb.append(iZzB3);
                    zzdt.zzc("BoxParsers", sb.toString());
                } else {
                    String str = strArr[iZzB3];
                    while (true) {
                        int iZzg2 = zzegVar2.zzg();
                        if (iZzg2 >= iZzg) {
                            zzesVar = null;
                            break;
                        }
                        int iZzB4 = zzegVar2.zzB();
                        if (zzegVar2.zzB() == 1684108385) {
                            int iZzB5 = zzegVar2.zzB();
                            int iZzB6 = zzegVar2.zzB();
                            int i2 = iZzB4 - 16;
                            byte[] bArr = new byte[i2];
                            zzegVar2.zzm(bArr, 0, i2);
                            zzesVar = new zzes(str, bArr, iZzB6, iZzB5);
                            break;
                        }
                        zzegVar2.zzh(iZzg2 + iZzB4);
                    }
                    if (zzesVar != null) {
                        arrayList.add(zzesVar);
                    }
                }
                zzegVar2.zzh(iZzg);
            }
            if (!arrayList.isEmpty()) {
                return new zzap(arrayList);
            }
        }
        return null;
    }

    public static void zzf(zzeg zzegVar) {
        int iZzg = zzegVar.zzg();
        zzegVar.zzk(4);
        if (zzegVar.zzB() != 1751411826) {
            iZzg += 4;
        }
        zzegVar.zzh(iZzg);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x02d7 A[ADDED_TO_REGION, LOOP:14: B:110:0x02d7->B:114:0x02e1, LOOP_START, PHI: r22
  0x02d7: PHI (r22v2 int) = (r22v1 int), (r22v3 int) binds: [B:109:0x02d5, B:114:0x02e1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x02c6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ca A[PHI: r12
  0x01ca: PHI (r12v4 int) = (r12v3 int), (r12v3 int), (r12v12 int), (r12v3 int) binds: [B:40:0x0107, B:47:0x0123, B:64:0x01c9, B:46:0x0121] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzaji zzg(com.google.android.gms.internal.ads.zzajf r42, com.google.android.gms.internal.ads.zzeu r43, com.google.android.gms.internal.ads.zzads r44, boolean r45) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 1900
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaik.zzg(com.google.android.gms.internal.ads.zzajf, com.google.android.gms.internal.ads.zzeu, com.google.android.gms.internal.ads.zzads, boolean):com.google.android.gms.internal.ads.zzaji");
    }

    private static zzap zzh(zzeg zzegVar) {
        short sZzv = zzegVar.zzv();
        zzegVar.zzk(2);
        String strZzK = zzegVar.zzK(sZzv, StandardCharsets.UTF_8);
        int iMax = Math.max(strZzK.lastIndexOf(43), strZzK.lastIndexOf(45));
        try {
            return new zzap(C.TIME_UNSET, new zzex(Float.parseFloat(strZzK.substring(0, iMax)), Float.parseFloat(strZzK.substring(iMax, strZzK.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static int zzi(zzeg zzegVar) {
        zzegVar.zzh(16);
        return zzegVar.zzB();
    }

    private static String zzj(byte[] bArr, int i, int i2) {
        zzgmd.zzh(bArr.length == 64);
        ArrayList arrayList = new ArrayList(16);
        for (int i3 = 0; i3 < bArr.length - 3; i3 += 4) {
            int iZze = zzgst.zze(bArr[i3], bArr[i3 + 1], bArr[i3 + 2], bArr[i3 + 3]);
            String str = zzep.zza;
            int i4 = ((iZze >> 8) & 255) + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
            int i5 = (iZze >> 16) & 255;
            int iMax = Math.max(0, Math.min(((i4 * 14075) / 10000) + i5, 255)) << 16;
            int i6 = (iZze & 255) + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
            arrayList.add(String.format("%06x", Integer.valueOf(Math.max(0, Math.min(i5 + ((i6 * 17790) / 10000), 255)) | iMax | (Math.max(0, Math.min((i5 - ((i6 * 3455) / 10000)) - ((i4 * 7169) / 10000), 255)) << 8))));
        }
        String strZzd = zzglx.zzd(arrayList, ", ");
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 7 + String.valueOf(i2).length() + 10 + strZzd.length() + 1);
        sb.append("size: ");
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        sb.append("\npalette: ");
        sb.append(strZzd);
        sb.append("\n");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0187  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.gms.internal.ads.zzi zzk(com.google.android.gms.internal.ads.zzeg r15) {
        /*
            Method dump skipped, instruction units count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaik.zzk(com.google.android.gms.internal.ads.zzeg):com.google.android.gms.internal.ads.zzi");
    }

    private static zzi zzl(zzeg zzegVar) {
        zzh zzhVar = new zzh();
        byte[] bArrZzi = zzegVar.zzi();
        zzef zzefVar = new zzef(bArrZzi, bArrZzi.length);
        zzefVar.zzf(zzegVar.zzg() * 8);
        zzefVar.zzo(1);
        int iZzj = zzefVar.zzj(8);
        for (int i = 0; i < iZzj; i++) {
            zzefVar.zzo(1);
            int iZzj2 = zzefVar.zzj(8);
            for (int i2 = 0; i2 < iZzj2; i2++) {
                zzefVar.zzh(6);
                boolean zZzi = zzefVar.zzi();
                zzefVar.zzg();
                zzefVar.zzo(11);
                zzefVar.zzh(4);
                int iZzj3 = zzefVar.zzj(4) + 8;
                zzhVar.zze(iZzj3);
                zzhVar.zzf(iZzj3);
                zzefVar.zzo(1);
                if (zZzi) {
                    int iZzj4 = zzefVar.zzj(8);
                    int iZzj5 = zzefVar.zzj(8);
                    zzefVar.zzo(1);
                    boolean zZzi2 = zzefVar.zzi();
                    zzhVar.zza(zzi.zzb(iZzj4));
                    zzhVar.zzb(true != zZzi2 ? 2 : 1);
                    zzhVar.zzc(zzi.zzc(iZzj5));
                }
            }
        }
        return zzhVar.zzg();
    }

    private static ByteBuffer zzm() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static Pair zzn(zzeu zzeuVar) {
        zzev zzevVarZzc = zzeuVar.zzc(Atom.TYPE_elst);
        if (zzevVarZzc == null) {
            return null;
        }
        zzeg zzegVar = zzevVarZzc.zza;
        zzegVar.zzh(8);
        int iZza = zza(zzegVar.zzB());
        int iZzH = zzegVar.zzH();
        long[] jArr = new long[iZzH];
        long[] jArr2 = new long[iZzH];
        for (int i = 0; i < iZzH; i++) {
            jArr[i] = iZza == 1 ? zzegVar.zzJ() : zzegVar.zzz();
            jArr2[i] = iZza == 1 ? zzegVar.zzD() : zzegVar.zzB();
            if (zzegVar.zzv() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            zzegVar.zzk(2);
        }
        return Pair.create(jArr, jArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zzo(com.google.android.gms.internal.ads.zzeg r34, int r35, int r36, int r37, int r38, java.lang.String r39, boolean r40, com.google.android.gms.internal.ads.zzq r41, com.google.android.gms.internal.ads.zzaig r42, int r43) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 1787
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaik.zzo(com.google.android.gms.internal.ads.zzeg, int, int, int, int, java.lang.String, boolean, com.google.android.gms.internal.ads.zzq, com.google.android.gms.internal.ads.zzaig, int):void");
    }

    private static zzaib zzp(zzeg zzegVar, int i) {
        zzegVar.zzh(i + 12);
        zzegVar.zzk(1);
        zzs(zzegVar);
        zzegVar.zzk(2);
        int iZzs = zzegVar.zzs();
        if ((iZzs & 128) != 0) {
            zzegVar.zzk(2);
        }
        if ((iZzs & 64) != 0) {
            zzegVar.zzk(zzegVar.zzs());
        }
        if ((iZzs & 32) != 0) {
            zzegVar.zzk(2);
        }
        zzegVar.zzk(1);
        zzs(zzegVar);
        String strZzf = zzas.zzf(zzegVar.zzs());
        if (MimeTypes.AUDIO_MPEG.equals(strZzf) || MimeTypes.AUDIO_DTS.equals(strZzf) || MimeTypes.AUDIO_DTS_HD.equals(strZzf)) {
            return new zzaib(strZzf, null, -1L, -1L);
        }
        zzegVar.zzk(4);
        long jZzz = zzegVar.zzz();
        long jZzz2 = zzegVar.zzz();
        zzegVar.zzk(1);
        int iZzs2 = zzs(zzegVar);
        byte[] bArr = new byte[iZzs2];
        zzegVar.zzm(bArr, 0, iZzs2);
        return new zzaib(strZzf, bArr, jZzz2 <= 0 ? -1L : jZzz2, jZzz > 0 ? jZzz : -1L);
    }

    private static zzahz zzq(zzeg zzegVar, int i) {
        zzegVar.zzh(i + 8);
        zzegVar.zzk(4);
        return new zzahz(zzegVar.zzz(), zzegVar.zzz());
    }

    private static Pair zzr(zzeg zzegVar, int i, int i2) throws zzat {
        Integer num;
        zzajg zzajgVar;
        Pair pairCreate;
        int i3;
        int i4;
        byte[] bArr;
        int iZzg = zzegVar.zzg();
        while (iZzg - i < i2) {
            zzegVar.zzh(iZzg);
            int iZzB = zzegVar.zzB();
            zzade.zza(iZzB > 0, "childAtomSize must be positive");
            if (zzegVar.zzB() == 1936289382) {
                int i5 = iZzg + 8;
                int i6 = 0;
                int i7 = -1;
                String strZzK = null;
                Integer numValueOf = null;
                while (i5 - iZzg < iZzB) {
                    zzegVar.zzh(i5);
                    int iZzB2 = zzegVar.zzB();
                    int iZzB3 = zzegVar.zzB();
                    if (iZzB3 == 1718775137) {
                        numValueOf = Integer.valueOf(zzegVar.zzB());
                    } else if (iZzB3 == 1935894637) {
                        zzegVar.zzk(4);
                        strZzK = zzegVar.zzK(4, StandardCharsets.UTF_8);
                    } else if (iZzB3 == 1935894633) {
                        i7 = i5;
                        i6 = iZzB2;
                    }
                    i5 += iZzB2;
                }
                if (C.CENC_TYPE_cenc.equals(strZzK) || C.CENC_TYPE_cbc1.equals(strZzK) || C.CENC_TYPE_cens.equals(strZzK) || C.CENC_TYPE_cbcs.equals(strZzK)) {
                    zzade.zza(numValueOf != null, "frma atom is mandatory");
                    zzade.zza(i7 != -1, "schi atom is mandatory");
                    int i8 = i7 + 8;
                    while (true) {
                        if (i8 - i7 >= i6) {
                            num = numValueOf;
                            zzajgVar = null;
                            break;
                        }
                        zzegVar.zzh(i8);
                        int iZzB4 = zzegVar.zzB();
                        if (zzegVar.zzB() == 1952804451) {
                            int iZza = zza(zzegVar.zzB());
                            zzegVar.zzk(1);
                            if (iZza == 0) {
                                zzegVar.zzk(1);
                                i3 = 0;
                                i4 = 0;
                            } else {
                                int iZzs = zzegVar.zzs();
                                int i9 = (iZzs & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                                i3 = iZzs & 15;
                                i4 = i9;
                            }
                            boolean z = zzegVar.zzs() == 1;
                            int iZzs2 = zzegVar.zzs();
                            byte[] bArr2 = new byte[16];
                            zzegVar.zzm(bArr2, 0, 16);
                            if (z && iZzs2 == 0) {
                                int iZzs3 = zzegVar.zzs();
                                byte[] bArr3 = new byte[iZzs3];
                                zzegVar.zzm(bArr3, 0, iZzs3);
                                bArr = bArr3;
                            } else {
                                bArr = null;
                            }
                            num = numValueOf;
                            zzajgVar = new zzajg(z, strZzK, iZzs2, bArr2, i4, i3, bArr);
                        } else {
                            i8 += iZzB4;
                        }
                    }
                    zzade.zza(zzajgVar != null, "tenc atom is mandatory");
                    String str = zzep.zza;
                    pairCreate = Pair.create(num, zzajgVar);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            iZzg += iZzB;
        }
        return null;
    }

    private static int zzs(zzeg zzegVar) {
        int iZzs = zzegVar.zzs();
        int i = iZzs & 127;
        while ((iZzs & 128) == 128) {
            iZzs = zzegVar.zzs();
            i = (i << 7) | (iZzs & 127);
        }
        return i;
    }
}
