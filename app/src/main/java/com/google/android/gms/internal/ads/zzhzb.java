package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhzb extends RuntimeException {
    public zzhzb(zzhxz zzhxzVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzhxd zza() {
        return new zzhxd(getMessage());
    }
}
