package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzfom {
    protected final ClientApi zza;
    protected final Context zzb;
    protected final int zzc;
    protected final zzfhj zzd;
    protected com.google.android.gms.ads.internal.client.zzft zze;
    protected AtomicBoolean zzf;
    protected com.google.android.gms.ads.internal.client.zzch zzg;
    private com.google.android.gms.ads.internal.client.zzce zzh;
    private final Queue zzi;
    private final zzfnq zzj;
    private final String zzk;
    private AtomicBoolean zzl;
    private final ScheduledExecutorService zzm;
    private AtomicBoolean zzn;
    private AtomicBoolean zzo;
    private zzfnv zzp;
    private final Clock zzq;
    private final zzfoc zzr;

    public zzfom(ClientApi clientApi, Context context, int i, zzfhj zzfhjVar, com.google.android.gms.ads.internal.client.zzft zzftVar, com.google.android.gms.ads.internal.client.zzce zzceVar, ScheduledExecutorService scheduledExecutorService, zzfnq zzfnqVar, Clock clock) {
        this("none", clientApi, context, i, zzfhjVar, zzftVar, scheduledExecutorService, zzfnqVar, clock);
        this.zzh = zzceVar;
    }

    static final /* synthetic */ double zzD(com.google.android.gms.ads.internal.client.zzea zzeaVar) {
        if (zzeaVar instanceof zzcyh) {
            return ((zzcyh) zzeaVar).zzl();
        }
        return 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzF, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzt(Object obj) {
        this.zzl.set(false);
        if (obj != null) {
            this.zzj.zza();
            this.zzo.set(true);
            zzI(obj);
        }
        zzJ(obj == null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzG, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzu(Throwable th) {
        this.zzl.set(false);
        if ((th instanceof zzfni) && ((zzfni) th).zza() == 0) {
            throw null;
        }
        zzJ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzv(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (this.zzn.get()) {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new zzfoj(this, zzeVar));
        }
        this.zzl.set(false);
        int i = zzeVar.zza;
        if (i != 1 && i != 8 && i != 10 && i != 11) {
            zzJ(true);
            return;
        }
        com.google.android.gms.ads.internal.client.zzft zzftVar = this.zze;
        int i2 = zzftVar.zzb;
        String str = zzftVar.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 26 + String.valueOf(str).length() + 61);
        sb.append("Preloading ");
        sb.append(i2);
        sb.append(", for adUnitId:");
        sb.append(str);
        sb.append(", Ad load failed. Stop preloading due to non-retriable error:");
        String string = sb.toString();
        int i3 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh(string);
        this.zzf.set(false);
        zzfob zzfobVar = new zzfob(this.zze.zza, zzm());
        zzfobVar.zza(this.zzk);
        this.zzp.zzk(this.zzq.currentTimeMillis(), new zzfoc(zzfobVar, null), zzeVar, this.zze.zzd, zzn(), zzz());
    }

    private final synchronized void zzI(Object obj) {
        Clock clock = this.zzq;
        zzfod zzfodVar = new zzfod(obj, clock);
        this.zzi.add(zzfodVar);
        com.google.android.gms.ads.internal.client.zzea zzeaVarZzb = zzb(obj);
        long jCurrentTimeMillis = clock.currentTimeMillis();
        if (this.zzn.get()) {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new zzfoh(this, zzeaVarZzb));
        }
        ScheduledExecutorService scheduledExecutorService = this.zzm;
        scheduledExecutorService.execute(new zzfoi(this, jCurrentTimeMillis, zzeaVarZzb));
        scheduledExecutorService.schedule(new zzfog(this), zzfodVar.zzc(), TimeUnit.MILLISECONDS);
    }

    private final synchronized void zzJ(boolean z) {
        zzfnq zzfnqVar = this.zzj;
        if (zzfnqVar.zzd()) {
            return;
        }
        if (z) {
            zzfnqVar.zzc();
        }
        this.zzm.schedule(new zzfog(this), zzfnqVar.zzb(), TimeUnit.MILLISECONDS);
    }

    private final synchronized void zzK() {
        Iterator it = this.zzi.iterator();
        while (it.hasNext()) {
            if (((zzfod) it.next()).zzb()) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzL, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzw(com.google.android.gms.ads.internal.client.zze zzeVar) {
        com.google.android.gms.ads.internal.client.zzch zzchVar = this.zzg;
        if (zzchVar != null) {
            try {
                zzchVar.zzg(this.zzk, zzeVar);
            } catch (RemoteException unused) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Failed to call onAdFailedToPreload");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0026 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0016 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: zzM, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void zzx(com.google.android.gms.ads.internal.client.zzea r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.ads.internal.client.zzce r0 = r2.zzh     // Catch: java.lang.Throwable -> L28
            if (r0 == 0) goto L12
            com.google.android.gms.ads.internal.client.zzft r1 = r2.zze     // Catch: android.os.RemoteException -> Lb java.lang.Throwable -> L28
            r0.zze(r1)     // Catch: android.os.RemoteException -> Lb java.lang.Throwable -> L28
            goto L12
        Lb:
            int r0 = com.google.android.gms.ads.internal.util.zze.zza     // Catch: java.lang.Throwable -> L28
            java.lang.String r0 = "Failed to call onAdsAvailable"
            com.google.android.gms.ads.internal.util.client.zzo.zzi(r0)     // Catch: java.lang.Throwable -> L28
        L12:
            com.google.android.gms.ads.internal.client.zzch r0 = r2.zzg     // Catch: java.lang.Throwable -> L28
            if (r0 == 0) goto L26
            java.lang.String r1 = r2.zzk     // Catch: android.os.RemoteException -> L1d java.lang.Throwable -> L28
            r0.zze(r1, r3)     // Catch: android.os.RemoteException -> L1d java.lang.Throwable -> L28
            monitor-exit(r2)
            return
        L1d:
            int r3 = com.google.android.gms.ads.internal.util.zze.zza     // Catch: java.lang.Throwable -> L28
            java.lang.String r3 = "Failed to call onAdPreloaded"
            com.google.android.gms.ads.internal.util.client.zzo.zzi(r3)     // Catch: java.lang.Throwable -> L28
            monitor-exit(r2)
            return
        L26:
            monitor-exit(r2)
            return
        L28:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfom.zzx(com.google.android.gms.ads.internal.client.zzea):void");
    }

    private final synchronized void zzN() {
        if (this.zzo.get() && this.zzi.isEmpty()) {
            this.zzo.set(false);
            if (this.zzn.get()) {
                com.google.android.gms.ads.internal.util.zzs.zza.post(new zzfok(this));
            }
            this.zzm.execute(new zzfol(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0026 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0016 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: zzO, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void zzy() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.ads.internal.client.zzce r0 = r2.zzh     // Catch: java.lang.Throwable -> L28
            if (r0 == 0) goto L12
            com.google.android.gms.ads.internal.client.zzft r1 = r2.zze     // Catch: android.os.RemoteException -> Lb java.lang.Throwable -> L28
            r0.zzf(r1)     // Catch: android.os.RemoteException -> Lb java.lang.Throwable -> L28
            goto L12
        Lb:
            int r0 = com.google.android.gms.ads.internal.util.zze.zza     // Catch: java.lang.Throwable -> L28
            java.lang.String r0 = "Failed to call onAdsExhausted"
            com.google.android.gms.ads.internal.util.client.zzo.zzi(r0)     // Catch: java.lang.Throwable -> L28
        L12:
            com.google.android.gms.ads.internal.client.zzch r0 = r2.zzg     // Catch: java.lang.Throwable -> L28
            if (r0 == 0) goto L26
            java.lang.String r1 = r2.zzk     // Catch: android.os.RemoteException -> L1d java.lang.Throwable -> L28
            r0.zzf(r1)     // Catch: android.os.RemoteException -> L1d java.lang.Throwable -> L28
            monitor-exit(r2)
            return
        L1d:
            int r0 = com.google.android.gms.ads.internal.util.zze.zza     // Catch: java.lang.Throwable -> L28
            java.lang.String r0 = "Failed to call onAdsExhausted"
            com.google.android.gms.ads.internal.util.client.zzo.zzi(r0)     // Catch: java.lang.Throwable -> L28
            monitor-exit(r2)
            return
        L26:
            monitor-exit(r2)
            return
        L28:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfom.zzy():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzP, reason: merged with bridge method [inline-methods] */
    public final String zzz() {
        return true != "none".equals(this.zzk) ? "2" : "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String zzQ(com.google.android.gms.ads.internal.client.zzea zzeaVar) {
        if (zzeaVar instanceof zzcyh) {
            return ((zzcyh) zzeaVar).zzk();
        }
        return null;
    }

    final /* synthetic */ zzfnv zzA() {
        return this.zzp;
    }

    final /* synthetic */ Clock zzB() {
        return this.zzq;
    }

    final /* synthetic */ zzfoc zzC() {
        return this.zzr;
    }

    protected abstract ListenableFuture zza(Context context);

    protected abstract com.google.android.gms.ads.internal.client.zzea zzb(Object obj);

    public final synchronized zzfom zzc() {
        this.zzm.submit(new zzfog(this));
        return this;
    }

    public final synchronized boolean zzd() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzH)).booleanValue()) {
            this.zzj.zza();
        }
        zzK();
        return !this.zzi.isEmpty();
    }

    public final synchronized Object zze() {
        this.zzj.zza();
        Queue queue = this.zzi;
        zzfod zzfodVar = (zzfod) queue.poll();
        this.zzo.set(zzfodVar != null);
        if (zzfodVar == null) {
            zzfodVar = null;
        } else if (!queue.isEmpty()) {
            zzfod zzfodVar2 = (zzfod) queue.peek();
            AdFormat adFormat = AdFormat.getAdFormat(this.zze.zzb);
            String strZzQ = zzQ(zzb(zzfodVar.zza()));
            if (zzfodVar2 != null && adFormat != null && strZzQ != null && zzfodVar2.zzd() < zzfodVar.zzd()) {
                this.zzp.zzg(this.zzq.currentTimeMillis(), this.zze.zzd, zzn(), strZzQ, this.zzr, zzz());
            }
        }
        zzq();
        if (zzfodVar == null) {
            return null;
        }
        return zzfodVar.zza();
    }

    public final void zzf() {
        this.zzf.set(false);
        this.zzn.set(false);
    }

    public final void zzg() {
        this.zzf.set(false);
    }

    public final synchronized void zzh() {
        this.zzf.set(true);
        this.zzn.set(true);
        this.zzm.submit(new zzfog(this));
    }

    public final synchronized String zzi() {
        Object objZzp;
        objZzp = zzp();
        return zzQ(objZzp == null ? null : zzb(objZzp));
    }

    public final void zzj(zzfnv zzfnvVar) {
        this.zzp = zzfnvVar;
    }

    public final synchronized void zzk(int i) {
        Preconditions.checkArgument(i >= 5);
        this.zzj.zze(i);
    }

    protected final String zzl() {
        return this.zzk;
    }

    protected final AdFormat zzm() {
        return AdFormat.getAdFormat(this.zze.zzb);
    }

    protected final synchronized int zzn() {
        return this.zzi.size();
    }

    protected final void zzo() {
        this.zzi.clear();
    }

    protected final synchronized Object zzp() {
        zzfod zzfodVar = (zzfod) this.zzi.peek();
        if (zzfodVar == null) {
            return null;
        }
        return zzfodVar.zza();
    }

    protected final synchronized void zzq() {
        ListenableFuture listenableFutureZza;
        zzK();
        zzN();
        if (!this.zzl.get() && this.zzf.get() && this.zzi.size() < this.zze.zzd) {
            this.zzl.set(true);
            Activity activityZzd = com.google.android.gms.ads.internal.zzt.zzg().zzd();
            if (activityZzd == null) {
                String str = this.zze.zza;
                String.valueOf(str);
                String strValueOf = String.valueOf(str);
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Empty activity context at preloading: ".concat(strValueOf));
                listenableFutureZza = zza(this.zzb);
            } else {
                listenableFutureZza = zza(activityZzd);
            }
            zzgui.zzr(listenableFutureZza, new zzfoe(this), this.zzm);
        }
    }

    protected final void zzr(int i) {
        Preconditions.checkArgument(i > 0);
        AdFormat adFormat = AdFormat.getAdFormat(this.zze.zzb);
        int i2 = this.zze.zzd;
        synchronized (this) {
            com.google.android.gms.ads.internal.client.zzft zzftVar = this.zze;
            this.zze = new com.google.android.gms.ads.internal.client.zzft(zzftVar.zza, zzftVar.zzb, zzftVar.zzc, i > 0 ? i : zzftVar.zzd);
            Queue queue = this.zzi;
            if (queue.size() > i) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzw)).booleanValue()) {
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < i; i3++) {
                        zzfod zzfodVar = (zzfod) queue.poll();
                        if (zzfodVar != null) {
                            arrayList.add(zzfodVar);
                        }
                    }
                    queue.clear();
                    queue.addAll(arrayList);
                }
            }
        }
        zzfnv zzfnvVar = this.zzp;
        if (zzfnvVar == null || adFormat == null) {
            return;
        }
        zzfnvVar.zzc(i2, i, this.zzq.currentTimeMillis(), new zzfoc(new zzfob(this.zze.zza, adFormat), null));
    }

    protected final void zzs(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzB)).booleanValue()) {
            Bundle bundle = zzmVar.zzB;
            bundle.putInt("plcs", zzn());
            bundle.putInt("plbs", this.zze.zzd);
            bundle.putString("plid", this.zzk);
        }
    }

    public zzfom(String str, ClientApi clientApi, Context context, int i, zzfhj zzfhjVar, com.google.android.gms.ads.internal.client.zzft zzftVar, com.google.android.gms.ads.internal.client.zzch zzchVar, ScheduledExecutorService scheduledExecutorService, zzfnq zzfnqVar, Clock clock) {
        this(str, clientApi, context, i, zzfhjVar, zzftVar, scheduledExecutorService, zzfnqVar, clock);
        this.zzg = zzchVar;
    }

    private zzfom(String str, ClientApi clientApi, Context context, int i, zzfhj zzfhjVar, com.google.android.gms.ads.internal.client.zzft zzftVar, ScheduledExecutorService scheduledExecutorService, zzfnq zzfnqVar, Clock clock) {
        this.zzk = str;
        this.zza = clientApi;
        this.zzb = context;
        this.zzc = i;
        this.zzd = zzfhjVar;
        this.zze = zzftVar;
        this.zzi = new PriorityQueue(Math.max(1, zzftVar.zzd), new zzfof(this));
        this.zzf = new AtomicBoolean(true);
        this.zzl = new AtomicBoolean(false);
        this.zzm = scheduledExecutorService;
        this.zzj = zzfnqVar;
        this.zzn = new AtomicBoolean(true);
        this.zzo = new AtomicBoolean(false);
        this.zzq = clock;
        zzfob zzfobVar = new zzfob(zzftVar.zza, AdFormat.getAdFormat(this.zze.zzb));
        zzfobVar.zza(str);
        this.zzr = new zzfoc(zzfobVar, null);
    }
}
