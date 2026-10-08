package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.internal.ads.zzflc;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzeyd {
    private final Context zza;
    private final Set zzb;
    private final Executor zzc;
    private final zzflm zzd;
    private final zzdvi zze;
    private long zzf = 0;
    private int zzg = 0;

    public zzeyd(Context context, Executor executor, Set set, zzflm zzflmVar, zzdvi zzdviVar) {
        this.zza = context;
        this.zzc = executor;
        this.zzb = set;
        this.zzd = zzflmVar;
        this.zze = zzdviVar;
    }

    public final ListenableFuture zza(final Object obj, final Bundle bundle, final boolean z) {
        zzflc zzflcVarZzn = zzflc.CC.zzn(this.zza, 8);
        zzflcVarZzn.zza();
        Set<zzeya> set = this.zzb;
        final ArrayList arrayList = new ArrayList(set.size());
        List arrayList2 = new ArrayList();
        zzbel zzbelVar = zzbeu.zzmK;
        if (!((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).isEmpty()) {
            arrayList2 = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).split(","));
        }
        List list = arrayList2;
        this.zzf = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime();
        final Bundle bundle2 = new Bundle();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcv)).booleanValue() && bundle != null) {
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
            if (obj instanceof zzcxq) {
                bundle.putLong(zzduq.CLIENT_SIGNALS_START.zza(), jCurrentTimeMillis);
            } else {
                bundle.putLong(zzduq.GMS_SIGNALS_START.zza(), jCurrentTimeMillis);
            }
        }
        for (final zzeya zzeyaVar : set) {
            if (!list.contains(String.valueOf(zzeyaVar.zzb()))) {
                final long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime();
                ListenableFuture listenableFutureZza = zzeyaVar.zza();
                listenableFutureZza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeyb
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzb(jElapsedRealtime, zzeyaVar, bundle2);
                    }
                }, zzcbv.zzg);
                arrayList.add(listenableFutureZza);
            }
        }
        ListenableFuture listenableFutureZza2 = zzgui.zzp(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeyc
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                Object obj2;
                Bundle bundle3;
                Iterator it = arrayList.iterator();
                while (true) {
                    obj2 = obj;
                    if (!it.hasNext()) {
                        break;
                    }
                    zzexy zzexyVar = (zzexy) ((ListenableFuture) it.next()).get();
                    if (zzexyVar != null) {
                        boolean z2 = z;
                        zzexyVar.zza(obj2);
                        if (z2) {
                            zzexyVar.zzb(obj2);
                        }
                    }
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcv)).booleanValue() && (bundle3 = bundle) != null) {
                    Bundle bundle4 = bundle2;
                    long jCurrentTimeMillis2 = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
                    if (obj2 instanceof zzcxq) {
                        bundle3.putLong(zzduq.CLIENT_SIGNALS_END.zza(), jCurrentTimeMillis2);
                        bundle3.putBundle("client_sig_latency_key", bundle4);
                    } else {
                        bundle3.putLong(zzduq.GMS_SIGNALS_END.zza(), jCurrentTimeMillis2);
                        bundle3.putBundle("gms_sig_latency_key", bundle4);
                    }
                }
                return obj2;
            }
        }, this.zzc);
        if (zzflp.zza()) {
            zzfll.zzd(listenableFutureZza2, this.zzd, zzflcVarZzn);
        }
        return listenableFutureZza2;
    }

    final /* synthetic */ void zzb(long j, zzeya zzeyaVar, Bundle bundle) {
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - j;
        if (((Boolean) zzbgw.zza.zze()).booleanValue()) {
            String strZza = zzgmu.zza(zzeyaVar.getClass().getCanonicalName());
            StringBuilder sb = new StringBuilder(strZza.length() + 25 + String.valueOf(jElapsedRealtime).length());
            sb.append("Signal runtime (ms) : ");
            sb.append(strZza);
            sb.append(" = ");
            sb.append(jElapsedRealtime);
            com.google.android.gms.ads.internal.util.zze.zza(sb.toString());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcv)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcB)).booleanValue()) {
                synchronized (this) {
                    int iZzb = zzeyaVar.zzb();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(iZzb).length() + 3);
                    sb2.append("sig");
                    sb2.append(iZzb);
                    bundle.putLong(sb2.toString(), jElapsedRealtime);
                }
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzct)).booleanValue()) {
            zzdvh zzdvhVarZza = this.zze.zza();
            zzdvhVarZza.zzc(NativeProtocol.WEB_DIALOG_ACTION, "lat_ms");
            zzdvhVarZza.zzc("lat_grp", "sig_lat_grp");
            zzdvhVarZza.zzc("lat_id", String.valueOf(zzeyaVar.zzb()));
            zzdvhVarZza.zzc("clat_ms", String.valueOf(jElapsedRealtime));
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcu)).booleanValue()) {
                synchronized (this) {
                    this.zzg++;
                }
                zzdvhVarZza.zzc("seq_num", com.google.android.gms.ads.internal.zzt.zzh().zzr().zzm());
                synchronized (this) {
                    if (this.zzg == this.zzb.size() && this.zzf != 0) {
                        this.zzg = 0;
                        String strValueOf = String.valueOf(com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - this.zzf);
                        if (zzeyaVar.zzb() <= 39 || zzeyaVar.zzb() >= 52) {
                            zzdvhVarZza.zzc("lat_clsg", strValueOf);
                        } else {
                            zzdvhVarZza.zzc("lat_gmssg", strValueOf);
                        }
                    }
                }
            }
            zzdvhVarZza.zzh();
        }
    }
}
