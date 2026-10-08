package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzacc extends zzacf implements zzadm {
    protected zzabv zza = zzabv.zze();

    private final void zzc(zzace zzaceVar) {
        if (zzaceVar.zza != ((zzacf) zzb(6, null, null))) {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }

    final zzabv zzU() {
        if (this.zza.zzl()) {
            this.zza = this.zza.clone();
        }
        return this.zza;
    }

    public final Object zzV(zzabo zzaboVar) {
        zzace zzaceVar = (zzace) zzaboVar;
        zzc(zzaceVar);
        Object objZzf = this.zza.zzf(zzaceVar.zzd);
        if (objZzf == null) {
            return zzaceVar.zzb;
        }
        zzacd zzacdVar = zzaceVar.zzd;
        if (!zzacdVar.zzd) {
            return zzaceVar.zza(objZzf);
        }
        if (zzacdVar.zzc.zza() != zzaey.ENUM) {
            return objZzf;
        }
        zzadu zzaduVar = new zzadu();
        List list = (List) objZzf;
        zzaduVar.zzf(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzaduVar.add(zzaceVar.zza(it.next()));
        }
        zzaduVar.zzb();
        return zzaduVar;
    }

    public final boolean zzW(zzabo zzaboVar) {
        zzace zzaceVar = (zzace) zzaboVar;
        zzc(zzaceVar);
        zzabv zzabvVar = this.zza;
        zzacd zzacdVar = zzaceVar.zzd;
        if (zzacdVar.zzd) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return zzabvVar.zza.get(zzacdVar) != null;
    }
}
