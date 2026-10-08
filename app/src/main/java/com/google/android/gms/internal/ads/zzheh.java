package com.google.android.gms.internal.ads;

import com.hive.core.Configuration;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzheh extends zzgwj {
    private final String zza;
    private final zzhlt zzb;

    /* synthetic */ zzheh(String str, zzhlt zzhltVar, byte[] bArr) {
        this.zza = str;
        this.zzb = zzhltVar;
    }

    public final String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = this.zza;
        int iOrdinal = this.zzb.ordinal();
        objArr[1] = iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? Configuration.HIVE_COUNTRY_DEFAULT : "CRUNCHY" : "RAW" : "LEGACY" : "TINK";
        return String.format("(typeUrl=%s, outputPrefixType=%s)", objArr);
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zzb != zzhlt.RAW;
    }
}
