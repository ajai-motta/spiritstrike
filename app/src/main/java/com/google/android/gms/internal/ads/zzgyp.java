package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgyp extends zzgxb {
    private final int zza;
    private final zzgyo zzb;

    /* synthetic */ zzgyp(int i, zzgyo zzgyoVar, byte[] bArr) {
        this.zza = i;
        this.zzb = zzgyoVar;
    }

    public static zzgyn zzb() {
        return new zzgyn(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgyp)) {
            return false;
        }
        zzgyp zzgypVar = (zzgyp) obj;
        return zzgypVar.zza == this.zza && zzgypVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzgyp.class, Integer.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzb);
        int length = String.valueOf(strValueOf).length();
        int i = this.zza;
        StringBuilder sb = new StringBuilder(length + 33 + String.valueOf(i).length() + 10);
        sb.append("AesGcmSiv Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(i);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zzb != zzgyo.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzgyo zzd() {
        return this.zzb;
    }
}
