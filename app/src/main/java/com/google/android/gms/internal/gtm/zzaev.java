package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaev extends IllegalArgumentException {
    zzaev(int i, int i2) {
        super("Unpaired surrogate at index " + i + " of " + i2);
    }
}
