package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzqd extends Exception {
    public final int zza;
    public final boolean zzb;

    public zzqd(int i, int i2, int i3, int i4, int i5, zzv zzvVar, boolean z, Exception exc) {
        String strValueOf = String.valueOf(zzvVar);
        int length = String.valueOf(i).length();
        int length2 = String.valueOf(i2).length();
        int length3 = String.valueOf(i3).length();
        int length4 = String.valueOf(i4).length();
        int length5 = String.valueOf(i5).length();
        int length6 = String.valueOf(strValueOf).length();
        int i6 = length + 31 + length2 + 2 + length3 + 2 + length4 + 2 + length5 + 2;
        String str = true != z ? "" : " (recoverable)";
        StringBuilder sb = new StringBuilder(i6 + length6 + str.length());
        sb.append("AudioTrack init failed ");
        sb.append(i);
        sb.append(" Config(");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append(") ");
        sb.append(strValueOf);
        sb.append(str);
        super(sb.toString(), exc);
        this.zza = i;
        this.zzb = z;
    }
}
