package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaiy {
    public final zzajf zza;
    public final zzaji zzb;
    public final zzaem zzc;
    public final zzaen zzd;
    public int zze;
    public zzv zzf;

    public zzaiy(zzajf zzajfVar, zzaji zzajiVar, zzaem zzaemVar) {
        this.zza = zzajfVar;
        this.zzb = zzajiVar;
        this.zzc = zzaemVar;
        this.zzd = MimeTypes.AUDIO_TRUEHD.equals(zzajfVar.zzg.zzo) ? new zzaen() : null;
    }
}
