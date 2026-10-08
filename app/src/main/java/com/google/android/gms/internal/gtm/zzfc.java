package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfc extends zzbq implements zzcq {
    private final zzfe zza;

    public zzfc(zzbu zzbuVar) {
        super(zzbuVar);
        this.zza = new zzfe();
    }

    @Override // com.google.android.gms.internal.gtm.zzcq
    public final /* synthetic */ zzcp zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzcq
    public final void zzb(String str, String str2) {
        this.zza.zzg.put(str, str2);
    }

    @Override // com.google.android.gms.internal.gtm.zzcq
    public final void zzc(String str, boolean z) {
        if ("ga_autoActivityTracking".equals(str)) {
            this.zza.zzd = z ? 1 : 0;
        } else if ("ga_anonymizeIp".equals(str)) {
            this.zza.zze = z ? 1 : 0;
        } else if (!"ga_reportUncaughtExceptions".equals(str)) {
            zzR("bool configuration name not recognized", str);
        } else {
            this.zza.zzf = z ? 1 : 0;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzcq
    public final void zzd(String str, int i) {
        if ("ga_sessionTimeout".equals(str)) {
            this.zza.zzc = i;
        } else {
            zzR("int configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzcq
    public final void zze(String str, String str2) {
        if ("ga_trackingId".equals(str)) {
            this.zza.zza = str2;
            return;
        }
        if (!"ga_sampleFrequency".equals(str)) {
            zzR("string configuration name not recognized", str);
            return;
        }
        try {
            this.zza.zzb = Double.parseDouble(str2);
        } catch (NumberFormatException e) {
            zzS("Error parsing ga_sampleFrequency value", str2, e);
        }
    }
}
