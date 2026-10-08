package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzabc extends AbstractMap {
    private static final Comparator zza = new zzaaz();
    private final Object[] zzb;
    private final int[] zzc;
    private final Set zzd = new zzabb(this, -1);
    private Integer zze = null;
    private String zzf = null;

    zzabc(zzabc zzabcVar, zzabc zzabcVar2) {
        int i;
        Object objZza;
        Object[] objArr;
        int size = zzabcVar.size() + zzabcVar2.size();
        int i2 = zzabcVar.zzc[zzabcVar.size()] + zzabcVar2.zzc[zzabcVar2.size()];
        int i3 = size + 1;
        Object[] objArr2 = new Object[i2];
        int[] iArr = new int[i3];
        int i4 = 0;
        iArr[0] = size;
        int i5 = size;
        Map.Entry entryZzg = zzabcVar.zzg(0);
        Map.Entry entryZzg2 = zzabcVar2.zzg(0);
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (entryZzg == null && entryZzg2 == null) {
                break;
            }
            int i9 = i6 + 1;
            if (entryZzg != null) {
                if (entryZzg2 != null) {
                    int iCompareTo = ((String) entryZzg.getKey()).compareTo((String) entryZzg2.getKey());
                    if (iCompareTo == 0) {
                        int i10 = i7 + 1;
                        int i11 = i8 + 1;
                        objArr2[i6] = zzf((String) entryZzg.getKey(), i6);
                        zzabb zzabbVar = (zzabb) entryZzg.getValue();
                        zzabb zzabbVar2 = (zzabb) entryZzg2.getValue();
                        int i12 = i4;
                        int i13 = i12;
                        while (true) {
                            if (i13 >= zzabbVar.zzc() - zzabbVar.zzb() && i12 >= zzabbVar2.zzc() - zzabbVar2.zzb()) {
                                break;
                            }
                            int iCompare = i13 == zzabbVar.zzc() - zzabbVar.zzb() ? 1 : i12 == zzabbVar2.zzc() - zzabbVar2.zzb() ? -1 : i4;
                            if (iCompare == 0) {
                                int i14 = zzabe.zza;
                                i = i10;
                                iCompare = zzabe.zzb.compare(zzabbVar.zza(i13), zzabbVar2.zza(i12));
                            } else {
                                i = i10;
                            }
                            if (iCompare < 0) {
                                objZza = zzabbVar.zza(i13);
                                i13++;
                            } else {
                                int i15 = i12 + 1;
                                Object objZza2 = zzabbVar2.zza(i12);
                                i13 = iCompare == 0 ? i13 + 1 : i13;
                                objZza = objZza2;
                                i12 = i15;
                            }
                            objArr2[i5] = objZza;
                            i5++;
                            i10 = i;
                            i4 = 0;
                        }
                        iArr[i9] = i5;
                        entryZzg = zzabcVar.zzg(i11);
                        entryZzg2 = zzabcVar2.zzg(i10);
                        i7 = i10;
                        i8 = i11;
                        i6 = i9;
                    } else {
                        if (iCompareTo < 0) {
                        }
                        i6 = i9;
                        i4 = 0;
                    }
                }
                int i16 = i8 + 1;
                int iZzd = zzd(entryZzg, i6, i5, objArr2, iArr);
                entryZzg = zzabcVar.zzg(i16);
                i5 = iZzd;
                i8 = i16;
                i6 = i9;
                i4 = 0;
            }
            int i17 = i7 + 1;
            int iZzd2 = zzd(entryZzg2, i6, i5, objArr2, iArr);
            entryZzg2 = zzabcVar2.zzg(i17);
            i5 = iZzd2;
            i7 = i17;
            i6 = i9;
            i4 = 0;
        }
        int i18 = iArr[i4];
        int i19 = i18 - i6;
        if (i19 != 0) {
            for (int i20 = i4; i20 <= i6; i20++) {
                iArr[i20] = iArr[i20] - i19;
            }
            int i21 = iArr[i6];
            int i22 = i21 - i6;
            if (zze(i2, i21)) {
                objArr = new Object[i21];
                System.arraycopy(objArr2, i4, objArr, i4, i6);
            } else {
                objArr = objArr2;
            }
            System.arraycopy(objArr2, i18, objArr, i6, i22);
            objArr2 = objArr;
        }
        this.zzb = objArr2;
        int i23 = iArr[i4] + 1;
        this.zzc = zze(i3, i23) ? Arrays.copyOf(iArr, i23) : iArr;
    }

    private final int zzd(Map.Entry entry, int i, int i2, Object[] objArr, int[] iArr) {
        zzabb zzabbVar = (zzabb) entry.getValue();
        int iZzc = zzabbVar.zzc() - zzabbVar.zzb();
        System.arraycopy(zzabbVar.zzb.zzb, zzabbVar.zzb(), objArr, i2, iZzc);
        objArr[i] = zzf((String) entry.getKey(), i);
        int i3 = i2 + iZzc;
        iArr[i + 1] = i3;
        return i3;
    }

    private static boolean zze(int i, int i2) {
        return i > 16 && i * 9 > i2 * 10;
    }

    private final Map.Entry zzf(String str, int i) {
        return new AbstractMap.SimpleImmutableEntry(str, new zzabb(this, i));
    }

    private final Map.Entry zzg(int i) {
        if (i < this.zzc[0]) {
            return (Map.Entry) this.zzb[i];
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return this.zzd;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        if (this.zze == null) {
            this.zze = Integer.valueOf(super.hashCode());
        }
        return this.zze.intValue();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        if (this.zzf == null) {
            this.zzf = super.toString();
        }
        return this.zzf;
    }

    final /* synthetic */ Object[] zzb() {
        return this.zzb;
    }

    final /* synthetic */ int[] zzc() {
        return this.zzc;
    }

    zzabc(List list) {
        Iterator it = list.iterator();
        if (it.hasNext()) {
            throw null;
        }
        int size = list.size();
        Object[] objArr = new Object[size];
        int[] iArr = new int[1];
        Iterator it2 = list.iterator();
        if (it2.hasNext()) {
            throw null;
        }
        iArr[0] = 0;
        this.zzb = zze(size, 0) ? Arrays.copyOf(objArr, 0) : objArr;
        this.zzc = iArr;
    }
}
