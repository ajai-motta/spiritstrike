package com.google.android.gms.internal.ads;

import io.ktor.sse.ServerSentEventKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcf extends Exception {
    public zzcf(String str, zzcd zzcdVar) {
        String strValueOf = String.valueOf(zzcdVar);
        StringBuilder sb = new StringBuilder(str.length() + 1 + String.valueOf(strValueOf).length());
        sb.append(str);
        sb.append(ServerSentEventKt.SPACE);
        sb.append(strValueOf);
        super(sb.toString());
    }
}
