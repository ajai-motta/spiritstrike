package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzgpo<E> extends zzgpa<E> implements Set<E> {
    private transient zzgpe zza;

    zzgpo() {
    }

    public static zzgpo zzh() {
        return zzgrf.zza;
    }

    public static zzgpo zzi(Object obj) {
        return new zzgrp(obj);
    }

    public static zzgpo zzj(Object obj, Object obj2) {
        return zzv(2, obj, obj2);
    }

    public static zzgpo zzk(Object obj, Object obj2, Object obj3) {
        return zzv(3, obj, obj2, obj3);
    }

    public static zzgpo zzl(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzv(5, obj, obj2, obj3, obj4, obj5);
    }

    @SafeVarargs
    public static zzgpo zzm(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        int length = objArr.length;
        int i = length + 6;
        Object[] objArr2 = new Object[i];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, length);
        return zzv(i, objArr2);
    }

    static int zzn(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            zzgmd.zzb(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zzgpo zzo(Collection collection) {
        if ((collection instanceof zzgpo) && !(collection instanceof SortedSet)) {
            zzgpo zzgpoVar = (zzgpo) collection;
            if (!zzgpoVar.zzf()) {
                return zzgpoVar;
            }
        }
        Object[] array = collection.toArray();
        return zzv(array.length, array);
    }

    public static zzgpo zzp(Object[] objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? zzv(length, (Object[]) objArr.clone()) : new zzgrp(objArr[0]) : zzgrf.zza;
    }

    public static zzgpn zzs(int i) {
        zzgoc.zzb(i, "expectedSize");
        return new zzgpn(i, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzw(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzgpo) && zzq() && ((zzgpo) obj).zzq() && hashCode() != obj.hashCode()) {
            return false;
        }
        return zzgro.zzd(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzgro.zzc(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgpa, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public abstract zzgrs iterator();

    @Override // com.google.android.gms.internal.ads.zzgpa
    public zzgpe zze() {
        zzgpe zzgpeVar = this.zza;
        if (zzgpeVar != null) {
            return zzgpeVar;
        }
        zzgpe zzgpeVarZzr = zzr();
        this.zza = zzgpeVarZzr;
        return zzgpeVarZzr;
    }

    boolean zzq() {
        return false;
    }

    zzgpe zzr() {
        Object[] array = toArray();
        int i = zzgpe.zzd;
        return zzgpe.zzt(array, array.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzgpo zzv(int i, Object... objArr) {
        if (i == 0) {
            return zzgrf.zza;
        }
        if (i == 1) {
            return new zzgrp(Objects.requireNonNull(objArr[0]));
        }
        int iZzn = zzn(i);
        Object[] objArr2 = new Object[iZzn];
        int i2 = iZzn - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[i5];
            zzgqx.zzb(obj, i5);
            int iHashCode = obj.hashCode();
            int iZza = zzgox.zza(iHashCode);
            while (true) {
                int i6 = iZza & i2;
                Object obj2 = objArr2[i6];
                if (obj2 == null) {
                    objArr[i4] = obj;
                    objArr2[i6] = obj;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (!obj2.equals(obj)) {
                    iZza++;
                }
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            return new zzgrp(Objects.requireNonNull(objArr[0]));
        }
        if (zzn(i4) < iZzn / 2) {
            return zzv(i4, objArr);
        }
        if (zzw(i4, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzgrf(objArr, i3, objArr2, i2, i4);
    }
}
