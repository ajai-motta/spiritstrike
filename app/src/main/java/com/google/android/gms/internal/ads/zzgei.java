package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgei extends RuntimeException {
    zzgei(int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 3);
        sb.append("r: ");
        sb.append(i);
        super(sb.toString());
    }
}
