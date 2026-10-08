package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfcc extends com.google.android.gms.ads.internal.client.zzbw implements com.google.android.gms.ads.internal.overlay.zzr, zzbch {
    protected zzcra zza;
    private final zzcjn zzb;
    private final Context zzc;
    private final String zze;
    private final zzfbw zzf;
    private final zzfbu zzg;
    private final VersionInfoParcel zzh;
    private final zzdvi zzi;
    private zzcqn zzk;
    private AtomicBoolean zzd = new AtomicBoolean();
    private long zzj = -1;

    public zzfcc(zzcjn zzcjnVar, Context context, String str, zzfbw zzfbwVar, zzfbu zzfbuVar, VersionInfoParcel versionInfoParcel, zzdvi zzdviVar) {
        this.zzb = zzcjnVar;
        this.zzc = context;
        this.zze = str;
        this.zzf = zzfbwVar;
        this.zzg = zzfbuVar;
        this.zzh = versionInfoParcel;
        this.zzi = zzdviVar;
        zzfbuVar.zzq(this);
    }

    private final synchronized void zzV(int i) {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzg.zzt();
            zzcqn zzcqnVar = this.zzk;
            if (zzcqnVar != null) {
                com.google.android.gms.ads.internal.zzt.zzg().zzc(zzcqnVar);
            }
            if (this.zza != null) {
                long jElapsedRealtime = -1;
                if (this.zzj != -1) {
                    jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - this.zzj;
                }
                this.zza.zze(jElapsedRealtime, i);
            }
            zzc();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized boolean zzA() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized boolean zzB() {
        return this.zzf.zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzC(zzbyb zzbybVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzD(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzE(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized com.google.android.gms.ads.internal.client.zzed zzF() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzG(com.google.android.gms.ads.internal.client.zzga zzgaVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzH(com.google.android.gms.ads.internal.client.zzeh zzehVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzI(com.google.android.gms.ads.internal.client.zzx zzxVar) {
        this.zzf.zzd(zzxVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzJ(zzbcq zzbcqVar) {
        this.zzg.zzo(zzbcqVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzK(boolean z) {
    }

    final /* synthetic */ void zzL() {
        zzV(5);
    }

    final /* synthetic */ void zzM() {
        this.zzb.zzb().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfcb
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzL();
            }
        });
    }

    final /* synthetic */ zzfbu zzN() {
        return this.zzg;
    }

    final /* synthetic */ zzdvi zzO() {
        return this.zzi;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzP(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzQ(com.google.android.gms.ads.internal.client.zzm zzmVar, com.google.android.gms.ads.internal.client.zzbn zzbnVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzR(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzS(com.google.android.gms.ads.internal.client.zzcv zzcvVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzT(long j) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final long zzU() {
        return 0L;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzY(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbch
    public final void zza() {
        zzV(3);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final IObjectWrapper zzb() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzc() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzcra zzcraVar = this.zza;
        if (zzcraVar != null) {
            zzcraVar.zzd();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzd() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdA() {
        zzcra zzcraVar = this.zza;
        if (zzcraVar != null) {
            zzcraVar.zze(com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - this.zzj, 1);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdB() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdC() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdD() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdE() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzdW(com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdX() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdt() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdu() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdv() {
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    @Override // com.google.android.gms.ads.internal.client.zzbx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean zze(com.google.android.gms.ads.internal.client.zzm r6) throws android.os.RemoteException {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r6.zzb()     // Catch: java.lang.Throwable -> L90
            r1 = 0
            if (r0 == 0) goto L9
            goto L49
        L9:
            com.google.android.gms.internal.ads.zzbge r0 = com.google.android.gms.internal.ads.zzbgs.zzd     // Catch: java.lang.Throwable -> L90
            java.lang.Object r0 = r0.zze()     // Catch: java.lang.Throwable -> L90
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L90
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L90
            if (r0 == 0) goto L2b
            com.google.android.gms.internal.ads.zzbel r0 = com.google.android.gms.internal.ads.zzbeu.zzmi     // Catch: java.lang.Throwable -> L90
            com.google.android.gms.internal.ads.zzbes r2 = com.google.android.gms.ads.internal.client.zzbd.zzc()     // Catch: java.lang.Throwable -> L90
            java.lang.Object r0 = r2.zzd(r0)     // Catch: java.lang.Throwable -> L90
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L90
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L90
            if (r0 == 0) goto L2b
            r0 = 1
            goto L2c
        L2b:
            r0 = r1
        L2c:
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r2 = r5.zzh     // Catch: java.lang.Throwable -> L90
            int r2 = r2.clientJarVersion     // Catch: java.lang.Throwable -> L90
            com.google.android.gms.internal.ads.zzbel r3 = com.google.android.gms.internal.ads.zzbeu.zzmj     // Catch: java.lang.Throwable -> L90
            com.google.android.gms.internal.ads.zzbes r4 = com.google.android.gms.ads.internal.client.zzbd.zzc()     // Catch: java.lang.Throwable -> L90
            java.lang.Object r3 = r4.zzd(r3)     // Catch: java.lang.Throwable -> L90
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L90
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L90
            if (r2 < r3) goto L44
            if (r0 != 0) goto L49
        L44:
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch: java.lang.Throwable -> L90
        L49:
            com.google.android.gms.ads.internal.zzt.zzc()     // Catch: java.lang.Throwable -> L90
            android.content.Context r0 = r5.zzc     // Catch: java.lang.Throwable -> L90
            boolean r0 = com.google.android.gms.ads.internal.util.zzs.zzL(r0)     // Catch: java.lang.Throwable -> L90
            if (r0 == 0) goto L6d
            com.google.android.gms.ads.internal.client.zzc r0 = r6.zzs     // Catch: java.lang.Throwable -> L90
            if (r0 == 0) goto L59
            goto L6d
        L59:
            int r6 = com.google.android.gms.ads.internal.util.zze.zza     // Catch: java.lang.Throwable -> L90
            java.lang.String r6 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.ads.internal.util.client.zzo.zzf(r6)     // Catch: java.lang.Throwable -> L90
            com.google.android.gms.internal.ads.zzfbu r6 = r5.zzg     // Catch: java.lang.Throwable -> L90
            r0 = 4
            r2 = 0
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfhp.zzd(r0, r2, r2)     // Catch: java.lang.Throwable -> L90
            r6.zzdN(r0)     // Catch: java.lang.Throwable -> L90
            monitor-exit(r5)
            return r1
        L6d:
            boolean r0 = r5.zzB()     // Catch: java.lang.Throwable -> L90
            if (r0 == 0) goto L75
            monitor-exit(r5)
            return r1
        L75:
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean     // Catch: java.lang.Throwable -> L90
            r0.<init>()     // Catch: java.lang.Throwable -> L90
            r5.zzd = r0     // Catch: java.lang.Throwable -> L90
            com.google.android.gms.internal.ads.zzfby r0 = new com.google.android.gms.internal.ads.zzfby     // Catch: java.lang.Throwable -> L90
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L90
            com.google.android.gms.internal.ads.zzfbw r1 = r5.zzf     // Catch: java.lang.Throwable -> L90
            java.lang.String r2 = r5.zze     // Catch: java.lang.Throwable -> L90
            com.google.android.gms.internal.ads.zzfbz r3 = new com.google.android.gms.internal.ads.zzfbz     // Catch: java.lang.Throwable -> L90
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L90
            boolean r6 = r1.zza(r6, r2, r0, r3)     // Catch: java.lang.Throwable -> L90
            monitor-exit(r5)
            return r6
        L90:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfcc.zze(com.google.android.gms.ads.internal.client.zzm):boolean");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzf() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzg() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzh() {
        if (this.zza != null) {
            this.zzj = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime();
            int iZzc = this.zza.zzc();
            if (iZzc > 0) {
                zzcqn zzcqnVar = new zzcqn(this.zzb.zzc(), com.google.android.gms.ads.internal.zzt.zzk());
                this.zzk = zzcqnVar;
                zzcqnVar.zzb(iZzc, new Runnable() { // from class: com.google.android.gms.internal.ads.zzfca
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzM();
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzi(com.google.android.gms.ads.internal.client.zzco zzcoVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzj(com.google.android.gms.ads.internal.client.zzcb zzcbVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final Bundle zzk() {
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzl() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzm() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized com.google.android.gms.ads.internal.client.zzr zzn() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzo(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzp(zzbvr zzbvrVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzq(zzbvu zzbvuVar, String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String zzr() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String zzs() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized com.google.android.gms.ads.internal.client.zzea zzt() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String zzu() {
        return this.zze;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzco zzv() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzbk zzw() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzx(zzbfp zzbfpVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzy(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzz(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdY(int i) {
        if (i == 0) {
            throw null;
        }
        int i2 = i - 1;
        if (i2 == 0) {
            zzV(2);
            return;
        }
        if (i2 == 1) {
            zzV(4);
        } else if (i2 != 2) {
            zzV(6);
        } else {
            zzV(3);
        }
    }
}
