package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzri;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzel implements zzem {
    zzel(zzep zzepVar) {
    }

    @Override // com.google.android.gms.tagmanager.zzem
    public final void zza(zzri zzriVar, Set set, Set set2, zzdj zzdjVar) {
        set.addAll(zzriVar.zzc());
        set2.addAll(zzriVar.zzh());
        zzriVar.zzc();
        zzriVar.zzb();
        zzriVar.zzh();
        zzriVar.zzg();
    }
}
