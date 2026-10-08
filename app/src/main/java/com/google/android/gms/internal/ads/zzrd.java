package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzrd implements zzqk {
    final /* synthetic */ zzrh zza;

    /* synthetic */ zzrd(zzrh zzrhVar, byte[] bArr) {
        Objects.requireNonNull(zzrhVar);
        this.zza = zzrhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zza(long j) {
        zzrh zzrhVar = this.zza;
        if (zzrhVar.zzI() != null) {
            ((zzrk) zzrhVar.zzI()).zza.zzaw().zzd(j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zzb(long j, long j2, long j3, long j4) {
        zzrh zzrhVar = this.zza;
        long jZzF = zzrhVar.zzF();
        long jZzG = zzrhVar.zzG();
        int length = String.valueOf(j).length();
        int length2 = String.valueOf(j2).length();
        int length3 = String.valueOf(j3).length();
        int length4 = String.valueOf(j4).length();
        StringBuilder sb = new StringBuilder(length + 54 + length2 + 2 + length3 + 2 + length4 + 2 + String.valueOf(jZzF).length() + 2 + String.valueOf(jZzG).length());
        sb.append("Spurious audio timestamp (frame position mismatch): ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(j4);
        sb.append(", ");
        sb.append(jZzF);
        sb.append(", ");
        sb.append(jZzG);
        zzdt.zzc("DefaultAudioSink", sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zzc(long j, long j2, long j3, long j4) {
        zzrh zzrhVar = this.zza;
        long jZzF = zzrhVar.zzF();
        long jZzG = zzrhVar.zzG();
        int length = String.valueOf(j).length();
        int length2 = String.valueOf(j2).length();
        int length3 = String.valueOf(j3).length();
        int length4 = String.valueOf(j4).length();
        StringBuilder sb = new StringBuilder(length + 52 + length2 + 2 + length3 + 2 + length4 + 2 + String.valueOf(jZzF).length() + 2 + String.valueOf(jZzG).length());
        sb.append("Spurious audio timestamp (system clock mismatch): ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(j4);
        sb.append(", ");
        sb.append(jZzF);
        sb.append(", ");
        sb.append(jZzG);
        zzdt.zzc("DefaultAudioSink", sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zzd(long j) {
        StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 41);
        sb.append("Ignoring impossibly large audio latency: ");
        sb.append(j);
        zzdt.zzc("DefaultAudioSink", sb.toString());
    }
}
