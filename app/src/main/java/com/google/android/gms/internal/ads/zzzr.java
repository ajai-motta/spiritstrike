package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzzr {
    private static final Comparator zza = zzzq.zza;
    private static final Comparator zzb = zzzp.zza;
    private int zzf;
    private int zzg;
    private int zzh;
    private final zzzo[] zzd = new zzzo[5];
    private final ArrayList zzc = new ArrayList();
    private int zze = -1;

    public zzzr(int i) {
    }

    public final void zza() {
        this.zzc.clear();
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
    }

    public final void zzb(int i, float f) {
        zzzo zzzoVar;
        if (this.zze != 1) {
            Collections.sort(this.zzc, zza);
            this.zze = 1;
        }
        int i2 = this.zzh;
        if (i2 > 0) {
            zzzo[] zzzoVarArr = this.zzd;
            int i3 = i2 - 1;
            this.zzh = i3;
            zzzoVar = zzzoVarArr[i3];
        } else {
            zzzoVar = new zzzo(null);
        }
        int i4 = this.zzf;
        this.zzf = i4 + 1;
        zzzoVar.zza = i4;
        zzzoVar.zzb = i;
        zzzoVar.zzc = f;
        ArrayList arrayList = this.zzc;
        arrayList.add(zzzoVar);
        this.zzg += i;
        while (true) {
            int i5 = this.zzg;
            if (i5 <= 2000) {
                return;
            }
            int i6 = i5 - 2000;
            zzzo zzzoVar2 = (zzzo) arrayList.get(0);
            int i7 = zzzoVar2.zzb;
            if (i7 <= i6) {
                this.zzg -= i7;
                arrayList.remove(0);
                int i8 = this.zzh;
                if (i8 < 5) {
                    zzzo[] zzzoVarArr2 = this.zzd;
                    this.zzh = i8 + 1;
                    zzzoVarArr2[i8] = zzzoVar2;
                }
            } else {
                zzzoVar2.zzb = i7 - i6;
                this.zzg -= i6;
            }
        }
    }

    public final float zzc(float f) {
        int i = 0;
        if (this.zze != 0) {
            Collections.sort(this.zzc, zzb);
            this.zze = 0;
        }
        float f2 = this.zzg;
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.zzc;
            if (i >= arrayList.size()) {
                if (arrayList.isEmpty()) {
                    return Float.NaN;
                }
                return ((zzzo) arrayList.get(arrayList.size() - 1)).zzc;
            }
            float f3 = 0.5f * f2;
            zzzo zzzoVar = (zzzo) arrayList.get(i);
            i2 += zzzoVar.zzb;
            if (i2 >= f3) {
                return zzzoVar.zzc;
            }
            i++;
        }
    }
}
