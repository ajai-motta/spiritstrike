package com.google.android.gms.internal.ads;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzait {
    public static void zza(int i, zzap zzapVar, zzt zztVar, zzap zzapVar2, zzap... zzapVarArr) {
        if (zzapVar2 == null) {
            zzapVar2 = new zzap(C.TIME_UNSET, new zzao[0]);
        }
        if (zzapVar != null) {
            zzgpe zzgpeVarZzd = zzapVar.zzd(zzes.class);
            int size = zzgpeVarZzd.size();
            for (int i2 = 0; i2 < size; i2++) {
                zzes zzesVar = (zzes) zzgpeVarZzd.get(i2);
                if (!zzesVar.zza.equals(MdtaMetadataEntry.KEY_ANDROID_CAPTURE_FPS) || i == 2) {
                    zzapVar2 = zzapVar2.zzg(zzesVar);
                }
            }
        }
        for (zzap zzapVar3 : zzapVarArr) {
            zzapVar2 = zzapVar2.zzf(zzapVar3);
        }
        if (zzapVar2.zza() > 0) {
            zztVar.zzk(zzapVar2);
        }
    }

    public static void zzb(int i, zzads zzadsVar, zzt zztVar) {
        if (i == 1 && zzadsVar.zzb()) {
            zztVar.zzH(zzadsVar.zza);
            zztVar.zzI(zzadsVar.zzb);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x0288 A[Catch: all -> 0x0200, TryCatch #0 {all -> 0x0200, blocks: (B:9:0x0030, B:11:0x003b, B:13:0x0047, B:16:0x0053, B:19:0x0060, B:22:0x006d, B:25:0x007a, B:28:0x0087, B:30:0x0093, B:38:0x00ae, B:39:0x00cc, B:40:0x00df, B:43:0x00eb, B:46:0x00f8, B:49:0x0105, B:52:0x0112, B:55:0x011f, B:58:0x012c, B:61:0x0139, B:64:0x0146, B:67:0x0153, B:70:0x0163, B:74:0x0177, B:76:0x017d, B:78:0x0192, B:79:0x0199, B:81:0x01a0, B:86:0x01ab, B:91:0x01b7, B:137:0x0288, B:92:0x01cc, B:94:0x01d3, B:96:0x01df, B:97:0x01f3, B:112:0x0220, B:115:0x022d, B:118:0x023a, B:121:0x0247, B:124:0x0253, B:127:0x025f, B:130:0x0269, B:133:0x0275, B:136:0x0281, B:138:0x02a5, B:139:0x02ac), top: B:144:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzao zzc(com.google.android.gms.internal.ads.zzeg r14) {
        /*
            Method dump skipped, instruction units count: 698
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzait.zzc(com.google.android.gms.internal.ads.zzeg):com.google.android.gms.internal.ads.zzao");
    }

    private static zzagv zzd(int i, String str, zzeg zzegVar) {
        int iZzB = zzegVar.zzB();
        if (zzegVar.zzB() == 1684108385) {
            zzegVar.zzk(8);
            return new zzagv(str, null, zzgpe.zzj(zzegVar.zzL(iZzB - 16)));
        }
        zzdt.zzc("MetadataUtil", "Failed to parse text attribute: ".concat(zzew.zze(i)));
        return null;
    }

    private static zzagq zze(int i, String str, zzeg zzegVar, boolean z, boolean z2) {
        int iZzf = zzf(zzegVar);
        if (z2) {
            iZzf = Math.min(1, iZzf);
        }
        if (iZzf >= 0) {
            return z ? new zzagv(str, null, zzgpe.zzj(Integer.toString(iZzf))) : new zzagk(C.LANGUAGE_UNDETERMINED, str, Integer.toString(iZzf));
        }
        zzdt.zzc("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzew.zze(i)));
        return null;
    }

    private static int zzf(zzeg zzegVar) {
        int iZzB = zzegVar.zzB();
        if (zzegVar.zzB() == 1684108385) {
            zzegVar.zzk(8);
            int i = iZzB - 16;
            if (i == 1) {
                return zzegVar.zzs();
            }
            if (i == 2) {
                return zzegVar.zzt();
            }
            if (i == 3) {
                return zzegVar.zzx();
            }
            if (i == 4 && (zzegVar.zzn() & 128) == 0) {
                return zzegVar.zzH();
            }
        }
        zzdt.zzc("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    private static zzagv zzg(int i, String str, zzeg zzegVar) {
        int iZzB = zzegVar.zzB();
        if (zzegVar.zzB() == 1684108385 && iZzB >= 22) {
            zzegVar.zzk(10);
            int iZzt = zzegVar.zzt();
            if (iZzt > 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(iZzt).length());
                sb.append(iZzt);
                String string = sb.toString();
                int iZzt2 = zzegVar.zzt();
                if (iZzt2 > 0) {
                    StringBuilder sb2 = new StringBuilder(string.length() + 1 + String.valueOf(iZzt2).length());
                    sb2.append(string);
                    sb2.append(DomExceptionUtils.SEPARATOR);
                    sb2.append(iZzt2);
                    string = sb2.toString();
                }
                return new zzagv(str, null, zzgpe.zzj(string));
            }
        }
        zzdt.zzc("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzew.zze(i)));
        return null;
    }
}
