package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdwl {
    private final Map zza = new ConcurrentHashMap();

    zzdwl() {
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006b A[Catch: all -> 0x0130, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0015, B:15:0x0035, B:20:0x006b, B:22:0x0075, B:23:0x007d, B:24:0x0084, B:26:0x008a, B:27:0x008e, B:29:0x00a3, B:30:0x00ac, B:32:0x00b2, B:34:0x00c0, B:36:0x00c6, B:37:0x00d8, B:39:0x00de, B:41:0x00f0, B:43:0x00f8, B:47:0x0109, B:49:0x0111, B:51:0x0117, B:53:0x0120, B:54:0x0129, B:16:0x0046, B:17:0x0057), top: B:62:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void zza(long r8, int r10, long r11) {
        /*
            Method dump skipped, instruction units count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdwl.zza(long, int, long):void");
    }

    public final synchronized Map zzb() {
        HashMap map;
        map = new HashMap();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zziu)).booleanValue()) {
            zzc();
            for (Map.Entry entry : this.zza.entrySet()) {
                map.put((zzdwo) entry.getKey(), new ArrayDeque((Collection) entry.getValue()));
            }
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zzc() {
        /*
            r9 = this;
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzt.zzk()
            long r0 = r0.currentTimeMillis()
            java.util.Map r2 = r9.zza
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L12:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto La5
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.ads.zzdwo r4 = (com.google.android.gms.internal.ads.zzdwo) r4
            java.lang.Object r3 = r3.getValue()
            java.util.ArrayDeque r3 = (java.util.ArrayDeque) r3
            int r4 = r4.zzb()
            r5 = 0
            if (r4 == 0) goto L6f
            r7 = 1
            if (r4 == r7) goto L5e
            r7 = 2
            if (r4 == r7) goto L4d
            r7 = 3
            if (r4 == r7) goto L3c
            goto L6f
        L3c:
            com.google.android.gms.internal.ads.zzbel r4 = com.google.android.gms.internal.ads.zzbeu.zziz
            com.google.android.gms.internal.ads.zzbes r7 = com.google.android.gms.ads.internal.client.zzbd.zzc()
            java.lang.Object r4 = r7.zzd(r4)
            java.lang.Long r4 = (java.lang.Long) r4
            long r7 = r4.longValue()
            goto L70
        L4d:
            com.google.android.gms.internal.ads.zzbel r4 = com.google.android.gms.internal.ads.zzbeu.zziy
            com.google.android.gms.internal.ads.zzbes r7 = com.google.android.gms.ads.internal.client.zzbd.zzc()
            java.lang.Object r4 = r7.zzd(r4)
            java.lang.Long r4 = (java.lang.Long) r4
            long r7 = r4.longValue()
            goto L70
        L5e:
            com.google.android.gms.internal.ads.zzbel r4 = com.google.android.gms.internal.ads.zzbeu.zzix
            com.google.android.gms.internal.ads.zzbes r7 = com.google.android.gms.ads.internal.client.zzbd.zzc()
            java.lang.Object r4 = r7.zzd(r4)
            java.lang.Long r4 = (java.lang.Long) r4
            long r7 = r4.longValue()
            goto L70
        L6f:
            r7 = r5
        L70:
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 != 0) goto L78
            r2.remove()
            r7 = r5
        L78:
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 <= 0) goto L12
            java.util.Iterator r4 = r3.iterator()
        L80:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L9a
            java.lang.Object r5 = r4.next()
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = r0 - r5
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L9a
            r4.remove()
            goto L80
        L9a:
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L12
            r2.remove()
            goto L12
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdwl.zzc():void");
    }
}
