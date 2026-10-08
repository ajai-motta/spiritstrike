package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfiy {
    private final zzfic zza;
    private final zzfiv zzb;
    private final zzfhy zzc;
    private zzfje zze;
    private int zzf = 1;
    private final ArrayDeque zzd = new ArrayDeque();

    public zzfiy(zzfic zzficVar, zzfhy zzfhyVar, zzfiv zzfivVar) {
        this.zza = zzficVar;
        this.zzc = zzfhyVar;
        this.zzb = zzfivVar;
        zzfhyVar.zza(new zzfhx() { // from class: com.google.android.gms.internal.ads.zzfix
            @Override // com.google.android.gms.internal.ads.zzfhx
            public final /* synthetic */ void zza() {
                this.zza.zzc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        r3 = new com.google.android.gms.internal.ads.zzfje(r4.zza, r4.zzb, r0);
        r4.zze = r3;
        r3.zza(new com.google.android.gms.internal.ads.zzfit(r4, r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0069, code lost:
    
        return;
     */
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void zzd() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.google.android.gms.internal.ads.zzbel r0 = com.google.android.gms.internal.ads.zzbeu.zzgO     // Catch: java.lang.Throwable -> L6c
            com.google.android.gms.internal.ads.zzbes r1 = com.google.android.gms.ads.internal.client.zzbd.zzc()     // Catch: java.lang.Throwable -> L6c
            java.lang.Object r0 = r1.zzd(r0)     // Catch: java.lang.Throwable -> L6c
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L6c
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L6c
            if (r0 == 0) goto L2d
            com.google.android.gms.internal.ads.zzcbj r0 = com.google.android.gms.ads.internal.zzt.zzh()     // Catch: java.lang.Throwable -> L6c
            com.google.android.gms.ads.internal.util.zzg r0 = r0.zzo()     // Catch: java.lang.Throwable -> L6c
            com.google.android.gms.internal.ads.zzcbe r0 = r0.zzi()     // Catch: java.lang.Throwable -> L6c
            boolean r0 = r0.zzi()     // Catch: java.lang.Throwable -> L6c
            if (r0 == 0) goto L26
            goto L2d
        L26:
            java.util.ArrayDeque r0 = r4.zzd     // Catch: java.lang.Throwable -> L6c
            r0.clear()     // Catch: java.lang.Throwable -> L6c
            monitor-exit(r4)
            return
        L2d:
            boolean r0 = r4.zzi()     // Catch: java.lang.Throwable -> L6c
            if (r0 == 0) goto L6a
        L33:
            java.util.ArrayDeque r0 = r4.zzd     // Catch: java.lang.Throwable -> L6c
            boolean r1 = r0.isEmpty()     // Catch: java.lang.Throwable -> L6c
            if (r1 != 0) goto L6a
            java.lang.Object r0 = r0.pollFirst()     // Catch: java.lang.Throwable -> L6c
            com.google.android.gms.internal.ads.zzfiw r0 = (com.google.android.gms.internal.ads.zzfiw) r0     // Catch: java.lang.Throwable -> L6c
            if (r0 == 0) goto L55
            com.google.android.gms.internal.ads.zzfim r1 = r0.zzb()     // Catch: java.lang.Throwable -> L6c
            if (r1 == 0) goto L33
            com.google.android.gms.internal.ads.zzfic r1 = r4.zza     // Catch: java.lang.Throwable -> L6c
            com.google.android.gms.internal.ads.zzfim r2 = r0.zzb()     // Catch: java.lang.Throwable -> L6c
            boolean r1 = r1.zzc(r2)     // Catch: java.lang.Throwable -> L6c
            if (r1 == 0) goto L33
        L55:
            com.google.android.gms.internal.ads.zzfic r1 = r4.zza     // Catch: java.lang.Throwable -> L6c
            com.google.android.gms.internal.ads.zzfiv r2 = r4.zzb     // Catch: java.lang.Throwable -> L6c
            com.google.android.gms.internal.ads.zzfje r3 = new com.google.android.gms.internal.ads.zzfje     // Catch: java.lang.Throwable -> L6c
            r3.<init>(r1, r2, r0)     // Catch: java.lang.Throwable -> L6c
            r4.zze = r3     // Catch: java.lang.Throwable -> L6c
            com.google.android.gms.internal.ads.zzfit r1 = new com.google.android.gms.internal.ads.zzfit     // Catch: java.lang.Throwable -> L6c
            r1.<init>(r4, r0)     // Catch: java.lang.Throwable -> L6c
            r3.zza(r1)     // Catch: java.lang.Throwable -> L6c
            monitor-exit(r4)
            return
        L6a:
            monitor-exit(r4)
            return
        L6c:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfiy.zzd():void");
    }

    private final synchronized boolean zzi() {
        return this.zze == null;
    }

    public final synchronized void zza(zzfiw zzfiwVar) {
        this.zzd.add(zzfiwVar);
    }

    public final synchronized ListenableFuture zzb(zzfiw zzfiwVar) {
        this.zzf = 2;
        if (zzi()) {
            return null;
        }
        return this.zze.zzb(zzfiwVar);
    }

    final /* synthetic */ void zzc() {
        synchronized (this) {
            this.zzf = 1;
            zzd();
        }
    }

    final /* synthetic */ ArrayDeque zze() {
        return this.zzd;
    }

    final /* synthetic */ void zzf(zzfje zzfjeVar) {
        this.zze = null;
    }

    final /* synthetic */ int zzg() {
        return this.zzf;
    }
}
