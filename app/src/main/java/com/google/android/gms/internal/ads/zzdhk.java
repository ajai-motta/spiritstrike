package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdhk extends zzdem {
    zzdhk(Set set) {
        super(set);
    }

    public final synchronized void zza(final com.google.android.gms.ads.nonagon.signalgeneration.zzbj zzbjVar) {
        zzs(new zzdel() { // from class: com.google.android.gms.internal.ads.zzdhj
            @Override // com.google.android.gms.internal.ads.zzdel
            public final /* synthetic */ void zza(Object obj) {
                ((zzdhh) obj).zzd(zzbjVar);
            }
        });
    }

    public final synchronized void zzb(final String str) {
        zzs(new zzdel() { // from class: com.google.android.gms.internal.ads.zzdhi
            @Override // com.google.android.gms.internal.ads.zzdel
            public final /* synthetic */ void zza(Object obj) {
                ((zzdhh) obj).zze(str);
            }
        });
    }
}
