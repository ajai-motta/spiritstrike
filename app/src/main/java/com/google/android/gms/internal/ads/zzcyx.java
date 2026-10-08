package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcyx extends zzdem implements zzcys {
    public zzcyx(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzcys
    public final void zzc(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzs(new zzdel() { // from class: com.google.android.gms.internal.ads.zzcyw
            @Override // com.google.android.gms.internal.ads.zzdel
            public final /* synthetic */ void zza(Object obj) {
                ((zzcze) obj).zzj(zzeVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcys
    public final void zzd(final zzdjk zzdjkVar) {
        zzs(new zzdel() { // from class: com.google.android.gms.internal.ads.zzcyu
            @Override // com.google.android.gms.internal.ads.zzdel
            public final /* synthetic */ void zza(Object obj) {
                zzcze zzczeVar = (zzcze) obj;
                String message = zzdjkVar.getMessage();
                if (message == null) {
                    message = "Internal show error.";
                }
                zzczeVar.zzj(zzfhp.zzd(12, message, null));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcys
    public final void zze() {
        zzs(zzcyv.zza);
    }
}
