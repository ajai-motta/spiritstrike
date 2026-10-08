package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.InputEvent;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcpe {
    zzbwh zza;
    zzbwh zzb;
    private final Context zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;
    private final zzehg zze;
    private final zzdsj zzf;
    private final zzgus zzg;
    private final Executor zzh;
    private final ScheduledExecutorService zzi;

    zzcpe(Context context, com.google.android.gms.ads.internal.util.zzg zzgVar, zzehg zzehgVar, zzdsj zzdsjVar, zzgus zzgusVar, zzgus zzgusVar2, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = context;
        this.zzd = zzgVar;
        this.zze = zzehgVar;
        this.zzf = zzdsjVar;
        this.zzg = zzgusVar;
        this.zzh = zzgusVar2;
        this.zzi = scheduledExecutorService;
    }

    public static boolean zzc(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains((CharSequence) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzli));
    }

    private final ListenableFuture zzk(final String str, final InputEvent inputEvent, Random random) {
        try {
            if (!str.contains((CharSequence) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzli)) || this.zzd.zzx()) {
                return zzgui.zza(str);
            }
            final Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlj), String.valueOf(random.nextInt(Integer.MAX_VALUE)));
            if (inputEvent != null) {
                return (zzgua) zzgui.zzh((zzgua) zzgui.zzj(zzgua.zzw(this.zze.zza()), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzcoy
                    @Override // com.google.android.gms.internal.ads.zzgtq
                    public final /* synthetic */ ListenableFuture zza(Object obj) {
                        return this.zza.zze(builderBuildUpon, str, inputEvent, (Integer) obj);
                    }
                }, this.zzh), Throwable.class, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzcoz
                    @Override // com.google.android.gms.internal.ads.zzgtq
                    public final /* synthetic */ ListenableFuture zza(Object obj) {
                        return this.zza.zzf(builderBuildUpon, (Throwable) obj);
                    }
                }, this.zzg);
            }
            builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlk), "11");
            return zzgui.zza(builderBuildUpon.toString());
        } catch (Exception e) {
            return zzgui.zzc(e);
        }
    }

    public final void zza(String str, zzfng zzfngVar, Random random, com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzgui.zzr(zzgui.zzi(zzk(str, this.zzf.zzb(), random), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlo)).intValue(), TimeUnit.MILLISECONDS, this.zzi), new zzcox(this, zzfngVar, str, zzvVar), this.zzg);
    }

    public final ListenableFuture zzb(final String str, Random random) {
        return TextUtils.isEmpty(str) ? zzgui.zza(str) : zzgui.zzh(zzk(str, this.zzf.zzb(), random), Throwable.class, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzcpd
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzd(str, (Throwable) obj);
            }
        }, this.zzg);
    }

    final /* synthetic */ ListenableFuture zzd(String str, final Throwable th) {
        this.zzg.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcpc
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzh(th);
            }
        });
        return zzgui.zza(str);
    }

    final /* synthetic */ ListenableFuture zze(final Uri.Builder builder, String str, InputEvent inputEvent, Integer num) {
        if (num.intValue() != 1) {
            builder.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlk), "10");
            return zzgui.zza(builder.toString());
        }
        Uri.Builder builderBuildUpon = builder.build().buildUpon();
        builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzll), "1");
        builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlk), "12");
        if (str.contains((CharSequence) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlm))) {
            builderBuildUpon.authority((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzln));
        }
        return (zzgua) zzgui.zzj(zzgua.zzw(this.zze.zzb(builderBuildUpon.build(), inputEvent)), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzcpa
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                String str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlk);
                Uri.Builder builder2 = builder;
                builder2.appendQueryParameter(str2, "12");
                return zzgui.zza(builder2.toString());
            }
        }, this.zzh);
    }

    final /* synthetic */ ListenableFuture zzf(Uri.Builder builder, final Throwable th) {
        this.zzg.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcpb
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzg(th);
            }
        });
        builder.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlk), "9");
        return zzgui.zza(builder.toString());
    }

    final /* synthetic */ void zzg(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlp)).booleanValue()) {
            zzbwh zzbwhVarZzc = zzbwf.zzc(this.zzc);
            this.zzb = zzbwhVarZzc;
            zzbwhVarZzc.zzh(th, "AttributionReporting");
        } else {
            zzbwh zzbwhVarZza = zzbwf.zza(this.zzc);
            this.zza = zzbwhVarZza;
            zzbwhVarZza.zzh(th, "AttributionReportingSampled");
        }
    }

    final /* synthetic */ void zzh(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlp)).booleanValue()) {
            zzbwh zzbwhVarZzc = zzbwf.zzc(this.zzc);
            this.zzb = zzbwhVarZzc;
            zzbwhVarZzc.zzh(th, "AttributionReporting.getUpdatedUrlAndRegisterSource");
        } else {
            zzbwh zzbwhVarZza = zzbwf.zza(this.zzc);
            this.zza = zzbwhVarZza;
            zzbwhVarZza.zzh(th, "AttributionReportingSampled.getUpdatedUrlAndRegisterSource");
        }
    }

    final /* synthetic */ Context zzi() {
        return this.zzc;
    }

    final /* synthetic */ zzgus zzj() {
        return this.zzg;
    }
}
