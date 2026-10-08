package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzffh implements zzepj {
    private final Context zza;
    private final Executor zzb;
    private final zzcjn zzc;
    private final zzfey zzd;
    private final zzfdm zze;
    private final zzfgg zzf;
    private final zzflp zzg;
    private final zzfgm zzh;
    private ListenableFuture zzi;

    public zzffh(Context context, Executor executor, zzcjn zzcjnVar, zzfdm zzfdmVar, zzfey zzfeyVar, zzfgm zzfgmVar, zzfgg zzfggVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcjnVar;
        this.zze = zzfdmVar;
        this.zzd = zzfeyVar;
        this.zzh = zzfgmVar;
        this.zzf = zzfggVar;
        this.zzg = zzcjnVar.zzx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzk, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzdrm zze(zzfdk zzfdkVar) {
        zzdrm zzdrmVarZzp = this.zzc.zzp();
        zzcxw zzcxwVar = new zzcxw();
        zzcxwVar.zza(this.zza);
        zzcxwVar.zzb(((zzffg) zzfdkVar).zza);
        zzcxwVar.zzf(this.zzf);
        zzdrmVarZzp.zzd(zzcxwVar.zze());
        zzdrmVarZzp.zze(new zzden().zzn());
        return zzdrmVarZzp;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    @Override // com.google.android.gms.internal.ads.zzepj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zza(com.google.android.gms.ads.internal.client.zzm r12, java.lang.String r13, com.google.android.gms.internal.ads.zzeph r14, com.google.android.gms.internal.ads.zzepi r15) throws android.os.RemoteException {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzffh.zza(com.google.android.gms.ads.internal.client.zzm, java.lang.String, com.google.android.gms.internal.ads.zzeph, com.google.android.gms.internal.ads.zzepi):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzepj
    public final boolean zzb() {
        throw null;
    }

    final /* synthetic */ void zzc() {
        this.zzd.zzdN(zzfhp.zzd(6, null, null));
    }

    final /* synthetic */ Executor zzf() {
        return this.zzb;
    }

    final /* synthetic */ zzfey zzg() {
        return this.zzd;
    }

    final /* synthetic */ zzfdm zzh() {
        return this.zze;
    }

    final /* synthetic */ zzflp zzi() {
        return this.zzg;
    }

    final void zzj(int i) {
        this.zzh.zzj().zza(i);
    }
}
