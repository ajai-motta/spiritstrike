package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzdzv extends Exception {
    private final int zza;

    public zzdzv(int i) {
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }

    public zzdzv(int i, String str) {
        super(str);
        this.zza = i;
    }

    public zzdzv(int i, String str, Throwable th) {
        super(str, th);
        this.zza = 1;
    }
}
