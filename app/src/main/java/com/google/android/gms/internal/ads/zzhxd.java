package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzhxd extends IOException {
    private boolean zza;

    public zzhxd(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    final void zza() {
        this.zza = true;
    }

    final boolean zzb() {
        return this.zza;
    }

    public zzhxd(String str) {
        super(str);
    }

    public zzhxd(String str, IOException iOException) {
        super("Unable to parse map entry.", iOException);
    }
}
