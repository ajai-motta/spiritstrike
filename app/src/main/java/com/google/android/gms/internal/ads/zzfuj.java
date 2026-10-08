package com.google.android.gms.internal.ads;

import java.io.Closeable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzfuj implements Closeable {
    public static zzfuv zza() {
        return new zzfuv();
    }

    public static zzfuv zzb(zzgmv<Integer> zzgmvVar, zzgmv<Integer> zzgmvVar2, zzful zzfulVar) {
        return new zzfuv(zzgmvVar, zzgmvVar2, zzfulVar);
    }

    public static zzfuv zzc(final int i, zzful zzfulVar) {
        return new zzfuv(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzfui
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final /* synthetic */ Object zza() {
                return Integer.valueOf(i);
            }
        }, zzfuh.zza, zzfulVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer zzf() {
        return -1;
    }
}
