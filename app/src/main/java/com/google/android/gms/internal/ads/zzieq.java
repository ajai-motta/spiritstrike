package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzieq extends zzieo implements zzarf {
    private int zzg;

    protected zzieq(String str) {
        super("mvhd");
    }

    public final int zzg() {
        if (!this.zzb) {
            zzf();
        }
        return this.zzg;
    }

    protected final long zzh(ByteBuffer byteBuffer) {
        this.zzg = zzare.zzc(byteBuffer.get());
        zzare.zzb(byteBuffer);
        byteBuffer.get();
        return 4L;
    }
}
