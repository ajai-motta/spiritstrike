package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbeu;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzcbv;
import com.google.android.gms.internal.ads.zzdvn;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzo {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private final Context zzc;
    private final zzdvn zzd;
    private final ExecutorService zze;

    zzo(Context context, zzdvn zzdvnVar, ExecutorService executorService) {
        this.zzc = context;
        this.zzd = zzdvnVar;
        this.zze = executorService;
    }

    private final void zzh(final boolean z) {
        Map map = this.zzb;
        Boolean boolValueOf = Boolean.valueOf(z);
        if (map.containsKey(boolValueOf)) {
            return;
        }
        map.put(boolValueOf, new ArrayList());
        this.zze.submit(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzl
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzf(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final synchronized void zze(boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        bundle.putBoolean("accept_3p_cookie", z);
        Map map = this.zza;
        Boolean boolValueOf = Boolean.valueOf(z);
        zzq zzqVar = (zzq) map.get(boolValueOf);
        int iZzd = 0;
        if (z2 && zzqVar != null) {
            iZzd = zzqVar.zzd() + 1;
        }
        zzq zzqVar2 = (zzq) map.get(boolValueOf);
        final zzp zzpVar = new zzp(this, z, iZzd, zzqVar2 == null ? null : Boolean.valueOf(zzqVar2.zze()), this.zzd);
        final AdRequest adRequestBuild = new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle).build();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmd)).booleanValue()) {
            this.zze.submit(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzm
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.zza.zzg(adRequestBuild, zzpVar);
                }
            });
        } else {
            QueryInfo.generate(this.zzc, AdFormat.BANNER, adRequestBuild, zzpVar);
        }
    }

    private final void zzj(zzq zzqVar, Pair pair, boolean z) {
        zzqVar.zzf();
        QueryInfo queryInfoZza = zzqVar.zza();
        if (queryInfoZza != null) {
            ((QueryInfoGenerationCallback) pair.first).onSuccess(queryInfoZza);
        } else {
            ((QueryInfoGenerationCallback) pair.first).onFailure(zzqVar.zzb());
        }
        zzdvn zzdvnVar = this.zzd;
        Pair[] pairArr = new Pair[7];
        pairArr[0] = new Pair("se", "query_g");
        pairArr[1] = new Pair(FirebaseAnalytics.Param.AD_FORMAT, AdFormat.BANNER.name());
        pairArr[2] = new Pair("rtype", Integer.toString(6));
        pairArr[3] = new Pair("scar", "true");
        pairArr[4] = new Pair("lat_ms", Long.toString(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() - ((Long) pair.second).longValue()));
        pairArr[5] = new Pair("sgpc_h", Boolean.toString(z));
        pairArr[6] = new Pair("sgpc_rs", Boolean.toString(zzqVar.zza() != null));
        zzaa.zze(zzdvnVar, null, "sgpcr", pairArr);
    }

    public final synchronized void zza() {
        zzh(true);
        zzh(false);
    }

    public final synchronized void zzb(final Object obj, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        final Pair pair = new Pair(queryInfoGenerationCallback, Long.valueOf(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis()));
        zzcbv.zzf.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzn
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzd(obj, pair);
            }
        });
    }

    final synchronized void zzc(final boolean z, zzq zzqVar) {
        Map map = this.zza;
        Boolean boolValueOf = Boolean.valueOf(z);
        zzq zzqVar2 = (zzq) map.get(boolValueOf);
        if (zzqVar2 == null || zzqVar2.zzc() || zzqVar2.zza() == null || zzqVar.zza() != null) {
            map.put(boolValueOf, zzqVar);
        }
        long jLongValue = (zzqVar.zza() != null ? (Long) zzbgz.zzf.zze() : (Long) zzbgz.zzg.zze()).longValue();
        final boolean z2 = zzqVar.zza() == null;
        zzcbv.zzd.schedule(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzk
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zze(z, z2);
            }
        }, jLongValue, TimeUnit.SECONDS);
        Map map2 = this.zzb;
        List list = (List) map2.get(boolValueOf);
        map2.put(boolValueOf, new ArrayList());
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzj(zzqVar, (Pair) it.next(), false);
            }
        }
    }

    final /* synthetic */ void zzd(Object obj, Pair pair) {
        boolean zAcceptThirdPartyCookies = false;
        if (obj instanceof WebView) {
            CookieManager cookieManagerZza = com.google.android.gms.ads.internal.zzt.zzf().zza(this.zzc);
            if (cookieManagerZza != null) {
                zAcceptThirdPartyCookies = cookieManagerZza.acceptThirdPartyCookies((WebView) obj);
            }
        }
        Map map = this.zza;
        Boolean boolValueOf = Boolean.valueOf(zAcceptThirdPartyCookies);
        zzq zzqVar = (zzq) map.get(boolValueOf);
        if (zzqVar != null && !zzqVar.zzc()) {
            zzj(zzqVar, pair, true);
            return;
        }
        Map map2 = this.zzb;
        List arrayList = (List) map2.get(boolValueOf);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map2.put(boolValueOf, arrayList);
        }
        arrayList.add(pair);
    }

    final /* synthetic */ void zzf(boolean z) {
        zze(z, false);
    }

    final /* synthetic */ Object zzg(AdRequest adRequest, zzp zzpVar) {
        QueryInfo.generate(this.zzc, AdFormat.BANNER, adRequest, zzpVar);
        return true;
    }
}
