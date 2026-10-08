package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdbd extends zzdem implements zzczi, zzdan {
    private final zzffu zzb;
    private final AtomicBoolean zzc;
    private final zzfgf zzd;

    public zzdbd(Set set, zzffu zzffuVar, zzfgf zzfgfVar) {
        super(set);
        this.zzc = new AtomicBoolean();
        this.zzb = zzffuVar;
        this.zzd = zzfgfVar;
    }

    private final void zzb() {
        final com.google.android.gms.ads.internal.client.zzt zztVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zziG)).booleanValue() && this.zzc.compareAndSet(false, true) && (zztVar = this.zzb.zzae) != null && zztVar.zza == 3) {
            zzs(new zzdel() { // from class: com.google.android.gms.internal.ads.zzdbc
                @Override // com.google.android.gms.internal.ads.zzdel
                public final /* synthetic */ void zza(Object obj) {
                    ((zzdbf) obj).zzm(zztVar);
                }
            });
        }
    }

    public final void zza(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        if (com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zza(this.zzd) && this.zzb.zzaB) {
            zzs(new zzdel() { // from class: com.google.android.gms.internal.ads.zzdbb
                @Override // com.google.android.gms.internal.ads.zzdel
                public final /* synthetic */ void zza(Object obj) {
                    ((zzdbf) obj).zzm(zztVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczi
    public final void zzdw() {
        int i = this.zzb.zzb;
        if (i == 2 || i == 5 || i == 4 || i == 6 || i == 7) {
            zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final void zzl() {
        if (this.zzb.zzb == 1) {
            zzb();
        }
    }
}
