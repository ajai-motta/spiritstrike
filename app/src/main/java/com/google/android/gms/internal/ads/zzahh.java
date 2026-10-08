package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzahh implements Comparable {
    public final long zza;
    public final long zzb;

    public zzahh(long j, long j2) {
        this.zza = j;
        this.zzb = j2;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Long.compare(this.zza, ((zzahh) obj).zza);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzahh)) {
            return false;
        }
        zzahh zzahhVar = (zzahh) obj;
        return this.zza == zzahhVar.zza && this.zzb == zzahhVar.zzb;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), Long.valueOf(this.zzb));
    }
}
