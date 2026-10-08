package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzsg implements zzsv {
    private final MediaCodec zza;
    private final zzsl zzb;
    private final zzsw zzc;
    private final zzsr zzd;
    private boolean zze;
    private int zzf = 0;

    /* synthetic */ zzsg(MediaCodec mediaCodec, HandlerThread handlerThread, zzsw zzswVar, zzsr zzsrVar, byte[] bArr) {
        this.zza = mediaCodec;
        this.zzb = new zzsl(handlerThread);
        this.zzc = zzswVar;
        this.zzd = zzsrVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzt(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zza(int i, int i2, int i3, long j, int i4) {
        this.zzc.zzb(i, 0, i3, j, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzb(int i, int i2, zzhe zzheVar, long j, int i3) {
        this.zzc.zzc(i, 0, zzheVar, j, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzc(int i, boolean z) {
        this.zza.releaseOutputBuffer(i, false);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzd(int i, long j) {
        this.zza.releaseOutputBuffer(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final int zze() {
        this.zzc.zzg();
        return this.zzb.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final int zzf(MediaCodec.BufferInfo bufferInfo) {
        this.zzc.zzg();
        return this.zzb.zzd(bufferInfo);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final MediaFormat zzg() {
        return this.zzb.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final ByteBuffer zzh(int i) {
        return this.zza.getInputBuffer(i);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final ByteBuffer zzi(int i) {
        return this.zza.getOutputBuffer(i);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzj() {
        this.zzc.zze();
        MediaCodec mediaCodec = this.zza;
        mediaCodec.flush();
        this.zzb.zzf();
        mediaCodec.start();
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzk() {
        zzsr zzsrVar;
        zzsr zzsrVar2;
        try {
            try {
                if (this.zzf == 1) {
                    this.zzc.zzf();
                    this.zzb.zzb();
                }
                this.zzf = 2;
            } finally {
                if (!this.zze) {
                    if (Build.VERSION.SDK_INT >= 30 && Build.VERSION.SDK_INT < 33) {
                        this.zza.stop();
                    }
                    if (Build.VERSION.SDK_INT >= 35 && (zzsrVar2 = this.zzd) != null) {
                        zzsrVar2.zzc(this.zza);
                    }
                    this.zza.release();
                    this.zze = true;
                }
            }
        } catch (Throwable th) {
            if (Build.VERSION.SDK_INT >= 35 && (zzsrVar = this.zzd) != null) {
                zzsrVar.zzc(this.zza);
            }
            this.zza.release();
            this.zze = true;
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final boolean zzl(zzsu zzsuVar) {
        this.zzb.zzg(zzsuVar);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzm(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzn() {
        this.zza.detachOutputSurface();
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzo(Bundle bundle) {
        this.zzc.zzd(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzsv
    public final void zzp(int i) {
        this.zza.setVideoScalingMode(i);
    }

    final /* synthetic */ void zzq(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        zzsr zzsrVar;
        zzsl zzslVar = this.zzb;
        MediaCodec mediaCodec = this.zza;
        zzslVar.zza(mediaCodec);
        Trace.beginSection("configureCodec");
        mediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, i);
        Trace.endSection();
        this.zzc.zza();
        Trace.beginSection("startCodec");
        mediaCodec.start();
        Trace.endSection();
        if (Build.VERSION.SDK_INT >= 35 && (zzsrVar = this.zzd) != null) {
            zzsrVar.zzb(mediaCodec);
        }
        this.zzf = 1;
    }
}
