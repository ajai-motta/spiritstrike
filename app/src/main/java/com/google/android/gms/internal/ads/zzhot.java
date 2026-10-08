package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhot extends zzhpp {
    public static final BigInteger zza = BigInteger.valueOf(65537);
    private final int zzb;
    private final BigInteger zzc;
    private final zzhos zzd;
    private final zzhor zze;

    /* synthetic */ zzhot(int i, BigInteger bigInteger, zzhos zzhosVar, zzhor zzhorVar, byte[] bArr) {
        this.zzb = i;
        this.zzc = bigInteger;
        this.zzd = zzhosVar;
        this.zze = zzhorVar;
    }

    public static zzhoq zzb() {
        return new zzhoq(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhot)) {
            return false;
        }
        zzhot zzhotVar = (zzhot) obj;
        return zzhotVar.zzb == this.zzb && Objects.equals(zzhotVar.zzc, this.zzc) && zzhotVar.zzd == this.zzd && zzhotVar.zze == this.zze;
    }

    public final int hashCode() {
        return Objects.hash(zzhot.class, Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze);
    }

    public final String toString() {
        BigInteger bigInteger = this.zzc;
        zzhor zzhorVar = this.zze;
        String strValueOf = String.valueOf(this.zzd);
        String strValueOf2 = String.valueOf(zzhorVar);
        String strValueOf3 = String.valueOf(bigInteger);
        int length = String.valueOf(strValueOf).length();
        int length2 = String.valueOf(strValueOf2).length();
        int length3 = String.valueOf(strValueOf3).length();
        int i = this.zzb;
        StringBuilder sb = new StringBuilder(length + 47 + length2 + 18 + length3 + 6 + String.valueOf(i).length() + 13);
        sb.append("RSA SSA PKCS1 Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", hashType: ");
        sb.append(strValueOf2);
        sb.append(", publicExponent: ");
        sb.append(strValueOf3);
        sb.append(", and ");
        sb.append(i);
        sb.append("-bit modulus)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zzd != zzhos.zzd;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final BigInteger zzd() {
        return this.zzc;
    }

    public final zzhos zze() {
        return this.zzd;
    }

    public final zzhor zzf() {
        return this.zze;
    }
}
