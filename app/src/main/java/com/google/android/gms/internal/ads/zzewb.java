package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzewb implements zzexy {
    private final zzfgn zza;
    private final PackageInfo zzb;
    private final com.google.android.gms.ads.internal.util.zzg zzc;

    public zzewb(zzfgn zzfgnVar, PackageInfo packageInfo, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzfgnVar;
        this.zzb = packageInfo;
        this.zzc = zzgVar;
    }

    private final void zzc(Bundle bundle) {
        int i;
        zzbhx zzbhxVar = this.zza.zzj;
        if (zzbhxVar == null || (i = zzbhxVar.zzi) == 0) {
            return;
        }
        bundle.putBoolean("sccg_tap", zzbhxVar.zzj);
        bundle.putInt("sccg_dir", i);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x010b  */
    @Override // com.google.android.gms.internal.ads.zzexy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ void zza(java.lang.Object r13) {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzewb.zza(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ArrayList arrayList = this.zza.zzh;
        zzcxq zzcxqVar = (zzcxq) obj;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        zzc(zzcxqVar.zzb);
    }
}
