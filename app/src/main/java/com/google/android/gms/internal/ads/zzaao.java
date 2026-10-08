package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaao {
    private final Context zza;
    private final zzaba zzb;
    private zzbs zzc;
    private boolean zzd;
    private boolean zzf;
    private long zzg = 15000;
    private final zzabb zzh = new zzabb(1.0f);
    private zzdc zze = zzdc.zza;

    public zzaao(Context context, zzaba zzabaVar) {
        this.zza = context.getApplicationContext();
        this.zzb = zzabaVar;
    }

    public final zzaao zza(boolean z) {
        this.zzd = true;
        return this;
    }

    public final zzaao zzb(zzdc zzdcVar) {
        this.zze = zzdcVar;
        return this;
    }

    public final zzaao zzc(long j) {
        this.zzg = j;
        return this;
    }

    public final zzaaw zzd() {
        zzgmd.zzh(!this.zzf);
        if (this.zzc == null) {
            this.zzc = new zzaau(false);
        }
        zzaaw zzaawVar = new zzaaw(this, null);
        this.zzf = true;
        return zzaawVar;
    }

    final /* synthetic */ Context zze() {
        return this.zza;
    }

    final /* synthetic */ zzaba zzf() {
        return this.zzb;
    }

    final /* synthetic */ zzbs zzg() {
        return this.zzc;
    }

    final /* synthetic */ boolean zzh() {
        return this.zzd;
    }

    final /* synthetic */ zzdc zzi() {
        return this.zze;
    }

    final /* synthetic */ long zzj() {
        return this.zzg;
    }

    final /* synthetic */ zzabb zzk() {
        return this.zzh;
    }
}
