package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhak extends zzgxb {
    private final zzhaj zza;
    private final int zzb;

    private zzhak(zzhaj zzhajVar, int i) {
        this.zza = zzhajVar;
        this.zzb = i;
    }

    public static zzhak zzb(zzhaj zzhajVar, int i) throws GeneralSecurityException {
        if (i < 8 || i > 12) {
            throw new GeneralSecurityException("Salt size must be between 8 and 12 bytes");
        }
        return new zzhak(zzhajVar, i);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhak)) {
            return false;
        }
        zzhak zzhakVar = (zzhak) obj;
        return zzhakVar.zza == this.zza && zzhakVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzhak.class, this.zza, Integer.valueOf(this.zzb));
    }

    public final String toString() {
        String string = this.zza.toString();
        int length = string.length();
        int i = this.zzb;
        StringBuilder sb = new StringBuilder(length + 48 + String.valueOf(i).length() + 1);
        sb.append("X-AES-GCM Parameters (variant: ");
        sb.append(string);
        sb.append("salt_size_bytes: ");
        sb.append(i);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zza != zzhaj.zzb;
    }

    public final zzhaj zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }
}
