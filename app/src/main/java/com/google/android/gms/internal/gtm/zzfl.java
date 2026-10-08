package com.google.android.gms.internal.gtm;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfl extends zzfr {
    private final String zzb;
    private final int zzc;
    private final int zzd;

    /* synthetic */ zzfl(String str, boolean z, int i, zzfh zzfhVar, zzfi zzfiVar, int i2, zzfk zzfkVar) {
        this.zzb = str;
        this.zzc = i;
        this.zzd = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfr) {
            zzfr zzfrVar = (zzfr) obj;
            if (this.zzb.equals(zzfrVar.zzc())) {
                zzfrVar.zzd();
                int i = this.zzc;
                int iZze = zzfrVar.zze();
                if (i == 0) {
                    throw null;
                }
                if (i == iZze) {
                    zzfrVar.zza();
                    zzfrVar.zzb();
                    int i2 = this.zzd;
                    int iZzf = zzfrVar.zzf();
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
        return "FileComplianceOptions{fileOwner=" + this.zzb + ", hasDifferentDmaOwner=false, fileChecks=" + str2 + ", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=" + str + "}";
    }

    @Override // com.google.android.gms.internal.gtm.zzfr
    public final zzfh zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.gtm.zzfr
    public final zzfi zzb() {
        return null;
    }

    @Override // com.google.android.gms.internal.gtm.zzfr
    public final String zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.gtm.zzfr
    public final boolean zzd() {
        return false;
    }

    @Override // com.google.android.gms.internal.gtm.zzfr
    public final int zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzfr
    public final int zzf() {
        return this.zzd;
    }
}
