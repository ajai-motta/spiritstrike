package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdhr extends zzdem {
    private boolean zzb;

    protected zzdhr(Set set) {
        super(set);
    }

    public final void zza() {
        zzs(zzdhq.zza);
    }

    public final void zzb() {
        zzs(zzdhm.zza);
    }

    public final synchronized void zzc() {
        zzs(zzdhn.zza);
        this.zzb = true;
    }

    public final synchronized void zzd() {
        if (!this.zzb) {
            zzs(zzdhp.zza);
            this.zzb = true;
        }
        zzs(zzdho.zza);
    }
}
