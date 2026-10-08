package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgs extends zzgq {
    public final int zzc;

    public zzgs(int i, String str, IOException iOException, Map map, zzgf zzgfVar, byte[] bArr) {
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 15);
        sb.append("Response code: ");
        sb.append(i);
        super(sb.toString(), iOException, zzgfVar, 2004, 1);
        this.zzc = i;
    }
}
