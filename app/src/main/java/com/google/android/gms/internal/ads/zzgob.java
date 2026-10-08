package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgob extends zzgqy implements Serializable {
    final zzglu zza;
    final zzgqy zzb;

    zzgob(zzglu zzgluVar, zzgqy zzgqyVar) {
        this.zza = zzgluVar;
        this.zzb = zzgqyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgqy, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        zzglu zzgluVar = this.zza;
        return this.zzb.compare(zzgluVar.apply(obj), zzgluVar.apply(obj2));
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgob) {
            zzgob zzgobVar = (zzgob) obj;
            if (this.zza.equals(zzgobVar.zza) && this.zzb.equals(zzgobVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb);
    }

    public final String toString() {
        String string = this.zzb.toString();
        int length = string.length();
        String string2 = this.zza.toString();
        StringBuilder sb = new StringBuilder(length + 12 + string2.length() + 1);
        sb.append(string);
        sb.append(".onResultOf(");
        sb.append(string2);
        sb.append(")");
        return sb.toString();
    }
}
