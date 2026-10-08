package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfse implements zzfsh {
    private static final zzauz zza;

    static {
        zzauc zzaucVarZzj = zzauz.zzj();
        zzaucVarZzj.zzo(ExifInterface.LONGITUDE_EAST);
        zza = (zzauz) zzaucVarZzj.zzbu();
    }

    zzfse() {
    }

    @Override // com.google.android.gms.internal.ads.zzfsh
    public final zzauz zza() {
        return zza;
    }
}
