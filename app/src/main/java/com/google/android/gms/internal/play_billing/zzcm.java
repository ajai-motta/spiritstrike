package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.ads.zzeg$$ExternalSyntheticBackport0;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class zzcm {
    public static /* synthetic */ boolean zza(Unsafe unsafe, Object obj, long j, Object obj2, Object obj3) {
        while (!zzeg$$ExternalSyntheticBackport0.m(unsafe, obj, j, obj2, obj3)) {
            if (unsafe.getObject(obj, j) != obj2) {
                return false;
            }
        }
        return true;
    }
}
