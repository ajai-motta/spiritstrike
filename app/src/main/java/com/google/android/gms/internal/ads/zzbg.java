package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbg {
    public final int zza;
    public final String zzb;
    public final int zzc;
    private final zzv[] zzd;
    private int zze;

    static {
        String str = zzep.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
    }

    public zzbg(String str, zzv... zzvVarArr) {
        int length = zzvVarArr.length;
        int i = 1;
        zzgmd.zza(length > 0);
        this.zzb = str;
        this.zzd = zzvVarArr;
        this.zza = length;
        int iZzg = zzas.zzg(zzvVarArr[0].zzo);
        this.zzc = iZzg == -1 ? zzas.zzg(zzvVarArr[0].zzn) : iZzg;
        String strZzc = zzc(zzvVarArr[0].zzd);
        int i2 = zzvVarArr[0].zzf | 16384;
        while (true) {
            zzv[] zzvVarArr2 = this.zzd;
            if (i >= zzvVarArr2.length) {
                return;
            }
            if (!strZzc.equals(zzc(zzvVarArr2[i].zzd))) {
                zzv[] zzvVarArr3 = this.zzd;
                zzd("languages", zzvVarArr3[0].zzd, zzvVarArr3[i].zzd, i);
                return;
            } else {
                zzv[] zzvVarArr4 = this.zzd;
                if (i2 != (zzvVarArr4[i].zzf | 16384)) {
                    zzd("role flags", Integer.toBinaryString(zzvVarArr4[0].zzf), Integer.toBinaryString(this.zzd[i].zzf), i);
                    return;
                }
                i++;
            }
        }
    }

    private static String zzc(String str) {
        return (str == null || str.equals(C.LANGUAGE_UNDETERMINED)) ? "" : str;
    }

    private static void zzd(String str, String str2, String str3, int i) {
        int length = String.valueOf(str2).length();
        int length2 = String.valueOf(str3).length();
        StringBuilder sb = new StringBuilder(str.length() + 40 + length + 17 + length2 + 9 + String.valueOf(i).length() + 1);
        sb.append("Different ");
        sb.append(str);
        sb.append(" combined in one TrackGroup: '");
        sb.append(str2);
        sb.append("' (track 0) and '");
        sb.append(str3);
        sb.append("' (track ");
        sb.append(i);
        sb.append(")");
        zzdt.zzf("TrackGroup", "", new IllegalStateException(sb.toString()));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzbg zzbgVar = (zzbg) obj;
            if (this.zzb.equals(zzbgVar.zzb) && Arrays.equals(this.zzd, zzbgVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zze;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((this.zzb.hashCode() + 527) * 31) + Arrays.hashCode(this.zzd);
        this.zze = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        String string = Arrays.toString(this.zzd);
        String str = this.zzb;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(string).length());
        sb.append(str);
        sb.append(": ");
        sb.append(string);
        return sb.toString();
    }

    public final zzv zza(int i) {
        return this.zzd[i];
    }

    public final int zzb(zzv zzvVar) {
        int i = 0;
        while (true) {
            zzv[] zzvVarArr = this.zzd;
            if (i >= zzvVarArr.length) {
                return -1;
            }
            if (zzvVar == zzvVarArr[i]) {
                return i;
            }
            i++;
        }
    }
}
