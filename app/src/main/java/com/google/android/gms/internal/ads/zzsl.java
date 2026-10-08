package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.collection.CircularIntArray;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzsl extends MediaCodec.Callback {
    private final HandlerThread zzb;
    private Handler zzc;
    private MediaFormat zzh;
    private MediaFormat zzi;
    private MediaCodec.CodecException zzj;
    private MediaCodec.CryptoException zzk;
    private long zzl;
    private boolean zzm;
    private IllegalStateException zzn;
    private zzsu zzo;
    private final Object zza = new Object();
    private final CircularIntArray zzd = new CircularIntArray();
    private final CircularIntArray zze = new CircularIntArray();
    private final ArrayDeque zzf = new ArrayDeque();
    private final ArrayDeque zzg = new ArrayDeque();

    zzsl(HandlerThread handlerThread) {
        this.zzb = handlerThread;
    }

    private final void zzi() {
        ArrayDeque arrayDeque = this.zzg;
        if (!arrayDeque.isEmpty()) {
            this.zzi = (MediaFormat) arrayDeque.getLast();
        }
        this.zzd.clear();
        this.zze.clear();
        this.zzf.clear();
        arrayDeque.clear();
    }

    private final boolean zzj() {
        return this.zzl > 0 || this.zzm;
    }

    private final void zzk(MediaFormat mediaFormat) {
        this.zze.addLast(-2);
        this.zzg.add(mediaFormat);
    }

    private final void zzl() {
        IllegalStateException illegalStateException = this.zzn;
        if (illegalStateException != null) {
            this.zzn = null;
            throw illegalStateException;
        }
        MediaCodec.CodecException codecException = this.zzj;
        if (codecException != null) {
            this.zzj = null;
            throw codecException;
        }
        MediaCodec.CryptoException cryptoException = this.zzk;
        if (cryptoException == null) {
            return;
        }
        this.zzk = null;
        throw cryptoException;
    }

    @Override // android.media.MediaCodec.Callback
    public final void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.zza) {
            this.zzk = cryptoException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.zza) {
            this.zzj = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.zza) {
            this.zzd.addLast(i);
            zzsu zzsuVar = this.zzo;
            if (zzsuVar != null) {
                zzte zzteVar = ((zztc) zzsuVar).zza;
                if (zzteVar.zzbe() != null) {
                    zzteVar.zzbe().zza();
                }
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.zza) {
            MediaFormat mediaFormat = this.zzi;
            if (mediaFormat != null) {
                zzk(mediaFormat);
                this.zzi = null;
            }
            this.zze.addLast(i);
            this.zzf.add(bufferInfo);
            zzsu zzsuVar = this.zzo;
            if (zzsuVar != null) {
                zzte zzteVar = ((zztc) zzsuVar).zza;
                if (zzteVar.zzbe() != null) {
                    zzteVar.zzbe().zza();
                }
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.zza) {
            zzk(mediaFormat);
            this.zzi = null;
        }
    }

    public final void zza(MediaCodec mediaCodec) {
        zzgmd.zzh(this.zzc == null);
        HandlerThread handlerThread = this.zzb;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        mediaCodec.setCallback(this, handler);
        this.zzc = handler;
    }

    public final void zzb() {
        synchronized (this.zza) {
            this.zzm = true;
            this.zzb.quit();
            zzi();
        }
    }

    public final int zzc() {
        synchronized (this.zza) {
            zzl();
            int iPopFirst = -1;
            if (zzj()) {
                return -1;
            }
            CircularIntArray circularIntArray = this.zzd;
            if (!circularIntArray.isEmpty()) {
                iPopFirst = circularIntArray.popFirst();
            }
            return iPopFirst;
        }
    }

    public final int zzd(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.zza) {
            zzl();
            if (zzj()) {
                return -1;
            }
            CircularIntArray circularIntArray = this.zze;
            if (circularIntArray.isEmpty()) {
                return -1;
            }
            int iPopFirst = circularIntArray.popFirst();
            if (iPopFirst >= 0) {
                this.zzh.getClass();
                MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) this.zzf.remove();
                bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
            } else if (iPopFirst == -2) {
                this.zzh = (MediaFormat) this.zzg.remove();
                iPopFirst = -2;
            }
            return iPopFirst;
        }
    }

    public final MediaFormat zze() {
        MediaFormat mediaFormat;
        synchronized (this.zza) {
            mediaFormat = this.zzh;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public final void zzf() {
        synchronized (this.zza) {
            this.zzl++;
            Handler handler = this.zzc;
            String str = zzep.zza;
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzsk
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzh();
                }
            });
        }
    }

    public final void zzg(zzsu zzsuVar) {
        synchronized (this.zza) {
            this.zzo = zzsuVar;
        }
    }

    final /* synthetic */ void zzh() {
        Object obj = this.zza;
        synchronized (obj) {
            if (this.zzm) {
                return;
            }
            long j = this.zzl - 1;
            this.zzl = j;
            if (j > 0) {
                return;
            }
            if (j >= 0) {
                zzi();
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException();
            synchronized (obj) {
                this.zzn = illegalStateException;
            }
        }
    }
}
