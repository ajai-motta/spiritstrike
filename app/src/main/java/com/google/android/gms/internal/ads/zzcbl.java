package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import java.math.BigInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcbl {
    private BigInteger zza = BigInteger.ONE;
    private String zzb = AppEventsConstants.EVENT_PARAM_VALUE_NO;

    public final synchronized String zza() {
        String string;
        string = this.zza.toString();
        this.zza = this.zza.add(BigInteger.ONE);
        this.zzb = string;
        return string;
    }

    public final synchronized String zzb() {
        return this.zzb;
    }
}
