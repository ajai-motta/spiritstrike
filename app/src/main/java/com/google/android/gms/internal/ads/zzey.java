package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzao;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzey implements zzao {
    public final long zza;
    public final long zzb;
    public final long zzc;

    public zzey(long j, long j2, long j3) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzey)) {
            return false;
        }
        zzey zzeyVar = (zzey) obj;
        return this.zza == zzeyVar.zza && this.zzb == zzeyVar.zzb && this.zzc == zzeyVar.zzc;
    }

    public final int hashCode() {
        return ((((UByte$$ExternalSyntheticBackport0.m(this.zza) + 527) * 31) + UByte$$ExternalSyntheticBackport0.m(this.zzb)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.zzc);
    }

    public final String toString() {
        long j = this.zza;
        int length = String.valueOf(j).length();
        long j2 = this.zzb;
        int length2 = String.valueOf(j2).length();
        long j3 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 48 + length2 + 12 + String.valueOf(j3).length());
        sb.append("Mp4Timestamp: creation time=");
        sb.append(j);
        sb.append(", modification time=");
        sb.append(j2);
        sb.append(", timescale=");
        sb.append(j3);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public /* synthetic */ void zza(zzam zzamVar) {
        zzao.CC.$default$zza(this, zzamVar);
    }
}
