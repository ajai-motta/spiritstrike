package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzacf {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final float zzk;
    public final String zzl;

    private zzacf(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f, String str) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = i8;
        this.zzj = i9;
        this.zzk = f;
        this.zzl = str;
    }

    public static zzacf zza(zzeg zzegVar) throws zzat {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        String strZza;
        float f;
        try {
            zzegVar.zzk(4);
            int iZzs = (zzegVar.zzs() & 3) + 1;
            if (iZzs == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iZzs2 = zzegVar.zzs() & 31;
            for (int i9 = 0; i9 < iZzs2; i9++) {
                arrayList.add(zzb(zzegVar));
            }
            int iZzs3 = zzegVar.zzs();
            for (int i10 = 0; i10 < iZzs3; i10++) {
                arrayList.add(zzb(zzegVar));
            }
            if (iZzs2 > 0) {
                byte[] bArr = (byte[]) arrayList.get(0);
                byte[] bArr2 = (byte[]) arrayList.get(0);
                byte[] bArr3 = zzfm.zza;
                zzfl zzflVarZzd = zzfm.zzd(bArr2, 5, bArr.length);
                int i11 = zzflVarZzd.zze;
                int i12 = zzflVarZzd.zzf;
                int i13 = zzflVarZzd.zzh + 8;
                int i14 = zzflVarZzd.zzi + 8;
                int i15 = zzflVarZzd.zzj;
                int i16 = zzflVarZzd.zzk;
                int i17 = zzflVarZzd.zzl;
                int i18 = zzflVarZzd.zzm;
                float f2 = zzflVarZzd.zzg;
                strZza = zzdd.zza(zzflVarZzd.zza, zzflVarZzd.zzb, zzflVarZzd.zzc);
                i7 = i17;
                i8 = i18;
                f = f2;
                i4 = i14;
                i5 = i15;
                i6 = i16;
                i = i11;
                i2 = i12;
                i3 = i13;
            } else {
                i = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                i6 = -1;
                i7 = -1;
                i8 = 16;
                strZza = null;
                f = 1.0f;
            }
            return new zzacf(arrayList, iZzs, i, i2, i3, i4, i5, i6, i7, i8, f, strZza);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw zzat.zzb("Error parsing AVC config", e);
        }
    }

    private static byte[] zzb(zzeg zzegVar) {
        int iZzt = zzegVar.zzt();
        int iZzg = zzegVar.zzg();
        zzegVar.zzk(iZzt);
        return zzdd.zzf(zzegVar.zzi(), iZzg, iZzt);
    }
}
