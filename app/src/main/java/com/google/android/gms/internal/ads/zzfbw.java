package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfbw extends zzfbe {
    public zzfbw(Context context, Executor executor, zzcjn zzcjnVar, zzfdm zzfdmVar, zzfbu zzfbuVar, zzfgm zzfgmVar, VersionInfoParcel versionInfoParcel) {
        super(context, executor, zzcjnVar, zzfdmVar, zzfbuVar, zzfgmVar, versionInfoParcel);
    }

    @Override // com.google.android.gms.internal.ads.zzfbe
    protected final /* bridge */ /* synthetic */ zzcxu zzc(zzcrd zzcrdVar, zzcxx zzcxxVar, zzdeo zzdeoVar) {
        zzcqt zzcqtVarZzk = this.zza.zzk();
        zzcqtVarZzk.zzd(zzcxxVar);
        zzcqtVarZzk.zze(zzdeoVar);
        return zzcqtVarZzk;
    }
}
