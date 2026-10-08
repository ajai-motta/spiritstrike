package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzacw implements zzadg {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20, 21};
    private static final zzacv zzc = new zzacv(zzact.zza);
    private static final zzacv zzd = new zzacv(zzacs.zza);
    private zzgpe zze;
    private final zzakg zzf = new zzakb();

    @Override // com.google.android.gms.internal.ads.zzadg
    public final synchronized zzada[] zza() {
        return zzb(Uri.EMPTY, new HashMap());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01fa A[Catch: all -> 0x03e0, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0017, B:9:0x001e, B:138:0x01fa, B:139:0x01fd, B:259:0x03c2, B:260:0x03c5, B:262:0x03ca, B:265:0x03d0, B:266:0x03d3, B:267:0x03d6, B:142:0x0206, B:144:0x020e, B:147:0x0218, B:150:0x0224, B:152:0x022c, B:155:0x0236, B:158:0x0241, B:161:0x024c, B:164:0x0257, B:166:0x025f, B:168:0x0267, B:171:0x0271, B:173:0x027f, B:176:0x0289, B:179:0x0294, B:181:0x029c, B:183:0x02aa, B:185:0x02b8, B:188:0x02c8, B:190:0x02d6, B:193:0x02e0, B:195:0x02e8, B:197:0x02f0, B:199:0x02f8, B:202:0x0302, B:204:0x030a, B:207:0x031a, B:209:0x0322, B:212:0x032c, B:214:0x0334, B:217:0x033e, B:219:0x0346, B:222:0x034f, B:225:0x035b, B:228:0x0367, B:231:0x0373, B:233:0x037b, B:236:0x0384, B:238:0x038c, B:241:0x0395, B:14:0x0047, B:15:0x004f, B:114:0x01c0, B:17:0x0054, B:20:0x0060, B:23:0x006b, B:26:0x0077, B:29:0x0083, B:32:0x008e, B:35:0x009a, B:38:0x00a5, B:41:0x00b1, B:44:0x00bd, B:47:0x00c8, B:50:0x00d4, B:53:0x00df, B:56:0x00ea, B:59:0x00f5, B:62:0x0101, B:65:0x010c, B:68:0x0118, B:71:0x0124, B:74:0x0130, B:77:0x013c, B:80:0x0148, B:83:0x0154, B:86:0x0160, B:89:0x016b, B:92:0x0176, B:95:0x0181, B:98:0x018c, B:101:0x0197, B:104:0x01a1, B:107:0x01ab, B:110:0x01b5), top: B:273:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0206 A[Catch: all -> 0x03e0, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0017, B:9:0x001e, B:138:0x01fa, B:139:0x01fd, B:259:0x03c2, B:260:0x03c5, B:262:0x03ca, B:265:0x03d0, B:266:0x03d3, B:267:0x03d6, B:142:0x0206, B:144:0x020e, B:147:0x0218, B:150:0x0224, B:152:0x022c, B:155:0x0236, B:158:0x0241, B:161:0x024c, B:164:0x0257, B:166:0x025f, B:168:0x0267, B:171:0x0271, B:173:0x027f, B:176:0x0289, B:179:0x0294, B:181:0x029c, B:183:0x02aa, B:185:0x02b8, B:188:0x02c8, B:190:0x02d6, B:193:0x02e0, B:195:0x02e8, B:197:0x02f0, B:199:0x02f8, B:202:0x0302, B:204:0x030a, B:207:0x031a, B:209:0x0322, B:212:0x032c, B:214:0x0334, B:217:0x033e, B:219:0x0346, B:222:0x034f, B:225:0x035b, B:228:0x0367, B:231:0x0373, B:233:0x037b, B:236:0x0384, B:238:0x038c, B:241:0x0395, B:14:0x0047, B:15:0x004f, B:114:0x01c0, B:17:0x0054, B:20:0x0060, B:23:0x006b, B:26:0x0077, B:29:0x0083, B:32:0x008e, B:35:0x009a, B:38:0x00a5, B:41:0x00b1, B:44:0x00bd, B:47:0x00c8, B:50:0x00d4, B:53:0x00df, B:56:0x00ea, B:59:0x00f5, B:62:0x0101, B:65:0x010c, B:68:0x0118, B:71:0x0124, B:74:0x0130, B:77:0x013c, B:80:0x0148, B:83:0x0154, B:86:0x0160, B:89:0x016b, B:92:0x0176, B:95:0x0181, B:98:0x018c, B:101:0x0197, B:104:0x01a1, B:107:0x01ab, B:110:0x01b5), top: B:273:0x0003 }] */
    @Override // com.google.android.gms.internal.ads.zzadg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized com.google.android.gms.internal.ads.zzada[] zzb(android.net.Uri r25, java.util.Map r26) {
        /*
            Method dump skipped, instruction units count: 1194
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacw.zzb(android.net.Uri, java.util.Map):com.google.android.gms.internal.ads.zzada[]");
    }

    private final void zzc(int i, List list) {
        switch (i) {
            case 0:
                list.add(new zzamf());
                break;
            case 1:
                list.add(new zzami());
                break;
            case 2:
                list.add(new zzaml(0));
                break;
            case 3:
                list.add(new zzaeu(0));
                break;
            case 4:
                zzada zzadaVarZza = zzc.zza(0);
                if (zzadaVarZza == null) {
                    list.add(new zzafl(0));
                } else {
                    list.add(zzadaVarZza);
                }
                break;
            case 5:
                list.add(new zzafo());
                break;
            case 6:
                list.add(new zzahk(this.zzf, 0));
                break;
            case 7:
                list.add(new zzahs(0));
                break;
            case 8:
                zzakg zzakgVar = this.zzf;
                list.add(new zzair(zzakgVar, 0, null, null, zzgpe.zzi(), null));
                list.add(new zzaiz(zzakgVar, 0));
                break;
            case 9:
                list.add(new zzajp());
                break;
            case 10:
                list.add(new zzanp());
                break;
            case 11:
                if (this.zze == null) {
                    this.zze = zzgpe.zzi();
                }
                list.add(new zzaoa(1, 0, this.zzf, new zzem(0L), new zzamn(0, this.zze), TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES));
                break;
            case 12:
                list.add(new zzaon());
                break;
            case 14:
                list.add(new zzafu(0));
                break;
            case 15:
                zzada zzadaVarZza2 = zzd.zza(new Object[0]);
                if (zzadaVarZza2 != null) {
                    list.add(zzadaVarZza2);
                }
                break;
            case 16:
                list.add(new zzaey(0, this.zzf));
                break;
            case 17:
                list.add(new zzajz());
                break;
            case 18:
                list.add(new zzaos());
                break;
            case 19:
                list.add(new zzafg());
                break;
            case 20:
                list.add(new zzaft());
                break;
            case 21:
                list.add(new zzaff());
                break;
        }
    }
}
