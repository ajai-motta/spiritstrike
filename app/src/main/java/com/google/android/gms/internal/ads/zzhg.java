package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhg extends IllegalStateException {
    public zzhg(int i, int i2) {
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21 + String.valueOf(i2).length() + 1);
        sb.append("Buffer too small (");
        sb.append(i);
        sb.append(" < ");
        sb.append(i2);
        sb.append(")");
        super(sb.toString());
    }
}
