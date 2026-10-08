package com.google.android.gms.internal.ads;

import android.os.Build;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zztm implements zztp {
    static final /* synthetic */ zztm zza = new zztm();

    private /* synthetic */ zztm() {
    }

    @Override // com.google.android.gms.internal.ads.zztp
    public final /* synthetic */ int zza(Object obj) {
        int i = zztq.zza;
        String str = ((zzsy) obj).zza;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (Build.VERSION.SDK_INT >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }
}
