package com.google.android.gms.internal.ads;

import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzieu extends zziez {
    final String zza;

    public zzieu(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zziez
    public final void zza(String str) {
        String str2 = this.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str).length());
        sb.append(str2);
        sb.append(":");
        sb.append(str);
        Log.d("isoparser", sb.toString());
    }
}
