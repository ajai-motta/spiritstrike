package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgvx {
    private boolean zza;

    @Nullable
    private final zzgwj zzc;
    private final zzgvv zzb = zzgvv.zza;
    private zzgvy zzd = null;

    @Nullable
    private zzgvz zze = null;

    /* synthetic */ zzgvx(zzgwj zzgwjVar, byte[] bArr) {
        this.zzc = zzgwjVar;
    }

    public final zzgvx zza() {
        zzgvz zzgvzVar = this.zze;
        if (zzgvzVar != null) {
            zzgvzVar.zzc();
        }
        this.zza = true;
        return this;
    }

    public final zzgvx zzb() {
        this.zzd = zzgvy.zza;
        return this;
    }

    final /* synthetic */ boolean zzc() {
        return this.zza;
    }

    final /* synthetic */ void zzd(boolean z) {
        this.zza = false;
    }

    final /* synthetic */ zzgvv zze() {
        return this.zzb;
    }

    final /* synthetic */ zzgwj zzf() {
        return this.zzc;
    }

    final /* synthetic */ zzgvy zzg() {
        return this.zzd;
    }

    final /* synthetic */ zzgvz zzh() {
        return this.zze;
    }

    final /* synthetic */ void zzi(zzgvz zzgvzVar) {
        this.zze = zzgvzVar;
    }
}
