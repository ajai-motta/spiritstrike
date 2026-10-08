package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzdia {
    private final zzdjl zza;
    private final zzcgy zzb;

    public zzdia(zzdjl zzdjlVar, zzcgy zzcgyVar) {
        this.zza = zzdjlVar;
        this.zzb = zzcgyVar;
    }

    public final zzdjl zza() {
        return this.zza;
    }

    public final zzcgy zzb() {
        return this.zzb;
    }

    public final View zzc() {
        zzcgy zzcgyVar = this.zzb;
        if (zzcgyVar != null) {
            return zzcgyVar.zzD();
        }
        return null;
    }

    public final View zzd() {
        zzcgy zzcgyVar = this.zzb;
        if (zzcgyVar == null) {
            return null;
        }
        return zzcgyVar.zzD();
    }

    public Set zze(zzcxf zzcxfVar) {
        return Collections.singleton(new zzdgn(zzcxfVar, zzcbv.zzg));
    }

    public Set zzf(zzcxf zzcxfVar) {
        return Collections.singleton(new zzdgn(zzcxfVar, zzcbv.zzg));
    }

    public final zzdgn zzg(Executor executor) {
        final zzcgy zzcgyVar = this.zzb;
        return new zzdgn(new zzddl() { // from class: com.google.android.gms.internal.ads.zzdhy
            @Override // com.google.android.gms.internal.ads.zzddl
            public final /* synthetic */ void zza() {
                com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL;
                zzcgy zzcgyVar2 = zzcgyVar;
                if (zzcgyVar2 == null || (zzmVarZzL = zzcgyVar2.zzL()) == null) {
                    return;
                }
                zzmVarZzL.zzb();
            }
        }, executor);
    }
}
