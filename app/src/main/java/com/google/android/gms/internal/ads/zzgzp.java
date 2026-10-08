package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgzp extends zzgxb {
    private final zzgzo zza;
    private final String zzb;
    private final zzgzn zzc;
    private final zzgxb zzd;

    /* synthetic */ zzgzp(zzgzo zzgzoVar, String str, zzgzn zzgznVar, zzgxb zzgxbVar, byte[] bArr) {
        this.zza = zzgzoVar;
        this.zzb = str;
        this.zzc = zzgznVar;
        this.zzd = zzgxbVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgzp)) {
            return false;
        }
        zzgzp zzgzpVar = (zzgzp) obj;
        return zzgzpVar.zzc.equals(this.zzc) && zzgzpVar.zzd.equals(this.zzd) && zzgzpVar.zzb.equals(this.zzb) && zzgzpVar.zza.equals(this.zza);
    }

    public final int hashCode() {
        return Objects.hash(zzgzp.class, this.zzb, this.zzc, this.zzd, this.zza);
    }

    public final String toString() {
        zzgzo zzgzoVar = this.zza;
        zzgxb zzgxbVar = this.zzd;
        String strValueOf = String.valueOf(this.zzc);
        String strValueOf2 = String.valueOf(zzgxbVar);
        String strValueOf3 = String.valueOf(zzgzoVar);
        String str = this.zzb;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(strValueOf).length();
        StringBuilder sb = new StringBuilder(length + 64 + length2 + 27 + String.valueOf(strValueOf2).length() + 11 + String.valueOf(strValueOf3).length() + 1);
        sb.append("LegacyKmsEnvelopeAead Parameters (kekUri: ");
        sb.append(str);
        sb.append(", dekParsingStrategy: ");
        sb.append(strValueOf);
        sb.append(", dekParametersForNewKeys: ");
        sb.append(strValueOf2);
        sb.append(", variant: ");
        sb.append(strValueOf3);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zza != zzgzo.zzb;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final zzgzo zzc() {
        return this.zza;
    }

    public final zzgxb zzd() {
        return this.zzd;
    }
}
