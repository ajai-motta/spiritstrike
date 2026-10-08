package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
class zzgry extends zzgrz {
    private volatile zzgrz zza;
    final zzgru zzb;
    final Character zzc;

    zzgry(zzgru zzgruVar, Character ch) {
        this.zzb = zzgruVar;
        boolean z = true;
        if (ch != null) {
            ch.charValue();
            if (zzgruVar.zze('=')) {
                z = false;
            }
        }
        zzgmd.zzf(z, "Padding character %s was already in alphabet", ch);
        this.zzc = ch;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgry) {
            zzgry zzgryVar = (zzgry) obj;
            if (this.zzb.equals(zzgryVar.zzb) && Objects.equals(this.zzc, zzgryVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Character ch = this.zzc;
        return Objects.hashCode(ch) ^ this.zzb.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        zzgru zzgruVar = this.zzb;
        sb.append(zzgruVar);
        if (8 % zzgruVar.zzb != 0) {
            Character ch = this.zzc;
            if (ch == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(ch);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgrz
    void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzgmd.zzo(0, i2, bArr.length);
        while (i3 < i2) {
            int i4 = this.zzb.zzd;
            zze(appendable, bArr, i3, Math.min(i4, i2 - i3));
            i3 += i4;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgrz
    int zzb(byte[] bArr, CharSequence charSequence) throws zzgrx {
        int i;
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
        int i2 = 0;
        int i3 = 0;
        while (i2 < charSequenceZzg.length()) {
            long jZzc = 0;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                i = zzgruVar.zzc;
                if (i4 >= i) {
                    break;
                }
                jZzc <<= zzgruVar.zzb;
                if (i2 + i4 < charSequenceZzg.length()) {
                    jZzc |= (long) zzgruVar.zzc(charSequenceZzg.charAt(i5 + i2));
                    i5++;
                }
                i4++;
            }
            int i6 = zzgruVar.zzd;
            int i7 = i5 * zzgruVar.zzb;
            int i8 = (i6 - 1) * 8;
            while (i8 >= (i6 * 8) - i7) {
                bArr[i3] = (byte) ((jZzc >>> i8) & 255);
                i8 -= 8;
                i3++;
            }
            i2 += i;
        }
        return i3;
    }

    zzgrz zzc(zzgru zzgruVar, Character ch) {
        return new zzgry(zzgruVar, ch);
    }

    @Override // com.google.android.gms.internal.ads.zzgrz
    final int zzd(int i) {
        zzgru zzgruVar = this.zzb;
        return zzgruVar.zzc * zzgsm.zzb(i, zzgruVar.zzd, RoundingMode.CEILING);
    }

    final void zze(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzgmd.zzo(i, i + i2, bArr.length);
        zzgru zzgruVar = this.zzb;
        int i3 = zzgruVar.zzd;
        int i4 = 0;
        zzgmd.zza(i2 <= i3);
        long j = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            j = (j | ((long) (bArr[i + i5] & 255))) << 8;
        }
        int i6 = (i2 + 1) * 8;
        int i7 = zzgruVar.zzb;
        while (i4 < i2 * 8) {
            appendable.append(zzgruVar.zza(zzgruVar.zza & ((int) (j >>> ((i6 - i7) - i4)))));
            i4 += i7;
        }
        Character ch = this.zzc;
        if (ch != null) {
            while (i4 < i3 * 8) {
                ch.charValue();
                appendable.append('=');
                i4 += i7;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgrz
    final int zzf(int i) {
        return (int) (((((long) this.zzb.zzb) * ((long) i)) + 7) / 8);
    }

    @Override // com.google.android.gms.internal.ads.zzgrz
    public final zzgrz zzh() {
        return this.zzc == null ? this : zzc(this.zzb, null);
    }

    @Override // com.google.android.gms.internal.ads.zzgrz
    public final zzgrz zzi() {
        zzgrz zzgrzVarZzc = this.zza;
        if (zzgrzVarZzc == null) {
            zzgru zzgruVar = this.zzb;
            zzgru zzgruVarZzd = zzgruVar.zzd();
            zzgrzVarZzc = zzgruVarZzd == zzgruVar ? this : zzc(zzgruVarZzd, this.zzc);
            this.zza = zzgrzVarZzc;
        }
        return zzgrzVarZzc;
    }

    zzgry(String str, String str2, Character ch) {
        this(new zzgru(str, str2.toCharArray()), ch);
    }

    @Override // com.google.android.gms.internal.ads.zzgrz
    final CharSequence zzg(CharSequence charSequence) {
        charSequence.getClass();
        Character ch = this.zzc;
        if (ch == null) {
            return charSequence;
        }
        ch.charValue();
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (charSequence.charAt(length) == '=');
        return charSequence.subSequence(0, length + 1);
    }
}
