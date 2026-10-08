package com.google.android.recaptcha.internal;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzpb extends zzpc implements Serializable {
    final byte[] zza;

    @Override // com.google.android.recaptcha.internal.zzpc
    public final int zzb() {
        return this.zza.length * 8;
    }

    @Override // com.google.android.recaptcha.internal.zzpc
    final boolean zzc(zzpc zzpcVar) {
        int length = zzpcVar.zze().length;
        byte[] bArr = this.zza;
        if (bArr.length != length) {
            return false;
        }
        boolean z = true;
        for (int i = 0; i < bArr.length; i++) {
            z &= bArr[i] == zzpcVar.zze()[i];
        }
        return z;
    }

    @Override // com.google.android.recaptcha.internal.zzpc
    public final byte[] zzd() {
        return (byte[]) this.zza.clone();
    }

    @Override // com.google.android.recaptcha.internal.zzpc
    final byte[] zze() {
        return this.zza;
    }

    zzpb(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.recaptcha.internal.zzpc
    public final int zza() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        if (length < 4) {
            throw new IllegalStateException(zzmg.zza("HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", Integer.valueOf(length)));
        }
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }
}
