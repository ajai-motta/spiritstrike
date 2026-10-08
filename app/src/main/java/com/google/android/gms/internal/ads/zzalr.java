package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzalr {
    private static final Pattern zza = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern zzb = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private final zzeg zzc = new zzeg();
    private final StringBuilder zzd = new StringBuilder();

    static void zzb(zzeg zzegVar) {
        while (true) {
            for (boolean z = true; zzegVar.zzd() > 0 && z; z = false) {
                char c = (char) zzegVar.zzi()[zzegVar.zzg()];
                if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                    zzegVar.zzk(1);
                } else {
                    int iZzg = zzegVar.zzg();
                    int iZze = zzegVar.zze();
                    byte[] bArrZzi = zzegVar.zzi();
                    if (iZzg + 2 <= iZze) {
                        int i = iZzg + 1;
                        if (bArrZzi[iZzg] == 47) {
                            int i2 = iZzg + 2;
                            if (bArrZzi[i] == 42) {
                                while (true) {
                                    int i3 = i2 + 1;
                                    if (i3 >= iZze) {
                                        break;
                                    }
                                    if (((char) bArrZzi[i2]) == '*' && ((char) bArrZzi[i3]) == '/') {
                                        iZze = i2 + 2;
                                        i2 = iZze;
                                    } else {
                                        i2 = i3;
                                    }
                                }
                                zzegVar.zzk(iZze - zzegVar.zzg());
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return;
        }
    }

    static String zzc(zzeg zzegVar, StringBuilder sb) {
        zzb(zzegVar);
        if (zzegVar.zzd() == 0) {
            return null;
        }
        String strZzd = zzd(zzegVar, sb);
        if (!strZzd.isEmpty()) {
            return strZzd;
        }
        char cZzs = (char) zzegVar.zzs();
        StringBuilder sb2 = new StringBuilder(String.valueOf(cZzs).length());
        sb2.append(cZzs);
        return sb2.toString();
    }

    private static String zzd(zzeg zzegVar, StringBuilder sb) {
        boolean z;
        char c;
        sb.setLength(0);
        int iZzg = zzegVar.zzg();
        int iZze = zzegVar.zze();
        loop0: while (true) {
            for (false; iZzg < iZze && !z; true) {
                c = (char) zzegVar.zzi()[iZzg];
                z = (c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_');
            }
            sb.append(c);
            iZzg++;
        }
        zzegVar.zzk(iZzg - zzegVar.zzg());
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:172:0x0315, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List zza(com.google.android.gms.internal.ads.zzeg r18) {
        /*
            Method dump skipped, instruction units count: 790
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalr.zza(com.google.android.gms.internal.ads.zzeg):java.util.List");
    }
}
