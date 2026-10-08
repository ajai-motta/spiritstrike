package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzft implements zzgb {
    private final boolean zza;
    private final ArrayList zzb = new ArrayList(1);
    private int zzc;
    private zzgf zzd;

    protected zzft(boolean z) {
        this.zza = z;
    }

    protected final void zzf(zzgf zzgfVar) {
        for (int i = 0; i < this.zzc; i++) {
            ((zzgz) this.zzb.get(i)).zza(this, zzgfVar, this.zza);
        }
    }

    protected final void zzg(zzgf zzgfVar) {
        this.zzd = zzgfVar;
        for (int i = 0; i < this.zzc; i++) {
            ((zzgz) this.zzb.get(i)).zzb(this, zzgfVar, this.zza);
        }
    }

    protected final void zzh(int i) {
        zzgf zzgfVar = this.zzd;
        String str = zzep.zza;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            ((zzgz) this.zzb.get(i2)).zzc(this, zzgfVar, this.zza, i);
        }
    }

    protected final void zzi() {
        zzgf zzgfVar = this.zzd;
        String str = zzep.zza;
        for (int i = 0; i < this.zzc; i++) {
            ((zzgz) this.zzb.get(i)).zzd(this, zzgfVar, this.zza);
        }
        this.zzd = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public /* synthetic */ Map zzj() {
        return Collections.emptyMap();
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zze(zzgz zzgzVar) {
        zzgzVar.getClass();
        ArrayList arrayList = this.zzb;
        if (arrayList.contains(zzgzVar)) {
            return;
        }
        arrayList.add(zzgzVar);
        this.zzc++;
    }
}
