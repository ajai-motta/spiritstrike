package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzag {
    public final Uri zza;
    public final String zzb;
    public final zzad zzc;
    public final zzy zzd;
    public final List zze;
    public final String zzf;
    public final zzgpe zzg;
    public final Object zzh;
    public final long zzi;

    static {
        String str = zzep.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
    }

    /* synthetic */ zzag(Uri uri, String str, zzad zzadVar, zzy zzyVar, List list, String str2, zzgpe zzgpeVar, Object obj, long j, byte[] bArr) {
        this.zza = uri;
        int i = zzas.zza;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = list;
        this.zzf = null;
        this.zzg = zzgpeVar;
        int i2 = zzgpe.zzd;
        zzgpb zzgpbVar = new zzgpb();
        if (zzgpeVar.size() > 0) {
            throw null;
        }
        zzgpbVar.zzi();
        this.zzh = null;
        this.zzi = C.TIME_UNSET;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzag)) {
            return false;
        }
        zzag zzagVar = (zzag) obj;
        if (this.zza.equals(zzagVar.zza)) {
            String str = zzagVar.zzb;
            zzad zzadVar = zzagVar.zzc;
            zzy zzyVar = zzagVar.zzd;
            if (this.zze.equals(zzagVar.zze)) {
                String str2 = zzagVar.zzf;
                if (this.zzg.equals(zzagVar.zzg)) {
                    Object obj2 = zzagVar.zzh;
                    long j = zzagVar.zzi;
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) ((((long) (((((this.zza.hashCode() * 923521) + this.zze.hashCode()) * 961) + this.zzg.hashCode()) * 31)) * 31) + C.TIME_UNSET);
    }
}
