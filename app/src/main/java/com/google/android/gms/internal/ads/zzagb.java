package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.internal.ads.zzao;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzagb implements zzao {
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final byte[] zze;
    private int zzf;

    static {
        zzt zztVar = new zzt();
        zztVar.zzm(MimeTypes.APPLICATION_ID3);
        zztVar.zzM();
        zzt zztVar2 = new zzt();
        zztVar2.zzm(MimeTypes.APPLICATION_SCTE35);
        zztVar2.zzM();
    }

    public zzagb(String str, String str2, long j, long j2, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagb zzagbVar = (zzagb) obj;
            if (this.zzc == zzagbVar.zzc && this.zzd == zzagbVar.zzd && Objects.equals(this.zza, zzagbVar.zza) && Objects.equals(this.zzb, zzagbVar.zzb) && Arrays.equals(this.zze, zzagbVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzf;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((this.zza.hashCode() + 527) * 31) + this.zzb.hashCode();
        long j = this.zzc;
        int iHashCode2 = (((((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) this.zzd)) * 31) + Arrays.hashCode(this.zze);
        this.zzf = iHashCode2;
        return iHashCode2;
    }

    public final String toString() {
        long j = this.zzd;
        int length = String.valueOf(j).length();
        long j2 = this.zzc;
        int length2 = String.valueOf(j2).length();
        String str = this.zza;
        int length3 = str.length() + 18 + length + 13 + length2;
        String str2 = this.zzb;
        StringBuilder sb = new StringBuilder(length3 + 8 + str2.length());
        sb.append("EMSG: scheme=");
        sb.append(str);
        sb.append(", id=");
        sb.append(j);
        sb.append(", durationMs=");
        sb.append(j2);
        sb.append(", value=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public /* synthetic */ void zza(zzam zzamVar) {
        zzao.CC.$default$zza(this, zzamVar);
    }
}
