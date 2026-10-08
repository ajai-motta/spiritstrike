package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes5.dex */
final class zzit implements Callable {
    final /* synthetic */ zzbh zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzjd zzc;

    zzit(zzjd zzjdVar, zzbh zzbhVar, String str) {
        this.zza = zzbhVar;
        this.zzb = str;
        Objects.requireNonNull(zzjdVar);
        this.zzc = zzjdVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x03f2 A[Catch: all -> 0x054b, TryCatch #4 {all -> 0x054b, blocks: (B:101:0x03cf, B:102:0x03ec, B:104:0x03f2, B:106:0x0406, B:107:0x0411, B:109:0x045a, B:110:0x0468, B:112:0x0470, B:113:0x0473, B:115:0x047b, B:118:0x0484, B:121:0x049b, B:122:0x049e, B:117:0x0481, B:134:0x052d, B:63:0x0200, B:65:0x0208, B:67:0x020e), top: B:150:0x0200, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x045a A[Catch: all -> 0x054b, TryCatch #4 {all -> 0x054b, blocks: (B:101:0x03cf, B:102:0x03ec, B:104:0x03f2, B:106:0x0406, B:107:0x0411, B:109:0x045a, B:110:0x0468, B:112:0x0470, B:113:0x0473, B:115:0x047b, B:118:0x0484, B:121:0x049b, B:122:0x049e, B:117:0x0481, B:134:0x052d, B:63:0x0200, B:65:0x0208, B:67:0x020e), top: B:150:0x0200, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0470 A[Catch: all -> 0x054b, TryCatch #4 {all -> 0x054b, blocks: (B:101:0x03cf, B:102:0x03ec, B:104:0x03f2, B:106:0x0406, B:107:0x0411, B:109:0x045a, B:110:0x0468, B:112:0x0470, B:113:0x0473, B:115:0x047b, B:118:0x0484, B:121:0x049b, B:122:0x049e, B:117:0x0481, B:134:0x052d, B:63:0x0200, B:65:0x0208, B:67:0x020e), top: B:150:0x0200, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x047b A[Catch: all -> 0x054b, TryCatch #4 {all -> 0x054b, blocks: (B:101:0x03cf, B:102:0x03ec, B:104:0x03f2, B:106:0x0406, B:107:0x0411, B:109:0x045a, B:110:0x0468, B:112:0x0470, B:113:0x0473, B:115:0x047b, B:118:0x0484, B:121:0x049b, B:122:0x049e, B:117:0x0481, B:134:0x052d, B:63:0x0200, B:65:0x0208, B:67:0x020e), top: B:150:0x0200, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0267 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01cf A[Catch: all -> 0x054d, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x054d, blocks: (B:8:0x0058, B:10:0x0063, B:13:0x007d, B:15:0x0083, B:16:0x0095, B:18:0x00ac, B:19:0x00b3, B:21:0x00bd, B:22:0x00ca, B:24:0x00d4, B:25:0x00e1, B:27:0x00ec, B:28:0x00f4, B:30:0x010c, B:31:0x010f, B:33:0x0129, B:35:0x0139, B:37:0x0141, B:39:0x0147, B:40:0x014a, B:42:0x0159, B:44:0x015f, B:46:0x0169, B:49:0x0170, B:51:0x0184, B:53:0x018a, B:55:0x0194, B:56:0x01a5, B:58:0x01a9, B:60:0x01b6, B:50:0x0179, B:62:0x01cf, B:63:0x0200, B:65:0x0208, B:67:0x020e, B:68:0x0225, B:70:0x022f, B:71:0x023c, B:72:0x024e, B:74:0x0254, B:81:0x026c, B:84:0x0295, B:85:0x029c, B:87:0x02a2, B:88:0x02d6, B:83:0x0270), top: B:152:0x0058, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022f A[Catch: all -> 0x054d, TryCatch #5 {all -> 0x054d, blocks: (B:8:0x0058, B:10:0x0063, B:13:0x007d, B:15:0x0083, B:16:0x0095, B:18:0x00ac, B:19:0x00b3, B:21:0x00bd, B:22:0x00ca, B:24:0x00d4, B:25:0x00e1, B:27:0x00ec, B:28:0x00f4, B:30:0x010c, B:31:0x010f, B:33:0x0129, B:35:0x0139, B:37:0x0141, B:39:0x0147, B:40:0x014a, B:42:0x0159, B:44:0x015f, B:46:0x0169, B:49:0x0170, B:51:0x0184, B:53:0x018a, B:55:0x0194, B:56:0x01a5, B:58:0x01a9, B:60:0x01b6, B:50:0x0179, B:62:0x01cf, B:63:0x0200, B:65:0x0208, B:67:0x020e, B:68:0x0225, B:70:0x022f, B:71:0x023c, B:72:0x024e, B:74:0x0254, B:81:0x026c, B:84:0x0295, B:85:0x029c, B:87:0x02a2, B:88:0x02d6, B:83:0x0270), top: B:152:0x0058, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0254 A[Catch: all -> 0x054d, TryCatch #5 {all -> 0x054d, blocks: (B:8:0x0058, B:10:0x0063, B:13:0x007d, B:15:0x0083, B:16:0x0095, B:18:0x00ac, B:19:0x00b3, B:21:0x00bd, B:22:0x00ca, B:24:0x00d4, B:25:0x00e1, B:27:0x00ec, B:28:0x00f4, B:30:0x010c, B:31:0x010f, B:33:0x0129, B:35:0x0139, B:37:0x0141, B:39:0x0147, B:40:0x014a, B:42:0x0159, B:44:0x015f, B:46:0x0169, B:49:0x0170, B:51:0x0184, B:53:0x018a, B:55:0x0194, B:56:0x01a5, B:58:0x01a9, B:60:0x01b6, B:50:0x0179, B:62:0x01cf, B:63:0x0200, B:65:0x0208, B:67:0x020e, B:68:0x0225, B:70:0x022f, B:71:0x023c, B:72:0x024e, B:74:0x0254, B:81:0x026c, B:84:0x0295, B:85:0x029c, B:87:0x02a2, B:88:0x02d6, B:83:0x0270), top: B:152:0x0058, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0270 A[Catch: all -> 0x054d, TryCatch #5 {all -> 0x054d, blocks: (B:8:0x0058, B:10:0x0063, B:13:0x007d, B:15:0x0083, B:16:0x0095, B:18:0x00ac, B:19:0x00b3, B:21:0x00bd, B:22:0x00ca, B:24:0x00d4, B:25:0x00e1, B:27:0x00ec, B:28:0x00f4, B:30:0x010c, B:31:0x010f, B:33:0x0129, B:35:0x0139, B:37:0x0141, B:39:0x0147, B:40:0x014a, B:42:0x0159, B:44:0x015f, B:46:0x0169, B:49:0x0170, B:51:0x0184, B:53:0x018a, B:55:0x0194, B:56:0x01a5, B:58:0x01a9, B:60:0x01b6, B:50:0x0179, B:62:0x01cf, B:63:0x0200, B:65:0x0208, B:67:0x020e, B:68:0x0225, B:70:0x022f, B:71:0x023c, B:72:0x024e, B:74:0x0254, B:81:0x026c, B:84:0x0295, B:85:0x029c, B:87:0x02a2, B:88:0x02d6, B:83:0x0270), top: B:152:0x0058, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02a2 A[Catch: all -> 0x054d, LOOP:1: B:85:0x029c->B:87:0x02a2, LOOP_END, TryCatch #5 {all -> 0x054d, blocks: (B:8:0x0058, B:10:0x0063, B:13:0x007d, B:15:0x0083, B:16:0x0095, B:18:0x00ac, B:19:0x00b3, B:21:0x00bd, B:22:0x00ca, B:24:0x00d4, B:25:0x00e1, B:27:0x00ec, B:28:0x00f4, B:30:0x010c, B:31:0x010f, B:33:0x0129, B:35:0x0139, B:37:0x0141, B:39:0x0147, B:40:0x014a, B:42:0x0159, B:44:0x015f, B:46:0x0169, B:49:0x0170, B:51:0x0184, B:53:0x018a, B:55:0x0194, B:56:0x01a5, B:58:0x01a9, B:60:0x01b6, B:50:0x0179, B:62:0x01cf, B:63:0x0200, B:65:0x0208, B:67:0x020e, B:68:0x0225, B:70:0x022f, B:71:0x023c, B:72:0x024e, B:74:0x0254, B:81:0x026c, B:84:0x0295, B:85:0x029c, B:87:0x02a2, B:88:0x02d6, B:83:0x0270), top: B:152:0x0058, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x033d A[Catch: all -> 0x0526, TryCatch #2 {all -> 0x0526, blocks: (B:90:0x0311, B:92:0x033d, B:93:0x0351, B:95:0x035d, B:97:0x03b2, B:96:0x0395), top: B:148:0x0311 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x035d A[Catch: all -> 0x0526, TryCatch #2 {all -> 0x0526, blocks: (B:90:0x0311, B:92:0x033d, B:93:0x0351, B:95:0x035d, B:97:0x03b2, B:96:0x0395), top: B:148:0x0311 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0395 A[Catch: all -> 0x0526, TryCatch #2 {all -> 0x0526, blocks: (B:90:0x0311, B:92:0x033d, B:93:0x0351, B:95:0x035d, B:97:0x03b2, B:96:0x0395), top: B:148:0x0311 }] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.gms.measurement.internal.zzbh, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.google.android.gms.measurement.internal.zzol] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ java.lang.Object call() throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzit.call():java.lang.Object");
    }
}
