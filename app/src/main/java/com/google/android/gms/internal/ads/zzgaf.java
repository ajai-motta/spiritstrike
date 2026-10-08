package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzgaf implements zzgtq {
    static final /* synthetic */ zzgaf zza = new zzgaf();

    private /* synthetic */ zzgaf() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        final zzgab zzgabVar = (zzgab) obj;
        return zzgui.zzk(zzgabVar.zzb(), new zzglu() { // from class: com.google.android.gms.internal.ads.zzgag
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj2) {
                return zzgabVar;
            }
        }, zzguz.zza());
    }
}
