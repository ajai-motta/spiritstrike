package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.internal.ads.zzbyo;
import com.google.android.gms.internal.ads.zzbyx;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfb extends com.google.android.gms.ads.preload.zzb {
    public zzfb(Context context) {
        super(context, AdFormat.REWARDED);
    }

    public final RewardedAd zza(String str) {
        zzbyo zzbyoVarZzq;
        try {
            zzbyoVarZzq = this.zza.zzq(str);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            zzbyoVarZzq = null;
        }
        if (zzbyoVarZzq == null) {
            return null;
        }
        return new zzbyx(zzj(), zzbyoVarZzq);
    }
}
