package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzacb extends zzaca implements zzadm {
    protected zzacb(zzacc zzaccVar) {
        super(zzaccVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzaca
    protected final void zzH() {
        super.zzH();
        if (((zzacc) this.zza).zza != zzabv.zze()) {
            zzacc zzaccVar = (zzacc) this.zza;
            zzaccVar.zza = zzaccVar.zza.clone();
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaca, com.google.android.gms.internal.gtm.zzadk
    /* JADX INFO: renamed from: zzJ, reason: merged with bridge method [inline-methods] */
    public final zzacc zzE() {
        if (!((zzacc) this.zza).zzar()) {
            return (zzacc) this.zza;
        }
        ((zzacc) this.zza).zza.zzi();
        return (zzacc) super.zzE();
    }
}
