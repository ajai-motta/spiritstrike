package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaqf {
    public static final boolean zza = zzaqg.zzb;
    private final List zzb = new ArrayList();
    private boolean zzc = false;

    zzaqf() {
    }

    protected final void finalize() throws Throwable {
        if (this.zzc) {
            return;
        }
        zzb("Request on the loose");
        zzaqg.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }

    public final synchronized void zza(String str, long j) {
        if (this.zzc) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.zzb.add(new zzaqe(str, j, SystemClock.elapsedRealtime()));
    }

    public final synchronized void zzb(String str) {
        this.zzc = true;
        List<zzaqe> list = this.zzb;
        long j = list.size() == 0 ? 0L : ((zzaqe) list.get(list.size() - 1)).zzc - ((zzaqe) list.get(0)).zzc;
        if (j > 0) {
            long j2 = ((zzaqe) list.get(0)).zzc;
            zzaqg.zzb("(%-4d ms) %s", Long.valueOf(j), str);
            for (zzaqe zzaqeVar : list) {
                long j3 = zzaqeVar.zzc;
                zzaqg.zzb("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(zzaqeVar.zzb), zzaqeVar.zza);
                j2 = j3;
            }
        }
    }
}
