package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzalb {
    public final String zza;
    public final int zzb;
    public final Integer zzc;
    public final Integer zzd;
    public final float zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final int zzj;

    private zzalb(String str, int i, Integer num, Integer num2, float f, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this.zza = str;
        this.zzb = i;
        this.zzc = num;
        this.zzd = num2;
        this.zze = f;
        this.zzf = z;
        this.zzg = z2;
        this.zzh = z3;
        this.zzi = z4;
        this.zzj = i2;
    }

    public static zzalb zza(String str, zzakz zzakzVar) {
        int i;
        zzgmd.zza(str.startsWith("Style:"));
        String[] strArrSplit = TextUtils.split(str.substring(6), ",");
        int length = strArrSplit.length;
        int i2 = zzakzVar.zzk;
        if (length != i2) {
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(length), str};
            String str2 = zzep.zza;
            zzdt.zzc("SsaStyle", String.format(Locale.US, "Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", objArr));
            return null;
        }
        try {
            String strTrim = strArrSplit[zzakzVar.zza].trim();
            int i3 = zzakzVar.zzb;
            int iZzd = i3 != -1 ? zzd(strArrSplit[i3].trim()) : -1;
            int i4 = zzakzVar.zzc;
            Integer numZzb = i4 != -1 ? zzb(strArrSplit[i4].trim()) : null;
            int i5 = zzakzVar.zzd;
            Integer numZzb2 = i5 != -1 ? zzb(strArrSplit[i5].trim()) : null;
            int i6 = zzakzVar.zze;
            float f = -3.4028235E38f;
            if (i6 != -1) {
                String strTrim2 = strArrSplit[i6].trim();
                try {
                    f = Float.parseFloat(strTrim2);
                } catch (NumberFormatException e) {
                    StringBuilder sb = new StringBuilder(String.valueOf(strTrim2).length() + 29);
                    sb.append("Failed to parse font size: '");
                    sb.append(strTrim2);
                    sb.append("'");
                    zzdt.zzd("SsaStyle", sb.toString(), e);
                }
            }
            int i7 = zzakzVar.zzf;
            boolean z = i7 != -1 && zze(strArrSplit[i7].trim());
            int i8 = zzakzVar.zzg;
            boolean z2 = i8 != -1 && zze(strArrSplit[i8].trim());
            int i9 = zzakzVar.zzh;
            boolean z3 = i9 != -1 && zze(strArrSplit[i9].trim());
            int i10 = zzakzVar.zzi;
            boolean z4 = i10 != -1 && zze(strArrSplit[i10].trim());
            int i11 = zzakzVar.zzj;
            if (i11 != -1) {
                String strTrim3 = strArrSplit[i11].trim();
                try {
                    int i12 = Integer.parseInt(strTrim3.trim());
                    if (i12 == 1 || i12 == 3) {
                        i = i12;
                    }
                } catch (NumberFormatException unused) {
                }
                String.valueOf(strTrim3);
                zzdt.zzc("SsaStyle", "Ignoring unknown BorderStyle: ".concat(String.valueOf(strTrim3)));
                i = -1;
            } else {
                i = -1;
            }
            return new zzalb(strTrim, iZzd, numZzb, numZzb2, f, z, z2, z3, z4, i);
        } catch (RuntimeException e2) {
            StringBuilder sb2 = new StringBuilder(str.length() + 36);
            sb2.append("Skipping malformed 'Style:' line: '");
            sb2.append(str);
            sb2.append("'");
            zzdt.zzd("SsaStyle", sb2.toString(), e2);
            return null;
        }
    }

    public static Integer zzb(String str) {
        try {
            long j = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            zzgmd.zza(j <= 4294967295L);
            return Integer.valueOf(Color.argb(zzgst.zza(((j >> 24) & 255) ^ 255), zzgst.zza(j & 255), zzgst.zza((j >> 8) & 255), zzgst.zza((j >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 36);
            sb.append("Failed to parse color expression: '");
            sb.append(str);
            sb.append("'");
            zzdt.zzd("SsaStyle", sb.toString(), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzd(String str) {
        int i;
        try {
            i = Integer.parseInt(str.trim());
        } catch (NumberFormatException unused) {
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return i;
            default:
                String.valueOf(str);
                zzdt.zzc("SsaStyle", "Ignoring unknown alignment: ".concat(String.valueOf(str)));
                return -1;
        }
    }

    private static boolean zze(String str) {
        try {
            int i = Integer.parseInt(str);
            return i == 1 || i == -1;
        } catch (NumberFormatException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
            sb.append("Failed to parse boolean value: '");
            sb.append(str);
            sb.append("'");
            zzdt.zzd("SsaStyle", sb.toString(), e);
            return false;
        }
    }
}
