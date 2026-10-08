package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzagj extends zzagq {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final String[] zzd;
    private final zzagq[] zze;

    public zzagj(String str, boolean z, boolean z2, String[] strArr, zzagq[] zzagqVarArr) {
        super(ChapterTocFrame.ID);
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = strArr;
        this.zze = zzagqVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagj zzagjVar = (zzagj) obj;
            if (this.zzb == zzagjVar.zzb && this.zzc == zzagjVar.zzc && Objects.equals(this.zza, zzagjVar.zza) && Arrays.equals(this.zzd, zzagjVar.zzd) && Arrays.equals(this.zze, zzagjVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.zzb ? 1 : 0) + 527) * 31) + (this.zzc ? 1 : 0)) * 31) + this.zza.hashCode();
    }
}
