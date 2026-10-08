package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzflc;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzepq implements zzepj {
    private final zzfgm zza;
    private final zzcjn zzb;
    private final Context zzc;
    private final zzepg zzd;
    private final zzflp zze;
    private zzcud zzf;

    public zzepq(zzcjn zzcjnVar, Context context, zzepg zzepgVar, zzfgm zzfgmVar) {
        this.zzb = zzcjnVar;
        this.zzc = context;
        this.zzd = zzepgVar;
        this.zza = zzfgmVar;
        this.zze = zzcjnVar.zzx();
        zzfgmVar.zzt(zzepgVar.zzc());
    }

    @Override // com.google.android.gms.internal.ads.zzepj
    public final boolean zza(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzeph zzephVar, zzepi zzepiVar) throws RemoteException {
        zzflm zzflmVar;
        com.google.android.gms.ads.internal.zzt.zzc();
        Context context = this.zzc;
        if (com.google.android.gms.ads.internal.util.zzs.zzL(context) && zzmVar.zzs == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to load the ad because app ID is missing.");
            this.zzb.zzb().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzepp
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzc();
                }
            });
            return false;
        }
        if (str == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zzb().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzepo
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzd();
                }
            });
            return false;
        }
        boolean z = zzmVar.zzf;
        zzfhk.zzb(context, z);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjT)).booleanValue() && z) {
            this.zzb.zzw().zzc(true);
        }
        int i3 = ((zzepk) zzephVar).zza;
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
        String strZza = zzduq.PUBLIC_API_CALL.zza();
        Long lValueOf = Long.valueOf(jCurrentTimeMillis);
        Bundle bundleZza = zzdus.zza(new Pair(strZza, lValueOf), new Pair(zzduq.DYNAMITE_ENTER.zza(), lValueOf));
        zzfgm zzfgmVar = this.zza;
        zzfgmVar.zza(zzmVar);
        zzfgmVar.zzv(bundleZza);
        zzfgmVar.zzl(i3);
        zzfgn zzfgnVarZzz = zzfgmVar.zzz();
        zzflc zzflcVarZzo = zzflc.CC.zzo(context, zzfll.zzg(zzfgnVarZzz), 8, zzmVar);
        com.google.android.gms.ads.internal.client.zzco zzcoVar = zzfgnVarZzz.zzo;
        if (zzcoVar != null) {
            this.zzd.zzc().zzn(zzcoVar);
        }
        zzcjn zzcjnVar = this.zzb;
        zzdjy zzdjyVarZzo = zzcjnVar.zzo();
        zzcxw zzcxwVar = new zzcxw();
        zzcxwVar.zza(context);
        zzcxwVar.zzb(zzfgnVarZzz);
        zzdjyVarZzo.zzf(zzcxwVar.zze());
        zzden zzdenVar = new zzden();
        zzepg zzepgVar = this.zzd;
        zzdenVar.zze(zzepgVar.zzc(), zzcjnVar.zzb());
        zzdjyVarZzo.zzg(zzdenVar.zzn());
        zzdjyVarZzo.zze(zzepgVar.zzb());
        zzdjyVarZzo.zzd(new zzcrd(null));
        zzdjz zzdjzVarZza = zzdjyVarZzo.zza();
        if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
            zzflm zzflmVarZzc = zzdjzVarZza.zzc();
            zzflmVarZzc.zzi(8);
            zzflmVarZzc.zzc(zzmVar.zzp);
            zzflmVarZzc.zzd(zzmVar.zzm);
            zzflmVar = zzflmVarZzc;
        } else {
            zzflmVar = null;
        }
        zzcjnVar.zzv().zza(1);
        zzgus zzgusVarZzc = zzfjn.zzc();
        ScheduledExecutorService scheduledExecutorServiceZzc = zzcjnVar.zzc();
        zzcus zzcusVarZza = zzdjzVarZza.zza();
        zzcud zzcudVar = new zzcud(zzgusVarZzc, scheduledExecutorServiceZzc, zzcusVarZza.zzc(zzcusVarZza.zzb()));
        this.zzf = zzcudVar;
        zzcudVar.zza(new zzepn(this, zzepiVar, zzflmVar, zzflcVarZzo, zzdjzVarZza));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzepj
    public final boolean zzb() {
        zzcud zzcudVar = this.zzf;
        return zzcudVar != null && zzcudVar.zzb();
    }

    final /* synthetic */ void zzc() {
        this.zzd.zze().zzdN(zzfhp.zzd(4, null, null));
    }

    final /* synthetic */ void zzd() {
        this.zzd.zze().zzdN(zzfhp.zzd(6, null, null));
    }

    final /* synthetic */ zzcjn zze() {
        return this.zzb;
    }

    final /* synthetic */ zzepg zzf() {
        return this.zzd;
    }

    final /* synthetic */ zzflp zzg() {
        return this.zze;
    }
}
