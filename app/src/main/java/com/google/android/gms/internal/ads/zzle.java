package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzle {
    private final zzpc zza;
    private final zzld zze;
    private final zzmi zzh;
    private final zzdm zzi;
    private boolean zzj;
    private zzgz zzk;
    private zzwn zzl = new zzwn(0);
    private final IdentityHashMap zzc = new IdentityHashMap();
    private final Map zzd = new HashMap();
    private final List zzb = new ArrayList();
    private final HashMap zzf = new HashMap();
    private final Set zzg = new HashSet();

    public zzle(zzld zzldVar, zzmi zzmiVar, zzdm zzdmVar, zzpc zzpcVar) {
        this.zza = zzpcVar;
        this.zze = zzldVar;
        this.zzh = zzmiVar;
        this.zzi = zzdmVar;
    }

    private final void zzr() {
        Iterator it = this.zzg.iterator();
        while (it.hasNext()) {
            zzlb zzlbVar = (zzlb) it.next();
            if (zzlbVar.zzc.isEmpty()) {
                zzs(zzlbVar);
                it.remove();
            }
        }
    }

    private final void zzs(zzlb zzlbVar) {
        zzla zzlaVar = (zzla) this.zzf.get(zzlbVar);
        if (zzlaVar != null) {
            zzlaVar.zza.zzr(zzlaVar.zzb);
        }
    }

    private final void zzt(int i, int i2) {
        while (true) {
            i2--;
            if (i2 < i) {
                return;
            }
            zzlb zzlbVar = (zzlb) this.zzb.remove(i2);
            this.zzd.remove(zzlbVar.zzb);
            zzu(i2, -zzlbVar.zza.zzz().zza());
            zzlbVar.zze = true;
            if (this.zzj) {
                zzw(zzlbVar);
            }
        }
    }

    private final void zzu(int i, int i2) {
        while (true) {
            List list = this.zzb;
            if (i >= list.size()) {
                return;
            }
            ((zzlb) list.get(i)).zzd += i2;
            i++;
        }
    }

    private final void zzv(zzlb zzlbVar) {
        zzup zzupVar = zzlbVar.zza;
        zzuv zzuvVar = new zzuv() { // from class: com.google.android.gms.internal.ads.zzlc
            @Override // com.google.android.gms.internal.ads.zzuv
            public final /* synthetic */ void zza(zzuw zzuwVar, zzbf zzbfVar) {
                this.zza.zzi(zzuwVar, zzbfVar);
            }
        };
        zzkz zzkzVar = new zzkz(this, zzlbVar);
        this.zzf.put(zzlbVar, new zzla(zzupVar, zzuvVar, zzkzVar));
        zzupVar.zzl(new Handler(zzep.zze(), null), zzkzVar);
        zzupVar.zzn(new Handler(zzep.zze(), null), zzkzVar);
        zzupVar.zzp(zzuvVar, this.zzk, this.zza);
    }

    private final void zzw(zzlb zzlbVar) {
        if (zzlbVar.zze && zzlbVar.zzc.isEmpty()) {
            zzla zzlaVar = (zzla) this.zzf.remove(zzlbVar);
            zzlaVar.getClass();
            zzuw zzuwVar = zzlaVar.zza;
            zzuwVar.zzs(zzlaVar.zzb);
            zzkz zzkzVar = zzlaVar.zzc;
            zzuwVar.zzm(zzkzVar);
            zzuwVar.zzo(zzkzVar);
            this.zzg.remove(zzlbVar);
        }
    }

    public final zzbf zza(int i, int i2, List list) {
        zzgmd.zza(i >= 0 && i <= i2 && i2 <= zzc());
        zzgmd.zza(list.size() == i2 - i);
        for (int i3 = i; i3 < i2; i3++) {
            ((zzlb) this.zzb.get(i3)).zza.zzA((zzak) list.get(i3 - i));
        }
        return zzh();
    }

    public final boolean zzb() {
        return this.zzj;
    }

    public final int zzc() {
        return this.zzb.size();
    }

    public final void zzd(zzgz zzgzVar) {
        zzgmd.zzh(!this.zzj);
        this.zzk = zzgzVar;
        int i = 0;
        while (true) {
            List list = this.zzb;
            if (i >= list.size()) {
                this.zzj = true;
                return;
            }
            zzlb zzlbVar = (zzlb) list.get(i);
            zzv(zzlbVar);
            this.zzg.add(zzlbVar);
            i++;
        }
    }

    public final zzus zze(zzuu zzuuVar, zzyv zzyvVar, long j) {
        int i = zzll.zzb;
        Pair pair = (Pair) zzuuVar.zza;
        Object obj = pair.first;
        zzuu zzuuVarZza = zzuuVar.zza(pair.second);
        zzlb zzlbVar = (zzlb) this.zzd.get(obj);
        zzlbVar.getClass();
        this.zzg.add(zzlbVar);
        zzla zzlaVar = (zzla) this.zzf.get(zzlbVar);
        if (zzlaVar != null) {
            zzlaVar.zza.zzq(zzlaVar.zzb);
        }
        zzlbVar.zzc.add(zzuuVarZza);
        zzum zzumVarZzC = zzlbVar.zza.zzG(zzuuVarZza, zzyvVar, j);
        this.zzc.put(zzumVarZzC, zzlbVar);
        zzr();
        return zzumVarZzC;
    }

    public final void zzf(zzus zzusVar) {
        IdentityHashMap identityHashMap = this.zzc;
        zzlb zzlbVar = (zzlb) identityHashMap.remove(zzusVar);
        zzlbVar.getClass();
        zzlbVar.zza.zzD(zzusVar);
        zzlbVar.zzc.remove(((zzum) zzusVar).zza);
        if (!identityHashMap.isEmpty()) {
            zzr();
        }
        zzw(zzlbVar);
    }

    public final void zzg() {
        for (zzla zzlaVar : this.zzf.values()) {
            try {
                zzlaVar.zza.zzs(zzlaVar.zzb);
            } catch (RuntimeException e) {
                zzdt.zzf("MediaSourceList", "Failed to release child source.", e);
            }
            zzuw zzuwVar = zzlaVar.zza;
            zzkz zzkzVar = zzlaVar.zzc;
            zzuwVar.zzm(zzkzVar);
            zzuwVar.zzo(zzkzVar);
        }
        this.zzf.clear();
        this.zzg.clear();
        this.zzj = false;
    }

    public final zzbf zzh() {
        List list = this.zzb;
        if (list.isEmpty()) {
            return zzbf.zza;
        }
        int iZza = 0;
        for (int i = 0; i < list.size(); i++) {
            zzlb zzlbVar = (zzlb) list.get(i);
            zzlbVar.zzd = iZza;
            iZza += zzlbVar.zza.zzz().zza();
        }
        return new zzll(list, this.zzl);
    }

    final /* synthetic */ void zzi(zzuw zzuwVar, zzbf zzbfVar) {
        this.zze.zzo();
    }

    final /* synthetic */ zzmi zzj() {
        return this.zzh;
    }

    final /* synthetic */ zzdm zzk() {
        return this.zzi;
    }

    public final zzbf zzl(List list, zzwn zzwnVar) {
        List list2 = this.zzb;
        zzt(0, list2.size());
        return zzm(list2.size(), list, zzwnVar);
    }

    public final zzbf zzm(int i, List list, zzwn zzwnVar) {
        if (!list.isEmpty()) {
            this.zzl = zzwnVar;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                zzlb zzlbVar = (zzlb) list.get(i2 - i);
                if (i2 > 0) {
                    zzlb zzlbVar2 = (zzlb) this.zzb.get(i2 - 1);
                    zzlbVar.zzc(zzlbVar2.zzd + zzlbVar2.zza.zzz().zza());
                } else {
                    zzlbVar.zzc(0);
                }
                zzu(i2, zzlbVar.zza.zzz().zza());
                this.zzb.add(i2, zzlbVar);
                this.zzd.put(zzlbVar.zzb, zzlbVar);
                if (this.zzj) {
                    zzv(zzlbVar);
                    if (this.zzc.isEmpty()) {
                        this.zzg.add(zzlbVar);
                    } else {
                        zzs(zzlbVar);
                    }
                }
            }
        }
        return zzh();
    }

    public final zzbf zzn(int i, int i2, zzwn zzwnVar) {
        boolean z = false;
        if (i >= 0 && i <= i2 && i2 <= zzc()) {
            z = true;
        }
        zzgmd.zza(z);
        this.zzl = zzwnVar;
        zzt(i, i2);
        return zzh();
    }

    public final zzbf zzo(int i, int i2, int i3, zzwn zzwnVar) {
        zzgmd.zza(zzc() >= 0);
        this.zzl = null;
        return zzh();
    }

    public final zzbf zzp(zzwn zzwnVar) {
        int iZzc = zzc();
        if (zzwnVar.zza() != iZzc) {
            zzwnVar = zzwnVar.zzh().zzf(0, iZzc);
        }
        this.zzl = zzwnVar;
        return zzh();
    }

    public final zzwn zzq() {
        return this.zzl;
    }
}
