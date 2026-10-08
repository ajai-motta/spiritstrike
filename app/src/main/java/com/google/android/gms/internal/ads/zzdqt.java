package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdqt {
    private final com.google.android.gms.ads.internal.zza zzb;
    private final Context zzc;
    private final zzdvi zzd;
    private final Executor zze;
    private final zzaxa zzf;
    private final VersionInfoParcel zzg;
    private final zzefy zzi;
    private final zzfng zzj;
    private final zzegj zzk;
    private final zzfgr zzl;
    private ListenableFuture zzm;
    private final zzdqh zza = new zzdqh();
    private final zzbmo zzh = new zzbmo();

    zzdqt(zzdqr zzdqrVar) {
        this.zzc = zzdqrVar.zzb();
        this.zze = zzdqrVar.zze();
        this.zzf = zzdqrVar.zzf();
        this.zzg = zzdqrVar.zzg();
        this.zzb = zzdqrVar.zza();
        this.zzi = zzdqrVar.zzd();
        this.zzj = zzdqrVar.zzh();
        this.zzd = zzdqrVar.zzc();
        this.zzk = zzdqrVar.zzi();
        this.zzl = zzdqrVar.zzj();
    }

    public final synchronized void zza() {
        String str = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzen);
        zzaxa zzaxaVar = this.zzf;
        com.google.android.gms.ads.internal.zza zzaVar = this.zzb;
        zzegj zzegjVar = this.zzk;
        ListenableFuture listenableFutureZzk = zzgui.zzk(zzcho.zzb(this.zzc, this.zzg, str, zzaxaVar, zzaVar, zzegjVar, this.zzl, this.zzd), new zzglu() { // from class: com.google.android.gms.internal.ads.zzdqq
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj) {
                zzcgy zzcgyVar = (zzcgy) obj;
                this.zza.zzi(zzcgyVar);
                return zzcgyVar;
            }
        }, this.zze);
        this.zzm = listenableFutureZzk;
        zzcby.zza(listenableFutureZzk, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzb() {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzgui.zzr(listenableFuture, new zzdqi(this), this.zze);
        this.zzm = null;
    }

    public final synchronized ListenableFuture zzc(final String str, final JSONObject jSONObject) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return zzgui.zza(null);
        }
        return zzgui.zzj(listenableFuture, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzdqp
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzj(str, jSONObject, (zzcgy) obj);
            }
        }, this.zze);
    }

    public final synchronized void zzd(String str, zzblx zzblxVar) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzgui.zzr(listenableFuture, new zzdqj(this, str, zzblxVar), this.zze);
    }

    public final synchronized void zze(String str, zzblx zzblxVar) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzgui.zzr(listenableFuture, new zzdqk(this, str, zzblxVar), this.zze);
    }

    public final synchronized void zzf(String str, Map map) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzgui.zzr(listenableFuture, new zzdql(this, "sendMessageToNativeJs", map), this.zze);
    }

    public final synchronized void zzg(zzffu zzffuVar, zzffx zzffxVar, zzcpe zzcpeVar) {
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture == null) {
            return;
        }
        zzgui.zzr(listenableFuture, new zzdqm(this, zzffuVar, zzffxVar, zzcpeVar), this.zze);
    }

    public final void zzh(WeakReference weakReference, String str, zzblx zzblxVar) {
        zzd(str, new zzdqs(this, weakReference, str, zzblxVar, null));
    }

    final /* synthetic */ zzcgy zzi(zzcgy zzcgyVar) {
        zzcgyVar.zzab("/result", this.zzh);
        zzciw zzciwVarZzP = zzcgyVar.zzP();
        com.google.android.gms.ads.internal.zzb zzbVar = new com.google.android.gms.ads.internal.zzb(this.zzc, null, null);
        zzefy zzefyVar = this.zzi;
        zzfng zzfngVar = this.zzj;
        zzdvi zzdviVar = this.zzd;
        zzdqh zzdqhVar = this.zza;
        zzciwVarZzP.zzZ(null, zzdqhVar, zzdqhVar, zzdqhVar, zzdqhVar, false, null, zzbVar, null, null, zzefyVar, zzfngVar, zzdviVar, null, null, null, null, null, null, null, null);
        return zzcgyVar;
    }

    final /* synthetic */ ListenableFuture zzj(String str, JSONObject jSONObject, zzcgy zzcgyVar) {
        return this.zzh.zzc(zzcgyVar, str, jSONObject);
    }

    final /* synthetic */ zzdqh zzk() {
        return this.zza;
    }

    final /* synthetic */ zzdvi zzl() {
        return this.zzd;
    }

    final /* synthetic */ zzefy zzm() {
        return this.zzi;
    }

    final /* synthetic */ zzfng zzn() {
        return this.zzj;
    }
}
