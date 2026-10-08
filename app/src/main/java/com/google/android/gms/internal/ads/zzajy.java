package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzajy extends zzajw {
    private zzajx zza;
    private int zzb;
    private boolean zzc;
    private zzaer zzd;
    private zzaep zze;

    zzajy() {
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    protected final void zza(boolean z) {
        super.zza(z);
        if (z) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    protected final long zzb(zzeg zzegVar) {
        if ((zzegVar.zzi()[0] & 1) == 1) {
            return -1L;
        }
        byte b = zzegVar.zzi()[0];
        zzajx zzajxVar = this.zza;
        zzajxVar.getClass();
        int i = !zzajxVar.zzd[(b >> 1) & (255 >>> (8 - zzajxVar.zze))].zza ? zzajxVar.zza.zze : zzajxVar.zza.zzf;
        int i2 = this.zzc ? (this.zzb + i) / 4 : 0;
        if (zzegVar.zzj() < zzegVar.zze() + 4) {
            byte[] bArrCopyOf = Arrays.copyOf(zzegVar.zzi(), zzegVar.zze() + 4);
            zzegVar.zzb(bArrCopyOf, bArrCopyOf.length);
        } else {
            zzegVar.zzf(zzegVar.zze() + 4);
        }
        long j = i2;
        byte[] bArrZzi = zzegVar.zzi();
        bArrZzi[zzegVar.zze() - 4] = (byte) (j & 255);
        bArrZzi[zzegVar.zze() - 3] = (byte) ((j >>> 8) & 255);
        bArrZzi[zzegVar.zze() - 2] = (byte) ((j >>> 16) & 255);
        bArrZzi[zzegVar.zze() - 1] = (byte) ((j >>> 24) & 255);
        this.zzc = true;
        this.zzb = i;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    protected final void zzj(long j) {
        super.zzj(j);
        this.zzc = j != 0;
        zzaer zzaerVar = this.zzd;
        this.zzb = zzaerVar != null ? zzaerVar.zze : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzeg zzegVar, long j, zzaju zzajuVar) throws IOException {
        zzajx zzajxVar;
        int i;
        int iZzb;
        int i2;
        int i3;
        zzaer zzaerVar;
        long jFloor;
        if (this.zza != null) {
            zzajuVar.zza.getClass();
            return false;
        }
        zzaer zzaerVar2 = this.zzd;
        int i4 = 4;
        if (zzaerVar2 == null) {
            zzaes.zzd(1, zzegVar, false);
            int iZzI = zzegVar.zzI();
            int iZzs = zzegVar.zzs();
            int iZzI2 = zzegVar.zzI();
            int iZzC = zzegVar.zzC();
            int i5 = iZzC <= 0 ? -1 : iZzC;
            int iZzC2 = zzegVar.zzC();
            int i6 = iZzC2 <= 0 ? -1 : iZzC2;
            int iZzC3 = zzegVar.zzC();
            int i7 = iZzC3 <= 0 ? -1 : iZzC3;
            int iZzs2 = zzegVar.zzs();
            this.zzd = new zzaer(iZzI, iZzs, iZzI2, i5, i6, i7, (int) Math.pow(2.0d, iZzs2 & 15), (int) Math.pow(2.0d, (iZzs2 & PsExtractor.VIDEO_STREAM_MASK) >> 4), 1 == (zzegVar.zzs() & 1), Arrays.copyOf(zzegVar.zzi(), zzegVar.zze()));
        } else {
            zzaep zzaepVar = this.zze;
            if (zzaepVar == null) {
                this.zze = zzaes.zzb(zzegVar, true, true);
            } else {
                byte[] bArr = new byte[zzegVar.zze()];
                System.arraycopy(zzegVar.zzi(), 0, bArr, 0, zzegVar.zze());
                int i8 = zzaerVar2.zza;
                int i9 = 5;
                zzaes.zzd(5, zzegVar, false);
                int iZzs3 = zzegVar.zzs() + 1;
                zzaeo zzaeoVar = new zzaeo(zzegVar.zzi());
                zzaeoVar.zzc(zzegVar.zzg() * 8);
                int i10 = 0;
                while (true) {
                    int i11 = 2;
                    int i12 = 16;
                    if (i10 >= iZzs3) {
                        zzaer zzaerVar3 = zzaerVar2;
                        int i13 = 6;
                        int iZzb2 = zzaeoVar.zzb(6) + 1;
                        for (int i14 = 0; i14 < iZzb2; i14++) {
                            if (zzaeoVar.zzb(16) != 0) {
                                throw zzat.zzb("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int i15 = 1;
                        int iZzb3 = zzaeoVar.zzb(6) + 1;
                        int i16 = 0;
                        while (true) {
                            int i17 = 3;
                            if (i16 < iZzb3) {
                                int iZzb4 = zzaeoVar.zzb(i12);
                                if (iZzb4 == 0) {
                                    i2 = iZzb3;
                                    int i18 = 8;
                                    zzaeoVar.zzc(8);
                                    zzaeoVar.zzc(16);
                                    zzaeoVar.zzc(16);
                                    zzaeoVar.zzc(6);
                                    zzaeoVar.zzc(8);
                                    int iZzb5 = zzaeoVar.zzb(4) + 1;
                                    int i19 = 0;
                                    while (i19 < iZzb5) {
                                        zzaeoVar.zzc(i18);
                                        i19++;
                                        i18 = 8;
                                    }
                                } else {
                                    if (iZzb4 != i15) {
                                        StringBuilder sb = new StringBuilder(String.valueOf(iZzb4).length() + 41);
                                        sb.append("floor type greater than 1 not decodable: ");
                                        sb.append(iZzb4);
                                        throw zzat.zzb(sb.toString(), null);
                                    }
                                    int iZzb6 = zzaeoVar.zzb(i9);
                                    int[] iArr = new int[iZzb6];
                                    int i20 = -1;
                                    for (int i21 = 0; i21 < iZzb6; i21++) {
                                        int iZzb7 = zzaeoVar.zzb(4);
                                        iArr[i21] = iZzb7;
                                        if (iZzb7 > i20) {
                                            i20 = iZzb7;
                                        }
                                    }
                                    int i22 = i20 + 1;
                                    int[] iArr2 = new int[i22];
                                    int i23 = 0;
                                    while (i23 < i22) {
                                        iArr2[i23] = zzaeoVar.zzb(i17) + 1;
                                        int iZzb8 = zzaeoVar.zzb(i11);
                                        if (iZzb8 > 0) {
                                            i3 = 8;
                                            zzaeoVar.zzc(8);
                                        } else {
                                            i3 = 8;
                                        }
                                        int i24 = iZzb3;
                                        int i25 = 0;
                                        for (int i26 = 1; i25 < (i26 << iZzb8); i26 = 1) {
                                            zzaeoVar.zzc(i3);
                                            i25++;
                                            i3 = 8;
                                        }
                                        i23++;
                                        iZzb3 = i24;
                                        i11 = 2;
                                        i17 = 3;
                                    }
                                    i2 = iZzb3;
                                    zzaeoVar.zzc(i11);
                                    int iZzb9 = zzaeoVar.zzb(4);
                                    int i27 = 0;
                                    int i28 = 0;
                                    for (int i29 = 0; i29 < iZzb6; i29++) {
                                        i27 += iArr2[iArr[i29]];
                                        while (i28 < i27) {
                                            zzaeoVar.zzc(iZzb9);
                                            i28++;
                                        }
                                    }
                                }
                                i16++;
                                iZzb3 = i2;
                                i13 = 6;
                                i11 = 2;
                                i12 = 16;
                                i15 = 1;
                                i9 = 5;
                            } else {
                                int i30 = 1;
                                int iZzb10 = zzaeoVar.zzb(i13) + 1;
                                int i31 = 0;
                                while (i31 < iZzb10) {
                                    if (zzaeoVar.zzb(16) > 2) {
                                        throw zzat.zzb("residueType greater than 2 is not decodable", null);
                                    }
                                    zzaeoVar.zzc(24);
                                    zzaeoVar.zzc(24);
                                    zzaeoVar.zzc(24);
                                    int iZzb11 = zzaeoVar.zzb(i13) + i30;
                                    int i32 = 8;
                                    zzaeoVar.zzc(8);
                                    int[] iArr3 = new int[iZzb11];
                                    for (int i33 = 0; i33 < iZzb11; i33++) {
                                        iArr3[i33] = ((zzaeoVar.zza() ? zzaeoVar.zzb(5) : 0) * 8) + zzaeoVar.zzb(3);
                                    }
                                    int i34 = 0;
                                    while (i34 < iZzb11) {
                                        int i35 = 0;
                                        while (i35 < i32) {
                                            if ((iArr3[i34] & (1 << i35)) != 0) {
                                                zzaeoVar.zzc(i32);
                                            }
                                            i35++;
                                            i32 = 8;
                                        }
                                        i34++;
                                        i32 = 8;
                                    }
                                    i31++;
                                    i13 = 6;
                                    i30 = 1;
                                }
                                int iZzb12 = zzaeoVar.zzb(i13) + 1;
                                for (int i36 = 0; i36 < iZzb12; i36++) {
                                    int iZzb13 = zzaeoVar.zzb(16);
                                    if (iZzb13 != 0) {
                                        StringBuilder sb2 = new StringBuilder(String.valueOf(iZzb13).length() + 41);
                                        sb2.append("mapping type other than 0 not supported: ");
                                        sb2.append(iZzb13);
                                        zzdt.zze("VorbisUtil", sb2.toString());
                                    } else {
                                        if (zzaeoVar.zza()) {
                                            i = 1;
                                            iZzb = zzaeoVar.zzb(4) + 1;
                                        } else {
                                            i = 1;
                                            iZzb = 1;
                                        }
                                        if (zzaeoVar.zza()) {
                                            int iZzb14 = zzaeoVar.zzb(8) + i;
                                            for (int i37 = 0; i37 < iZzb14; i37++) {
                                                int i38 = i8 - 1;
                                                zzaeoVar.zzc(zzaes.zza(i38));
                                                zzaeoVar.zzc(zzaes.zza(i38));
                                            }
                                        }
                                        if (zzaeoVar.zzb(2) != 0) {
                                            throw zzat.zzb("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (iZzb > 1) {
                                            for (int i39 = 0; i39 < i8; i39++) {
                                                zzaeoVar.zzc(4);
                                            }
                                        }
                                        for (int i40 = 0; i40 < iZzb; i40++) {
                                            zzaeoVar.zzc(8);
                                            zzaeoVar.zzc(8);
                                            zzaeoVar.zzc(8);
                                        }
                                    }
                                }
                                int iZzb15 = zzaeoVar.zzb(6);
                                int i41 = iZzb15 + 1;
                                zzaeq[] zzaeqVarArr = new zzaeq[i41];
                                for (int i42 = 0; i42 < i41; i42++) {
                                    zzaeqVarArr[i42] = new zzaeq(zzaeoVar.zza(), zzaeoVar.zzb(16), zzaeoVar.zzb(16), zzaeoVar.zzb(8));
                                }
                                if (!zzaeoVar.zza()) {
                                    throw zzat.zzb("framing bit after modes not set as expected", null);
                                }
                                zzajxVar = new zzajx(zzaerVar3, zzaepVar, bArr, zzaeqVarArr, zzaes.zza(iZzb15));
                            }
                        }
                    } else {
                        if (zzaeoVar.zzb(24) != 5653314) {
                            int iZzd = zzaeoVar.zzd();
                            StringBuilder sb3 = new StringBuilder(String.valueOf(iZzd).length() + 55);
                            sb3.append("expected code book to start with [0x56, 0x43, 0x42] at ");
                            sb3.append(iZzd);
                            throw zzat.zzb(sb3.toString(), null);
                        }
                        int iZzb16 = zzaeoVar.zzb(16);
                        int iZzb17 = zzaeoVar.zzb(24);
                        if (zzaeoVar.zza()) {
                            zzaeoVar.zzc(5);
                            for (int iZzb18 = 0; iZzb18 < iZzb17; iZzb18 += zzaeoVar.zzb(zzaes.zza(iZzb17 - iZzb18))) {
                            }
                        } else {
                            boolean zZza = zzaeoVar.zza();
                            for (int i43 = 0; i43 < iZzb17; i43++) {
                                if (!zZza) {
                                    zzaeoVar.zzc(5);
                                } else if (zzaeoVar.zza()) {
                                    zzaeoVar.zzc(5);
                                }
                            }
                        }
                        int iZzb19 = zzaeoVar.zzb(i4);
                        if (iZzb19 > 2) {
                            StringBuilder sb4 = new StringBuilder(String.valueOf(iZzb19).length() + 42);
                            sb4.append("lookup type greater than 2 not decodable: ");
                            sb4.append(iZzb19);
                            throw zzat.zzb(sb4.toString(), null);
                        }
                        if (iZzb19 != 1) {
                            if (iZzb19 != 2) {
                                zzaerVar = zzaerVar2;
                            }
                            i10++;
                            zzaerVar2 = zzaerVar;
                            i4 = 4;
                        } else {
                            i11 = iZzb19;
                        }
                        zzaeoVar.zzc(32);
                        zzaeoVar.zzc(32);
                        int iZzb20 = zzaeoVar.zzb(i4) + 1;
                        zzaeoVar.zzc(1);
                        if (i11 != 1) {
                            zzaerVar = zzaerVar2;
                            jFloor = ((long) iZzb16) * ((long) iZzb17);
                        } else if (iZzb16 != 0) {
                            zzaerVar = zzaerVar2;
                            jFloor = (long) Math.floor(Math.pow(iZzb17, 1.0d / ((double) iZzb16)));
                        } else {
                            zzaerVar = zzaerVar2;
                            jFloor = 0;
                        }
                        zzaeoVar.zzc((int) (jFloor * ((long) iZzb20)));
                        i10++;
                        zzaerVar2 = zzaerVar;
                        i4 = 4;
                    }
                }
            }
        }
        zzajxVar = null;
        this.zza = zzajxVar;
        if (zzajxVar == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        zzaer zzaerVar4 = zzajxVar.zza;
        arrayList.add(zzaerVar4.zzg);
        arrayList.add(zzajxVar.zzc);
        zzap zzapVarZzc = zzaes.zzc(zzgpe.zzr(zzajxVar.zzb.zza));
        zzt zztVar = new zzt();
        zztVar.zzl(MimeTypes.AUDIO_OGG);
        zztVar.zzm(MimeTypes.AUDIO_VORBIS);
        zztVar.zzh(zzaerVar4.zzd);
        zztVar.zzi(zzaerVar4.zzc);
        zztVar.zzE(zzaerVar4.zza);
        zztVar.zzF(zzaerVar4.zzb);
        zztVar.zzp(arrayList);
        zztVar.zzk(zzapVarZzc);
        zzajuVar.zza = zztVar.zzM();
        return true;
    }
}
