package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzru {
    public final int zza;
    public final zzuu zzb;
    private final CopyOnWriteArrayList zzc;

    public zzru() {
        this(new CopyOnWriteArrayList(), 0, null);
    }

    private zzru(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzuu zzuuVar) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzuuVar;
    }

    public final zzru zza(int i, zzuu zzuuVar) {
        return new zzru(this.zzc, 0, zzuuVar);
    }

    public final void zzb(Handler handler, zzrv zzrvVar) {
        this.zzc.add(new zzrt(handler, zzrvVar));
    }

    public final void zzc(zzrv zzrvVar) {
        CopyOnWriteArrayList<zzrt> copyOnWriteArrayList = this.zzc;
        for (zzrt zzrtVar : copyOnWriteArrayList) {
            if (zzrtVar.zza == zzrvVar) {
                copyOnWriteArrayList.remove(zzrtVar);
            }
        }
    }
}
