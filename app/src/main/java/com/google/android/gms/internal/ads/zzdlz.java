package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdlz {
    zzbjj zza;
    zzbjg zzb;
    zzbjw zzc;
    zzbjt zzd;
    zzbor zze;
    final SimpleArrayMap zzf = new SimpleArrayMap();
    final SimpleArrayMap zzg = new SimpleArrayMap();

    public final zzdlz zza(zzbjj zzbjjVar) {
        this.zza = zzbjjVar;
        return this;
    }

    public final zzdlz zzb(zzbjg zzbjgVar) {
        this.zzb = zzbjgVar;
        return this;
    }

    public final zzdlz zzc(zzbjw zzbjwVar) {
        this.zzc = zzbjwVar;
        return this;
    }

    public final zzdlz zzd(zzbjt zzbjtVar) {
        this.zzd = zzbjtVar;
        return this;
    }

    public final zzdlz zze(zzbor zzborVar) {
        this.zze = zzborVar;
        return this;
    }

    public final zzdlz zzf(String str, zzbjp zzbjpVar, zzbjm zzbjmVar) {
        this.zzf.put(str, zzbjpVar);
        if (zzbjmVar != null) {
            this.zzg.put(str, zzbjmVar);
        }
        return this;
    }

    public final zzdma zzg() {
        return new zzdma(this, null);
    }
}
