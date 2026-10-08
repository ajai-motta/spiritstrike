package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzeyz implements zzeya {
    private final Context zza;
    private final ScheduledExecutorService zzb;
    private final Executor zzc;
    private final int zzd;
    private final boolean zze;
    private final boolean zzf;
    private final zzcbb zzg;

    zzeyz(zzcbb zzcbbVar, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i, boolean z, boolean z2) {
        this.zzg = zzcbbVar;
        this.zza = context;
        this.zzb = scheduledExecutorService;
        this.zzc = executor;
        this.zzd = i;
        this.zze = z;
        this.zzf = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        zzgua zzguaVarZzw = zzgua.zzw(this.zzg.zza(this.zza, this.zzd));
        zzglu zzgluVar = new zzglu() { // from class: com.google.android.gms.internal.ads.zzeyy
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzc((AdvertisingIdClient.Info) obj);
            }
        };
        Executor executor = this.zzc;
        return (zzgua) zzgui.zzg((zzgua) zzgui.zzi((zzgua) zzgui.zzk(zzguaVarZzw, zzgluVar, executor), ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbn)).longValue(), TimeUnit.MILLISECONDS, this.zzb), Throwable.class, new zzglu() { // from class: com.google.android.gms.internal.ads.zzeyx
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzd((Throwable) obj);
            }
        }, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 40;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ com.google.android.gms.internal.ads.zzeza zzc(com.google.android.gms.ads.identifier.AdvertisingIdClient.Info r8) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzfwt r0 = new com.google.android.gms.internal.ads.zzfwt
            r0.<init>()
            boolean r1 = r7.zze
            if (r1 != 0) goto L1c
            com.google.android.gms.internal.ads.zzbel r1 = com.google.android.gms.internal.ads.zzbeu.zzdF
            com.google.android.gms.internal.ads.zzbes r2 = com.google.android.gms.ads.internal.client.zzbd.zzc()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L2f
            goto L71
        L1c:
            com.google.android.gms.internal.ads.zzbel r1 = com.google.android.gms.internal.ads.zzbeu.zzdG
            com.google.android.gms.internal.ads.zzbes r2 = com.google.android.gms.ads.internal.client.zzbd.zzc()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L2f
            goto L71
        L2f:
            android.content.Context r0 = r7.zza     // Catch: java.lang.IllegalArgumentException -> L60 java.io.IOException -> L62
            com.google.android.gms.internal.ads.zzfwx r1 = com.google.android.gms.internal.ads.zzfwx.zzh(r0)     // Catch: java.lang.IllegalArgumentException -> L60 java.io.IOException -> L62
            java.lang.Object r2 = java.util.Objects.requireNonNull(r8)     // Catch: java.lang.IllegalArgumentException -> L60 java.io.IOException -> L62
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r2 = (com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) r2     // Catch: java.lang.IllegalArgumentException -> L60 java.io.IOException -> L62
            java.lang.String r2 = r2.getId()     // Catch: java.lang.IllegalArgumentException -> L60 java.io.IOException -> L62
            java.lang.Object r2 = java.util.Objects.requireNonNull(r2)     // Catch: java.lang.IllegalArgumentException -> L60 java.io.IOException -> L62
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.IllegalArgumentException -> L60 java.io.IOException -> L62
            java.lang.String r3 = r0.getPackageName()     // Catch: java.lang.IllegalArgumentException -> L60 java.io.IOException -> L62
            com.google.android.gms.internal.ads.zzbel r0 = com.google.android.gms.internal.ads.zzbeu.zzdL     // Catch: java.lang.IllegalArgumentException -> L60 java.io.IOException -> L62
            com.google.android.gms.internal.ads.zzbes r4 = com.google.android.gms.ads.internal.client.zzbd.zzc()     // Catch: java.lang.IllegalArgumentException -> L60 java.io.IOException -> L62
            java.lang.Object r0 = r4.zzd(r0)     // Catch: java.lang.IllegalArgumentException -> L60 java.io.IOException -> L62
            java.lang.Long r0 = (java.lang.Long) r0     // Catch: java.lang.IllegalArgumentException -> L60 java.io.IOException -> L62
            long r4 = r0.longValue()     // Catch: java.lang.IllegalArgumentException -> L60 java.io.IOException -> L62
            boolean r6 = r7.zzf     // Catch: java.lang.IllegalArgumentException -> L60 java.io.IOException -> L62
            com.google.android.gms.internal.ads.zzfwt r0 = r1.zzj(r2, r3, r4, r6)     // Catch: java.lang.IllegalArgumentException -> L60 java.io.IOException -> L62
            goto L71
        L60:
            r0 = move-exception
            goto L63
        L62:
            r0 = move-exception
        L63:
            java.lang.String r1 = "AdIdInfoSignalSource.getPaidV1"
            com.google.android.gms.internal.ads.zzcbj r2 = com.google.android.gms.ads.internal.zzt.zzh()
            r2.zzg(r0, r1)
            com.google.android.gms.internal.ads.zzfwt r0 = new com.google.android.gms.internal.ads.zzfwt
            r0.<init>()
        L71:
            com.google.android.gms.internal.ads.zzeza r1 = new com.google.android.gms.internal.ads.zzeza
            r2 = 0
            r1.<init>(r8, r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeyz.zzc(com.google.android.gms.ads.identifier.AdvertisingIdClient$Info):com.google.android.gms.internal.ads.zzeza");
    }

    final /* synthetic */ zzeza zzd(Throwable th) {
        com.google.android.gms.ads.internal.client.zzbb.zza();
        ContentResolver contentResolver = this.zza.getContentResolver();
        return new zzeza(null, contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id"), new zzfwt());
    }
}
