package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdma {
    public static final zzdma zza = new zzdma(new zzdlz());
    private final zzbjj zzb;
    private final zzbjg zzc;
    private final zzbjw zzd;
    private final zzbjt zze;
    private final zzbor zzf;
    private final SimpleArrayMap zzg;
    private final SimpleArrayMap zzh;

    private zzdma(zzdlz zzdlzVar) {
        this.zzb = zzdlzVar.zza;
        this.zzc = zzdlzVar.zzb;
        this.zzd = zzdlzVar.zzc;
        this.zzg = new SimpleArrayMap(zzdlzVar.zzf);
        this.zzh = new SimpleArrayMap(zzdlzVar.zzg);
        this.zze = zzdlzVar.zzd;
        this.zzf = zzdlzVar.zze;
    }

    /* synthetic */ zzdma(zzdlz zzdlzVar, byte[] bArr) {
        this(zzdlzVar);
    }

    public final zzbjj zza() {
        return this.zzb;
    }

    public final zzbjg zzb() {
        return this.zzc;
    }

    public final zzbjw zzc() {
        return this.zzd;
    }

    public final zzbjt zzd() {
        return this.zze;
    }

    public final zzbor zze() {
        return this.zzf;
    }

    public final zzbjp zzf(String str) {
        if (str == null) {
            return null;
        }
        return (zzbjp) this.zzg.get(str);
    }

    public final zzbjm zzg(String str) {
        return (zzbjm) this.zzh.get(str);
    }

    public final ArrayList zzh() {
        ArrayList arrayList = new ArrayList();
        if (this.zzd != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzb != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzc != null) {
            arrayList.add(Integer.toString(2));
        }
        if (!this.zzg.isEmpty()) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzf != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    public final ArrayList zzi() {
        SimpleArrayMap simpleArrayMap = this.zzg;
        ArrayList arrayList = new ArrayList(simpleArrayMap.size());
        for (int i = 0; i < simpleArrayMap.size(); i++) {
            arrayList.add((String) simpleArrayMap.keyAt(i));
        }
        return arrayList;
    }
}
