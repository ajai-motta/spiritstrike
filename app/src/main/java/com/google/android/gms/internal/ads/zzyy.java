package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzyy {
    private final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public final void zza(Handler handler, zzyz zzyzVar) {
        zzb(zzyzVar);
        this.zza.add(new zzyx(handler, zzyzVar));
    }

    public final void zzb(zzyz zzyzVar) {
        CopyOnWriteArrayList<zzyx> copyOnWriteArrayList = this.zza;
        for (zzyx zzyxVar : copyOnWriteArrayList) {
            if (zzyxVar.zzc() == zzyzVar) {
                zzyxVar.zza();
                copyOnWriteArrayList.remove(zzyxVar);
            }
        }
    }

    public final void zzc(final int i, final long j, final long j2) {
        for (final zzyx zzyxVar : this.zza) {
            if (!zzyxVar.zzd()) {
                zzyxVar.zzb().post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzyw
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzyxVar.zzc().zzX(i, j, j2);
                    }
                });
            }
        }
    }
}
