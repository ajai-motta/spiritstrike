package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbxs extends zzbxu {
    private final String zza;
    private final int zzb;

    public zzbxs(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbxs)) {
            return false;
        }
        zzbxs zzbxsVar = (zzbxs) obj;
        if (Objects.equal(this.zza, zzbxsVar.zza)) {
            if (Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzbxsVar.zzb))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbxv
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbxv
    public final int zzc() {
        return this.zzb;
    }
}
