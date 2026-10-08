package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzab implements zzdb {
    final /* synthetic */ zzag zza;

    /* synthetic */ zzab(zzag zzagVar, zzaf zzafVar) {
        this.zza = zzagVar;
    }

    @Override // com.google.android.gms.tagmanager.zzdb
    public final void zza(int i) {
        if (i == 4) {
            this.zza.zzi.zzc();
        }
        synchronized (this.zza) {
            if (!this.zza.isReady()) {
                if (this.zza.zzk != null) {
                    zzag zzagVar = this.zza;
                    zzagVar.setResult(zzagVar.zzk);
                } else {
                    zzag zzagVar2 = this.zza;
                    zzagVar2.setResult(zzagVar2.createFailedResult(Status.RESULT_TIMEOUT));
                }
            }
        }
        this.zza.zzr(this.zza.zzi.zzb());
    }
}
