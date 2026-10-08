package com.google.android.gms.ads.nonagon.signalgeneration;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzdhh;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbl implements zzdhh {
    private final zzb zza;
    private final int zzb;
    private final String zzc;

    public zzbl(zzb zzbVar, int i, String str) {
        this.zza = zzbVar;
        this.zzb = i;
        this.zzc = str;
    }

    final /* synthetic */ void zza(zzbj zzbjVar) {
        this.zza.zza(this.zzc, zzbjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdhh
    public final void zzd(final zzbj zzbjVar) {
        if (zzbjVar == null || this.zzb != 2 || TextUtils.isEmpty(this.zzc)) {
            return;
        }
        com.google.android.gms.ads.internal.util.zzs.zzh(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbk
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zza(zzbjVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdhh
    public final void zze(String str) {
    }
}
