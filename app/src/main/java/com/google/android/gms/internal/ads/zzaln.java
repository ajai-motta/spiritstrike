package com.google.android.gms.internal.ads;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaln implements zzaki {
    private final zzeg zza = new zzeg();
    private final boolean zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final float zzf;
    private final int zzg;

    public zzaln(List list) {
        int size = list.size();
        String str = C.SANS_SERIF_NAME;
        if (size != 1 || (((byte[]) list.get(0)).length != 48 && ((byte[]) list.get(0)).length != 53)) {
            this.zzc = 0;
            this.zzd = -1;
            this.zze = C.SANS_SERIF_NAME;
            this.zzb = false;
            this.zzf = 0.85f;
            this.zzg = -1;
            return;
        }
        byte[] bArr = (byte[]) list.get(0);
        this.zzc = bArr[24];
        this.zzd = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
        this.zze = true == "Serif".equals(zzep.zzj(bArr, 43, bArr.length + (-43))) ? C.SERIF_NAME : str;
        int i = bArr[25] * Ascii.DC4;
        this.zzg = i;
        boolean z = (bArr[0] & 32) != 0;
        this.zzb = z;
        if (z) {
            this.zzf = Math.max(0.0f, Math.min(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i, 0.95f));
        } else {
            this.zzf = 0.85f;
        }
    }

    private static void zzb(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            int i7 = i & 1;
            int i8 = i & 2;
            boolean z = true;
            if (i7 != 0) {
                if (i8 != 0) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                    z = false;
                }
            } else if (i8 != 0) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            } else {
                z = false;
            }
            if ((i & 4) != 0) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            } else {
                if (i7 != 0 || z) {
                    return;
                }
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
            }
        }
    }

    private static void zzc(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, i5 | 33);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zza(byte[] bArr, int i, int i2, zzakh zzakhVar, zzdg zzdgVar) {
        String strZzK;
        int i3;
        int i4;
        int length;
        zzeg zzegVar = this.zza;
        zzegVar.zzb(bArr, i + i2);
        zzegVar.zzh(i);
        int i5 = 1;
        int i6 = 0;
        int i7 = 2;
        zzgmd.zza(zzegVar.zzd() >= 2);
        int iZzt = zzegVar.zzt();
        if (iZzt == 0) {
            strZzK = "";
        } else {
            int iZzg = zzegVar.zzg();
            Charset charsetZzR = zzegVar.zzR();
            int iZzg2 = zzegVar.zzg() - iZzg;
            if (charsetZzR == null) {
                charsetZzR = StandardCharsets.UTF_8;
            }
            strZzK = zzegVar.zzK(iZzt - iZzg2, charsetZzR);
        }
        if (strZzK.isEmpty()) {
            zzdgVar.zza(new zzaka(zzgpe.zzi(), C.TIME_UNSET, C.TIME_UNSET));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strZzK);
        int i8 = this.zzc;
        zzb(spannableStringBuilder, i8, 0, 0, spannableStringBuilder.length(), 16711680);
        int i9 = this.zzd;
        zzc(spannableStringBuilder, i9, -1, 0, spannableStringBuilder.length(), 16711680);
        String str = this.zze;
        int length2 = spannableStringBuilder.length();
        if (str != C.SANS_SERIF_NAME) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length2, 16711713);
        }
        float fMax = this.zzf;
        while (zzegVar.zzd() >= 8) {
            int iZzg3 = zzegVar.zzg();
            int iZzB = zzegVar.zzB();
            int iZzB2 = zzegVar.zzB();
            if (iZzB2 == 1937013100) {
                zzgmd.zza(zzegVar.zzd() >= i7 ? i5 : i6);
                int iZzt2 = zzegVar.zzt();
                int i10 = i6;
                while (i10 < iZzt2) {
                    zzgmd.zza(zzegVar.zzd() >= 12 ? i5 : i6);
                    int iZzt3 = zzegVar.zzt();
                    int iZzt4 = zzegVar.zzt();
                    zzegVar.zzk(i7);
                    int iZzs = zzegVar.zzs();
                    zzegVar.zzk(i5);
                    int iZzB3 = zzegVar.zzB();
                    if (iZzt4 > spannableStringBuilder.length()) {
                        int length3 = spannableStringBuilder.length();
                        i4 = iZzt2;
                        StringBuilder sb = new StringBuilder(String.valueOf(iZzt4).length() + 44 + String.valueOf(length3).length() + 2);
                        sb.append("Truncating styl end (");
                        sb.append(iZzt4);
                        sb.append(") to cueText.length() (");
                        sb.append(length3);
                        sb.append(").");
                        zzdt.zzc("Tx3gParser", sb.toString());
                        length = spannableStringBuilder.length();
                    } else {
                        i4 = iZzt2;
                        length = iZzt4;
                    }
                    if (iZzt3 >= length) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(iZzt3).length() + 36 + String.valueOf(length).length() + 2);
                        sb2.append("Ignoring styl with start (");
                        sb2.append(iZzt3);
                        sb2.append(") >= end (");
                        sb2.append(length);
                        sb2.append(").");
                        zzdt.zzc("Tx3gParser", sb2.toString());
                    } else {
                        int i11 = length;
                        zzb(spannableStringBuilder, iZzs, i8, iZzt3, i11, 0);
                        zzc(spannableStringBuilder, iZzB3, i9, iZzt3, i11, 0);
                    }
                    i10++;
                    iZzt2 = i4;
                    i5 = 1;
                    i6 = 0;
                    i7 = 2;
                }
                i3 = i7;
            } else if (iZzB2 == 1952608120 && this.zzb) {
                i3 = 2;
                zzgmd.zza(zzegVar.zzd() >= 2);
                float fZzt = zzegVar.zzt();
                int i12 = this.zzg;
                String str2 = zzep.zza;
                fMax = Math.max(0.0f, Math.min(fZzt / i12, 0.95f));
            } else {
                i3 = 2;
            }
            zzegVar.zzh(iZzg3 + iZzB);
            i7 = i3;
            i5 = 1;
            i6 = 0;
        }
        zzcl zzclVar = new zzcl();
        zzclVar.zza(spannableStringBuilder);
        zzclVar.zzf(fMax, 0);
        zzclVar.zzg(0);
        zzdgVar.zza(new zzaka(zzgpe.zzj(zzclVar.zzr()), C.TIME_UNSET, C.TIME_UNSET));
    }
}
