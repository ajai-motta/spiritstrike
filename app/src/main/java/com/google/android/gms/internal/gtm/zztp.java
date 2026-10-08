package com.google.android.gms.internal.gtm;

import com.facebook.appevents.AppEventsConstants;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zztp extends zzti implements Set {

    @CheckForNull
    private transient zztl zza;

    zztp() {
    }

    static int zzf(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            if (iMax < 1073741824) {
                return 1073741824;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zztp zzi(Object obj, Object obj2, Object obj3) {
        return zzl(3, "", AppEventsConstants.EVENT_PARAM_VALUE_NO, "false");
    }

    public static zztp zzj(Object obj, Object obj2, Object obj3, Object obj4) {
        return zzl(4, "GET", "HEAD", "POST", "PUT");
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zztp) && zzk() && ((zztp) obj).zzk() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzty.zza(this);
    }

    @Override // com.google.android.gms.internal.gtm.zzti, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zzd */
    public abstract zzua iterator();

    public final zztl zzg() {
        zztl zztlVar = this.zza;
        if (zztlVar != null) {
            return zztlVar;
        }
        zztl zztlVarZzh = zzh();
        this.zza = zztlVarZzh;
        return zztlVarZzh;
    }

    zztl zzh() {
        Object[] array = toArray();
        int i = zztl.zzd;
        return zztl.zzg(array, array.length);
    }

    boolean zzk() {
        return false;
    }

    private static zztp zzl(int i, Object... objArr) {
        if (i == 0) {
            return zztx.zza;
        }
        if (i == 1) {
            return new zztz(Objects.requireNonNull(objArr[0]));
        }
        int iZzf = zzf(i);
        Object[] objArr2 = new Object[iZzf];
        int i2 = iZzf - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[i5];
            if (obj == null) {
                throw new NullPointerException("at index " + i5);
            }
            int iHashCode = obj.hashCode();
            int iZza = zzth.zza(iHashCode);
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
            return new zztz(Objects.requireNonNull(objArr[0]));
        }
        if (zzf(i4) < iZzf / 2) {
            return zzl(i4, objArr);
        }
        int length = objArr.length;
        if (i4 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zztx(objArr, i3, objArr2, i2, i4);
    }
}
