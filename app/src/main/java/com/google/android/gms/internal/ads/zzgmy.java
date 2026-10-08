package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgmy implements zzgmv {
    private static final zzgmv zzb = zzgmx.zza;
    private final zzgnc zza = new zzgnc();
    private volatile zzgmv zzc;
    private Object zzd;

    zzgmy(zzgmv zzgmvVar) {
        this.zzc = zzgmvVar;
    }

    public final String toString() {
        Object string = this.zzc;
        if (string == zzb) {
            String strValueOf = String.valueOf(this.zzd);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(strValueOf);
            sb.append(">");
            string = sb.toString();
        }
        String strValueOf2 = String.valueOf(string);
        StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(strValueOf2);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgmv
    public final Object zza() {
        zzgmv zzgmvVar = this.zzc;
        zzgmv zzgmvVar2 = zzb;
        if (zzgmvVar != zzgmvVar2) {
            synchronized (this.zza) {
                if (this.zzc != zzgmvVar2) {
                    Object objZza = this.zzc.zza();
                    this.zzd = objZza;
                    this.zzc = zzgmvVar2;
                    return objZza;
                }
            }
        }
        return this.zzd;
    }
}
