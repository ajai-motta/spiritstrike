package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhhf extends zzhhi {
    private final int zza;
    private final int zzb;
    private final zzhhe zzc;
    private final zzhhd zzd;

    /* synthetic */ zzhhf(int i, int i2, zzhhe zzhheVar, zzhhd zzhhdVar, byte[] bArr) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzhheVar;
        this.zzd = zzhhdVar;
    }

    public static zzhhc zzb() {
        return new zzhhc(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhhf)) {
            return false;
        }
        zzhhf zzhhfVar = (zzhhf) obj;
        return zzhhfVar.zza == this.zza && zzhhfVar.zze() == zze() && zzhhfVar.zzc == this.zzc && zzhhfVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzhhf.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public final String toString() {
        zzhhd zzhhdVar = this.zzd;
        String strValueOf = String.valueOf(this.zzc);
        String strValueOf2 = String.valueOf(zzhhdVar);
        int length = String.valueOf(strValueOf).length();
        int length2 = String.valueOf(strValueOf2).length();
        int i = this.zzb;
        int length3 = String.valueOf(i).length();
        int i2 = this.zza;
        StringBuilder sb = new StringBuilder(length + 38 + length2 + 2 + length3 + 16 + String.valueOf(i2).length() + 10);
        sb.append("HMAC Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", hashType: ");
        sb.append(strValueOf2);
        sb.append(", ");
        sb.append(i);
        sb.append("-byte tags, and ");
        sb.append(i2);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zzc != zzhhe.zzd;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() {
        zzhhe zzhheVar = this.zzc;
        if (zzhheVar == zzhhe.zzd) {
            return this.zzb;
        }
        if (zzhheVar == zzhhe.zza || zzhheVar == zzhhe.zzb || zzhheVar == zzhhe.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzhhe zzf() {
        return this.zzc;
    }

    public final zzhhd zzg() {
        return this.zzd;
    }
}
