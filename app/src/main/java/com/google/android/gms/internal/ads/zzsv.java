package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zzsv {

    /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzsv$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
    public final /* synthetic */ class CC {
        public static boolean $default$zzl(zzsv _this, zzsu zzsuVar) {
            return false;
        }
    }

    void zza(int i, int i2, int i3, long j, int i4);

    void zzb(int i, int i2, zzhe zzheVar, long j, int i3);

    void zzc(int i, boolean z);

    void zzd(int i, long j);

    int zze();

    int zzf(MediaCodec.BufferInfo bufferInfo);

    MediaFormat zzg();

    ByteBuffer zzh(int i);

    ByteBuffer zzi(int i);

    void zzj();

    void zzk();

    boolean zzl(zzsu zzsuVar);

    void zzm(Surface surface);

    void zzn();

    void zzo(Bundle bundle);

    void zzp(int i);
}
