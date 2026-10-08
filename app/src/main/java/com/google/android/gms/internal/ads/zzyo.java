package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzyo extends zzyr {
    protected abstract Pair zzh(zzyn zzynVar, int[][][] iArr, int[] iArr2, zzuu zzuuVar, zzbf zzbfVar) throws zzib;

    @Override // com.google.android.gms.internal.ads.zzyr
    public final void zzp(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    public final zzys zzq(zzlp[] zzlpVarArr, zzwv zzwvVar, zzuu zzuuVar, zzbf zzbfVar) throws zzib {
        List[] listArr;
        boolean z;
        int[] iArr;
        int[] iArr2 = new int[3];
        zzbg[][] zzbgVarArr = new zzbg[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i = 0; i < 3; i++) {
            int i2 = zzwvVar.zzb;
            zzbgVarArr[i] = new zzbg[i2];
            iArr3[i] = new int[i2][];
        }
        int i3 = 2;
        int[] iArr4 = new int[2];
        for (int i4 = 0; i4 < 2; i4++) {
            iArr4[i4] = zzlpVarArr[i4].zzu();
        }
        int i5 = 0;
        while (i5 < zzwvVar.zzb) {
            zzbg zzbgVarZza = zzwvVar.zza(i5);
            int i6 = zzbgVarZza.zzc;
            int i7 = i3;
            int i8 = 0;
            int i9 = 0;
            boolean z2 = true;
            while (i8 < i3) {
                zzlp zzlpVar = zzlpVarArr[i8];
                int iMax = 0;
                for (int i10 = 0; i10 < zzbgVarZza.zza; i10++) {
                    iMax = Math.max(iMax, zzlpVar.zzab(zzbgVarZza.zza(i10)) & 7);
                }
                boolean z3 = iArr2[i8] == 0;
                if (iMax > i9) {
                    z2 = z3;
                    i7 = i8;
                    i9 = iMax;
                } else if (iMax == i9 && i6 == 5 && !z2 && z3) {
                    i7 = i8;
                    i9 = iMax;
                    z2 = true;
                }
                i8++;
                i3 = 2;
            }
            if (i7 == i3) {
                iArr = new int[zzbgVarZza.zza];
            } else {
                zzlp zzlpVar2 = zzlpVarArr[i7];
                int i11 = zzbgVarZza.zza;
                int[] iArr5 = new int[i11];
                for (int i12 = 0; i12 < i11; i12++) {
                    iArr5[i12] = zzlpVar2.zzab(zzbgVarZza.zza(i12));
                }
                iArr = iArr5;
            }
            int i13 = iArr2[i7];
            zzbgVarArr[i7][i13] = zzbgVarZza;
            iArr3[i7][i13] = iArr;
            iArr2[i7] = i13 + 1;
            i5++;
            i3 = 2;
        }
        int i14 = i3;
        boolean z4 = true;
        zzwv[] zzwvVarArr = new zzwv[i14];
        String[] strArr = new String[i14];
        int[] iArr6 = new int[i14];
        int i15 = 0;
        while (i15 < i14) {
            int i16 = iArr2[i15];
            zzwvVarArr[i15] = new zzwv((zzbg[]) zzep.zzb(zzbgVarArr[i15], i16));
            iArr3[i15] = (int[][]) zzep.zzb(iArr3[i15], i16);
            strArr[i15] = zzlpVarArr[i15].zzS();
            iArr6[i15] = zzlpVarArr[i15].zza();
            i15++;
            i14 = 2;
        }
        int i17 = i14;
        zzyn zzynVar = new zzyn(strArr, iArr6, zzwvVarArr, iArr4, iArr3, new zzwv((zzbg[]) zzep.zzb(zzbgVarArr[i17], iArr2[i17])));
        Pair pairZzh = zzh(zzynVar, iArr3, iArr4, zzuuVar, zzbfVar);
        zzyp[] zzypVarArr = (zzyp[]) pairZzh.second;
        List[] listArr2 = new List[zzypVarArr.length];
        for (int i18 = 0; i18 < zzypVarArr.length; i18++) {
            zzyp zzypVar = zzypVarArr[i18];
            listArr2[i18] = zzypVar != null ? zzgpe.zzj(zzypVar) : zzgpe.zzi();
        }
        zzgpb zzgpbVar = new zzgpb();
        int i19 = 0;
        while (i19 < 2) {
            zzwv zzwvVarZzb = zzynVar.zzb(i19);
            List list = listArr2[i19];
            int i20 = 0;
            while (i20 < zzwvVarZzb.zzb) {
                zzbg zzbgVarZza2 = zzwvVarZzb.zza(i20);
                boolean z5 = zzynVar.zzd(i19, i20, false) != 0 ? z4 : false;
                int i21 = zzbgVarZza2.zza;
                int[] iArr7 = new int[i21];
                boolean[] zArr = new boolean[i21];
                int i22 = 0;
                while (i22 < i21) {
                    iArr7[i22] = zzynVar.zzc(i19, i20, i22) & 7;
                    int i23 = 0;
                    while (true) {
                        if (i23 >= list.size()) {
                            listArr = listArr2;
                            z = false;
                            break;
                        }
                        zzyp zzypVar2 = (zzyp) list.get(i23);
                        listArr = listArr2;
                        if (zzypVar2.zza().equals(zzbgVarZza2) && zzypVar2.zzg(i22) != -1) {
                            z = true;
                            break;
                        }
                        i23++;
                        listArr2 = listArr;
                    }
                    zArr[i22] = z;
                    i22++;
                    listArr2 = listArr;
                }
                zzgpbVar.zzf(new zzbm(zzbgVarZza2, z5, iArr7, zArr));
                i20++;
                z4 = true;
            }
            i19++;
            z4 = true;
        }
        zzwv zzwvVarZze = zzynVar.zze();
        for (int i24 = 0; i24 < zzwvVarZze.zzb; i24++) {
            zzbg zzbgVarZza3 = zzwvVarZze.zza(i24);
            int i25 = zzbgVarZza3.zza;
            int[] iArr8 = new int[i25];
            Arrays.fill(iArr8, 0);
            zzgpbVar.zzf(new zzbm(zzbgVarZza3, false, iArr8, new boolean[i25]));
        }
        return new zzys((zzlq[]) pairZzh.first, (zzyk[]) pairZzh.second, new zzbn(zzgpbVar.zzi()), zzynVar);
    }
}
