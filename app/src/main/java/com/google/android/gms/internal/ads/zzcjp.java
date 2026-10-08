package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcjp {
    private final VersionInfoParcel zza;
    private final Context zzb;
    private final long zzc;
    private final WeakReference zzd;

    /* synthetic */ zzcjp(zzcjo zzcjoVar, byte[] bArr) {
        this.zza = zzcjoVar.zzd();
        this.zzb = zzcjoVar.zze();
        this.zzd = zzcjoVar.zzg();
        this.zzc = zzcjoVar.zzf();
    }

    final Context zza() {
        return this.zzb;
    }

    final Context zzb() {
        return this.zzb;
    }

    final WeakReference zzc() {
        return this.zzd;
    }

    final VersionInfoParcel zzd() {
        return this.zza;
    }

    final String zze() {
        return com.google.android.gms.ads.internal.zzt.zzc().zze(this.zzb, this.zza.afmaVersion);
    }

    final zzcjm zzf() {
        return new zzcjm(this.zzb, this.zza);
    }

    public final com.google.android.gms.ads.internal.zzk zzg() {
        return new com.google.android.gms.ads.internal.zzk(this.zzb, this.zza);
    }

    final zzbho zzh() {
        return new zzbho(this.zzb);
    }

    final long zzi() {
        return this.zzc;
    }
}
