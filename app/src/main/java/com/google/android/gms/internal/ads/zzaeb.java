package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaeb {
    public final zzaee zza;
    public final zzaee zzb;

    public zzaeb(zzaee zzaeeVar, zzaee zzaeeVar2) {
        this.zza = zzaeeVar;
        this.zzb = zzaeeVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzaeb zzaebVar = (zzaeb) obj;
            if (this.zza.equals(zzaebVar.zza) && this.zzb.equals(zzaebVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        zzaee zzaeeVar = this.zza;
        zzaee zzaeeVar2 = this.zzb;
        String string = zzaeeVar.toString();
        String strConcat = zzaeeVar.equals(zzaeeVar2) ? "" : ", ".concat(zzaeeVar2.toString());
        StringBuilder sb = new StringBuilder(string.length() + 1 + strConcat.length() + 1);
        sb.append("[");
        sb.append(string);
        sb.append(strConcat);
        sb.append("]");
        return sb.toString();
    }
}
