package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzflc;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdsd {
    private final zzcym zza;
    private final zzdgt zzb;
    private final zzczv zzc;
    private final zzdai zzd;
    private final zzdaz zze;
    private final zzdds zzf;
    private final Executor zzg;
    private final zzdgp zzh;
    private final zzcqb zzi;
    private final com.google.android.gms.ads.internal.zzb zzj;
    private final zzbzt zzk;
    private final zzaxa zzl;
    private final zzddj zzm;
    private final zzefy zzn;
    private final zzfng zzo;
    private final zzdvi zzp;
    private final zzcpe zzq;
    private final zzdsj zzr;
    private final zzdwl zzs;
    private final zzcxn zzt;

    public zzdsd(zzcym zzcymVar, zzczv zzczvVar, zzdai zzdaiVar, zzdaz zzdazVar, zzdds zzddsVar, Executor executor, zzdgp zzdgpVar, zzcqb zzcqbVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbzt zzbztVar, zzaxa zzaxaVar, zzddj zzddjVar, zzefy zzefyVar, zzfng zzfngVar, zzdvi zzdviVar, zzdgt zzdgtVar, zzcpe zzcpeVar, zzdsj zzdsjVar, zzdwl zzdwlVar, zzcxn zzcxnVar) {
        this.zza = zzcymVar;
        this.zzc = zzczvVar;
        this.zzd = zzdaiVar;
        this.zze = zzdazVar;
        this.zzf = zzddsVar;
        this.zzg = executor;
        this.zzh = zzdgpVar;
        this.zzi = zzcqbVar;
        this.zzj = zzbVar;
        this.zzk = zzbztVar;
        this.zzl = zzaxaVar;
        this.zzm = zzddjVar;
        this.zzn = zzefyVar;
        this.zzo = zzfngVar;
        this.zzp = zzdviVar;
        this.zzb = zzdgtVar;
        this.zzq = zzcpeVar;
        this.zzr = zzdsjVar;
        this.zzs = zzdwlVar;
        this.zzt = zzcxnVar;
    }

    public static final ListenableFuture zzj(zzcgy zzcgyVar, String str, String str2, final Bundle bundle, zzflm zzflmVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcy)).booleanValue()) {
            bundle.putLong(zzduq.RENDERING_WEBVIEW_LOAD_HTML_START.zza(), com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
        }
        final zzcca zzccaVar = new zzcca();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjP)).booleanValue()) {
            zzflc zzflcVarZzn = zzflc.CC.zzn(zzcgyVar.getContext(), 112);
            zzflcVarZzn.zza();
            zzfll.zzd(zzccaVar, zzflmVar, zzflcVarZzn);
        }
        zzcgyVar.zzP().zzG(new zzciu() { // from class: com.google.android.gms.internal.ads.zzdsb
            @Override // com.google.android.gms.internal.ads.zzciu
            public final /* synthetic */ void zza(boolean z, int i, String str3, String str4) {
                zzcca zzccaVar2 = zzccaVar;
                if (z) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcy)).booleanValue()) {
                        bundle.putLong(zzduq.RENDERING_WEBVIEW_LOAD_HTML_END.zza(), com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
                    }
                    zzccaVar2.zzc(null);
                    return;
                }
                int length = String.valueOf(i).length();
                StringBuilder sb = new StringBuilder(length + 55 + String.valueOf(str3).length() + 15 + String.valueOf(str4).length());
                sb.append("Ad Web View failed to load. Error code: ");
                sb.append(i);
                sb.append(", Description: ");
                sb.append(str3);
                sb.append(", Failing URL: ");
                sb.append(str4);
                zzccaVar2.zzd(new Exception(sb.toString()));
            }
        });
        zzcgyVar.zzau(str, str2, null);
        return zzccaVar;
    }

    final /* synthetic */ void zza() {
        this.zza.onAdClicked();
    }

    final /* synthetic */ void zzb(String str, String str2) {
        this.zzf.zzb(str, str2);
    }

    final /* synthetic */ void zzc() {
        this.zzc.zzb();
    }

    final /* synthetic */ boolean zzd(View view, MotionEvent motionEvent) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlb)).booleanValue() && motionEvent != null && motionEvent.getAction() == 0) {
            this.zzr.zza(motionEvent);
        }
        this.zzj.zza();
        if (view == null) {
            return false;
        }
        view.performClick();
        return false;
    }

    final /* synthetic */ void zze(View view) {
        this.zzj.zza();
    }

    final /* synthetic */ void zzf(zzcgy zzcgyVar, zzcgy zzcgyVar2, Map map) {
        this.zzi.zzn(zzcgyVar);
    }

    final /* synthetic */ zzczv zzg() {
        return this.zzc;
    }

    final /* synthetic */ zzddj zzh() {
        return this.zzm;
    }

    public final void zzi(final zzcgy zzcgyVar, boolean z, zzbma zzbmaVar, Bundle bundle) {
        zzawv zzawvVarZzb;
        zzbel zzbelVar = zzbeu.zzcy;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
            bundle.putLong(zzduq.RENDERING_CONFIGURE_WEBVIEW_START.zza(), com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
        }
        zzcgyVar.zzP().zzZ(new com.google.android.gms.ads.internal.client.zza() { // from class: com.google.android.gms.internal.ads.zzdsc
            @Override // com.google.android.gms.ads.internal.client.zza
            public final /* synthetic */ void onAdClicked() {
                this.zza.zza();
            }
        }, this.zzd, this.zze, new zzbkp() { // from class: com.google.android.gms.internal.ads.zzdrv
            @Override // com.google.android.gms.internal.ads.zzbkp
            public final /* synthetic */ void zzb(String str, String str2) {
                this.zza.zzb(str, str2);
            }
        }, new com.google.android.gms.ads.internal.overlay.zzad() { // from class: com.google.android.gms.internal.ads.zzdrw
            @Override // com.google.android.gms.ads.internal.overlay.zzad
            public final /* synthetic */ void zzl() {
                this.zza.zzc();
            }
        }, z, zzbmaVar, this.zzj, new zzdru(this), this.zzk, this.zzn, this.zzo, this.zzp, null, this.zzb, null, null, null, this.zzq, this.zzs, this.zzt);
        zzcgyVar.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.gms.internal.ads.zzdrx
            @Override // android.view.View.OnTouchListener
            public final /* synthetic */ boolean onTouch(View view, MotionEvent motionEvent) {
                this.zza.zzd(view, motionEvent);
                return false;
            }
        });
        zzcgyVar.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzdry
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view) {
                this.zza.zze(view);
            }
        });
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcZ)).booleanValue() && (zzawvVarZzb = this.zzl.zzb()) != null) {
            zzawvVarZzb.zzh(zzcgyVar.zzE());
        }
        zzdgp zzdgpVar = this.zzh;
        Executor executor = this.zzg;
        zzdgpVar.zzq(zzcgyVar, executor);
        zzdgpVar.zzq(new zzbau() { // from class: com.google.android.gms.internal.ads.zzdrz
            @Override // com.google.android.gms.internal.ads.zzbau
            public final /* synthetic */ void zzdo(zzbat zzbatVar) {
                Rect rect = zzbatVar.zzd;
                zzcgyVar.zzP().zza(rect.left, rect.top, false);
            }
        }, executor);
        zzdgpVar.zza(zzcgyVar.zzE());
        zzcgyVar.zzab("/trackActiveViewUnit", new zzblx() { // from class: com.google.android.gms.internal.ads.zzdsa
            @Override // com.google.android.gms.internal.ads.zzblx
            public final /* synthetic */ void zza(Object obj, Map map) {
                this.zza.zzf(zzcgyVar, (zzcgy) obj, map);
            }
        });
        this.zzi.zzo(zzcgyVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
            bundle.putLong(zzduq.RENDERING_CONFIGURE_WEBVIEW_END.zza(), com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
        }
    }
}
