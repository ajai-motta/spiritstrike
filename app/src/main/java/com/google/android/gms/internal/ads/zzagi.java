package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.metadata.id3.ChapterFrame;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzagi extends zzagq {
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final long zze;
    private final zzagq[] zzg;

    public zzagi(String str, int i, int i2, long j, long j2, zzagq[] zzagqVarArr) {
        super(ChapterFrame.ID);
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = j;
        this.zze = j2;
        this.zzg = zzagqVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagi zzagiVar = (zzagi) obj;
            if (this.zzb == zzagiVar.zzb && this.zzc == zzagiVar.zzc && this.zzd == zzagiVar.zzd && this.zze == zzagiVar.zze && Objects.equals(this.zza, zzagiVar.zza) && Arrays.equals(this.zzg, zzagiVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb + 527;
        String str = this.zza;
        long j = this.zze;
        return (((((((i * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + ((int) j)) * 31) + str.hashCode();
    }
}
