package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzge {
    private Uri zza;
    private Map zzb;
    private long zzc;
    private final long zzd;
    private int zze;

    public zzge() {
        this.zzb = Collections.emptyMap();
        this.zzd = -1L;
    }

    /* synthetic */ zzge(zzgf zzgfVar, byte[] bArr) {
        this.zza = zzgfVar.zza;
        this.zzb = zzgfVar.zzd;
        this.zzc = zzgfVar.zze;
        this.zzd = zzgfVar.zzf;
        this.zze = zzgfVar.zzg;
    }

    public final zzge zza(Uri uri) {
        this.zza = uri;
        return this;
    }

    public final zzge zzb(Map map) {
        this.zzb = map;
        return this;
    }

    public final zzge zzc(long j) {
        this.zzc = j;
        return this;
    }

    public final zzge zzd(int i) {
        this.zze = 6;
        return this;
    }

    public final zzgf zze() {
        zzgmd.zzk(this.zza, "The uri must be set.");
        return new zzgf(this.zza, 0L, 1, null, this.zzb, this.zzc, this.zzd, null, this.zze, null, null);
    }
}
