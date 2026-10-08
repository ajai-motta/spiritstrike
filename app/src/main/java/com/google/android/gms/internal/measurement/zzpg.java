package com.google.android.gms.internal.measurement;

import android.os.StrictMode;
import android.util.Log;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzpg {
    public static final /* synthetic */ int zzb = 0;
    private volatile zzqs zzd;
    private final zzlk zze;
    private final String zzf;
    private final String zzg;
    private final boolean zzh;
    private final ImmutableSet zzi;
    private final zzps zzj;
    private final zzqt zzk;
    private static final zzpe zzc = new zzpe(null);
    static final zzon zza = new zzon(zzox.zza, false, false, false, false, ImmutableSet.of());

    /* synthetic */ zzpg(zzlk zzlkVar, zzon zzonVar, String str, byte[] bArr) {
        this.zze = zzlkVar;
        String strZza = zzonVar.zza(zzlkVar.zzc());
        this.zzf = strZza;
        this.zzg = "";
        this.zzh = zzonVar.zzb();
        this.zzi = zzonVar.zzc();
        this.zzd = null;
        this.zzj = new zzps();
        this.zzk = new zzqt(zzlkVar, strZza, "", false);
    }

    public static zzpe zzd() {
        return zzc;
    }

    private final zzqs zzq() {
        zzqs zzqsVar = this.zzd;
        if (zzqsVar == null) {
            synchronized (this) {
                zzqsVar = this.zzd;
                if (zzqsVar == null) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
                    try {
                        zzqs zzqsVarZza = this.zzk.zza();
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                        if (!zzqsVarZza.zzk()) {
                            zzlk zzlkVar = this.zze;
                            zzlkVar.zzd().zza();
                            if (this.zzh || this.zzk.zzb() || !zzqsVarZza.zzd().isEmpty()) {
                                zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzoy
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        this.zza.zzf();
                                    }
                                });
                                zzlkVar.zzk().zza(zzqsVarZza.zze(), this.zzi, this.zzf);
                                if (!this.zzg.equals("")) {
                                    zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzoq
                                        @Override // java.lang.Runnable
                                        public final /* synthetic */ void run() {
                                            this.zza.zzh();
                                        }
                                    });
                                }
                                if (this.zzk.zzb()) {
                                    zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzor
                                        @Override // java.lang.Runnable
                                        public final /* synthetic */ void run() {
                                            this.zza.zzi();
                                        }
                                    });
                                }
                            } else {
                                zzlkVar.zzg().execute(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzop
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        this.zza.zzg();
                                    }
                                });
                                zzqsVarZza = zzqs.zzb(zzqv.zzi(), zzqsVarZza);
                            }
                        }
                        if (!this.zzh || !zzqsVarZza.zzj()) {
                            this.zzd = zzqsVarZza;
                        }
                        zzqsVar = zzqsVarZza;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                        throw th;
                    }
                }
            }
        }
        return zzqsVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzr, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final void zzg() {
        final zzqt zzqtVar = this.zzk;
        final ListenableFuture listenableFutureZzd = zzqtVar.zzd(this.zzg);
        Objects.requireNonNull(zzqtVar);
        AsyncFunction asyncFunction = new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzpf
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return zzqtVar.zzc((zzqv) obj);
            }
        };
        zzlk zzlkVar = this.zze;
        Futures.transformAsync(listenableFutureZzd, asyncFunction, zzlkVar.zzg()).addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzov
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzm(listenableFutureZzd);
            }
        }, zzlkVar.zzg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033 A[Catch: CancellationException | ExecutionException -> 0x006b, ExecutionException -> 0x006d, TryCatch #3 {CancellationException | ExecutionException -> 0x006b, blocks: (B:2:0x0000, B:4:0x0018, B:12:0x0025, B:14:0x0033, B:16:0x003b, B:20:0x0047, B:22:0x004b, B:6:0x001c, B:26:0x006a, B:8:0x001f, B:11:0x0024, B:18:0x003f, B:19:0x0046), top: B:35:0x0000, inners: #1 }] */
    /* JADX INFO: renamed from: zzs, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void zzm(com.google.common.util.concurrent.ListenableFuture r4) {
        /*
            r3 = this;
            java.lang.Object r4 = com.google.common.util.concurrent.Futures.getDone(r4)     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.android.gms.internal.measurement.zzqv r4 = (com.google.android.gms.internal.measurement.zzqv) r4     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.android.gms.internal.measurement.zzqr r0 = new com.google.android.gms.internal.measurement.zzqr     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            r1 = 6
            r2 = 2
            r0.<init>(r1, r2)     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.android.gms.internal.measurement.zzqs r0 = com.google.android.gms.internal.measurement.zzqs.zza(r4, r0)     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            boolean r1 = r3.zzh     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.common.base.Preconditions.checkNotNull(r0)     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            if (r1 != 0) goto L1c
            com.google.android.gms.internal.measurement.zzqs r2 = r3.zzd     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            if (r2 != 0) goto L25
        L1c:
            monitor-enter(r3)     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            if (r1 != 0) goto L3f
            com.google.android.gms.internal.measurement.zzqs r2 = r3.zzd     // Catch: java.lang.Throwable -> L68
            if (r2 != 0) goto L24
            goto L3f
        L24:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L68
        L25:
            com.google.common.collect.ImmutableMap r1 = r2.zzf()     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.common.collect.ImmutableMap r0 = r0.zzf()     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            boolean r0 = r1.equals(r0)     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            if (r0 != 0) goto L47
            com.google.android.gms.internal.measurement.zzlk r4 = r3.zze     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.android.gms.internal.measurement.zzqm r4 = r4.zzj()     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            if (r4 == 0) goto L9d
            r4.zza()     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            return
        L3f:
            r3.zzd = r0     // Catch: java.lang.Throwable -> L68
            com.google.android.gms.internal.measurement.zzps r0 = r3.zzj     // Catch: java.lang.Throwable -> L68
            r0.zzb()     // Catch: java.lang.Throwable -> L68
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L68
        L47:
            boolean r0 = r3.zzh     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            if (r0 == 0) goto L9d
            com.google.android.gms.internal.measurement.zzlk r0 = r3.zze     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.android.gms.internal.measurement.zzmj r1 = r0.zzh()     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            java.lang.String r4 = r4.zza()     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.common.util.concurrent.ListenableFuture r4 = r1.zzb(r4)     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            java.lang.Class<java.lang.Throwable> r1 = java.lang.Throwable.class
            com.google.android.gms.internal.measurement.zzow r2 = new com.google.android.gms.internal.measurement.zzow     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            r2.<init>()     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.common.util.concurrent.ListeningScheduledExecutorService r0 = r0.zzg()     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            com.google.common.util.concurrent.Futures.catching(r4, r1, r2, r0)     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
            return
        L68:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L68
            throw r4     // Catch: java.util.concurrent.CancellationException -> L6b java.util.concurrent.ExecutionException -> L6d
        L6b:
            r4 = move-exception
            goto L6e
        L6d:
            r4 = move-exception
        L6e:
            java.lang.Throwable r0 = r4.getCause()
            boolean r0 = r0 instanceof java.lang.SecurityException
            if (r0 != 0) goto L9d
            java.lang.String r0 = r3.zzf
            java.lang.String r1 = java.lang.String.valueOf(r0)
            int r1 = r1.length()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = r1 + 64
            r2.<init>(r1)
            java.lang.String r1 = "Unable to update local snapshot for "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = ", may result in stale flags."
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "FlagStore"
            android.util.Log.w(r1, r0, r4)
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzpg.zzm(com.google.common.util.concurrent.ListenableFuture):void");
    }

    final Object zza(String str, boolean z) {
        return zzq().zzf().get(str);
    }

    final String zzb() {
        return this.zzf;
    }

    final zzps zzc() {
        return this.zzj;
    }

    final /* synthetic */ ListenableFuture zzf() {
        ListenableFuture listenableFutureZzb;
        zzqs zzqsVarZzq = zzq();
        String strZzd = zzqsVarZzq.zzd();
        zzlk zzlkVar = this.zze;
        zzqn zzqnVarZzc = zzlkVar.zzd().zzc(false);
        if (zzqnVarZzc.zze()) {
            if (Strings.isNullOrEmpty(strZzd) && !zzqnVarZzc.zzd()) {
                return Futures.immediateVoidFuture();
            }
            zzmb zzmbVarZzb = zzme.zzb();
            zzmbVarZzb.zzb(zzqsVarZzq.zzi());
            if (!Strings.isNullOrEmpty(strZzd)) {
                zzmbVarZzb.zza(strZzd);
            }
            if (zzqnVarZzc.zzd()) {
                zzmbVarZzb.zzc(this.zzf);
            }
            listenableFutureZzb = zzlkVar.zzh().zzc((zzme) zzmbVarZzb.zzbd());
        } else {
            if (Strings.isNullOrEmpty(strZzd)) {
                return Futures.immediateVoidFuture();
            }
            listenableFutureZzb = zzlkVar.zzh().zzb(strZzd);
        }
        return Futures.catchingAsync(listenableFutureZzb, zzmk.class, new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzos
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return this.zza.zzj((zzmk) obj);
            }
        }, zzlkVar.zzg());
    }

    final /* synthetic */ void zzh() {
        zzlk zzlkVar = this.zze;
        final ListenableFuture listenableFutureZza = zzpu.zza(zzlkVar, this.zzf, this.zzg);
        listenableFutureZza.addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzot
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzk(listenableFutureZza);
            }
        }, zzlkVar.zzg());
    }

    final /* synthetic */ void zzi() {
        this.zze.zzf().zza(zzabz.FILE, this.zzh, zzou.zza);
    }

    final /* synthetic */ ListenableFuture zzj(zzmk zzmkVar) {
        int iZza = zzmkVar.zza();
        if ((iZza == 29501 || iZza == 29537 || iZza == 29538 || iZza == 29539 || iZza == 29540 || iZza == 29541 || iZza == 29542 || iZza == 29543 || iZza == 29544) && !this.zzk.zzb()) {
            zzg();
        }
        return Futures.immediateVoidFuture();
    }

    final /* synthetic */ void zzk(ListenableFuture listenableFuture) {
        try {
            Futures.getDone(listenableFuture);
        } catch (Exception e) {
            String str = this.zzf;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 73);
            sb.append("Failed to store account on flag read for: ");
            sb.append(str);
            sb.append(" which may lead to stale flags.");
            Log.w("FlagStore", sb.toString(), e);
        }
    }

    final /* synthetic */ Void zzn(Throwable th) {
        String str = this.zzf;
        String.valueOf(str);
        Log.w("FlagStore", "Failed to commit to updated flags for ".concat(String.valueOf(str)), th);
        return null;
    }

    final /* synthetic */ boolean zzo() {
        if (!this.zzh) {
            return true;
        }
        zzqs zzqsVar = this.zzd;
        if (zzqsVar != null && (zzqsVar.zzh() || zzqsVar.zzg() || this.zzk.zzb())) {
            synchronized (this) {
                zzqs zzqsVar2 = this.zzd;
                if (zzqsVar2 != null && (zzqsVar2.zzh() || zzqsVar2.zzg() || this.zzk.zzb())) {
                    this.zzd = null;
                    this.zzj.zzb();
                }
            }
        }
        return false;
    }

    final /* synthetic */ String zzp() {
        return this.zzf;
    }
}
