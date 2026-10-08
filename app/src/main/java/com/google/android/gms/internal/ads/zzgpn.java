package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgpn extends zzgoy {
    Object[] zzd;
    private int zze;

    public zzgpn() {
        super(4);
    }

    @Override // com.google.android.gms.internal.ads.zzgoy, com.google.android.gms.internal.ads.zzgoz
    public final /* bridge */ /* synthetic */ zzgoz zzd(Object obj) {
        zzf(obj);
        return this;
    }

    public final zzgpn zzg(Object... objArr) {
        if (this.zzd != null) {
            for (int i = 0; i < 2; i++) {
                zzf(objArr[i]);
            }
        } else {
            zzb(objArr, 2);
        }
        return this;
    }

    zzgpn(int i, boolean z) {
        super(i);
        this.zzd = new Object[zzgpo.zzn(i)];
    }

    public final zzgpn zzh(Iterable iterable) {
        iterable.getClass();
        if (this.zzd != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                zzf(it.next());
            }
        } else {
            super.zzc(iterable);
        }
        return this;
    }

    public final zzgpo zzi() {
        zzgpo zzgpoVarZzv;
        int i = this.zzb;
        if (i == 0) {
            return zzgrf.zza;
        }
        if (i == 1) {
            return new zzgrp(Objects.requireNonNull(this.zza[0]));
        }
        if (this.zzd == null || zzgpo.zzn(i) != this.zzd.length) {
            zzgpoVarZzv = zzgpo.zzv(this.zzb, this.zza);
            this.zzb = zzgpoVarZzv.size();
        } else {
            int i2 = this.zzb;
            Object[] objArrCopyOf = this.zza;
            if (zzgpo.zzw(i2, objArrCopyOf.length)) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i2);
            }
            zzgpoVarZzv = new zzgrf(objArrCopyOf, this.zze, this.zzd, r6.length - 1, this.zzb);
        }
        this.zzc = true;
        this.zzd = null;
        return zzgpoVarZzv;
    }

    public final zzgpn zzf(Object obj) {
        obj.getClass();
        if (this.zzd != null) {
            int iZzn = zzgpo.zzn(this.zzb);
            Object[] objArr = this.zzd;
            if (iZzn <= objArr.length) {
                Objects.requireNonNull(objArr);
                int length = this.zzd.length - 1;
                int iHashCode = obj.hashCode();
                int iZza = zzgox.zza(iHashCode);
                while (true) {
                    int i = iZza & length;
                    Object[] objArr2 = this.zzd;
                    Object obj2 = objArr2[i];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        iZza = i + 1;
                    } else {
                        objArr2[i] = obj;
                        this.zze += iHashCode;
                        super.zza(obj);
                        break;
                    }
                }
                return this;
            }
        }
        this.zzd = null;
        super.zza(obj);
        return this;
    }
}
