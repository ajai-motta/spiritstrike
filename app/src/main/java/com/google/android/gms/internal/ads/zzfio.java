package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfio implements zzfim {
    private final String zza;

    public zzfio(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzfim
    public final boolean equals(Object obj) {
        if (obj instanceof zzfio) {
            return this.zza.equals(((zzfio) obj).zza);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfim
    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza;
    }
}
