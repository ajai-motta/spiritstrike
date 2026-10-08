package com.google.android.gms.tagmanager;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.internal.gtm.zzre;
import com.google.android.gms.internal.gtm.zzri;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzeo {
    private zzre zzf;
    private final Set zza = new HashSet();
    private final Map zzb = new HashMap();
    private final Map zzd = new HashMap();
    private final Map zzc = new HashMap();
    private final Map zze = new HashMap();

    public final zzre zza() {
        return this.zzf;
    }

    public final Map zzb() {
        return this.zzd;
    }

    public final Map zzc() {
        return this.zzb;
    }

    public final Map zzd() {
        return this.zze;
    }

    public final Map zze() {
        return this.zzc;
    }

    public final Set zzf() {
        return this.zza;
    }

    public final void zzg(zzri zzriVar, zzre zzreVar) {
        List arrayList = (List) this.zzb.get(zzriVar);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.zzb.put(zzriVar, arrayList);
        }
        arrayList.add(zzreVar);
    }

    public final void zzh(zzri zzriVar, String str) {
        List arrayList = (List) this.zzd.get(zzriVar);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.zzd.put(zzriVar, arrayList);
        }
        arrayList.add(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
    }

    public final void zzi(zzri zzriVar, zzre zzreVar) {
        List arrayList = (List) this.zzc.get(zzriVar);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.zzc.put(zzriVar, arrayList);
        }
        arrayList.add(zzreVar);
    }

    public final void zzj(zzri zzriVar, String str) {
        List arrayList = (List) this.zze.get(zzriVar);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.zze.put(zzriVar, arrayList);
        }
        arrayList.add(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
    }

    public final void zzk(zzri zzriVar) {
        this.zza.add(zzriVar);
    }

    public final void zzl(zzre zzreVar) {
        this.zzf = zzreVar;
    }
}
