package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import java.util.ArrayDeque;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgaz {
    private MotionEvent zzb;
    private final ArrayDeque zza = new ArrayDeque();
    private zzgax zzc = new zzgax();

    zzgaz() {
    }

    public final synchronized void zza(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.zzb = MotionEvent.obtain(motionEvent);
        }
        this.zzc.zza(motionEvent);
        ArrayDeque arrayDeque = this.zza;
        if (arrayDeque.size() >= 6) {
            arrayDeque.remove();
        }
        arrayDeque.add(new zzgay(motionEvent));
    }

    public final synchronized void zzb(Map map) {
        MotionEvent motionEvent = this.zzb;
        if (motionEvent != null) {
            map.put("nv", motionEvent);
        }
        map.put("oe", this.zzc);
        ArrayDeque arrayDeque = this.zza;
        map.put("ro", arrayDeque.toArray(new zzgay[arrayDeque.size()]));
        this.zzc = new zzgax();
        arrayDeque.clear();
        MotionEvent motionEvent2 = this.zzb;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.zzb = null;
        }
    }
}
