package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgrv extends zzgry {
    final char[] zza;

    private zzgrv(zzgru zzgruVar) {
        super(zzgruVar, null);
        this.zza = new char[512];
        zzgmd.zza(zzgruVar.zzf().length == 16);
        for (int i = 0; i < 256; i++) {
            this.zza[i] = zzgruVar.zza(i >>> 4);
            this.zza[i | 256] = zzgruVar.zza(i & 15);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgry, com.google.android.gms.internal.ads.zzgrz
    final void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzgmd.zzo(0, i2, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i3] & 255;
            char[] cArr = this.zza;
            appendable.append(cArr[i4]);
            appendable.append(cArr[i4 | 256]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgry, com.google.android.gms.internal.ads.zzgrz
    final int zzb(byte[] bArr, CharSequence charSequence) throws zzgrx {
        if (charSequence.length() % 2 == 1) {
            int length = charSequence.length();
            StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 21);
            sb.append("Invalid input length ");
            sb.append(length);
            throw new zzgrx(sb.toString());
        }
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            zzgru zzgruVar = this.zzb;
            bArr[i2] = (byte) (zzgruVar.zzc(charSequence.charAt(i + 1)) | (zzgruVar.zzc(charSequence.charAt(i)) << 4));
            i += 2;
            i2++;
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgry
    final zzgrz zzc(zzgru zzgruVar, Character ch) {
        return new zzgrv(zzgruVar);
    }

    zzgrv(String str, String str2) {
        this(new zzgru("base16()", "0123456789ABCDEF".toCharArray()));
    }
}
