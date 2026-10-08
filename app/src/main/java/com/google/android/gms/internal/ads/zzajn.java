package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzajn extends zzajw {
    private zzadn zza;
    private zzajm zzb;

    zzajn() {
    }

    private static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    protected final void zza(boolean z) {
        super.zza(z);
        if (z) {
            this.zza = null;
            this.zzb = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    protected final long zzb(zzeg zzegVar) {
        if (!zzd(zzegVar.zzi())) {
            return -1L;
        }
        int i = (zzegVar.zzi()[2] & 255) >> 4;
        if (i == 6) {
            zzegVar.zzk(4);
            zzegVar.zzO();
        } else if (i == 7) {
            i = 7;
            zzegVar.zzk(4);
            zzegVar.zzO();
        }
        int iZzc = zzadi.zzc(zzegVar, i);
        zzegVar.zzh(0);
        return iZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzeg zzegVar, long j, zzaju zzajuVar) {
        byte[] bArrZzi = zzegVar.zzi();
        zzadn zzadnVar = this.zza;
        if (zzadnVar == null) {
            zzadn zzadnVar2 = new zzadn(bArrZzi, 17);
            this.zza = zzadnVar2;
            zzt zztVarZza = zzadnVar2.zzc(Arrays.copyOfRange(bArrZzi, 9, zzegVar.zze()), null).zza();
            zztVarZza.zzl(MimeTypes.AUDIO_OGG);
            zzajuVar.zza = zztVarZza.zzM();
            return true;
        }
        if ((bArrZzi[0] & 127) == 3) {
            zzadm zzadmVarZzc = zzadk.zzc(zzegVar);
            zzadn zzadnVarZze = zzadnVar.zze(zzadmVarZzc);
            this.zza = zzadnVarZze;
            this.zzb = new zzajm(zzadnVarZze, zzadmVarZzc);
            return true;
        }
        if (!zzd(bArrZzi)) {
            return true;
        }
        zzajm zzajmVar = this.zzb;
        if (zzajmVar != null) {
            zzajmVar.zzd(j);
            zzajuVar.zzb = this.zzb;
        }
        zzajuVar.zza.getClass();
        return false;
    }
}
