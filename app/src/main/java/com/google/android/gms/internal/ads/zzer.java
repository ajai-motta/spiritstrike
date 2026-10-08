package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzer {
    public final String zza;

    private zzer(int i, int i2, String str) {
        this.zza = str;
    }

    public static zzer zza(zzeg zzegVar) {
        String str;
        zzegVar.zzk(2);
        int iZzs = zzegVar.zzs();
        int i = iZzs >> 1;
        int i2 = iZzs & 1;
        int iZzs2 = zzegVar.zzs() >> 3;
        if (i == 4 || i == 5 || i == 7 || i == 8) {
            str = "dvhe";
        } else if (i == 9) {
            str = "dvav";
        } else {
            if (i != 10) {
                return null;
            }
            str = "dav1";
        }
        int i3 = iZzs2 | (i2 << 5);
        int length = String.valueOf(i).length();
        int length2 = String.valueOf(i3).length();
        String str2 = i < 10 ? ".0" : ".";
        int length3 = str.length() + str2.length() + length;
        String str3 = i3 >= 10 ? "." : ".0";
        StringBuilder sb = new StringBuilder(length3 + str3.length() + length2);
        sb.append(str);
        sb.append(str2);
        sb.append(i);
        sb.append(str3);
        sb.append(i3);
        return new zzer(i, i3, sb.toString());
    }
}
