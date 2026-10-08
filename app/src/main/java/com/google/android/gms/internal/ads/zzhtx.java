package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhtx extends AbstractMap implements Serializable {
    private static final Comparator zze = new zzhtq();
    zzhtw zza;
    int zzb;
    int zzc;
    final zzhtw zzd;
    private final Comparator zzf;
    private final boolean zzg;
    private zzhts zzh;
    private zzhtu zzi;

    public zzhtx() {
        this(zze, true);
    }

    private final void zzf(zzhtw zzhtwVar, zzhtw zzhtwVar2) {
        zzhtw zzhtwVar3 = zzhtwVar.zza;
        zzhtwVar.zza = null;
        if (zzhtwVar2 != null) {
            zzhtwVar2.zza = zzhtwVar3;
        }
        if (zzhtwVar3 == null) {
            this.zza = zzhtwVar2;
        } else if (zzhtwVar3.zzb == zzhtwVar) {
            zzhtwVar3.zzb = zzhtwVar2;
        } else {
            zzhtwVar3.zzc = zzhtwVar2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0080 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzg(com.google.android.gms.internal.ads.zzhtw r9, boolean r10) {
        /*
            r8 = this;
        L0:
            if (r9 == 0) goto L84
            com.google.android.gms.internal.ads.zzhtw r0 = r9.zzb
            com.google.android.gms.internal.ads.zzhtw r1 = r9.zzc
            r2 = 0
            if (r0 == 0) goto Lc
            int r3 = r0.zzi
            goto Ld
        Lc:
            r3 = r2
        Ld:
            if (r1 == 0) goto L12
            int r4 = r1.zzi
            goto L13
        L12:
            r4 = r2
        L13:
            int r5 = r3 - r4
            r6 = -2
            r7 = 1
            if (r5 != r6) goto L42
            com.google.android.gms.internal.ads.zzhtw r0 = r1.zzb
            com.google.android.gms.internal.ads.zzhtw r3 = r1.zzc
            if (r3 == 0) goto L22
            int r3 = r3.zzi
            goto L23
        L22:
            r3 = r2
        L23:
            if (r0 == 0) goto L28
            int r0 = r0.zzi
            goto L29
        L28:
            r0 = r2
        L29:
            int r0 = r0 - r3
            r3 = -1
            if (r0 == r3) goto L3a
            if (r0 != 0) goto L32
            if (r10 != 0) goto L33
            goto L3b
        L32:
            r7 = r10
        L33:
            r8.zzi(r1)
            r8.zzh(r9)
            goto L3f
        L3a:
            r2 = r10
        L3b:
            r8.zzh(r9)
            r7 = r2
        L3f:
            if (r7 != 0) goto L84
            goto L80
        L42:
            r1 = 2
            if (r5 != r1) goto L6d
            com.google.android.gms.internal.ads.zzhtw r1 = r0.zzb
            com.google.android.gms.internal.ads.zzhtw r3 = r0.zzc
            if (r3 == 0) goto L4e
            int r3 = r3.zzi
            goto L4f
        L4e:
            r3 = r2
        L4f:
            if (r1 == 0) goto L54
            int r1 = r1.zzi
            goto L55
        L54:
            r1 = r2
        L55:
            int r1 = r1 - r3
            if (r1 == r7) goto L65
            if (r1 != 0) goto L5d
            if (r10 != 0) goto L5e
            goto L66
        L5d:
            r7 = r10
        L5e:
            r8.zzh(r0)
            r8.zzi(r9)
            goto L6a
        L65:
            r2 = r10
        L66:
            r8.zzi(r9)
            r7 = r2
        L6a:
            if (r7 == 0) goto L80
            goto L84
        L6d:
            if (r5 != 0) goto L76
            int r3 = r3 + 1
            r9.zzi = r3
            if (r10 == 0) goto L80
            goto L84
        L76:
            int r0 = java.lang.Math.max(r3, r4)
            int r0 = r0 + r7
            r9.zzi = r0
            if (r10 != 0) goto L80
            goto L84
        L80:
            com.google.android.gms.internal.ads.zzhtw r9 = r9.zza
            goto L0
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhtx.zzg(com.google.android.gms.internal.ads.zzhtw, boolean):void");
    }

    private final void zzh(zzhtw zzhtwVar) {
        zzhtw zzhtwVar2 = zzhtwVar.zzb;
        zzhtw zzhtwVar3 = zzhtwVar.zzc;
        zzhtw zzhtwVar4 = zzhtwVar3.zzb;
        zzhtw zzhtwVar5 = zzhtwVar3.zzc;
        zzhtwVar.zzc = zzhtwVar4;
        if (zzhtwVar4 != null) {
            zzhtwVar4.zza = zzhtwVar;
        }
        zzf(zzhtwVar, zzhtwVar3);
        zzhtwVar3.zzb = zzhtwVar;
        zzhtwVar.zza = zzhtwVar3;
        int iMax = Math.max(zzhtwVar2 != null ? zzhtwVar2.zzi : 0, zzhtwVar4 != null ? zzhtwVar4.zzi : 0) + 1;
        zzhtwVar.zzi = iMax;
        zzhtwVar3.zzi = Math.max(iMax, zzhtwVar5 != null ? zzhtwVar5.zzi : 0) + 1;
    }

    private final void zzi(zzhtw zzhtwVar) {
        zzhtw zzhtwVar2 = zzhtwVar.zzb;
        zzhtw zzhtwVar3 = zzhtwVar.zzc;
        zzhtw zzhtwVar4 = zzhtwVar2.zzb;
        zzhtw zzhtwVar5 = zzhtwVar2.zzc;
        zzhtwVar.zzb = zzhtwVar5;
        if (zzhtwVar5 != null) {
            zzhtwVar5.zza = zzhtwVar;
        }
        zzf(zzhtwVar, zzhtwVar2);
        zzhtwVar2.zzc = zzhtwVar;
        zzhtwVar.zza = zzhtwVar2;
        int iMax = Math.max(zzhtwVar3 != null ? zzhtwVar3.zzi : 0, zzhtwVar5 != null ? zzhtwVar5.zzi : 0) + 1;
        zzhtwVar.zzi = iMax;
        zzhtwVar2.zzi = Math.max(iMax, zzhtwVar4 != null ? zzhtwVar4.zzi : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.zza = null;
        this.zzb = 0;
        this.zzc++;
        zzhtw zzhtwVar = this.zzd;
        zzhtwVar.zze = zzhtwVar;
        zzhtwVar.zzd = zzhtwVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return zzb(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        zzhts zzhtsVar = this.zzh;
        if (zzhtsVar != null) {
            return zzhtsVar;
        }
        zzhts zzhtsVar2 = new zzhts(this);
        this.zzh = zzhtsVar2;
        return zzhtsVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        zzhtw zzhtwVarZzb = zzb(obj);
        if (zzhtwVarZzb != null) {
            return zzhtwVarZzb.zzh;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        zzhtu zzhtuVar = this.zzi;
        if (zzhtuVar != null) {
            return zzhtuVar;
        }
        zzhtu zzhtuVar2 = new zzhtu(this);
        this.zzi = zzhtuVar2;
        return zzhtuVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.zzg) {
            throw new NullPointerException("value == null");
        }
        zzhtw zzhtwVarZza = zza(obj, true);
        Object obj3 = zzhtwVarZza.zzh;
        zzhtwVarZza.zzh = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzhtw zzhtwVarZze = zze(obj);
        if (zzhtwVarZze != null) {
            return zzhtwVarZze.zzh;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzb;
    }

    final zzhtw zza(Object obj, boolean z) {
        int iCompareTo;
        zzhtw zzhtwVar;
        Comparator comparator = this.zzf;
        zzhtw zzhtwVar2 = this.zza;
        if (zzhtwVar2 != null) {
            Comparable comparable = comparator == zze ? (Comparable) obj : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(zzhtwVar2.zzf) : comparator.compare(obj, zzhtwVar2.zzf);
                if (iCompareTo == 0) {
                    return zzhtwVar2;
                }
                zzhtw zzhtwVar3 = iCompareTo < 0 ? zzhtwVar2.zzb : zzhtwVar2.zzc;
                if (zzhtwVar3 == null) {
                    break;
                }
                zzhtwVar2 = zzhtwVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z) {
            return null;
        }
        zzhtw zzhtwVar4 = this.zzd;
        if (zzhtwVar2 != null) {
            zzhtwVar = new zzhtw(this.zzg, zzhtwVar2, obj, zzhtwVar4, zzhtwVar4.zze);
            if (iCompareTo < 0) {
                zzhtwVar2.zzb = zzhtwVar;
            } else {
                zzhtwVar2.zzc = zzhtwVar;
            }
            zzg(zzhtwVar2, true);
        } else {
            if (comparator == zze && !(obj instanceof Comparable)) {
                String name = obj.getClass().getName();
                String.valueOf(name);
                throw new ClassCastException(String.valueOf(name).concat(" is not Comparable"));
            }
            zzhtwVar = new zzhtw(this.zzg, null, obj, zzhtwVar4, zzhtwVar4.zze);
            this.zza = zzhtwVar;
        }
        this.zzb++;
        this.zzc++;
        return zzhtwVar;
    }

    final zzhtw zzb(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return zza(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    final zzhtw zzc(Map.Entry entry) {
        zzhtw zzhtwVarZzb = zzb(entry.getKey());
        if (zzhtwVarZzb == null || !Objects.equals(zzhtwVarZzb.zzh, entry.getValue())) {
            return null;
        }
        return zzhtwVarZzb;
    }

    final void zzd(zzhtw zzhtwVar, boolean z) {
        zzhtw zzhtwVar2;
        zzhtw zzhtwVar3;
        int i;
        if (z) {
            zzhtw zzhtwVar4 = zzhtwVar.zze;
            zzhtwVar4.zzd = zzhtwVar.zzd;
            zzhtwVar.zzd.zze = zzhtwVar4;
        }
        zzhtw zzhtwVar5 = zzhtwVar.zzb;
        zzhtw zzhtwVar6 = zzhtwVar.zzc;
        zzhtw zzhtwVar7 = zzhtwVar.zza;
        int i2 = 0;
        if (zzhtwVar5 == null || zzhtwVar6 == null) {
            if (zzhtwVar5 != null) {
                zzf(zzhtwVar, zzhtwVar5);
                zzhtwVar.zzb = null;
            } else if (zzhtwVar6 != null) {
                zzf(zzhtwVar, zzhtwVar6);
                zzhtwVar.zzc = null;
            } else {
                zzf(zzhtwVar, null);
            }
            zzg(zzhtwVar7, false);
            this.zzb--;
            this.zzc++;
            return;
        }
        if (zzhtwVar5.zzi > zzhtwVar6.zzi) {
            do {
                zzhtwVar3 = zzhtwVar5;
                zzhtwVar5 = zzhtwVar5.zzc;
            } while (zzhtwVar5 != null);
        } else {
            do {
                zzhtwVar2 = zzhtwVar6;
                zzhtwVar6 = zzhtwVar6.zzb;
            } while (zzhtwVar6 != null);
            zzhtwVar3 = zzhtwVar2;
        }
        zzd(zzhtwVar3, false);
        zzhtw zzhtwVar8 = zzhtwVar.zzb;
        if (zzhtwVar8 != null) {
            i = zzhtwVar8.zzi;
            zzhtwVar3.zzb = zzhtwVar8;
            zzhtwVar8.zza = zzhtwVar3;
            zzhtwVar.zzb = null;
        } else {
            i = 0;
        }
        zzhtw zzhtwVar9 = zzhtwVar.zzc;
        if (zzhtwVar9 != null) {
            i2 = zzhtwVar9.zzi;
            zzhtwVar3.zzc = zzhtwVar9;
            zzhtwVar9.zza = zzhtwVar3;
            zzhtwVar.zzc = null;
        }
        zzhtwVar3.zzi = Math.max(i, i2) + 1;
        zzf(zzhtwVar, zzhtwVar3);
    }

    final zzhtw zze(Object obj) {
        zzhtw zzhtwVarZzb = zzb(obj);
        if (zzhtwVarZzb != null) {
            zzd(zzhtwVarZzb, true);
        }
        return zzhtwVarZzb;
    }

    public zzhtx(Comparator comparator, boolean z) {
        this.zzb = 0;
        this.zzc = 0;
        this.zzf = comparator;
        this.zzg = z;
        this.zzd = new zzhtw(z);
    }

    public zzhtx(boolean z) {
        this(zze, false);
    }
}
