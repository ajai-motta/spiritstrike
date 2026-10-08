package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgon extends AbstractMap implements Serializable {
    private static final Object zzd = new Object();
    transient int[] zza;
    transient Object[] zzb;
    transient Object[] zzc;
    private transient Object zze;
    private transient int zzf;
    private transient int zzg;
    private transient Set zzh;
    private transient Set zzi;
    private transient Collection zzj;

    zzgon() {
        zza(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzA, reason: merged with bridge method [inline-methods] */
    public final int[] zzl() {
        return (int[]) Objects.requireNonNull(this.zza);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzB, reason: merged with bridge method [inline-methods] */
    public final Object[] zzm() {
        return (Object[]) Objects.requireNonNull(this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzC, reason: merged with bridge method [inline-methods] */
    public final Object[] zzn() {
        return (Object[]) Objects.requireNonNull(this.zzc);
    }

    private final void zzv(int i) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i)) & 31) | (this.zzf & (-32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzw, reason: merged with bridge method [inline-methods] */
    public final int zzh() {
        return (1 << (this.zzf & 31)) - 1;
    }

    private final int zzx(int i, int i2, int i3, int i4) {
        int i5 = i2 - 1;
        Object objZza = zzgoo.zza(i2);
        if (i4 != 0) {
            zzgoo.zzc(objZza, i3 & i5, i4 + 1);
        }
        Object objRequireNonNull = Objects.requireNonNull(this.zze);
        int[] iArrZzl = zzl();
        for (int i6 = 0; i6 <= i; i6++) {
            int iZzb = zzgoo.zzb(objRequireNonNull, i6);
            while (iZzb != 0) {
                int i7 = iZzb - 1;
                int i8 = iArrZzl[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int iZzb2 = zzgoo.zzb(objZza, i10);
                zzgoo.zzc(objZza, i10, iZzb);
                iArrZzl[i7] = ((~i5) & i9) | (iZzb2 & i5);
                iZzb = i8 & i;
            }
        }
        this.zze = objZza;
        zzv(i5);
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzy, reason: merged with bridge method [inline-methods] */
    public final int zzi(Object obj) {
        if (zzb()) {
            return -1;
        }
        int iZzb = zzgox.zzb(obj);
        int iZzh = zzh();
        int iZzb2 = zzgoo.zzb(Objects.requireNonNull(this.zze), iZzb & iZzh);
        if (iZzb2 != 0) {
            int i = ~iZzh;
            int i2 = iZzb & i;
            do {
                int i3 = iZzb2 - 1;
                int i4 = zzl()[i3];
                if ((i4 & i) == i2 && Objects.equals(obj, zzm()[i3])) {
                    return i3;
                }
                iZzb2 = i4 & iZzh;
            } while (iZzb2 != 0);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public final Object zzj(Object obj) {
        if (!zzb()) {
            int iZzh = zzh();
            int iZze = zzgoo.zze(obj, null, iZzh, Objects.requireNonNull(this.zze), zzl(), zzm(), null);
            if (iZze != -1) {
                Object obj2 = zzn()[iZze];
                zze(iZze, iZzh);
                this.zzg--;
                zzd();
                return obj2;
            }
        }
        return zzd;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (zzb()) {
            return;
        }
        zzd();
        Map mapZzc = zzc();
        if (mapZzc != null) {
            this.zzf = zzgst.zzc(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
            mapZzc.clear();
            this.zze = null;
            this.zzg = 0;
            return;
        }
        Arrays.fill(zzm(), 0, this.zzg, (Object) null);
        Arrays.fill(zzn(), 0, this.zzg, (Object) null);
        Object objRequireNonNull = Objects.requireNonNull(this.zze);
        if (objRequireNonNull instanceof byte[]) {
            Arrays.fill((byte[]) objRequireNonNull, (byte) 0);
        } else if (objRequireNonNull instanceof short[]) {
            Arrays.fill((short[]) objRequireNonNull, (short) 0);
        } else {
            Arrays.fill((int[]) objRequireNonNull, 0);
        }
        Arrays.fill(zzl(), 0, this.zzg, 0);
        this.zzg = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map mapZzc = zzc();
        return mapZzc != null ? mapZzc.containsKey(obj) : zzi(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.containsValue(obj);
        }
        for (int i = 0; i < this.zzg; i++) {
            if (Objects.equals(obj, zzn()[i])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.zzi;
        if (set != null) {
            return set;
        }
        zzgoi zzgoiVar = new zzgoi(this, null);
        this.zzi = zzgoiVar;
        return zzgoiVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.get(obj);
        }
        int iZzi = zzi(obj);
        if (iZzi == -1) {
            return null;
        }
        return zzn()[iZzi];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.zzh;
        if (set != null) {
            return set;
        }
        zzgok zzgokVar = new zzgok(this, null);
        this.zzh = zzgokVar;
        return zzgokVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int iMin;
        if (zzb()) {
            zzgmd.zzi(zzb(), "Arrays already allocated");
            int i = this.zzf;
            int iMax = Math.max(i + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            if (iMax > iHighestOneBit && (iHighestOneBit = iHighestOneBit + iHighestOneBit) <= 0) {
                iHighestOneBit = 1073741824;
            }
            int iMax2 = Math.max(4, iHighestOneBit);
            this.zze = zzgoo.zza(iMax2);
            zzv(iMax2 - 1);
            this.zza = new int[i];
            this.zzb = new Object[i];
            this.zzc = new Object[i];
        }
        Map mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.put(obj, obj2);
        }
        int[] iArrZzl = zzl();
        Object[] objArrZzm = zzm();
        Object[] objArrZzn = zzn();
        int i2 = this.zzg;
        int i3 = i2 + 1;
        int iZzb = zzgox.zzb(obj);
        int iZzh = zzh();
        int i4 = iZzb & iZzh;
        int iZzb2 = zzgoo.zzb(Objects.requireNonNull(this.zze), i4);
        if (iZzb2 != 0) {
            int i5 = ~iZzh;
            int i6 = iZzb & i5;
            int i7 = 0;
            while (true) {
                int i8 = iZzb2 - 1;
                int i9 = iArrZzl[i8];
                int i10 = i9 & i5;
                if (i10 == i6 && Objects.equals(obj, objArrZzm[i8])) {
                    Object obj3 = objArrZzn[i8];
                    objArrZzn[i8] = obj2;
                    return obj3;
                }
                int i11 = i9 & iZzh;
                i7++;
                if (i11 != 0) {
                    iZzb2 = i11;
                } else {
                    if (i7 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzh() + 1, 1.0f);
                        int iZzf = zzf();
                        while (iZzf >= 0) {
                            linkedHashMap.put(zzm()[iZzf], zzn()[iZzf]);
                            iZzf = zzg(iZzf);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzd();
                        return linkedHashMap.put(obj, obj2);
                    }
                    if (i3 > iZzh) {
                        iZzh = zzx(iZzh, zzgoo.zzd(iZzh), iZzb, i2);
                    } else {
                        iArrZzl[i8] = (i3 & iZzh) | i10;
                    }
                }
            }
        } else if (i3 > iZzh) {
            iZzh = zzx(iZzh, zzgoo.zzd(iZzh), iZzb, i2);
        } else {
            zzgoo.zzc(Objects.requireNonNull(this.zze), i4, i3);
        }
        int length = zzl().length;
        if (i3 > length && (iMin = Math.min(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            this.zza = Arrays.copyOf(zzl(), iMin);
            this.zzb = Arrays.copyOf(zzm(), iMin);
            this.zzc = Arrays.copyOf(zzn(), iMin);
        }
        zzl()[i2] = (~iZzh) & iZzb;
        zzm()[i2] = obj;
        zzn()[i2] = obj2;
        this.zzg = i3;
        zzd();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.remove(obj);
        }
        Object objZzj = zzj(obj);
        if (objZzj == zzd) {
            return null;
        }
        return objZzj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapZzc = zzc();
        return mapZzc != null ? mapZzc.size() : this.zzg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzgom zzgomVar = new zzgom(this, null);
        this.zzj = zzgomVar;
        return zzgomVar;
    }

    final void zza(int i) {
        this.zzf = zzgst.zzc(i, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    final boolean zzb() {
        return this.zze == null;
    }

    final Map zzc() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    final void zzd() {
        this.zzf += 32;
    }

    final void zze(int i, int i2) {
        Object objRequireNonNull = Objects.requireNonNull(this.zze);
        int[] iArrZzl = zzl();
        Object[] objArrZzm = zzm();
        Object[] objArrZzn = zzn();
        int size = size();
        int i3 = size - 1;
        if (i >= i3) {
            objArrZzm[i] = null;
            objArrZzn[i] = null;
            iArrZzl[i] = 0;
            return;
        }
        int i4 = i + 1;
        Object obj = objArrZzm[i3];
        objArrZzm[i] = obj;
        objArrZzn[i] = objArrZzn[i3];
        objArrZzm[i3] = null;
        objArrZzn[i3] = null;
        iArrZzl[i] = iArrZzl[i3];
        iArrZzl[i3] = 0;
        int iZzb = zzgox.zzb(obj) & i2;
        int iZzb2 = zzgoo.zzb(objRequireNonNull, iZzb);
        if (iZzb2 == size) {
            zzgoo.zzc(objRequireNonNull, iZzb, i4);
            return;
        }
        while (true) {
            int i5 = iZzb2 - 1;
            int i6 = iArrZzl[i5];
            int i7 = i6 & i2;
            if (i7 == size) {
                iArrZzl[i5] = (i6 & (~i2)) | (i2 & i4);
                return;
            }
            iZzb2 = i7;
        }
    }

    final int zzf() {
        return isEmpty() ? -1 : 0;
    }

    final int zzg(int i) {
        int i2 = i + 1;
        if (i2 < this.zzg) {
            return i2;
        }
        return -1;
    }

    final /* synthetic */ Object zzk() {
        return Objects.requireNonNull(this.zze);
    }

    final /* synthetic */ Object zzo(int i) {
        return zzm()[i];
    }

    final /* synthetic */ Object zzp(int i) {
        return zzn()[i];
    }

    final /* synthetic */ void zzq(int i, Object obj) {
        zzn()[i] = obj;
    }

    final /* synthetic */ int zzs() {
        return this.zzf;
    }

    final /* synthetic */ int zzt() {
        return this.zzg;
    }

    final /* synthetic */ void zzu(int i) {
        this.zzg = i;
    }

    zzgon(int i) {
        zza(8);
    }
}
