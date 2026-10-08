package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzqg extends Exception {
    public final int zza;
    public final boolean zzb;
    public final zzv zzc;

    public zzqg(int i, zzv zzvVar, boolean z) {
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 25);
        sb.append("AudioTrack write failed: ");
        sb.append(i);
        super(sb.toString());
        this.zzb = z;
        this.zza = i;
        this.zzc = zzvVar;
    }
}
