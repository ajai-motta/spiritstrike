package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbc {
    private static zzbc zza;
    private static final Object zzb = new Object();
    private final zzdx zzc;
    private final zzbx zzd;

    private zzbc(Context context) {
        zzbx zzbxVarZzb = zzbx.zzb(context);
        zzes zzesVar = new zzes();
        this.zzd = zzbxVarZzb;
        this.zzc = zzesVar;
    }

    public static zzbc zzb(Context context) {
        zzbc zzbcVar;
        synchronized (zzb) {
            if (zza == null) {
                zza = new zzbc(context);
            }
            zzbcVar = zza;
        }
        return zzbcVar;
    }

    public final boolean zza(String str) {
        if (this.zzc.zza()) {
            this.zzd.zzf(str, System.currentTimeMillis());
            return true;
        }
        Log.w("GoogleTagManager", "Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return false;
    }
}
