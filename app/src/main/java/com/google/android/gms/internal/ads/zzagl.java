package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzagl extends zzagq {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final byte[] zzd;

    public zzagl(String str, String str2, String str3, byte[] bArr) {
        super(GeobFrame.ID);
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagl zzaglVar = (zzagl) obj;
            if (Objects.equals(this.zza, zzaglVar.zza) && Objects.equals(this.zzb, zzaglVar.zzb) && Objects.equals(this.zzc, zzaglVar.zzc) && Arrays.equals(this.zzd, zzaglVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        return (((((((str != null ? str.hashCode() : 0) + 527) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode()) * 31) + Arrays.hashCode(this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzagq
    public final String toString() {
        String str = this.zzf;
        int length = String.valueOf(str).length();
        String str2 = this.zza;
        int length2 = String.valueOf(str2).length();
        String str3 = this.zzb;
        int length3 = length + 11 + length2 + 11 + str3.length();
        String str4 = this.zzc;
        StringBuilder sb = new StringBuilder(length3 + 14 + str4.length());
        sb.append(str);
        sb.append(": mimeType=");
        sb.append(str2);
        sb.append(", filename=");
        sb.append(str3);
        sb.append(", description=");
        sb.append(str4);
        return sb.toString();
    }
}
