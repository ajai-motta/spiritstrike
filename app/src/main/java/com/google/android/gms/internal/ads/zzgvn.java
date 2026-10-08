package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgvn implements zzgwf {
    private final InputStream zza;

    private zzgvn(InputStream inputStream) {
        this.zza = inputStream;
    }

    public static zzgwf zza(byte[] bArr) {
        return new zzgvn(new ByteArrayInputStream(bArr));
    }

    @Override // com.google.android.gms.internal.ads.zzgwf
    public final zzhlg zzb() throws IOException {
        try {
            return zzhlg.zzg(this.zza, zzhvy.zza());
        } finally {
            this.zza.close();
        }
    }
}
