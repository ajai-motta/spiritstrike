package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdyj {
    private final zzdxt zza;
    private final zzdsv zzb;
    private final Object zzc = new Object();
    private final List zzd = new ArrayList();
    private boolean zze;

    zzdyj(zzdxt zzdxtVar, zzdsv zzdsvVar) {
        this.zza = zzdxtVar;
        this.zzb = zzdsvVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final void zzc(List list) {
        zzdsu zzdsuVarZzc;
        zzdsu zzdsuVarZzc2;
        zzbtx zzbtxVar;
        synchronized (this.zzc) {
            if (this.zze) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzbnw zzbnwVar = (zzbnw) it.next();
                String string = (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzkp)).booleanValue() || (zzdsuVarZzc2 = this.zzb.zzc(zzbnwVar.zza)) == null || (zzbtxVar = zzdsuVarZzc2.zzc) == null) ? "" : zzbtxVar.toString();
                String str = string;
                boolean z = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzkq)).booleanValue() && (zzdsuVarZzc = this.zzb.zzc(zzbnwVar.zza)) != null && zzdsuVarZzc.zzd;
                List list2 = this.zzd;
                String str2 = zzbnwVar.zza;
                list2.add(new zzdyi(str2, str, this.zzb.zzd(str2), zzbnwVar.zzb ? 1 : 0, zzbnwVar.zzd, zzbnwVar.zzc, z));
            }
            this.zze = true;
        }
    }

    public final void zza() {
        this.zza.zzb(new zzdyh(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d A[Catch: all -> 0x003d, LOOP:0: B:13:0x0027->B:15:0x002d, LOOP_END, TryCatch #0 {, blocks: (B:4:0x0008, B:6:0x000c, B:8:0x0014, B:9:0x001c, B:10:0x001f, B:12:0x0021, B:13:0x0027, B:15:0x002d, B:16:0x003b), top: B:21:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONArray zzb() throws org.json.JSONException {
        /*
            r4 = this;
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.lang.Object r1 = r4.zzc
            monitor-enter(r1)
            boolean r2 = r4.zze     // Catch: java.lang.Throwable -> L3d
            if (r2 != 0) goto L21
            com.google.android.gms.internal.ads.zzdxt r2 = r4.zza     // Catch: java.lang.Throwable -> L3d
            boolean r3 = r2.zze()     // Catch: java.lang.Throwable -> L3d
            if (r3 == 0) goto L1c
            java.util.List r2 = r2.zzd()     // Catch: java.lang.Throwable -> L3d
            r4.zzc(r2)     // Catch: java.lang.Throwable -> L3d
            goto L21
        L1c:
            r4.zza()     // Catch: java.lang.Throwable -> L3d
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L3d
            goto L3c
        L21:
            java.util.List r2 = r4.zzd     // Catch: java.lang.Throwable -> L3d
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L3d
        L27:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L3d
            if (r3 == 0) goto L3b
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L3d
            com.google.android.gms.internal.ads.zzdyi r3 = (com.google.android.gms.internal.ads.zzdyi) r3     // Catch: java.lang.Throwable -> L3d
            org.json.JSONObject r3 = r3.zza()     // Catch: java.lang.Throwable -> L3d
            r0.put(r3)     // Catch: java.lang.Throwable -> L3d
            goto L27
        L3b:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L3d
        L3c:
            return r0
        L3d:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L3d
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdyj.zzb():org.json.JSONArray");
    }
}
