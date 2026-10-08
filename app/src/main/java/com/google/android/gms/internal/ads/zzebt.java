package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzebt extends zzbxa {
    private final zzcca zza;
    private final zzbxj zzb;

    zzebt(zzcca zzccaVar, zzbxj zzbxjVar) {
        this.zza = zzccaVar;
        this.zzb = zzbxjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zze(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zzc(new zzeck(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), this.zzb));
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zzf(com.google.android.gms.ads.internal.util.zzba zzbaVar) {
        this.zza.zzd(zzbaVar.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbxj zzbxjVar) {
        this.zza.zzc(new zzeck(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), zzbxjVar));
    }
}
