package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzsx extends zzhf {
    public final int zza;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzsx(Throwable th, zzsy zzsyVar) {
        int errorCode;
        String str = zzsyVar == null ? null : zzsyVar.zza;
        String.valueOf(str);
        super("Decoder failed: ".concat(String.valueOf(str)), th);
        if (th instanceof MediaCodec.CodecException) {
            MediaCodec.CodecException codecException = (MediaCodec.CodecException) th;
            codecException.getDiagnosticInfo();
            errorCode = codecException.getErrorCode();
        } else {
            errorCode = 0;
        }
        this.zza = errorCode;
    }
}
