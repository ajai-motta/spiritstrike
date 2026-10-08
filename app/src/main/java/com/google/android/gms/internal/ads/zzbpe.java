package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.internal.ads.zzbou;
import java.util.Map;
import java.util.Objects;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@ParametersAreNonnullByDefault
public final class zzbpe implements zzbow, zzbou {
    private final zzcgy zza;

    public zzbpe(Context context, VersionInfoParcel versionInfoParcel, zzaxa zzaxaVar, com.google.android.gms.ads.internal.zza zzaVar) throws zzchn {
        com.google.android.gms.ads.internal.zzt.zzd();
        zzcgy zzcgyVarZza = zzcho.zza(context, zzcji.zzb(), "", false, false, null, null, versionInfoParcel, null, null, null, zzbdt.zza(), null, null, null, null, null);
        this.zza = zzcgyVarZza;
        zzcgyVarZza.zzE().setWillNotDraw(true);
    }

    private static final void zzs(Runnable runnable) {
        com.google.android.gms.ads.internal.client.zzbb.zza();
        if (com.google.android.gms.ads.internal.util.client.zzf.zzz()) {
            com.google.android.gms.ads.internal.util.zze.zza("runOnUiThread > the UI thread is the main thread, the runnable will be run now");
            runnable.run();
        } else {
            com.google.android.gms.ads.internal.util.zze.zza("runOnUiThread > the UI thread is not the main thread, the runnable will be added to the message queue");
            if (com.google.android.gms.ads.internal.util.zzs.zza.post(runnable)) {
                return;
            }
            com.google.android.gms.ads.internal.util.client.zzo.zzi("runOnUiThread > the runnable could not be placed to the message queue");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpf
    public final void zza(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("invokeJavascript on adWebView from js");
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbpd
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzo(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbpf
    public /* synthetic */ void zzb(String str, JSONObject jSONObject) {
        zzc(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbpf
    public /* synthetic */ void zzc(String str, String str2) {
        zzbou.CC.$default$zzc(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbot
    public /* synthetic */ void zzd(String str, JSONObject jSONObject) {
        zzbou.CC.$default$zzd(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbot
    public /* synthetic */ void zze(String str, Map map) {
        zzbou.CC.$default$zze(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzbow
    public final void zzf(String str) {
        String.valueOf(str);
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascript on adWebView from path: ".concat(String.valueOf(str)));
        final String str2 = String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str);
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzboz
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzp(str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbow
    public final void zzg(final String str) {
        String.valueOf(str);
        com.google.android.gms.ads.internal.util.zze.zza("loadHtmlWrapper on adWebView from path: ".concat(String.valueOf(str)));
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbpb
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzr(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbow
    public final void zzh(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("loadHtml on adWebView from html");
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbpa
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzq(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbow
    public final void zzi(final zzbov zzbovVar) {
        zzciw zzciwVarZzP = this.zza.zzP();
        Objects.requireNonNull(zzbovVar);
        zzciwVarZzP.zzH(new zzciv() { // from class: com.google.android.gms.internal.ads.zzboy
            @Override // com.google.android.gms.internal.ads.zzciv
            public final /* synthetic */ void zza() {
                zzbovVar.zza();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbow
    public final void zzj() {
        this.zza.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzbow
    public final boolean zzk() {
        return this.zza.zzX();
    }

    @Override // com.google.android.gms.internal.ads.zzbow
    public final zzbqd zzl() {
        return new zzbqd(this);
    }

    @Override // com.google.android.gms.internal.ads.zzbqc
    public final void zzm(String str, zzblx zzblxVar) {
        this.zza.zzab(str, new zzbox(this, zzblxVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbqc
    public final void zzn(String str, final zzblx zzblxVar) {
        this.zza.zzad(str, new Predicate() { // from class: com.google.android.gms.internal.ads.zzbpc
            @Override // com.google.android.gms.common.util.Predicate
            public final /* synthetic */ boolean apply(Object obj) {
                zzblx zzblxVar2 = (zzblx) obj;
                if (zzblxVar2 instanceof zzbox) {
                    return ((zzbox) zzblxVar2).zzb().equals(zzblxVar);
                }
                return false;
            }
        });
    }

    final /* synthetic */ void zzo(String str) {
        this.zza.zza(str);
    }

    final /* synthetic */ void zzp(String str) {
        this.zza.loadData(str, "text/html", "UTF-8");
    }

    final /* synthetic */ void zzq(String str) {
        this.zza.loadData(str, "text/html", "UTF-8");
    }

    final /* synthetic */ void zzr(String str) {
        this.zza.loadUrl(str);
    }
}
