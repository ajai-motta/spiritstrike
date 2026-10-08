package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgyv extends zzgxb {
    private final zzgyu zza;

    private zzgyv(zzgyu zzgyuVar) {
        this.zza = zzgyuVar;
    }

    public static zzgyv zzb(zzgyu zzgyuVar) {
        return new zzgyv(zzgyuVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzgyv) && ((zzgyv) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzgyv.class, this.zza);
    }

    public final String toString() {
        String string = this.zza.toString();
        StringBuilder sb = new StringBuilder(string.length() + 39);
        sb.append("ChaCha20Poly1305 Parameters (variant: ");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zza != zzgyu.zzc;
    }

    public final zzgyu zzc() {
        return this.zza;
    }
}
