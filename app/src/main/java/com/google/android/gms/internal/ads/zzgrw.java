package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgrw extends zzgry {
    private zzgrw(zzgru zzgruVar, Character ch) {
        super(zzgruVar, ch);
        zzgmd.zza(zzgruVar.zzf().length == 64);
    }

    @Override // com.google.android.gms.internal.ads.zzgry, com.google.android.gms.internal.ads.zzgrz
    final void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzgmd.zzo(0, i2, bArr.length);
        for (int i4 = i2; i4 >= 3; i4 -= 3) {
            int i5 = bArr[i3] & 255;
            int i6 = bArr[i3 + 1] & 255;
            int i7 = bArr[i3 + 2] & 255;
            zzgru zzgruVar = this.zzb;
            int i8 = (i6 << 8) | (i5 << 16) | i7;
            appendable.append(zzgruVar.zza(i8 >>> 18));
            appendable.append(zzgruVar.zza((i8 >>> 12) & 63));
            appendable.append(zzgruVar.zza((i8 >>> 6) & 63));
            appendable.append(zzgruVar.zza(i8 & 63));
            i3 += 3;
        }
        if (i3 < i2) {
            zze(appendable, bArr, i3, i2 - i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgry, com.google.android.gms.internal.ads.zzgrz
    final int zzb(byte[] bArr, CharSequence charSequence) throws zzgrx {
        CharSequence charSequenceZzg = zzg(charSequence);
        int length = charSequenceZzg.length();
        zzgru zzgruVar = this.zzb;
        if (!zzgruVar.zzb(length)) {
            int length2 = charSequenceZzg.length();
            StringBuilder sb = new StringBuilder(String.valueOf(length2).length() + 21);
            sb.append("Invalid input length ");
            sb.append(length2);
            throw new zzgrx(sb.toString());
        }
        int i = 0;
        int i2 = 0;
        while (i < charSequenceZzg.length()) {
            int i3 = i2 + 1;
            int iZzc = (zzgruVar.zzc(charSequenceZzg.charAt(i + 1)) << 12) | (zzgruVar.zzc(charSequenceZzg.charAt(i)) << 18);
            bArr[i2] = (byte) (iZzc >>> 16);
            int i4 = i + 2;
            if (i4 < charSequenceZzg.length()) {
                int i5 = i + 3;
                int iZzc2 = iZzc | (zzgruVar.zzc(charSequenceZzg.charAt(i4)) << 6);
                int i6 = i2 + 2;
                bArr[i3] = (byte) ((iZzc2 >>> 8) & 255);
                if (i5 < charSequenceZzg.length()) {
                    i += 4;
                    i2 += 3;
                    bArr[i6] = (byte) ((iZzc2 | zzgruVar.zzc(charSequenceZzg.charAt(i5))) & 255);
                } else {
                    i2 = i6;
                    i = i5;
                }
            } else {
                i = i4;
                i2 = i3;
            }
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgry
    final zzgrz zzc(zzgru zzgruVar, Character ch) {
        return new zzgrw(zzgruVar, ch);
    }

    zzgrw(String str, String str2, Character ch) {
        this(new zzgru(str, str2.toCharArray()), ch);
    }
}
