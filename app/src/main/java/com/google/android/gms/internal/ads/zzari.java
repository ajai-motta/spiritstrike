package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Date;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzari extends zzieq {
    private Date zzg;
    private Date zzh;
    private long zzi;
    private long zzj;
    private double zzk;
    private float zzl;
    private zzifa zzm;
    private long zzn;

    public zzari() {
        super("mvhd");
        this.zzk = 1.0d;
        this.zzl = 1.0f;
        this.zzm = zzifa.zzj;
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.zzg + ";modificationTime=" + this.zzh + ";timescale=" + this.zzi + ";duration=" + this.zzj + ";rate=" + this.zzk + ";volume=" + this.zzl + ";matrix=" + this.zzm + ";nextTrackId=" + this.zzn + "]";
    }

    public final long zzc() {
        return this.zzi;
    }

    public final long zzd() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzieo
    public final void zze(ByteBuffer byteBuffer) {
        zzh(byteBuffer);
        if (zzg() == 1) {
            this.zzg = zziev.zza(zzare.zzd(byteBuffer));
            this.zzh = zziev.zza(zzare.zzd(byteBuffer));
            this.zzi = zzare.zza(byteBuffer);
            this.zzj = zzare.zzd(byteBuffer);
        } else {
            this.zzg = zziev.zza(zzare.zza(byteBuffer));
            this.zzh = zziev.zza(zzare.zza(byteBuffer));
            this.zzi = zzare.zza(byteBuffer);
            this.zzj = zzare.zza(byteBuffer);
        }
        this.zzk = zzare.zze(byteBuffer);
        byteBuffer.get(new byte[2]);
        this.zzl = ((short) ((r1[1] & 255) | ((short) (65280 & (r1[0] << 8))))) / 256.0f;
        zzare.zzb(byteBuffer);
        zzare.zza(byteBuffer);
        zzare.zza(byteBuffer);
        this.zzm = new zzifa(zzare.zze(byteBuffer), zzare.zze(byteBuffer), zzare.zze(byteBuffer), zzare.zze(byteBuffer), zzare.zzf(byteBuffer), zzare.zzf(byteBuffer), zzare.zzf(byteBuffer), zzare.zze(byteBuffer), zzare.zze(byteBuffer));
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        this.zzn = zzare.zza(byteBuffer);
    }
}
