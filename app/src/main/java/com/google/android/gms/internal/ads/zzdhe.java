package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdhe extends zzdem implements zzbmp {
    public zzdhe(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbmp
    public final synchronized void zza() {
        zzs(zzdhd.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbmp
    public final void zzb(final zzbyh zzbyhVar) {
        zzs(new zzdel() { // from class: com.google.android.gms.internal.ads.zzdhb
            @Override // com.google.android.gms.internal.ads.zzdel
            public final /* synthetic */ void zza(Object obj) {
                ((zzbmp) obj).zzb(zzbyhVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbmp
    public final void zzc() {
        zzs(zzdhc.zza);
    }
}
