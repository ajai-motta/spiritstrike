package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhzn extends IllegalArgumentException {
    zzhzn(int i, int i2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 32 + String.valueOf(i2).length());
        sb.append("Unpaired surrogate at index ");
        sb.append(i);
        sb.append(" of ");
        sb.append(i2);
        super(sb.toString());
    }
}
