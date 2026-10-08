package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgfi extends RuntimeException {
    public zzgfi() {
        this(0);
    }

    public zzgfi(int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 3);
        sb.append("r: ");
        sb.append(i);
        super(sb.toString());
    }

    public zzgfi(int i, Throwable th) {
        super("r: 2", th);
    }
}
