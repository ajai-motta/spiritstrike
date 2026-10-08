package com.google.android.gms.internal.ads;

import android.os.Build;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzsb {
    public static final boolean zza;

    static {
        boolean z = false;
        if ("Amazon".equals(Build.MANUFACTURER) && ("AFTM".equals(Build.MODEL) || "AFTB".equals(Build.MODEL))) {
            z = true;
        }
        zza = z;
    }
}
