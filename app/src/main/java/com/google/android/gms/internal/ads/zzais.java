package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzais implements zzaeh {
    public static final zzais zza = new zzais(true);
    public static final zzais zzb = new zzais(false);
    public final boolean zzc;

    private zzais(boolean z) {
        this.zzc = z;
    }

    public final String toString() {
        boolean z = !this.zzc;
        StringBuilder sb = new StringBuilder(String.valueOf(z).length() + 33);
        sb.append("IncorrectFragmentation{expected=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
