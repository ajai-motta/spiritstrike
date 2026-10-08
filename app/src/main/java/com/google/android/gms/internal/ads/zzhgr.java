package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhgr extends zzhhi {
    private final int zza;
    private final int zzb;
    private final zzhgq zzc;

    /* synthetic */ zzhgr(int i, int i2, zzhgq zzhgqVar, byte[] bArr) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzhgqVar;
    }

    public static zzhgp zzb() {
        return new zzhgp(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhgr)) {
            return false;
        }
        zzhgr zzhgrVar = (zzhgr) obj;
        return zzhgrVar.zza == this.zza && zzhgrVar.zze() == zze() && zzhgrVar.zzc == this.zzc;
    }

    public final int hashCode() {
        return Objects.hash(zzhgr.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzc);
        int length = String.valueOf(strValueOf).length();
        int i = this.zzb;
        int length2 = String.valueOf(i).length();
        int i2 = this.zza;
        StringBuilder sb = new StringBuilder(length + 32 + length2 + 16 + String.valueOf(i2).length() + 10);
        sb.append("AES-CMAC Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(i);
        sb.append("-byte tags, and ");
        sb.append(i2);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zzc != zzhgq.zzd;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() {
        zzhgq zzhgqVar = this.zzc;
        if (zzhgqVar == zzhgq.zzd) {
            return this.zzb;
        }
        if (zzhgqVar == zzhgq.zza || zzhgqVar == zzhgq.zzb || zzhgqVar == zzhgq.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzhgq zzf() {
        return this.zzc;
    }
}
