package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzri {
    private final List zza;
    private final List zzb;
    private final List zzc;
    private final List zzd;
    private final List zze;
    private final List zzf;
    private final List zzg;
    private final List zzh;

    /* synthetic */ zzri(List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, List list9, List list10, zzrl zzrlVar) {
        this.zza = Collections.unmodifiableList(list);
        this.zzb = Collections.unmodifiableList(list2);
        this.zzc = Collections.unmodifiableList(list3);
        this.zzd = Collections.unmodifiableList(list4);
        this.zze = Collections.unmodifiableList(list5);
        this.zzf = Collections.unmodifiableList(list6);
        Collections.unmodifiableList(list7);
        Collections.unmodifiableList(list8);
        this.zzg = Collections.unmodifiableList(list9);
        this.zzh = Collections.unmodifiableList(list10);
    }

    public final String toString() {
        List list = this.zzf;
        List list2 = this.zze;
        List list3 = this.zzd;
        List list4 = this.zzc;
        List list5 = this.zzb;
        return "Positive predicates: " + String.valueOf(this.zza) + "  Negative predicates: " + String.valueOf(list5) + "  Add tags: " + String.valueOf(list4) + "  Remove tags: " + String.valueOf(list3) + "  Add macros: " + String.valueOf(list2) + "  Remove macros: " + String.valueOf(list);
    }

    public final List zza() {
        return this.zze;
    }

    public final List zzb() {
        return this.zzg;
    }

    public final List zzc() {
        return this.zzc;
    }

    public final List zzd() {
        return this.zzb;
    }

    public final List zze() {
        return this.zza;
    }

    public final List zzf() {
        return this.zzf;
    }

    public final List zzg() {
        return this.zzh;
    }

    public final List zzh() {
        return this.zzd;
    }
}
