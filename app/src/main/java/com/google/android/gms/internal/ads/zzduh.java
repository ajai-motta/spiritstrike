package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbdz;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzduh implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;
    private final zzifq zzc;

    private zzduh(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3, zzifq zzifqVar4) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
        this.zzc = zzifqVar4;
    }

    public static zzduh zza(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3, zzifq zzifqVar4) {
        return new zzduh(zzifqVar, zzifqVar2, zzifqVar3, zzifqVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setEmptySet;
        final String strZza = ((zzfak) this.zza).zza();
        Context contextZza = ((zzcjv) this.zzb).zza();
        zzgus zzgusVarZzc = zzfjn.zzc();
        Map mapZzb = ((zzifl) this.zzc).zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfJ)).booleanValue()) {
            zzbdt zzbdtVar = new zzbdt(new zzbdy(contextZza));
            zzbdtVar.zzb(new zzbds() { // from class: com.google.android.gms.internal.ads.zzdui
                @Override // com.google.android.gms.internal.ads.zzbds
                public final /* synthetic */ void zza(zzbdz.zzt.zza zzaVar) {
                    zzaVar.zzh(strZza);
                }
            });
            setEmptySet = Collections.singleton(new zzdgn(new zzduk(zzbdtVar, mapZzb), zzgusVarZzc));
        } else {
            setEmptySet = Collections.emptySet();
        }
        zzifp.zzb(setEmptySet);
        return setEmptySet;
    }
}
