package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzapc;
import com.google.android.gms.internal.ads.zzapx;
import com.google.android.gms.internal.ads.zzcca;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@ParametersAreNonnullByDefault
public final class zzbl {
    private static zzapx zza;
    private static final Object zzb = new Object();

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[Catch: all -> 0x0040, TryCatch #0 {, blocks: (B:7:0x0010, B:9:0x0014, B:11:0x001d, B:13:0x002f, B:15:0x003c, B:14:0x0034, B:16:0x003e), top: B:21:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzbl(android.content.Context r4) {
        /*
            r3 = this;
            r3.<init>()
            android.content.Context r0 = r4.getApplicationContext()
            if (r0 == 0) goto Ld
            android.content.Context r4 = r4.getApplicationContext()
        Ld:
            java.lang.Object r0 = com.google.android.gms.ads.internal.util.zzbl.zzb
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzapx r1 = com.google.android.gms.ads.internal.util.zzbl.zza     // Catch: java.lang.Throwable -> L40
            if (r1 != 0) goto L3e
            com.google.android.gms.internal.ads.zzbeu.zza(r4)     // Catch: java.lang.Throwable -> L40
            boolean r1 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()     // Catch: java.lang.Throwable -> L40
            if (r1 != 0) goto L34
            com.google.android.gms.internal.ads.zzbel r1 = com.google.android.gms.internal.ads.zzbeu.zzeY     // Catch: java.lang.Throwable -> L40
            com.google.android.gms.internal.ads.zzbes r2 = com.google.android.gms.ads.internal.client.zzbd.zzc()     // Catch: java.lang.Throwable -> L40
            java.lang.Object r1 = r2.zzd(r1)     // Catch: java.lang.Throwable -> L40
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L40
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L34
            com.google.android.gms.internal.ads.zzapx r4 = com.google.android.gms.ads.internal.util.zzay.zzb(r4)     // Catch: java.lang.Throwable -> L40
            goto L3c
        L34:
            r1 = 0
            r2 = r1
            com.google.android.gms.internal.ads.zzaqi r2 = (com.google.android.gms.internal.ads.zzaqi) r2     // Catch: java.lang.Throwable -> L40
            com.google.android.gms.internal.ads.zzapx r4 = com.google.android.gms.internal.ads.zzaqz.zza(r4, r1)     // Catch: java.lang.Throwable -> L40
        L3c:
            com.google.android.gms.ads.internal.util.zzbl.zza = r4     // Catch: java.lang.Throwable -> L40
        L3e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L40
            return
        L40:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L40
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzbl.<init>(android.content.Context):void");
    }

    public final ListenableFuture zza(String str) {
        zzcca zzccaVar = new zzcca();
        zza.zzb(new zzbk(str, null, zzccaVar));
        return zzccaVar;
    }

    public final ListenableFuture zzb(int i, String str, Map map, byte[] bArr) {
        zzbi zzbiVar = new zzbi(null);
        zzbg zzbgVar = new zzbg(this, str, zzbiVar);
        com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
        zzbh zzbhVar = new zzbh(this, i, str, zzbiVar, zzbgVar, bArr, map, zzlVar);
        if (com.google.android.gms.ads.internal.util.client.zzl.zzj()) {
            try {
                zzlVar.zzb(str, "GET", zzbhVar.zzm(), zzbhVar.zzn());
            } catch (zzapc e) {
                String message = e.getMessage();
                int i2 = zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi(message);
            }
        }
        zza.zzb(zzbhVar);
        return zzbiVar;
    }
}
