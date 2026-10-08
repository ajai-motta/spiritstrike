package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaqa {
    public final Object zza;
    public final zzapd zzb;
    public final zzaqd zzc;
    public boolean zzd;

    private zzaqa(zzaqd zzaqdVar) {
        this.zzd = false;
        this.zza = null;
        this.zzb = null;
        this.zzc = zzaqdVar;
    }

    private zzaqa(Object obj, zzapd zzapdVar) {
        this.zzd = false;
        this.zza = obj;
        this.zzb = zzapdVar;
        this.zzc = null;
    }

    public static zzaqa zza(Object obj, zzapd zzapdVar) {
        return new zzaqa(obj, zzapdVar);
    }

    public static zzaqa zzb(zzaqd zzaqdVar) {
        return new zzaqa(zzaqdVar);
    }

    public final boolean zzc() {
        return this.zzc == null;
    }
}
