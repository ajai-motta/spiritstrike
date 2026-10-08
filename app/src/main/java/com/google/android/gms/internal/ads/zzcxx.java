package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcxx {
    private final Context zza;
    private final zzfgn zzb;
    private final Bundle zzc;
    private final zzfgg zzd;
    private final zzcxp zze;
    private final zzehp zzf;
    private final int zzg;

    /* synthetic */ zzcxx(zzcxw zzcxwVar, byte[] bArr) {
        this.zza = zzcxwVar.zzi();
        this.zzb = zzcxwVar.zzj();
        this.zzc = zzcxwVar.zzk();
        this.zzd = zzcxwVar.zzl();
        this.zze = zzcxwVar.zzm();
        this.zzf = zzcxwVar.zzn();
        this.zzg = zzcxwVar.zzo();
    }

    final zzcxw zza() {
        zzcxw zzcxwVar = new zzcxw();
        zzcxwVar.zza(this.zza);
        zzcxwVar.zzb(this.zzb);
        zzcxwVar.zzc(this.zzc);
        zzcxwVar.zzd(this.zze);
        zzcxwVar.zzg(this.zzf);
        return zzcxwVar;
    }

    final zzfgn zzb() {
        return this.zzb;
    }

    final zzfgg zzc() {
        return this.zzd;
    }

    final Bundle zzd() {
        return this.zzc;
    }

    final zzcxp zze() {
        return this.zze;
    }

    final Context zzf(Context context) {
        return this.zza;
    }

    final zzehp zzg(String str) {
        zzehp zzehpVar = this.zzf;
        return zzehpVar != null ? zzehpVar : new zzehp(str);
    }

    final int zzh() {
        return this.zzg;
    }
}
