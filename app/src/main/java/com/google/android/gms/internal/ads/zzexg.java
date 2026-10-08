package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzexg implements zzeya {
    public static final /* synthetic */ int zzb = 0;
    private static final zzexh zzc = new zzexh(new JSONArray().toString(), new Bundle(), "");
    final String zza;
    private final zzgus zzd;
    private final ScheduledExecutorService zze;
    private final zzeno zzf;
    private final Context zzg;
    private final zzfgn zzh;
    private final zzenj zzi;
    private final zzdsy zzj;
    private final zzdxv zzk;
    private final int zzl;

    zzexg(zzgus zzgusVar, ScheduledExecutorService scheduledExecutorService, String str, zzeno zzenoVar, Context context, zzfgn zzfgnVar, zzenj zzenjVar, zzdsy zzdsyVar, zzdxv zzdxvVar, int i) {
        this.zzd = zzgusVar;
        this.zze = scheduledExecutorService;
        this.zza = str;
        this.zzf = zzenoVar;
        this.zzg = context;
        this.zzh = zzfgnVar;
        this.zzi = zzenjVar;
        this.zzj = zzdsyVar;
        this.zzk = zzdxvVar;
        this.zzl = i;
    }

    private final void zzf(List list, Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            zzens zzensVar = (zzens) ((Map.Entry) it.next()).getValue();
            String str = zzensVar.zza;
            list.add(zzh(str, Collections.singletonList(zzensVar.zze), zzg(str), zzensVar.zzb, zzensVar.zzc));
        }
    }

    private final Bundle zzg(String str) {
        Bundle bundle = this.zzh.zzd.zzm;
        if (bundle != null) {
            return bundle.getBundle(str);
        }
        return null;
    }

    private final zzgua zzh(final String str, final List list, final Bundle bundle, final boolean z, final boolean z2) {
        zzgtp zzgtpVar = new zzgtp() { // from class: com.google.android.gms.internal.ads.zzexb
            @Override // com.google.android.gms.internal.ads.zzgtp
            public final /* synthetic */ ListenableFuture zza() {
                return this.zza.zzd(str, list, bundle, z, z2);
            }
        };
        zzgus zzgusVar = this.zzd;
        zzgua zzguaVarZzw = zzgua.zzw(zzgui.zzf(zzgtpVar, zzgusVar));
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbQ)).booleanValue()) {
            zzguaVarZzw = (zzgua) zzgui.zzi(zzguaVarZzw, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbJ)).longValue(), TimeUnit.MILLISECONDS, this.zze);
        }
        return (zzgua) zzgui.zzg(zzguaVarZzw, Throwable.class, new zzglu() { // from class: com.google.android.gms.internal.ads.zzexc
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                int i = zzexg.zzb;
                String str2 = str;
                String.valueOf(str2);
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzf("Error calling adapter: ".concat(String.valueOf(str2)));
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoc)).booleanValue()) {
                    zzcbj zzcbjVarZzh = com.google.android.gms.ads.internal.zzt.zzh();
                    String.valueOf(str2);
                    zzcbjVarZzh.zzh(th, "rtbSignal.fetchRtbJsonInfo-".concat(String.valueOf(str2)));
                    return null;
                }
                zzcbj zzcbjVarZzh2 = com.google.android.gms.ads.internal.zzt.zzh();
                String.valueOf(str2);
                zzcbjVarZzh2.zzg(th, "rtbSignal.fetchRtbJsonInfo-".concat(String.valueOf(str2)));
                return null;
            }
        }, zzgusVar);
    }

    private final void zzi(zzbti zzbtiVar, Bundle bundle, List list, zzenr zzenrVar) throws RemoteException {
        zzbtiVar.zze(ObjectWrapper.wrap(this.zzg), this.zza, bundle, (Bundle) list.get(0), this.zzh.zzf, zzenrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        if (this.zzl == 2) {
            return zzgui.zza(zzc);
        }
        zzfgn zzfgnVar = this.zzh;
        if (zzfgnVar.zzs) {
            if (!Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbW)).split(",")).contains(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzc(zzfgnVar.zzd)))) {
                return zzgui.zza(zzc);
            }
        }
        return zzgui.zzf(new zzgtp() { // from class: com.google.android.gms.internal.ads.zzexe
            @Override // com.google.android.gms.internal.ads.zzgtp
            public final /* synthetic */ ListenableFuture zza() {
                return this.zza.zzc();
            }
        }, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 32;
    }

    final /* synthetic */ ListenableFuture zzc() {
        final String str;
        String lowerCase = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlU)).booleanValue() ? this.zzh.zzg.toLowerCase(Locale.ROOT) : this.zzh.zzg;
        final Bundle bundleZzg = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbU)).booleanValue() ? this.zzk.zzg() : new Bundle();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeL)).booleanValue()) {
            int iZzk = com.google.android.gms.ads.internal.zzt.zzh().zzo().zzi().zzk();
            str = iZzk != 1 ? iZzk != 2 ? "EMPTY" : "INVALID" : "VALID";
        } else {
            str = "";
        }
        final ArrayList arrayList = new ArrayList();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcd)).booleanValue()) {
            zzf(arrayList, this.zzf.zzd(this.zza, lowerCase));
        } else {
            zzeno zzenoVar = this.zzf;
            for (Map.Entry entry : zzenoVar.zzc(this.zza, lowerCase).entrySet()) {
                String str2 = (String) entry.getKey();
                arrayList.add(zzh(str2, (List) entry.getValue(), zzg(str2), true, true));
            }
            zzf(arrayList, zzenoVar.zzb());
        }
        return zzgui.zzp(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzexa
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                int i = zzexg.zzb;
                JSONArray jSONArray = new JSONArray();
                for (ListenableFuture listenableFuture : arrayList) {
                    if (((JSONObject) listenableFuture.get()) != null) {
                        jSONArray.put(listenableFuture.get());
                    }
                }
                String str3 = str;
                Bundle bundle = bundleZzg;
                if (jSONArray.length() != 0) {
                    return new zzexh(jSONArray.toString(), bundle, str3);
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeL)).booleanValue()) {
                    return new zzexh(new JSONArray().toString(), bundle, str3);
                }
                return null;
            }
        }, this.zzd);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ com.google.common.util.concurrent.ListenableFuture zzd(java.lang.String r9, final java.util.List r10, final android.os.Bundle r11, boolean r12, boolean r13) throws android.os.RemoteException {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzcca r7 = new com.google.android.gms.internal.ads.zzcca
            r7.<init>()
            r0 = 0
            if (r13 == 0) goto L24
            com.google.android.gms.internal.ads.zzbel r13 = com.google.android.gms.internal.ads.zzbeu.zzbV
            com.google.android.gms.internal.ads.zzbes r1 = com.google.android.gms.ads.internal.client.zzbd.zzc()
            java.lang.Object r13 = r1.zzd(r13)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L24
            com.google.android.gms.internal.ads.zzenj r13 = r8.zzi
            r13.zza(r9)
            com.google.android.gms.internal.ads.zzbti r13 = r13.zzb(r9)
            goto L32
        L24:
            com.google.android.gms.internal.ads.zzdsy r13 = r8.zzj     // Catch: android.os.RemoteException -> L2b
            com.google.android.gms.internal.ads.zzbti r13 = r13.zzb(r9)     // Catch: android.os.RemoteException -> L2b
            goto L32
        L2b:
            r13 = move-exception
            java.lang.String r1 = "Couldn't create RTB adapter : "
            com.google.android.gms.ads.internal.util.zze.zzb(r1, r13)
            r13 = r0
        L32:
            if (r13 != 0) goto L4c
            com.google.android.gms.internal.ads.zzbel r10 = com.google.android.gms.internal.ads.zzbeu.zzbL
            com.google.android.gms.internal.ads.zzbes r11 = com.google.android.gms.ads.internal.client.zzbd.zzc()
            java.lang.Object r10 = r11.zzd(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L4b
            com.google.android.gms.internal.ads.zzenr.zzd(r9, r7)
            goto Lb8
        L4b:
            throw r0
        L4c:
            com.google.android.gms.internal.ads.zzenr r6 = new com.google.android.gms.internal.ads.zzenr
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzt.zzk()
            long r4 = r0.elapsedRealtime()
            r0 = r6
            r1 = r9
            r2 = r13
            r3 = r7
            r0.<init>(r1, r2, r3, r4)
            com.google.android.gms.internal.ads.zzbel r9 = com.google.android.gms.internal.ads.zzbeu.zzbQ
            com.google.android.gms.internal.ads.zzbes r0 = com.google.android.gms.ads.internal.client.zzbd.zzc()
            java.lang.Object r9 = r0.zzd(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L8b
            java.util.concurrent.ScheduledExecutorService r9 = r8.zze
            com.google.android.gms.internal.ads.zzexf r0 = new com.google.android.gms.internal.ads.zzexf
            r0.<init>()
            com.google.android.gms.internal.ads.zzbel r1 = com.google.android.gms.internal.ads.zzbeu.zzbJ
            com.google.android.gms.internal.ads.zzbes r2 = com.google.android.gms.ads.internal.client.zzbd.zzc()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
            r9.schedule(r0, r1, r3)
        L8b:
            if (r12 == 0) goto Lb5
            com.google.android.gms.internal.ads.zzbel r9 = com.google.android.gms.internal.ads.zzbeu.zzbX
            com.google.android.gms.internal.ads.zzbes r12 = com.google.android.gms.ads.internal.client.zzbd.zzc()
            java.lang.Object r9 = r12.zzd(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto Lb1
            com.google.android.gms.internal.ads.zzgus r9 = r8.zzd
            com.google.android.gms.internal.ads.zzexd r12 = new com.google.android.gms.internal.ads.zzexd
            r0 = r12
            r1 = r8
            r2 = r13
            r3 = r11
            r4 = r10
            r5 = r6
            r6 = r7
            r0.<init>()
            r9.zza(r12)
            goto Lb8
        Lb1:
            r8.zzi(r13, r11, r10, r6)
            goto Lb8
        Lb5:
            r6.zzb()
        Lb8:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzexg.zzd(java.lang.String, java.util.List, android.os.Bundle, boolean, boolean):com.google.common.util.concurrent.ListenableFuture");
    }

    final /* synthetic */ void zze(zzbti zzbtiVar, Bundle bundle, List list, zzenr zzenrVar, zzcca zzccaVar) {
        try {
            zzi(zzbtiVar, bundle, list, zzenrVar);
        } catch (RemoteException e) {
            zzccaVar.zzd(e);
        }
    }
}
