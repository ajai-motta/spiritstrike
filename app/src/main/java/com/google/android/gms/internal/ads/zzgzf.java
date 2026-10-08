package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgzf extends zzgxb {
    private final String zza;
    private final zzgze zzb;

    private zzgzf(String str, zzgze zzgzeVar) {
        this.zza = str;
        this.zzb = zzgzeVar;
    }

    public static zzgzf zzb(String str, zzgze zzgzeVar) {
        return new zzgzf(str, zzgzeVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgzf)) {
            return false;
        }
        zzgzf zzgzfVar = (zzgzf) obj;
        return zzgzfVar.zza.equals(this.zza) && zzgzfVar.zzb.equals(this.zzb);
    }

    public final int hashCode() {
        return Objects.hash(zzgzf.class, this.zza, this.zzb);
    }

    public final String toString() {
        String string = this.zzb.toString();
        String str = this.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 45 + string.length() + 1);
        sb.append("LegacyKmsAead Parameters (keyUri: ");
        sb.append(str);
        sb.append(", variant: ");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zzb != zzgze.zzb;
    }

    public final String zzc() {
        return this.zza;
    }

    public final zzgze zzd() {
        return this.zzb;
    }
}
