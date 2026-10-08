package com.google.android.recaptcha.internal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzpm extends zzpo {
    zzpm(String str, String str2, Character ch) {
        zzpk zzpkVar = new zzpk(str, str2.toCharArray());
        super(zzpkVar, ch);
        zzmd.zza(zzpkVar.zzf.length == 64);
    }

    @Override // com.google.android.recaptcha.internal.zzpo, com.google.android.recaptcha.internal.zzpp
    final int zza(byte[] bArr, CharSequence charSequence) throws zzpn {
        CharSequence charSequenceZze = zze(charSequence);
        int length = charSequenceZze.length();
        zzpk zzpkVar = this.zza;
        if (!zzpkVar.zzc(length)) {
            throw new zzpn("Invalid input length " + charSequenceZze.length());
        }
        int i = 0;
        int i2 = 0;
        while (i < charSequenceZze.length()) {
            int i3 = i2 + 1;
            int iZzb = (zzpkVar.zzb(charSequenceZze.charAt(i + 1)) << 12) | (zzpkVar.zzb(charSequenceZze.charAt(i)) << 18);
            bArr[i2] = (byte) (iZzb >>> 16);
            int i4 = i + 2;
            if (i4 < charSequenceZze.length()) {
                int i5 = i + 3;
                int iZzb2 = iZzb | (zzpkVar.zzb(charSequenceZze.charAt(i4)) << 6);
                int i6 = i2 + 2;
                bArr[i3] = (byte) ((iZzb2 >>> 8) & 255);
                if (i5 < charSequenceZze.length()) {
                    i += 4;
                    i2 += 3;
                    bArr[i6] = (byte) ((iZzb2 | zzpkVar.zzb(charSequenceZze.charAt(i5))) & 255);
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

    @Override // com.google.android.recaptcha.internal.zzpo, com.google.android.recaptcha.internal.zzpp
    final void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzmd.zzd(0, i2, bArr.length);
        for (int i4 = i2; i4 >= 3; i4 -= 3) {
            int i5 = bArr[i3] & 255;
            int i6 = bArr[i3 + 1] & 255;
            int i7 = bArr[i3 + 2] & 255;
            zzpk zzpkVar = this.zza;
            int i8 = (i6 << 8) | (i5 << 16) | i7;
            appendable.append(zzpkVar.zza(i8 >>> 18));
            appendable.append(zzpkVar.zza((i8 >>> 12) & 63));
            appendable.append(zzpkVar.zza((i8 >>> 6) & 63));
            appendable.append(zzpkVar.zza(i8 & 63));
            i3 += 3;
        }
        if (i3 < i2) {
            zzf(appendable, bArr, i3, i2 - i3);
        }
    }
}
