package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfps {
    private static final zzfps zza = new zzfps();
    private final ArrayList zzb = new ArrayList();
    private final ArrayList zzc = new ArrayList();

    private zzfps() {
    }

    public static zzfps zza() {
        return zza;
    }

    public final void zzb(zzfoy zzfoyVar) {
        this.zzb.add(zzfoyVar);
    }

    public final void zzc(zzfoy zzfoyVar) {
        ArrayList arrayList = this.zzc;
        boolean zZzg = zzg();
        arrayList.add(zzfoyVar);
        if (zZzg) {
            return;
        }
        zzfqa.zza().zzc();
    }

    public final void zzd(zzfoy zzfoyVar) {
        ArrayList arrayList = this.zzb;
        boolean zZzg = zzg();
        arrayList.remove(zzfoyVar);
        this.zzc.remove(zzfoyVar);
        if (!zZzg || zzg()) {
            return;
        }
        zzfqa.zza().zze();
    }

    public final Collection zze() {
        return Collections.unmodifiableCollection(this.zzb);
    }

    public final Collection zzf() {
        return Collections.unmodifiableCollection(this.zzc);
    }

    public final boolean zzg() {
        return this.zzc.size() > 0;
    }
}
