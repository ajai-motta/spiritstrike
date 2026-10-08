package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzrk implements zzqe {
    final /* synthetic */ zzrl zza;

    /* synthetic */ zzrk(zzrl zzrlVar, byte[] bArr) {
        Objects.requireNonNull(zzrlVar);
        this.zza = zzrlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqe
    public final void zza() {
        zzlm zzlmVarZzaY = this.zza.zzaY();
        if (zzlmVarZzaY != null) {
            zzlmVarZzaY.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqe
    public final void zzb(Exception exc) {
        zzdt.zzf("MediaCodecAudioRenderer", "Audio sink error", exc);
        this.zza.zzaw().zzi(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzqe
    public final void zzc(zzqb zzqbVar) {
        this.zza.zzaw().zzl(zzqbVar);
    }
}
