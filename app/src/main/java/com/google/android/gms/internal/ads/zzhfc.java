package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhfc {
    public static final zzhsz zza = zzhsz.zza(new byte[0]);

    public static final zzhsz zza(int i) {
        return zzhsz.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(i).array());
    }

    public static final zzhsz zzb(int i) {
        return zzhsz.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(i).array());
    }
}
