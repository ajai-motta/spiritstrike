package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzyj {
    public final zzbg zza;
    public final int[] zzb;

    public zzyj(zzbg zzbgVar, int[] iArr, int i) {
        if (iArr.length == 0) {
            zzdt.zzf("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.zza = zzbgVar;
        this.zzb = iArr;
    }
}
