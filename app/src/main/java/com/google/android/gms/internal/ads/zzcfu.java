package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcfu implements zzgb {
    private final zzgb zza;
    private final long zzb;
    private final zzgb zzc;
    private long zzd;
    private Uri zze;

    zzcfu(zzgb zzgbVar, int i, zzgb zzgbVar2) {
        this.zza = zzgbVar;
        this.zzb = i;
        this.zzc = zzgbVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.zzd;
        long j2 = this.zzb;
        if (j < j2) {
            int iZza = this.zza.zza(bArr, i, (int) Math.min(i2, j2 - j));
            long j3 = this.zzd + ((long) iZza);
            this.zzd = j3;
            i3 = iZza;
            j = j3;
        } else {
            i3 = 0;
        }
        if (j < j2) {
            return i3;
        }
        int iZza2 = this.zzc.zza(bArr, i + i3, i2 - i3);
        int i4 = i3 + iZza2;
        this.zzd += (long) iZza2;
        return i4;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final long zzb(zzgf zzgfVar) throws IOException {
        zzgf zzgfVar2;
        Uri uri = zzgfVar.zza;
        this.zze = uri;
        long j = zzgfVar.zze;
        long j2 = this.zzb;
        zzgf zzgfVar3 = null;
        if (j >= j2) {
            zzgfVar2 = null;
        } else {
            long j3 = zzgfVar.zzf;
            long j4 = j2 - j;
            zzgfVar2 = new zzgf(uri, j, j3 != -1 ? Math.min(j3, j4) : j4, null);
        }
        long j5 = zzgfVar.zzf;
        if (j5 == -1 || j + j5 > j2) {
            zzgfVar3 = new zzgf(uri, Math.max(j2, j), j5 != -1 ? Math.min(j5, (j + j5) - j2) : -1L, null);
        }
        long jZzb = zzgfVar2 != null ? this.zza.zzb(zzgfVar2) : 0L;
        long jZzb2 = zzgfVar3 != null ? this.zzc.zzb(zzgfVar3) : 0L;
        this.zzd = j;
        if (jZzb == -1 || jZzb2 == -1) {
            return -1L;
        }
        return jZzb + jZzb2;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final Uri zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zzd() throws IOException {
        this.zza.zzd();
        this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zze(zzgz zzgzVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final Map zzj() {
        return zzgph.zza();
    }
}
