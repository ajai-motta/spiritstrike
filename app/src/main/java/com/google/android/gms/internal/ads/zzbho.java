package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbho {
    private final Context zza;

    public zzbho(Context context) {
        this.zza = context;
    }

    public final void zza(zzbwl zzbwlVar) {
        try {
            ((zzbhp) com.google.android.gms.ads.internal.util.client.zzs.zza(this.zza, "com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy", zzbhn.zza)).zze(zzbwlVar);
        } catch (RemoteException e) {
            String message = e.getMessage();
            String.valueOf(message);
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Error calling setFlagsAccessedBeforeInitializedListener: ".concat(String.valueOf(message)));
        } catch (com.google.android.gms.ads.internal.util.client.zzr e2) {
            String message2 = e2.getMessage();
            String.valueOf(message2);
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not load com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy:".concat(String.valueOf(message2)));
        }
    }
}
