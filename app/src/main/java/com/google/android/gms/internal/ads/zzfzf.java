package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfzf implements zzfzg {
    private final zzhxz zza;

    public zzfzf(zzhxz zzhxzVar) {
        this.zza = zzhxzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzg
    public final /* synthetic */ void zza(Object obj, OutputStream outputStream) throws IOException {
        ((zzhxz) obj).zzaO(outputStream);
    }

    @Override // com.google.android.gms.internal.ads.zzfzg
    public final /* bridge */ /* synthetic */ Object zzb(InputStream inputStream) {
        try {
            return (zzhxz) this.zza.zzbd().zza(inputStream, zzhvy.zza());
        } catch (zzhxd e) {
            throw new zzfzc("Cannot read proto.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfzg
    public final /* synthetic */ Object zzc() {
        return this.zza;
    }
}
