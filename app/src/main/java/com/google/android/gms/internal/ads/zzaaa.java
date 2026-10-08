package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaaa {
    final /* synthetic */ zzaab zza;
    private zzv zzb;

    /* synthetic */ zzaaa(zzaab zzaabVar, byte[] bArr) {
        Objects.requireNonNull(zzaabVar);
        this.zza = zzaabVar;
    }

    public final void zza(final zzbv zzbvVar) {
        zzt zztVar = new zzt();
        zztVar.zzt(zzbvVar.zzb);
        zztVar.zzu(zzbvVar.zzc);
        zztVar.zzm("video/raw");
        this.zzb = zztVar.zzM();
        this.zza.zzC().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzz
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zza.zzB().zzd(zzbvVar);
            }
        });
    }

    public final void zzb(long j, long j2, boolean z) {
        if (z) {
            zzaab zzaabVar = this.zza;
            if (zzaabVar.zzA() != null) {
                zzaabVar.zzC().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzzx
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zza.zzB().zzb();
                    }
                });
            }
        }
        zzv zzvVarZzM = this.zzb;
        if (zzvVarZzM == null) {
            zzvVarZzM = new zzt().zzM();
        }
        zzv zzvVar = zzvVarZzM;
        zzaab zzaabVar2 = this.zza;
        zzaabVar2.zzD().zzcS(j2, j, zzvVar, null);
        ((zzabv) zzaabVar2.zzz().remove()).zza(j);
    }
}
