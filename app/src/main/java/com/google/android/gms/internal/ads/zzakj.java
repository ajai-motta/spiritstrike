package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzakj implements zzadd {
    private final zzadd zzb;
    private final zzakg zzc;
    private final SparseArray zzd = new SparseArray();
    private boolean zze;

    public zzakj(zzadd zzaddVar, zzakg zzakgVar) {
        this.zzb = zzaddVar;
        this.zzc = zzakgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final zzaem zzu(int i, int i2) {
        if (i2 != 3) {
            this.zze = true;
            return this.zzb.zzu(i, i2);
        }
        SparseArray sparseArray = this.zzd;
        zzakl zzaklVar = (zzakl) sparseArray.get(i);
        if (zzaklVar != null) {
            return zzaklVar;
        }
        zzakl zzaklVar2 = new zzakl(this.zzb.zzu(i, 3), this.zzc);
        sparseArray.put(i, zzaklVar2);
        return zzaklVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final void zzv() {
        this.zzb.zzv();
        if (!this.zze) {
            return;
        }
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.zzd;
            if (i >= sparseArray.size()) {
                return;
            }
            ((zzakl) sparseArray.valueAt(i)).zza(true);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final void zzw(zzaed zzaedVar) {
        this.zzb.zzw(zzaedVar);
    }
}
