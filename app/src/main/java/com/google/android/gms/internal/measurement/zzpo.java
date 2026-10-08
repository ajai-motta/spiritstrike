package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzpo {
    private final AtomicReferenceArray zza;
    private final zzog zzb;

    public zzpo(zzog zzogVar, int i) {
        this.zzb = zzogVar;
        this.zza = new AtomicReferenceArray(i);
    }

    public final zzom zza(int i, String str, boolean z) {
        AtomicReferenceArray atomicReferenceArray = this.zza;
        zzom zzomVarZza = (zzom) atomicReferenceArray.get(i);
        if (zzomVarZza == null) {
            zzomVarZza = this.zzb.zza(str, z);
            if (!zzpo$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceArray, i, null, zzomVarZza)) {
                return (zzom) Preconditions.checkNotNull((zzom) atomicReferenceArray.get(i));
            }
        }
        return zzomVarZza;
    }

    public final zzom zzb(int i, String str, long j) {
        AtomicReferenceArray atomicReferenceArray = this.zza;
        zzom zzomVarZzb = (zzom) atomicReferenceArray.get(i);
        if (zzomVarZzb == null) {
            zzomVarZzb = this.zzb.zzb(str, j);
            if (!zzpo$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceArray, i, null, zzomVarZzb)) {
                return (zzom) Preconditions.checkNotNull((zzom) atomicReferenceArray.get(i));
            }
        }
        return zzomVarZzb;
    }

    public final zzom zzc(int i, String str, double d) {
        AtomicReferenceArray atomicReferenceArray = this.zza;
        zzom zzomVarZzc = (zzom) atomicReferenceArray.get(2);
        if (zzomVarZzc == null) {
            zzomVarZzc = this.zzb.zzc("measurement.test.double_flag", -3.0d);
            if (!zzpo$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceArray, 2, null, zzomVarZzc)) {
                return (zzom) Preconditions.checkNotNull((zzom) atomicReferenceArray.get(2));
            }
        }
        return zzomVarZzc;
    }

    public final zzom zzd(int i, String str, String str2) {
        AtomicReferenceArray atomicReferenceArray = this.zza;
        zzom zzomVarZzd = (zzom) atomicReferenceArray.get(i);
        if (zzomVarZzd == null) {
            zzomVarZzd = this.zzb.zzd(str, str2);
            if (!zzpo$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceArray, i, null, zzomVarZzd)) {
                return (zzom) Preconditions.checkNotNull((zzom) atomicReferenceArray.get(i));
            }
        }
        return zzomVarZzd;
    }
}
