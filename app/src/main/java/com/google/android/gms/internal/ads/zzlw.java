package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public final class zzlw {
    private final zzik zza;

    @Deprecated
    public zzlw(Context context, zzls zzlsVar) {
        this.zza = new zzik(context, zzlsVar);
    }

    @Deprecated
    public final zzlw zza(final zzyr zzyrVar) {
        zzik zzikVar = this.zza;
        zzgmd.zzh(!zzikVar.zzw);
        zzyrVar.getClass();
        zzikVar.zze = new zzgmv() { // from class: com.google.android.gms.internal.ads.zzih
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final /* synthetic */ Object zza() {
                return zzyrVar;
            }
        };
        return this;
    }

    @Deprecated
    public final zzlw zzb(final zzkl zzklVar) {
        zzik zzikVar = this.zza;
        zzgmd.zzh(!zzikVar.zzw);
        zzklVar.getClass();
        zzikVar.zzf = new zzgmv() { // from class: com.google.android.gms.internal.ads.zzii
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final /* synthetic */ Object zza() {
                return zzklVar;
            }
        };
        return this;
    }

    @Deprecated
    public final zzlx zzc() {
        zzik zzikVar = this.zza;
        zzgmd.zzh(!zzikVar.zzw);
        zzikVar.zzw = true;
        return new zzlx(zzikVar);
    }
}
