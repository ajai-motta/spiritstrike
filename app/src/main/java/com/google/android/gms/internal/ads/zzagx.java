package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzao;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public class zzagx implements zzao {
    public final long zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;

    public zzagx(long j, long j2, long j3, long j4, long j5) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = j3;
        this.zzd = j4;
        this.zze = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagx zzagxVar = (zzagx) obj;
            if (this.zza == zzagxVar.zza && this.zzb == zzagxVar.zzb && this.zzc == zzagxVar.zzc && this.zzd == zzagxVar.zzd && this.zze == zzagxVar.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((UByte$$ExternalSyntheticBackport0.m(this.zza) + 527) * 31) + UByte$$ExternalSyntheticBackport0.m(this.zzb)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.zzc)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.zzd)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.zze);
    }

    public final String toString() {
        long j = this.zza;
        int length = String.valueOf(j).length();
        long j2 = this.zzb;
        int length2 = String.valueOf(j2).length();
        long j3 = this.zzc;
        int length3 = String.valueOf(j3).length();
        long j4 = this.zzd;
        int length4 = String.valueOf(j4).length();
        long j5 = this.zze;
        StringBuilder sb = new StringBuilder(length + 54 + length2 + 31 + length3 + 21 + length4 + 12 + String.valueOf(j5).length());
        sb.append("Motion photo metadata: photoStartPosition=");
        sb.append(j);
        sb.append(", photoSize=");
        sb.append(j2);
        sb.append(", photoPresentationTimestampUs=");
        sb.append(j3);
        sb.append(", videoStartPosition=");
        sb.append(j4);
        sb.append(", videoSize=");
        sb.append(j5);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public /* synthetic */ void zza(zzam zzamVar) {
        zzao.CC.$default$zza(this, zzamVar);
    }
}
