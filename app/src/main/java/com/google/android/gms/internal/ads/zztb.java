package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zztb extends Exception {
    public final String zza;
    public final boolean zzb;
    public final zzsy zzc;
    public final String zzd;

    public zztb(zzv zzvVar, Throwable th, boolean z, int i) {
        String string = zzvVar.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 25 + string.length());
        sb.append("Decoder init failed: [");
        sb.append(i);
        sb.append("], ");
        sb.append(string);
        String string2 = sb.toString();
        String str = zzvVar.zzo;
        int iAbs = Math.abs(i);
        StringBuilder sb2 = new StringBuilder(String.valueOf(iAbs).length() + 60);
        sb2.append("androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_neg_");
        sb2.append(iAbs);
        this(string2, th, str, false, null, sb2.toString(), null);
    }

    final /* synthetic */ zztb zza(zztb zztbVar) {
        return new zztb(getMessage(), getCause(), this.zza, false, this.zzc, this.zzd, zztbVar);
    }

    public zztb(zzv zzvVar, Throwable th, boolean z, zzsy zzsyVar) {
        String str = zzsyVar.zza;
        int length = str.length();
        String string = zzvVar.toString();
        StringBuilder sb = new StringBuilder(length + 23 + string.length());
        sb.append("Decoder init failed: ");
        sb.append(str);
        sb.append(", ");
        sb.append(string);
        this(sb.toString(), th, zzvVar.zzo, false, zzsyVar, th instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) th).getDiagnosticInfo() : null, null);
    }

    private zztb(String str, Throwable th, String str2, boolean z, zzsy zzsyVar, String str3, zztb zztbVar) {
        super(str, th);
        this.zza = str2;
        this.zzb = false;
        this.zzc = zzsyVar;
        this.zzd = str3;
    }
}
