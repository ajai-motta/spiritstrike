package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcxw {
    private Context zza;
    private zzfgn zzb;
    private Bundle zzc;
    private zzfgg zzd;
    private zzcxp zze;
    private zzehp zzf;
    private int zzg = 0;

    public final zzcxw zza(Context context) {
        this.zza = context;
        return this;
    }

    public final zzcxw zzb(zzfgn zzfgnVar) {
        this.zzb = zzfgnVar;
        return this;
    }

    public final zzcxw zzc(Bundle bundle) {
        this.zzc = bundle;
        return this;
    }

    public final zzcxw zzd(zzcxp zzcxpVar) {
        this.zze = zzcxpVar;
        return this;
    }

    public final zzcxx zze() {
        return new zzcxx(this, null);
    }

    public final zzcxw zzf(zzfgg zzfggVar) {
        this.zzd = zzfggVar;
        return this;
    }

    public final zzcxw zzg(zzehp zzehpVar) {
        this.zzf = zzehpVar;
        return this;
    }

    public final zzcxw zzh(int i) {
        this.zzg = i;
        return this;
    }

    final /* synthetic */ Context zzi() {
        return this.zza;
    }

    final /* synthetic */ zzfgn zzj() {
        return this.zzb;
    }

    final /* synthetic */ Bundle zzk() {
        return this.zzc;
    }

    final /* synthetic */ zzfgg zzl() {
        return this.zzd;
    }

    final /* synthetic */ zzcxp zzm() {
        return this.zze;
    }

    final /* synthetic */ zzehp zzn() {
        return this.zzf;
    }

    final /* synthetic */ int zzo() {
        return this.zzg;
    }
}
