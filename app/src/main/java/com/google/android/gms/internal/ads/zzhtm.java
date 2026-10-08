package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhtm extends zzhtn {
    final /* synthetic */ zzhtn zza;

    /* synthetic */ zzhtm(zzhtn zzhtnVar, byte[] bArr) {
        Objects.requireNonNull(zzhtnVar);
        this.zza = zzhtnVar;
    }

    public final String toString() {
        String string = this.zza.toString();
        StringBuilder sb = new StringBuilder(string.length() + 21);
        sb.append("NullSafeTypeAdapter[");
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzhtn
    public final void zza(zzhun zzhunVar, Object obj) throws IOException {
        throw null;
    }
}
