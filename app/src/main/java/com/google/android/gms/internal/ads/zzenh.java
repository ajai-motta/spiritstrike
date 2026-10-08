package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzenh {
    private final zzdjd zza;

    public zzenh(zzdjd zzdjdVar) {
        this.zza = zzdjdVar;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfgf zzfgfVar, zzffu zzffuVar, View view, zzend zzendVar) {
        zzenf zzenfVar = new zzenf(this, new zzene(this, zzffuVar));
        zzdhx zzdhxVarZzd = this.zza.zzd(new zzcue(zzfgfVar, zzffuVar, null), zzenfVar);
        zzendVar.zzd(new zzeng(this, zzdhxVarZzd));
        return zzdhxVarZzd.zzh();
    }
}
