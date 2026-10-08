package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhtz implements CharSequence {
    private char[] zza;
    private String zzb;

    private zzhtz() {
        throw null;
    }

    /* synthetic */ zzhtz(byte[] bArr) {
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.zza[i];
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.zza.length;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return new String(this.zza, i, i2 - i);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        if (this.zzb == null) {
            this.zzb = new String(this.zza);
        }
        return this.zzb;
    }

    final void zza(char[] cArr) {
        this.zza = cArr;
        this.zzb = null;
    }
}
