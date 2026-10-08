package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzww extends zzat {
    public final zzgpe zzc;

    public zzww(String str, Uri uri, List list) {
        super(str, null, false, 1);
        this.zzc = zzgpe.zzq(list);
    }

    @Override // com.google.android.gms.internal.ads.zzat, java.lang.Throwable
    public final String getMessage() {
        zzgpe zzgpeVar = this.zzc;
        String message = super.getMessage();
        if (zzgpeVar.isEmpty()) {
            return message;
        }
        int length = message.length();
        String strValueOf = String.valueOf(zzgpeVar);
        StringBuilder sb = new StringBuilder(length + 17 + String.valueOf(strValueOf).length());
        sb.append(message);
        sb.append("\nsniff failures: ");
        sb.append(strValueOf);
        return sb.toString();
    }
}
