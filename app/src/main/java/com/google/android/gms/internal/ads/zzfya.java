package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfya implements zzfxq {
    private ExecutorService zza;
    private Context zzb;
    private zzfxt zzc;

    private zzfya() {
        throw null;
    }

    /* synthetic */ zzfya(byte[] bArr) {
    }

    @Override // com.google.android.gms.internal.ads.zzfxq
    public final zzfxr zza() {
        zzifp.zzc(this.zza, ExecutorService.class);
        zzifp.zzc(this.zzb, Context.class);
        zzifp.zzc(this.zzc, zzfxt.class);
        return new zzfxz(new zzgdq(), new zzgds(), new zzgdu(), this.zza, this.zzb, this.zzc);
    }

    public final zzfya zzb(ExecutorService executorService) {
        executorService.getClass();
        this.zza = executorService;
        return this;
    }

    public final zzfya zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzfya zzd(zzfxt zzfxtVar) {
        zzfxtVar.getClass();
        this.zzc = zzfxtVar;
        return this;
    }
}
