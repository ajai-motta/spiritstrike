package com.google.android.gms.internal.ads;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzftw extends zzfuc {
    private final String zzb;
    private final int zzc;
    private final int zzd;

    /* synthetic */ zzftw(String str, boolean z, int i, zzftt zzfttVar, zzftu zzftuVar, int i2, byte[] bArr) {
        this.zzb = str;
        this.zzc = i;
        this.zzd = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfuc) {
            zzfuc zzfucVar = (zzfuc) obj;
            if (this.zzb.equals(zzfucVar.zza())) {
                zzfucVar.zzb();
                int i = this.zzc;
                int iZze = zzfucVar.zze();
                if (i == 0) {
                    throw null;
                }
                if (i == iZze) {
                    zzfucVar.zzc();
                    zzfucVar.zzd();
                    int i2 = this.zzd;
                    int iZzf = zzfucVar.zzf();
                    if (i2 == 0) {
                        throw null;
                    }
                    if (iZzf == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode() ^ 1000003;
        int i = this.zzc;
        if (i == 0) {
            throw null;
        }
        int i2 = (((iHashCode * 1000003) ^ 1237) * 1000003) ^ i;
        if (this.zzd != 0) {
            return (i2 * 583896283) ^ 1;
        }
        throw null;
    }

    public final String toString() {
        int i = this.zzc;
        String str = AbstractJsonLexerKt.NULL;
        String str2 = i != 1 ? i != 2 ? i != 3 ? i != 4 ? AbstractJsonLexerKt.NULL : "NO_CHECKS" : "SKIP_SECURITY_CHECK" : "SKIP_COMPLIANCE_CHECK" : "ALL_CHECKS";
        if (this.zzd == 1) {
            str = "READ_AND_WRITE";
        }
        String str3 = this.zzb;
        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 73 + str2.length() + 91 + str.length() + 1);
        sb.append("FileComplianceOptions{fileOwner=");
        sb.append(str3);
        sb.append(", hasDifferentDmaOwner=false, fileChecks=");
        sb.append(str2);
        sb.append(", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfuc
    public final String zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfuc
    public final boolean zzb() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfuc
    public final zzftt zzc() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfuc
    public final zzftu zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfuc
    public final int zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfuc
    public final int zzf() {
        return this.zzd;
    }
}
