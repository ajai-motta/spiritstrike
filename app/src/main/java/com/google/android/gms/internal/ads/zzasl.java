package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzasl {
    public int zza;
    public zzasg zzb;
    public zzaru zzc;
    public zzarx zzd;

    zzasl() {
        this(new zzarx(1));
    }

    public zzasl(zzarx zzarxVar) {
        this(zzasg.zzb, 0, new zzarv());
        this.zzd = zzarxVar;
    }

    private zzasl(zzasg zzasgVar, int i, zzaru zzaruVar) {
        this.zzb = zzasgVar;
        this.zza = i;
        this.zzc = zzaruVar;
    }

    public zzasl(zzasg zzasgVar, int i, zzaru zzaruVar, zzarx zzarxVar) {
        this(zzasgVar, i, zzaruVar);
        this.zzd = zzarxVar;
    }

    private final long zzg() throws zzask, zzasi {
        int[] iArr = {1246322141, 272302173, 1841378864, 825937997, 658822930, -1784934195, 38700438, 1600766768, 649830540};
        int i = 0;
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        int i10 = i8 + ((((i3 & (~i2)) | i4) + ((i2 & i5) | i6)) - i7);
        int i11 = i9 % 649830540;
        iArr[0] = 680326130;
        iArr[1] = 1378702392;
        iArr[2] = 3315809;
        iArr[3] = 1913472410;
        iArr[4] = 739293607;
        iArr[5] = -1193353858;
        iArr[6] = 1053514403;
        iArr[7] = 1743768897;
        iArr[8] = 152059765;
        int i12 = (((1378702392 & (~680326130)) | 3315809) + ((680326130 & 1913472410) | 739293607)) - 2048099035;
        int i13 = 1743768897 % 152059765;
        iArr[0] = 973294814;
        iArr[1] = 1252035530;
        iArr[2] = 51191353;
        iArr[3] = 1755616710;
        iArr[4] = 889459732;
        iArr[5] = 1628051670;
        iArr[6] = 133875502;
        iArr[7] = 1861701682;
        iArr[8] = 1196748250;
        int i14 = (((1252035530 & (~973294814)) | 51191353) + ((973294814 & 1755616710) | 889459732)) - 1494176168;
        int i15 = 1861701682 % 1196748250;
        iArr[0] = 29116548;
        iArr[1] = 174422021;
        iArr[2] = 84710160;
        iArr[3] = -1973327347;
        iArr[4] = -1266641286;
        iArr[5] = -1298677495;
        iArr[6] = 593052434;
        iArr[7] = 2091729405;
        iArr[8] = 1207774949;
        int i16 = (((174422021 & (~29116548)) | 84710160) + ((29116548 & (-1973327347)) | (-1266641286))) - (-1891729929);
        int i17 = 2091729405 % 1207774949;
        iArr[0] = 80201211;
        iArr[1] = 1629524354;
        iArr[2] = 38778411;
        iArr[3] = 1977746312;
        iArr[4] = 382371455;
        iArr[5] = -934978761;
        iArr[6] = 1438507752;
        iArr[7] = 1050760512;
        iArr[8] = 184320788;
        int i18 = ((((~80201211) & 1629524354) | 38778411) + ((80201211 & 1977746312) | 382371455)) - 1921480783;
        int i19 = 1050760512 % 184320788;
        long j = 0;
        while (i < (i10 ^ i11)) {
            try {
                zzaru zzaruVar = this.zzc;
                zzasg zzasgVar = this.zzb;
                int i20 = this.zza;
                this.zza = i20 + 1;
                byte bZza = zzaruVar.zza(zzasgVar, i20);
                int i21 = i14 ^ i15;
                int i22 = i12;
                j |= ((long) ((i12 ^ i13) & bZza)) << i;
                if (i == i21) {
                    if (bZza > 1) {
                        throw new zzasi();
                    }
                    i = i21;
                }
                if ((bZza & (i16 ^ i17)) == 0) {
                    return (j >>> 1) ^ (-(1 & j));
                }
                i += i18 ^ i19;
                i12 = i22;
            } catch (IndexOutOfBoundsException e) {
                throw new zzask(e);
            }
        }
        throw new zzasi();
    }

    private static final void zzh(long j) throws zzasj {
        long[] jArr = {141540322, 456640674, 1141397064, 993500330, 1614820873, 3337980909L, 410218731, 1716462158, 477127367};
        long j2 = jArr[0];
        long j3 = jArr[1];
        long j4 = jArr[2];
        long j5 = jArr[3];
        long j6 = jArr[4];
        long j7 = jArr[5];
        if (j % ((jArr[6] + ((((j3 & (~j2)) | j4) + ((j2 & j5) | j6)) - j7)) ^ (jArr[7] % 477127367)) != 0) {
            throw new zzasj();
        }
    }

    public final void zza(long j) throws zzask, zzasj {
        long[] jArr = {2139842053, 728564241, 750932242, 1403848321, 1892818418, 4558981222L, 1919655804, 1856374729, 899334107};
        long j2 = jArr[0];
        long j3 = jArr[1];
        long j4 = jArr[2];
        long j5 = jArr[3];
        long j6 = jArr[4];
        long j7 = jArr[5];
        long j8 = jArr[6];
        long j9 = jArr[7];
        zzh(j);
        long j10 = j / ((j8 + (((((~j2) & j3) | j4) + ((j2 & j5) | j6)) - j7)) ^ (j9 % 899334107));
        if (j10 >= 0 && j10 <= this.zzb.zza.length) {
            this.zza = (int) j10;
            return;
        }
        throw new zzask();
    }

    public final long zzb() {
        long[] jArr = {491705403, 818579170, 1201981453, 810223590, 1243973916, 3701563257L, 554701476, 1889947178, 1780695788};
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        return ((long) this.zza) * ((jArr[6] + ((((j2 & (~j)) | j3) + ((j & j4) | j5)) - j6)) ^ (jArr[7] % 1780695788));
    }

    public final long zzc() throws zzask {
        try {
            zzaru zzaruVar = this.zzc;
            zzasg zzasgVar = this.zzb;
            this.zza = this.zza + 1;
            return zzaruVar.zza(zzasgVar, r2);
        } catch (IndexOutOfBoundsException e) {
            throw new zzask(e);
        }
    }

    public final int zzd() throws zzask {
        int[] iArr = {413360099, 1621678468, 84323740, 1621644360, 385888249, 1519637107, 6072641, 1609416931, 1031126087};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6);
        int i10 = i8 % 1031126087;
        iArr[0] = 978587665;
        iArr[1] = 1228171537;
        iArr[2] = 1025392332;
        iArr[3] = 1075859857;
        iArr[4] = 983056096;
        iArr[5] = -1399000561;
        iArr[6] = 190113083;
        iArr[7] = 1723578341;
        iArr[8] = 672563970;
        int i11 = (((1228171537 & (~978587665)) | 1025392332) + ((978587665 & 1075859857) | 983056096)) - (-1589113644);
        int i12 = 1723578341 % 672563970;
        iArr[0] = 1163384280;
        iArr[1] = 546336857;
        iArr[2] = 505597090;
        iArr[3] = 546323033;
        iArr[4] = 358992768;
        iArr[5] = 1545617422;
        iArr[6] = 198628789;
        iArr[7] = 1124734562;
        iArr[8] = 530406424;
        int i13 = (((546336857 & (~1163384280)) | 505597090) + ((1163384280 & 546323033) | 358992768)) - 1346988633;
        int i14 = 1124734562 % 530406424;
        iArr[0] = 217161528;
        iArr[1] = 116398273;
        iArr[2] = 202500381;
        iArr[3] = 316821712;
        iArr[4] = 269928733;
        iArr[5] = 415634774;
        iArr[6] = 5622716;
        iArr[7] = 529302443;
        iArr[8] = 418646579;
        int i15 = ((((~217161528) & 116398273) | 202500381) + ((217161528 & 316821712) | 269928733)) - 410012058;
        int i16 = 529302443 % 418646579;
        try {
            zzaru zzaruVar = this.zzc;
            zzasg zzasgVar = this.zzb;
            int i17 = this.zza;
            this.zza = i17 + 1;
            byte bZza = zzaruVar.zza(zzasgVar, i17);
            int i18 = i9 ^ i10;
            zzaru zzaruVar2 = this.zzc;
            zzasg zzasgVar2 = this.zzb;
            int i19 = this.zza;
            this.zza = i19 + 1;
            int iZza = (bZza & i18) | ((zzaruVar2.zza(zzasgVar2, i19) & i18) << (i11 ^ i12));
            zzaru zzaruVar3 = this.zzc;
            zzasg zzasgVar3 = this.zzb;
            int i20 = this.zza;
            this.zza = i20 + 1;
            int iZza2 = iZza | ((i18 & zzaruVar3.zza(zzasgVar3, i20)) << (i13 ^ i14));
            zzaru zzaruVar4 = this.zzc;
            zzasg zzasgVar4 = this.zzb;
            int i21 = this.zza;
            this.zza = i21 + 1;
            return (zzaruVar4.zza(zzasgVar4, i21) << (i15 ^ i16)) | iZza2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzask(e);
        }
    }

    public final long zze() throws zzask, zzasi {
        return zzg();
    }

    public final zzasg zzf(long j) throws zzask, zzasj {
        int[] iArr = {1667674495, 1502201381, 1197125461, 478240810, 622476187, -1652496091, 840440151, 1203013321, 774318984};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6);
        zzh(zzb() + j);
        int i10 = this.zza;
        long j2 = i10;
        zzasg zzasgVar = this.zzb;
        long j3 = (j >> ((i8 % 774318984) ^ i9)) + j2;
        if (j3 > zzasgVar.zza.length || j3 < j2) {
            throw new zzask();
        }
        try {
            int i11 = (int) j3;
            zzasg zzasgVarZzb = this.zzc.zzb(zzasgVar, i10, i11);
            this.zza = i11;
            return zzasgVarZzb;
        } catch (IndexOutOfBoundsException e) {
            throw new AssertionError(zzase.zza("CEiv6BFfPnitUE+D"), e);
        }
    }
}
