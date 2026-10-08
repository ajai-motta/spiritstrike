package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzahy implements zzaeh {
    public final int zza;
    public final long zzb;
    public final int zzc;

    public zzahy(int i, long j, int i2) {
        this.zza = i;
        this.zzb = j;
        this.zzc = i2;
    }

    public final String toString() {
        String strZzx = zzep.zzx(this.zza);
        int length = strZzx.length();
        long j = this.zzb;
        int length2 = String.valueOf(j).length();
        int i = this.zzc;
        StringBuilder sb = new StringBuilder(length + 29 + length2 + 16 + String.valueOf(i).length() + 1);
        sb.append("AtomSizeTooSmall{type=");
        sb.append(strZzx);
        sb.append(", size=");
        sb.append(j);
        sb.append(", minHeaderSize=");
        sb.append(i);
        sb.append("}");
        return sb.toString();
    }
}
