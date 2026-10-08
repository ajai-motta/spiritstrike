package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgjs extends zzgku {
    private final String zza;
    private final String zzb;

    /* synthetic */ zzgjs(String str, String str2, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgku) {
            zzgku zzgkuVar = (zzgku) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzgkuVar.zza()) : zzgkuVar.zza() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzgkuVar.zzb()) : zzgkuVar.zzb() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        String str = this.zza;
        int length = String.valueOf(str).length();
        String str2 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 49 + String.valueOf(str2).length() + 1);
        sb.append("OverlayDisplayUpdateRequest{sessionToken=");
        sb.append(str);
        sb.append(", appId=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgku
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgku
    public final String zzb() {
        return this.zzb;
    }

    public final int hashCode() {
        String str = this.zza;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.zzb;
        return ((iHashCode ^ 1000003) * 1000003) ^ (str2 != null ? str2.hashCode() : 0);
    }
}
