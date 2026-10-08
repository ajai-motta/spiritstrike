package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzakx {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;

    private zzakx(int i, int i2, int i3, int i4, int i5, int i6) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = i6;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static zzakx zza(String str) {
        byte b;
        zzgmd.zza(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            int length = strArrSplit.length;
            if (i >= length) {
                if (i3 == -1 || i4 == -1 || i6 == -1) {
                    return null;
                }
                return new zzakx(i2, i3, i4, i5, i6, length);
            }
            String strZza = zzglm.zza(strArrSplit[i].trim());
            switch (strZza.hashCode()) {
                case 100571:
                    b = !strZza.equals(TtmlNode.END) ? (byte) -1 : (byte) 2;
                    break;
                case 3556653:
                    b = !strZza.equals("text") ? (byte) -1 : (byte) 4;
                    break;
                case 102749521:
                    b = !strZza.equals("layer") ? (byte) -1 : (byte) 0;
                    break;
                case 109757538:
                    b = !strZza.equals(TtmlNode.START) ? (byte) -1 : (byte) 1;
                    break;
                case 109780401:
                    b = !strZza.equals("style") ? (byte) -1 : (byte) 3;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                i2 = i;
            } else if (b == 1) {
                i3 = i;
            } else if (b == 2) {
                i4 = i;
            } else if (b == 3) {
                i5 = i;
            } else if (b == 4) {
                i6 = i;
            }
            i++;
        }
    }
}
