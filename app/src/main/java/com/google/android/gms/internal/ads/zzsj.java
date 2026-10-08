package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzsj implements zzsw {
    private static final ArrayDeque zza = new ArrayDeque();
    private static final Object zzb = new Object();
    private final MediaCodec zzc;
    private final HandlerThread zzd;
    private Handler zze;
    private final AtomicReference zzf;
    private final zzdf zzg;
    private boolean zzh;

    public zzsj(MediaCodec mediaCodec, HandlerThread handlerThread) {
        zzdf zzdfVar = new zzdf(zzdc.zza);
        this.zzc = mediaCodec;
        this.zzd = handlerThread;
        this.zzg = zzdfVar;
        this.zzf = new AtomicReference();
    }

    private static zzsi zzi() {
        ArrayDeque arrayDeque = zza;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return new zzsi();
            }
            return (zzsi) arrayDeque.removeFirst();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zza() {
        if (this.zzh) {
            return;
        }
        HandlerThread handlerThread = this.zzd;
        handlerThread.start();
        this.zze = new zzsh(this, handlerThread.getLooper());
        this.zzh = true;
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzb(int i, int i2, int i3, long j, int i4) {
        zzg();
        zzsi zzsiVarZzi = zzi();
        zzsiVarZzi.zza(i, 0, i3, j, i4);
        Handler handler = this.zze;
        String str = zzep.zza;
        handler.obtainMessage(1, zzsiVarZzi).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzc(int i, int i2, zzhe zzheVar, long j, int i3) {
        zzg();
        zzsi zzsiVarZzi = zzi();
        zzsiVarZzi.zza(i, 0, 0, j, i3);
        MediaCodec.CryptoInfo cryptoInfo = zzsiVarZzi.zzd;
        cryptoInfo.numSubSamples = zzheVar.zzf;
        cryptoInfo.numBytesOfClearData = zzj(zzheVar.zzd, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = zzj(zzheVar.zze, cryptoInfo.numBytesOfEncryptedData);
        byte[] bArrZzk = zzk(zzheVar.zzb, cryptoInfo.key);
        bArrZzk.getClass();
        cryptoInfo.key = bArrZzk;
        byte[] bArrZzk2 = zzk(zzheVar.zza, cryptoInfo.iv);
        bArrZzk2.getClass();
        cryptoInfo.iv = bArrZzk2;
        cryptoInfo.mode = zzheVar.zzc;
        if (Build.VERSION.SDK_INT >= 24) {
            cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(zzheVar.zzg, zzheVar.zzh));
        }
        Handler handler = this.zze;
        String str = zzep.zza;
        handler.obtainMessage(2, zzsiVarZzi).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzd(Bundle bundle) {
        zzg();
        Handler handler = this.zze;
        String str = zzep.zza;
        handler.obtainMessage(4, bundle).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zze() {
        if (this.zzh) {
            try {
                Handler handler = this.zze;
                handler.getClass();
                handler.removeCallbacksAndMessages(null);
                zzdf zzdfVar = this.zzg;
                zzdfVar.zzb();
                Handler handler2 = this.zze;
                handler2.getClass();
                handler2.obtainMessage(3).sendToTarget();
                zzdfVar.zzc();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzf() {
        if (this.zzh) {
            zze();
            this.zzd.quit();
        }
        this.zzh = false;
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzg() {
        RuntimeException runtimeException = (RuntimeException) this.zzf.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0083 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ void zzh(android.os.Message r11) {
        /*
            r10 = this;
            int r0 = r11.what
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 2
            if (r0 == r1) goto L37
            r1 = 3
            if (r0 == r1) goto L31
            r1 = 4
            if (r0 == r1) goto L20
            java.util.concurrent.atomic.AtomicReference r0 = r10.zzf
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            int r11 = r11.what
            java.lang.String r11 = java.lang.String.valueOf(r11)
            r1.<init>(r11)
            androidx.compose.animation.core.ComplexDouble$$ExternalSyntheticBackport0.m(r0, r2, r1)
            goto L76
        L20:
            java.lang.Object r11 = r11.obj
            android.os.Bundle r11 = (android.os.Bundle) r11
            android.media.MediaCodec r0 = r10.zzc     // Catch: java.lang.RuntimeException -> L2a
            r0.setParameters(r11)     // Catch: java.lang.RuntimeException -> L2a
            goto L76
        L2a:
            r11 = move-exception
            java.util.concurrent.atomic.AtomicReference r0 = r10.zzf
            androidx.compose.animation.core.ComplexDouble$$ExternalSyntheticBackport0.m(r0, r2, r11)
            goto L76
        L31:
            com.google.android.gms.internal.ads.zzdf r11 = r10.zzg
            r11.zza()
            goto L76
        L37:
            java.lang.Object r11 = r11.obj
            com.google.android.gms.internal.ads.zzsi r11 = (com.google.android.gms.internal.ads.zzsi) r11
            int r4 = r11.zza
            int r0 = r11.zzb
            android.media.MediaCodec$CryptoInfo r6 = r11.zzd
            long r7 = r11.zze
            int r9 = r11.zzf
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzsj.zzb     // Catch: java.lang.RuntimeException -> L53
            monitor-enter(r0)     // Catch: java.lang.RuntimeException -> L53
            android.media.MediaCodec r3 = r10.zzc     // Catch: java.lang.Throwable -> L50
            r5 = 0
            r3.queueSecureInputBuffer(r4, r5, r6, r7, r9)     // Catch: java.lang.Throwable -> L50
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L50
            goto L75
        L50:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L50
            throw r1     // Catch: java.lang.RuntimeException -> L53
        L53:
            r0 = move-exception
            java.util.concurrent.atomic.AtomicReference r1 = r10.zzf
            androidx.compose.animation.core.ComplexDouble$$ExternalSyntheticBackport0.m(r1, r2, r0)
            goto L75
        L5a:
            java.lang.Object r11 = r11.obj
            com.google.android.gms.internal.ads.zzsi r11 = (com.google.android.gms.internal.ads.zzsi) r11
            int r4 = r11.zza
            int r0 = r11.zzb
            int r6 = r11.zzc
            long r7 = r11.zze
            int r9 = r11.zzf
            android.media.MediaCodec r3 = r10.zzc     // Catch: java.lang.RuntimeException -> L6f
            r5 = 0
            r3.queueInputBuffer(r4, r5, r6, r7, r9)     // Catch: java.lang.RuntimeException -> L6f
            goto L75
        L6f:
            r0 = move-exception
            java.util.concurrent.atomic.AtomicReference r1 = r10.zzf
            androidx.compose.animation.core.ComplexDouble$$ExternalSyntheticBackport0.m(r1, r2, r0)
        L75:
            r2 = r11
        L76:
            if (r2 == 0) goto L83
            java.util.ArrayDeque r11 = com.google.android.gms.internal.ads.zzsj.zza
            monitor-enter(r11)
            r11.add(r2)     // Catch: java.lang.Throwable -> L80
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L80
            return
        L80:
            r0 = move-exception
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L80
            throw r0
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsj.zzh(android.os.Message):void");
    }

    private static int[] zzj(int[] iArr, int[] iArr2) {
        int length;
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < (length = iArr.length)) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    private static byte[] zzk(byte[] bArr, byte[] bArr2) {
        int length;
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < (length = bArr.length)) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
