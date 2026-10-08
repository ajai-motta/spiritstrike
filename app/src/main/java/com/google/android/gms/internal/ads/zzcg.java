package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zzcg {
    public static final ByteBuffer zza = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzcg$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
    public final /* synthetic */ class CC {
        public static long $default$zza(zzcg _this, long j) {
            return j;
        }

        @Deprecated
        public static void $default$zzh(zzcg _this) {
            throw new IllegalStateException("AudioProcessor must implement at least one #flush() overload.");
        }
    }

    long zza(long j);

    zzcd zzb(zzcd zzcdVar) throws zzcf;

    boolean zzc();

    void zzd(ByteBuffer byteBuffer);

    void zze();

    ByteBuffer zzf();

    boolean zzg();

    @Deprecated
    void zzh();

    void zzi(zzce zzceVar);

    void zzj();
}
