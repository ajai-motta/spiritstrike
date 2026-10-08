package com.google.android.gms.tagmanager;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzeb implements Runnable {
    private final Context zza;
    private final String zzb;
    private final String zzc;
    private zzdb zzd;
    private volatile zzak zze;
    private volatile String zzf;
    private volatile String zzg;

    public zzeb(Context context, String str, zzak zzakVar) {
        this.zza = context;
        this.zzb = str;
        this.zze = zzakVar;
        String strConcat = "/r?id=".concat(String.valueOf(str));
        this.zzc = strConcat;
        this.zzf = strConcat;
        this.zzg = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x01b3 A[Catch: all -> 0x01c6, TryCatch #2 {, blocks: (B:36:0x012f, B:38:0x0135, B:40:0x0144, B:41:0x015f, B:43:0x0161, B:44:0x017d, B:46:0x01b3, B:47:0x01ba), top: B:69:0x012f }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 569
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzeb.run():void");
    }

    final void zza(String str) {
        if (str == null) {
            str = this.zzc;
        } else {
            zzdc.zzb.zza("Setting CTFE URL path: ".concat(str));
        }
        this.zzf = str;
    }

    final void zzb(zzdb zzdbVar) {
        this.zzd = zzdbVar;
    }

    final void zzc(String str) {
        zzdc.zzb.zza("Setting previous container version: ".concat(String.valueOf(str)));
        this.zzg = str;
    }
}
