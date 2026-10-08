package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzflc;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfdy implements zzepj {
    private final Context zza;
    private final Executor zzb;
    private final zzcjn zzc;
    private final zzeot zzd;
    private final zzfey zze;
    private zzbfp zzf;
    private final zzflp zzg;
    private final zzfgm zzh;
    private ListenableFuture zzi;

    public zzfdy(Context context, Executor executor, zzcjn zzcjnVar, zzeot zzeotVar, zzfey zzfeyVar, zzfgm zzfgmVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcjnVar;
        this.zzd = zzeotVar;
        this.zzh = zzfgmVar;
        this.zze = zzfeyVar;
        this.zzg = zzcjnVar.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzepj
    public final boolean zza(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzeph zzephVar, zzepi zzepiVar) {
        zzdjd zzdjdVarZza;
        zzflm zzflmVar;
        if (str == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Ad unit ID should not be null for interstitial ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfdx
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzd();
                }
            });
            return false;
        }
        if (zzb()) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjT)).booleanValue() && zzmVar.zzf) {
            this.zzc.zzw().zzc(true);
        }
        com.google.android.gms.ads.internal.client.zzr zzrVar = ((zzfdr) zzephVar).zza;
        Bundle bundleZza = zzdus.zza(new Pair(zzduq.PUBLIC_API_CALL.zza(), Long.valueOf(zzmVar.zzz)), new Pair(zzduq.DYNAMITE_ENTER.zza(), Long.valueOf(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis())));
        zzfgm zzfgmVar = this.zzh;
        zzfgmVar.zzg(str);
        zzfgmVar.zzc(zzrVar);
        zzfgmVar.zza(zzmVar);
        zzfgmVar.zzv(bundleZza);
        Context context = this.zza;
        zzfgn zzfgnVarZzz = zzfgmVar.zzz();
        zzflc zzflcVarZzo = zzflc.CC.zzo(context, zzfll.zzg(zzfgnVarZzz), 4, zzmVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjb)).booleanValue()) {
            zzdjc zzdjcVarZzm = this.zzc.zzm();
            zzcxw zzcxwVar = new zzcxw();
            zzcxwVar.zza(context);
            zzcxwVar.zzb(zzfgnVarZzz);
            zzdjcVarZzm.zze(zzcxwVar.zze());
            zzden zzdenVar = new zzden();
            zzeot zzeotVar = this.zzd;
            Executor executor = this.zzb;
            zzdenVar.zzm(zzeotVar, executor);
            zzdenVar.zze(zzeotVar, executor);
            zzdjcVarZzm.zzf(zzdenVar.zzn());
            zzdjcVarZzm.zzd(new zzena(this.zzf));
            zzdjdVarZza = zzdjcVarZzm.zzh();
        } else {
            zzden zzdenVar2 = new zzden();
            zzfey zzfeyVar = this.zze;
            if (zzfeyVar != null) {
                Executor executor2 = this.zzb;
                zzdenVar2.zza(zzfeyVar, executor2);
                zzdenVar2.zzb(zzfeyVar, executor2);
                zzdenVar2.zzc(zzfeyVar, executor2);
            }
            zzdjc zzdjcVarZzm2 = this.zzc.zzm();
            zzcxw zzcxwVar2 = new zzcxw();
            zzcxwVar2.zza(context);
            zzcxwVar2.zzb(zzfgnVarZzz);
            zzdjcVarZzm2.zze(zzcxwVar2.zze());
            zzeot zzeotVar2 = this.zzd;
            Executor executor3 = this.zzb;
            zzdenVar2.zzm(zzeotVar2, executor3);
            zzdenVar2.zza(zzeotVar2, executor3);
            zzdenVar2.zzb(zzeotVar2, executor3);
            zzdenVar2.zzc(zzeotVar2, executor3);
            zzdenVar2.zzf(zzeotVar2, executor3);
            zzdenVar2.zzg(zzeotVar2, executor3);
            zzdenVar2.zze(zzeotVar2, executor3);
            zzdenVar2.zzk(zzeotVar2, executor3);
            zzdenVar2.zzd(zzeotVar2, executor3);
            zzdjcVarZzm2.zzf(zzdenVar2.zzn());
            zzdjcVarZzm2.zzd(new zzena(this.zzf));
            zzdjdVarZza = zzdjcVarZzm2.zzh();
        }
        zzdjd zzdjdVar = zzdjdVarZza;
        if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
            zzflm zzflmVarZzc = zzdjdVar.zzc();
            zzflmVarZzc.zzi(4);
            zzflmVarZzc.zzc(zzmVar.zzp);
            zzflmVarZzc.zzd(zzmVar.zzm);
            zzflmVar = zzflmVarZzc;
        } else {
            zzflmVar = null;
        }
        zzcus zzcusVarZzb = zzdjdVar.zzb();
        ListenableFuture listenableFutureZzc = zzcusVarZzb.zzc(zzcusVarZzb.zzb());
        this.zzi = listenableFutureZzc;
        zzgui.zzr(listenableFutureZzc, new zzfdw(this, zzepiVar, zzflmVar, zzflcVarZzo, zzdjdVar), this.zzb);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzepj
    public final boolean zzb() {
        ListenableFuture listenableFuture = this.zzi;
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }

    public final void zzc(zzbfp zzbfpVar) {
        this.zzf = zzbfpVar;
    }

    final /* synthetic */ void zzd() {
        this.zzd.zzdN(zzfhp.zzd(6, null, null));
    }

    final /* synthetic */ Executor zze() {
        return this.zzb;
    }

    final /* synthetic */ zzeot zzf() {
        return this.zzd;
    }

    final /* synthetic */ zzfey zzg() {
        return this.zze;
    }

    final /* synthetic */ zzflp zzh() {
        return this.zzg;
    }

    final /* synthetic */ void zzi(ListenableFuture listenableFuture) {
        this.zzi = null;
    }
}
