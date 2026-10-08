package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.internal.ads.zzbeu;
import com.google.android.gms.internal.ads.zzcbv;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzgjt;
import com.google.android.gms.internal.ads.zzgju;
import com.google.android.gms.internal.ads.zzgjv;
import com.google.android.gms.internal.ads.zzgjw;
import com.google.android.gms.internal.ads.zzgkp;
import com.google.android.gms.internal.ads.zzgkr;
import com.google.android.gms.internal.ads.zzgks;
import com.google.android.gms.internal.ads.zzgkt;
import com.google.android.gms.internal.ads.zzgku;
import com.google.android.gms.internal.ads.zzglh;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzz {
    private zzgks zzf;
    private zzcgy zzc = null;
    private boolean zze = false;
    private String zza = null;
    private zzgjv zzd = null;
    private String zzb = null;

    private final void zzl() {
        if (this.zzf == null) {
            this.zzf = new zzx(this);
        }
    }

    private final zzgku zzm() {
        zzgkt zzgktVarZzc = zzgku.zzc();
        if (!((Boolean) zzbd.zzc().zzd(zzbeu.zzmy)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzgktVarZzc.zza(str);
            } else {
                zzg("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzgktVarZzc.zzb(this.zzb);
        }
        return zzgktVarZzc.zzc();
    }

    public final synchronized void zza(zzcgy zzcgyVar, Context context) {
        this.zzc = zzcgyVar;
        if (!zzb(context)) {
            zzg("Unable to bind", "on_play_store_bind");
            return;
        }
        HashMap map = new HashMap();
        map.put(NativeProtocol.WEB_DIALOG_ACTION, "fetch_completed");
        zzi("on_play_store_bind", map);
    }

    public final synchronized boolean zzb(Context context) {
        if (!zzglh.zza(context)) {
            return false;
        }
        try {
            this.zzd = zzgjw.zza(context);
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.util.zze.zza("Error connecting LMD Overlay service");
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "LastMileDeliveryOverlay.bindLastMileDeliveryService");
        }
        if (this.zzd == null) {
            this.zze = false;
            return false;
        }
        zzl();
        this.zze = true;
        return true;
    }

    public final void zzc(zzcgy zzcgyVar, zzgkp zzgkpVar) {
        if (zzcgyVar == null) {
            zzg("adWebview missing", "onLMDShow");
            return;
        }
        this.zzc = zzcgyVar;
        if (!this.zze && !zzb(zzcgyVar.getContext())) {
            zzg("LMDOverlay not bound", "on_play_store_bind");
            return;
        }
        if (((Boolean) zzbd.zzc().zzd(zzbeu.zzmy)).booleanValue()) {
            this.zzb = zzgkpVar.zzb();
        }
        zzl();
        zzgjv zzgjvVar = this.zzd;
        if (zzgjvVar != null) {
            zzgjvVar.zza(zzgkpVar, this.zzf);
        }
    }

    public final void zzd() {
        zzgjv zzgjvVar;
        if (!this.zze || (zzgjvVar = this.zzd) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
        } else {
            zzgjvVar.zzd(zzm(), this.zzf);
            zzh("onLMDOverlayExpand");
        }
    }

    public final void zze() {
        zzgjv zzgjvVar;
        if (!this.zze || (zzgjvVar = this.zzd) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
        } else {
            zzgjvVar.zzc(zzm(), this.zzf);
            zzh("onLMDOverlayCollapse");
        }
    }

    public final void zzf() {
        zzgjv zzgjvVar;
        if (!this.zze || (zzgjvVar = this.zzd) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
            return;
        }
        zzgjt zzgjtVarZzc = zzgju.zzc();
        if (!((Boolean) zzbd.zzc().zzd(zzbeu.zzmy)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzgjtVarZzc.zza(str);
            } else {
                zzg("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzgjtVarZzc.zzb(this.zzb);
        }
        zzgjvVar.zzb(zzgjtVarZzc.zzc(), this.zzf);
    }

    final void zzg(String str, String str2) {
        com.google.android.gms.ads.internal.util.zze.zza(str);
        if (this.zzc != null) {
            HashMap map = new HashMap();
            map.put("message", str);
            map.put(NativeProtocol.WEB_DIALOG_ACTION, str2);
            zzi("onError", map);
        }
    }

    final void zzh(String str) {
        zzi(str, new HashMap());
    }

    final void zzi(final String str, final Map map) {
        zzcbv.zzf.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzy
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzk(str, map);
            }
        });
    }

    final void zzj(zzgkr zzgkrVar) {
        if (!TextUtils.isEmpty(zzgkrVar.zzb())) {
            if (!((Boolean) zzbd.zzc().zzd(zzbeu.zzmy)).booleanValue()) {
                this.zza = zzgkrVar.zzb();
            }
        }
        switch (zzgkrVar.zza()) {
            case 8152:
                zzh("onLMDOverlayOpened");
                break;
            case 8153:
                zzh("onLMDOverlayClicked");
                break;
            case 8155:
                zzh("onLMDOverlayClose");
                break;
            case 8157:
                this.zza = null;
                this.zzb = null;
                this.zze = false;
                break;
            case 8160:
            case 8161:
            case 8162:
                HashMap map = new HashMap();
                map.put("error", String.valueOf(zzgkrVar.zza()));
                zzi("onLMDOverlayFailedToOpen", map);
                break;
        }
    }

    final /* synthetic */ void zzk(String str, Map map) {
        zzcgy zzcgyVar = this.zzc;
        if (zzcgyVar != null) {
            zzcgyVar.zze(str, map);
        }
    }
}
