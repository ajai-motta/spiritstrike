package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgsr implements Serializable {
    private static final zzgsr zza = new zzgsr(new int[0], 0, 0);
    private final int[] zzb;
    private final int zzc;

    private zzgsr(int[] iArr, int i, int i2) {
        this.zzb = iArr;
        this.zzc = i2;
    }

    public static zzgsr zza() {
        return zza;
    }

    public static zzgsr zzb(int[] iArr) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        return new zzgsr(iArrCopyOf, 0, iArrCopyOf.length);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgsr)) {
            return false;
        }
        zzgsr zzgsrVar = (zzgsr) obj;
        int i = this.zzc;
        if (i != zzgsrVar.zzc) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (zzd(i2) != zzgsrVar.zzd(i2)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            i = (i * 31) + this.zzb[i2];
        }
        return i;
    }

    public final String toString() {
        int i = this.zzc;
        if (i == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(i * 5);
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        int[] iArr = this.zzb;
        sb.append(iArr[0]);
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(", ");
            sb.append(iArr[i2]);
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd(int i) {
        zzgmd.zzm(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        return this.zzb[i];
    }
}
