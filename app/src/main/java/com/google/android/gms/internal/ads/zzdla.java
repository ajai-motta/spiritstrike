package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzdla implements zzbau {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdll zzb;

    zzdla(zzdll zzdllVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzdllVar);
        this.zzb = zzdllVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbau
    public final void zzdo(zzbat zzbatVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzca)).booleanValue()) {
            synchronized (this) {
                if (zzbatVar.zzj) {
                    zzdll zzdllVar = this.zzb;
                    if (zzdllVar.zzaa() != null) {
                        zzdllVar.zzab().put(this.zza, true);
                        if (zzdllVar.zzaa() == null) {
                            return;
                        } else {
                            zzdllVar.zzu(zzdllVar.zzaa().zzdJ(), zzdllVar.zzaa().zzj(), zzdllVar.zzaa().zzk(), true);
                        }
                    }
                }
                return;
            }
        }
        if (zzbatVar.zzj) {
            zzdll zzdllVar2 = this.zzb;
            if (zzdllVar2.zzaa() != null) {
                zzdllVar2.zzab().put(this.zza, true);
                if (zzdllVar2.zzaa() == null) {
                    return;
                }
                zzdllVar2.zzu(zzdllVar2.zzaa().zzdJ(), zzdllVar2.zzaa().zzj(), zzdllVar2.zzaa().zzk(), true);
            }
        }
    }
}
