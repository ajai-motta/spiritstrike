package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzali implements zzaki {
    private final XmlPullParserFactory zzi;
    private static final Pattern zzc = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern zzd = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern zze = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    static final Pattern zza = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern zzb = Pattern.compile("^([-+]?\\d+\\.?\\d*?)% ([-+]?\\d+\\.?\\d*?)%$");
    private static final Pattern zzf = Pattern.compile("^([-+]?\\d+\\.?\\d*?)px ([-+]?\\d+\\.?\\d*?)px$");
    private static final Pattern zzg = Pattern.compile("^(\\d+) (\\d+)$");
    private static final zzalg zzh = new zzalg(30.0f, 1, 1);

    private static String[] zzc(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return new String[0];
        }
        String str2 = zzep.zza;
        return strTrim.split("\\s+", -1);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0384 A[Catch: zzake -> 0x03de, TryCatch #3 {zzake -> 0x03de, blocks: (B:167:0x02e9, B:169:0x0302, B:172:0x0318, B:174:0x031e, B:176:0x0325, B:197:0x035e, B:202:0x0387, B:204:0x038e, B:198:0x0362, B:199:0x037f, B:200:0x0380, B:201:0x0384, B:205:0x039a, B:206:0x03bb, B:171:0x030b, B:207:0x03bc, B:208:0x03dd), top: B:230:0x02e9 }] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r10v39 */
    /* JADX WARN: Type inference failed for: r10v40 */
    /* JADX WARN: Type inference failed for: r10v41 */
    /* JADX WARN: Type inference failed for: r10v42 */
    /* JADX WARN: Type inference failed for: r10v43 */
    /* JADX WARN: Type inference failed for: r10v44 */
    /* JADX WARN: Type inference failed for: r10v45 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v36 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r6v42 */
    /* JADX WARN: Type inference failed for: r6v43 */
    /* JADX WARN: Type inference failed for: r6v45 */
    /* JADX WARN: Type inference failed for: r6v46 */
    /* JADX WARN: Type inference failed for: r6v48 */
    /* JADX WARN: Type inference failed for: r6v49 */
    /* JADX WARN: Type inference failed for: r6v50 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r6v92 */
    /* JADX WARN: Type inference failed for: r6v93 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.gms.internal.ads.zzall zzd(org.xmlpull.v1.XmlPullParser r17, com.google.android.gms.internal.ads.zzall r18) {
        /*
            Method dump skipped, instruction units count: 1250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzali.zzd(org.xmlpull.v1.XmlPullParser, com.google.android.gms.internal.ads.zzall):com.google.android.gms.internal.ads.zzall");
    }

    private static zzall zze(zzall zzallVar) {
        return zzallVar == null ? new zzall() : zzallVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.text.Layout.Alignment zzf(java.lang.String r5) {
        /*
            java.lang.String r5 = com.google.android.gms.internal.ads.zzglm.zza(r5)
            int r0 = r5.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1364013995: goto L38;
                case 100571: goto L2e;
                case 3317767: goto L24;
                case 108511772: goto L1a;
                case 109757538: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L42
        L10:
            java.lang.String r0 = "start"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L42
            r5 = r4
            goto L43
        L1a:
            java.lang.String r0 = "right"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L42
            r5 = r3
            goto L43
        L24:
            java.lang.String r0 = "left"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L42
            r5 = 0
            goto L43
        L2e:
            java.lang.String r0 = "end"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L42
            r5 = r2
            goto L43
        L38:
            java.lang.String r0 = "center"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L42
            r5 = r1
            goto L43
        L42:
            r5 = -1
        L43:
            if (r5 == 0) goto L55
            if (r5 == r4) goto L55
            if (r5 == r3) goto L52
            if (r5 == r2) goto L52
            if (r5 == r1) goto L4f
            r5 = 0
            return r5
        L4f:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_CENTER
            return r5
        L52:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            return r5
        L55:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_NORMAL
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzali.zzf(java.lang.String):android.text.Layout$Alignment");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long zzg(java.lang.String r13, com.google.android.gms.internal.ads.zzalg r14) throws com.google.android.gms.internal.ads.zzake {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzali.zzg(java.lang.String, com.google.android.gms.internal.ads.zzalg):long");
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zza(byte[] bArr, int i, int i2, zzakh zzakhVar, zzdg zzdgVar) {
        zzakc.zza(zzb(bArr, i, i2), zzakhVar, zzdgVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x030f A[Catch: IOException -> 0x077d, XmlPullParserException -> 0x0787, TRY_LEAVE, TryCatch #17 {IOException -> 0x077d, XmlPullParserException -> 0x0787, blocks: (B:3:0x0008, B:6:0x0065, B:8:0x0070, B:11:0x007a, B:14:0x0084, B:16:0x008c, B:18:0x0093, B:20:0x009b, B:24:0x00af, B:26:0x00ce, B:28:0x00d8, B:29:0x00dc, B:31:0x00e8, B:33:0x00f3, B:59:0x0166, B:75:0x01bf, B:78:0x01d9, B:80:0x01df, B:82:0x01e7, B:84:0x01ef, B:86:0x01f7, B:88:0x01ff, B:90:0x0207, B:92:0x020d, B:94:0x0215, B:96:0x021d, B:98:0x0223, B:100:0x0229, B:102:0x022f, B:104:0x0237, B:107:0x0240, B:401:0x075d, B:108:0x026f, B:110:0x0275, B:112:0x027e, B:114:0x028d, B:116:0x0299, B:118:0x02af, B:120:0x02b5, B:269:0x0574, B:122:0x02c1, B:125:0x02cd, B:252:0x0525, B:129:0x02ea, B:131:0x02f2, B:133:0x02fa, B:135:0x0302, B:140:0x030f, B:143:0x0328, B:145:0x032f, B:147:0x0340, B:165:0x03a8, B:167:0x03b2, B:169:0x03b8, B:171:0x03c0, B:173:0x03c6, B:176:0x03d9, B:178:0x03e0, B:180:0x03f1, B:198:0x0479, B:200:0x0481, B:221:0x04c7, B:223:0x04cf, B:250:0x0518, B:182:0x0400, B:183:0x0410, B:186:0x0418, B:189:0x0429, B:191:0x0430, B:193:0x043f, B:195:0x0455, B:196:0x0465, B:149:0x034a, B:150:0x0352, B:153:0x035c, B:156:0x0365, B:158:0x036c, B:160:0x037b, B:162:0x038e, B:163:0x0397, B:255:0x0538, B:257:0x0545, B:259:0x0550, B:261:0x0556, B:263:0x0562, B:274:0x058f, B:277:0x05b0, B:331:0x065f, B:312:0x061c, B:315:0x0625, B:378:0x06f0, B:318:0x062d, B:321:0x0637, B:328:0x064c, B:329:0x0651, B:330:0x0658, B:338:0x0678, B:342:0x0689, B:346:0x0692, B:357:0x06b9, B:365:0x06cc, B:367:0x06da, B:369:0x06df, B:359:0x06c0, B:62:0x0175, B:64:0x0181, B:67:0x018a, B:69:0x0191, B:71:0x01a0, B:73:0x01af, B:37:0x010b, B:39:0x0117, B:42:0x0120, B:44:0x0127, B:46:0x0132, B:48:0x0139, B:54:0x0152, B:58:0x015e, B:384:0x0710, B:387:0x0722, B:389:0x072c, B:391:0x0737, B:393:0x0740, B:396:0x0753, B:399:0x0759, B:404:0x0778), top: B:444:0x0008, inners: #8, #11, #12, #13, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03c6 A[Catch: IOException -> 0x077d, XmlPullParserException -> 0x0787, TRY_LEAVE, TryCatch #17 {IOException -> 0x077d, XmlPullParserException -> 0x0787, blocks: (B:3:0x0008, B:6:0x0065, B:8:0x0070, B:11:0x007a, B:14:0x0084, B:16:0x008c, B:18:0x0093, B:20:0x009b, B:24:0x00af, B:26:0x00ce, B:28:0x00d8, B:29:0x00dc, B:31:0x00e8, B:33:0x00f3, B:59:0x0166, B:75:0x01bf, B:78:0x01d9, B:80:0x01df, B:82:0x01e7, B:84:0x01ef, B:86:0x01f7, B:88:0x01ff, B:90:0x0207, B:92:0x020d, B:94:0x0215, B:96:0x021d, B:98:0x0223, B:100:0x0229, B:102:0x022f, B:104:0x0237, B:107:0x0240, B:401:0x075d, B:108:0x026f, B:110:0x0275, B:112:0x027e, B:114:0x028d, B:116:0x0299, B:118:0x02af, B:120:0x02b5, B:269:0x0574, B:122:0x02c1, B:125:0x02cd, B:252:0x0525, B:129:0x02ea, B:131:0x02f2, B:133:0x02fa, B:135:0x0302, B:140:0x030f, B:143:0x0328, B:145:0x032f, B:147:0x0340, B:165:0x03a8, B:167:0x03b2, B:169:0x03b8, B:171:0x03c0, B:173:0x03c6, B:176:0x03d9, B:178:0x03e0, B:180:0x03f1, B:198:0x0479, B:200:0x0481, B:221:0x04c7, B:223:0x04cf, B:250:0x0518, B:182:0x0400, B:183:0x0410, B:186:0x0418, B:189:0x0429, B:191:0x0430, B:193:0x043f, B:195:0x0455, B:196:0x0465, B:149:0x034a, B:150:0x0352, B:153:0x035c, B:156:0x0365, B:158:0x036c, B:160:0x037b, B:162:0x038e, B:163:0x0397, B:255:0x0538, B:257:0x0545, B:259:0x0550, B:261:0x0556, B:263:0x0562, B:274:0x058f, B:277:0x05b0, B:331:0x065f, B:312:0x061c, B:315:0x0625, B:378:0x06f0, B:318:0x062d, B:321:0x0637, B:328:0x064c, B:329:0x0651, B:330:0x0658, B:338:0x0678, B:342:0x0689, B:346:0x0692, B:357:0x06b9, B:365:0x06cc, B:367:0x06da, B:369:0x06df, B:359:0x06c0, B:62:0x0175, B:64:0x0181, B:67:0x018a, B:69:0x0191, B:71:0x01a0, B:73:0x01af, B:37:0x010b, B:39:0x0117, B:42:0x0120, B:44:0x0127, B:46:0x0132, B:48:0x0139, B:54:0x0152, B:58:0x015e, B:384:0x0710, B:387:0x0722, B:389:0x072c, B:391:0x0737, B:393:0x0740, B:396:0x0753, B:399:0x0759, B:404:0x0778), top: B:444:0x0008, inners: #8, #11, #12, #13, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0481 A[Catch: IOException -> 0x077d, XmlPullParserException -> 0x0787, TRY_LEAVE, TryCatch #17 {IOException -> 0x077d, XmlPullParserException -> 0x0787, blocks: (B:3:0x0008, B:6:0x0065, B:8:0x0070, B:11:0x007a, B:14:0x0084, B:16:0x008c, B:18:0x0093, B:20:0x009b, B:24:0x00af, B:26:0x00ce, B:28:0x00d8, B:29:0x00dc, B:31:0x00e8, B:33:0x00f3, B:59:0x0166, B:75:0x01bf, B:78:0x01d9, B:80:0x01df, B:82:0x01e7, B:84:0x01ef, B:86:0x01f7, B:88:0x01ff, B:90:0x0207, B:92:0x020d, B:94:0x0215, B:96:0x021d, B:98:0x0223, B:100:0x0229, B:102:0x022f, B:104:0x0237, B:107:0x0240, B:401:0x075d, B:108:0x026f, B:110:0x0275, B:112:0x027e, B:114:0x028d, B:116:0x0299, B:118:0x02af, B:120:0x02b5, B:269:0x0574, B:122:0x02c1, B:125:0x02cd, B:252:0x0525, B:129:0x02ea, B:131:0x02f2, B:133:0x02fa, B:135:0x0302, B:140:0x030f, B:143:0x0328, B:145:0x032f, B:147:0x0340, B:165:0x03a8, B:167:0x03b2, B:169:0x03b8, B:171:0x03c0, B:173:0x03c6, B:176:0x03d9, B:178:0x03e0, B:180:0x03f1, B:198:0x0479, B:200:0x0481, B:221:0x04c7, B:223:0x04cf, B:250:0x0518, B:182:0x0400, B:183:0x0410, B:186:0x0418, B:189:0x0429, B:191:0x0430, B:193:0x043f, B:195:0x0455, B:196:0x0465, B:149:0x034a, B:150:0x0352, B:153:0x035c, B:156:0x0365, B:158:0x036c, B:160:0x037b, B:162:0x038e, B:163:0x0397, B:255:0x0538, B:257:0x0545, B:259:0x0550, B:261:0x0556, B:263:0x0562, B:274:0x058f, B:277:0x05b0, B:331:0x065f, B:312:0x061c, B:315:0x0625, B:378:0x06f0, B:318:0x062d, B:321:0x0637, B:328:0x064c, B:329:0x0651, B:330:0x0658, B:338:0x0678, B:342:0x0689, B:346:0x0692, B:357:0x06b9, B:365:0x06cc, B:367:0x06da, B:369:0x06df, B:359:0x06c0, B:62:0x0175, B:64:0x0181, B:67:0x018a, B:69:0x0191, B:71:0x01a0, B:73:0x01af, B:37:0x010b, B:39:0x0117, B:42:0x0120, B:44:0x0127, B:46:0x0132, B:48:0x0139, B:54:0x0152, B:58:0x015e, B:384:0x0710, B:387:0x0722, B:389:0x072c, B:391:0x0737, B:393:0x0740, B:396:0x0753, B:399:0x0759, B:404:0x0778), top: B:444:0x0008, inners: #8, #11, #12, #13, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x04cf A[Catch: IOException -> 0x077d, XmlPullParserException -> 0x0787, TRY_LEAVE, TryCatch #17 {IOException -> 0x077d, XmlPullParserException -> 0x0787, blocks: (B:3:0x0008, B:6:0x0065, B:8:0x0070, B:11:0x007a, B:14:0x0084, B:16:0x008c, B:18:0x0093, B:20:0x009b, B:24:0x00af, B:26:0x00ce, B:28:0x00d8, B:29:0x00dc, B:31:0x00e8, B:33:0x00f3, B:59:0x0166, B:75:0x01bf, B:78:0x01d9, B:80:0x01df, B:82:0x01e7, B:84:0x01ef, B:86:0x01f7, B:88:0x01ff, B:90:0x0207, B:92:0x020d, B:94:0x0215, B:96:0x021d, B:98:0x0223, B:100:0x0229, B:102:0x022f, B:104:0x0237, B:107:0x0240, B:401:0x075d, B:108:0x026f, B:110:0x0275, B:112:0x027e, B:114:0x028d, B:116:0x0299, B:118:0x02af, B:120:0x02b5, B:269:0x0574, B:122:0x02c1, B:125:0x02cd, B:252:0x0525, B:129:0x02ea, B:131:0x02f2, B:133:0x02fa, B:135:0x0302, B:140:0x030f, B:143:0x0328, B:145:0x032f, B:147:0x0340, B:165:0x03a8, B:167:0x03b2, B:169:0x03b8, B:171:0x03c0, B:173:0x03c6, B:176:0x03d9, B:178:0x03e0, B:180:0x03f1, B:198:0x0479, B:200:0x0481, B:221:0x04c7, B:223:0x04cf, B:250:0x0518, B:182:0x0400, B:183:0x0410, B:186:0x0418, B:189:0x0429, B:191:0x0430, B:193:0x043f, B:195:0x0455, B:196:0x0465, B:149:0x034a, B:150:0x0352, B:153:0x035c, B:156:0x0365, B:158:0x036c, B:160:0x037b, B:162:0x038e, B:163:0x0397, B:255:0x0538, B:257:0x0545, B:259:0x0550, B:261:0x0556, B:263:0x0562, B:274:0x058f, B:277:0x05b0, B:331:0x065f, B:312:0x061c, B:315:0x0625, B:378:0x06f0, B:318:0x062d, B:321:0x0637, B:328:0x064c, B:329:0x0651, B:330:0x0658, B:338:0x0678, B:342:0x0689, B:346:0x0692, B:357:0x06b9, B:365:0x06cc, B:367:0x06da, B:369:0x06df, B:359:0x06c0, B:62:0x0175, B:64:0x0181, B:67:0x018a, B:69:0x0191, B:71:0x01a0, B:73:0x01af, B:37:0x010b, B:39:0x0117, B:42:0x0120, B:44:0x0127, B:46:0x0132, B:48:0x0139, B:54:0x0152, B:58:0x015e, B:384:0x0710, B:387:0x0722, B:389:0x072c, B:391:0x0737, B:393:0x0740, B:396:0x0753, B:399:0x0759, B:404:0x0778), top: B:444:0x0008, inners: #8, #11, #12, #13, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0525 A[Catch: IOException -> 0x077d, XmlPullParserException -> 0x0787, TryCatch #17 {IOException -> 0x077d, XmlPullParserException -> 0x0787, blocks: (B:3:0x0008, B:6:0x0065, B:8:0x0070, B:11:0x007a, B:14:0x0084, B:16:0x008c, B:18:0x0093, B:20:0x009b, B:24:0x00af, B:26:0x00ce, B:28:0x00d8, B:29:0x00dc, B:31:0x00e8, B:33:0x00f3, B:59:0x0166, B:75:0x01bf, B:78:0x01d9, B:80:0x01df, B:82:0x01e7, B:84:0x01ef, B:86:0x01f7, B:88:0x01ff, B:90:0x0207, B:92:0x020d, B:94:0x0215, B:96:0x021d, B:98:0x0223, B:100:0x0229, B:102:0x022f, B:104:0x0237, B:107:0x0240, B:401:0x075d, B:108:0x026f, B:110:0x0275, B:112:0x027e, B:114:0x028d, B:116:0x0299, B:118:0x02af, B:120:0x02b5, B:269:0x0574, B:122:0x02c1, B:125:0x02cd, B:252:0x0525, B:129:0x02ea, B:131:0x02f2, B:133:0x02fa, B:135:0x0302, B:140:0x030f, B:143:0x0328, B:145:0x032f, B:147:0x0340, B:165:0x03a8, B:167:0x03b2, B:169:0x03b8, B:171:0x03c0, B:173:0x03c6, B:176:0x03d9, B:178:0x03e0, B:180:0x03f1, B:198:0x0479, B:200:0x0481, B:221:0x04c7, B:223:0x04cf, B:250:0x0518, B:182:0x0400, B:183:0x0410, B:186:0x0418, B:189:0x0429, B:191:0x0430, B:193:0x043f, B:195:0x0455, B:196:0x0465, B:149:0x034a, B:150:0x0352, B:153:0x035c, B:156:0x0365, B:158:0x036c, B:160:0x037b, B:162:0x038e, B:163:0x0397, B:255:0x0538, B:257:0x0545, B:259:0x0550, B:261:0x0556, B:263:0x0562, B:274:0x058f, B:277:0x05b0, B:331:0x065f, B:312:0x061c, B:315:0x0625, B:378:0x06f0, B:318:0x062d, B:321:0x0637, B:328:0x064c, B:329:0x0651, B:330:0x0658, B:338:0x0678, B:342:0x0689, B:346:0x0692, B:357:0x06b9, B:365:0x06cc, B:367:0x06da, B:369:0x06df, B:359:0x06c0, B:62:0x0175, B:64:0x0181, B:67:0x018a, B:69:0x0191, B:71:0x01a0, B:73:0x01af, B:37:0x010b, B:39:0x0117, B:42:0x0120, B:44:0x0127, B:46:0x0132, B:48:0x0139, B:54:0x0152, B:58:0x015e, B:384:0x0710, B:387:0x0722, B:389:0x072c, B:391:0x0737, B:393:0x0740, B:396:0x0753, B:399:0x0759, B:404:0x0778), top: B:444:0x0008, inners: #8, #11, #12, #13, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x06ca A[PHI: r14
  0x06ca: PHI (r14v5 long) = (r14v4 long), (r14v7 long) binds: [B:354:0x06b3, B:361:0x06c4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:369:0x06df A[Catch: zzake -> 0x06e3, IOException -> 0x077d, XmlPullParserException -> 0x0787, TRY_LEAVE, TryCatch #0 {zzake -> 0x06e3, blocks: (B:367:0x06da, B:369:0x06df), top: B:414:0x06da }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0175 A[Catch: IOException -> 0x077d, XmlPullParserException -> 0x0787, TryCatch #17 {IOException -> 0x077d, XmlPullParserException -> 0x0787, blocks: (B:3:0x0008, B:6:0x0065, B:8:0x0070, B:11:0x007a, B:14:0x0084, B:16:0x008c, B:18:0x0093, B:20:0x009b, B:24:0x00af, B:26:0x00ce, B:28:0x00d8, B:29:0x00dc, B:31:0x00e8, B:33:0x00f3, B:59:0x0166, B:75:0x01bf, B:78:0x01d9, B:80:0x01df, B:82:0x01e7, B:84:0x01ef, B:86:0x01f7, B:88:0x01ff, B:90:0x0207, B:92:0x020d, B:94:0x0215, B:96:0x021d, B:98:0x0223, B:100:0x0229, B:102:0x022f, B:104:0x0237, B:107:0x0240, B:401:0x075d, B:108:0x026f, B:110:0x0275, B:112:0x027e, B:114:0x028d, B:116:0x0299, B:118:0x02af, B:120:0x02b5, B:269:0x0574, B:122:0x02c1, B:125:0x02cd, B:252:0x0525, B:129:0x02ea, B:131:0x02f2, B:133:0x02fa, B:135:0x0302, B:140:0x030f, B:143:0x0328, B:145:0x032f, B:147:0x0340, B:165:0x03a8, B:167:0x03b2, B:169:0x03b8, B:171:0x03c0, B:173:0x03c6, B:176:0x03d9, B:178:0x03e0, B:180:0x03f1, B:198:0x0479, B:200:0x0481, B:221:0x04c7, B:223:0x04cf, B:250:0x0518, B:182:0x0400, B:183:0x0410, B:186:0x0418, B:189:0x0429, B:191:0x0430, B:193:0x043f, B:195:0x0455, B:196:0x0465, B:149:0x034a, B:150:0x0352, B:153:0x035c, B:156:0x0365, B:158:0x036c, B:160:0x037b, B:162:0x038e, B:163:0x0397, B:255:0x0538, B:257:0x0545, B:259:0x0550, B:261:0x0556, B:263:0x0562, B:274:0x058f, B:277:0x05b0, B:331:0x065f, B:312:0x061c, B:315:0x0625, B:378:0x06f0, B:318:0x062d, B:321:0x0637, B:328:0x064c, B:329:0x0651, B:330:0x0658, B:338:0x0678, B:342:0x0689, B:346:0x0692, B:357:0x06b9, B:365:0x06cc, B:367:0x06da, B:369:0x06df, B:359:0x06c0, B:62:0x0175, B:64:0x0181, B:67:0x018a, B:69:0x0191, B:71:0x01a0, B:73:0x01af, B:37:0x010b, B:39:0x0117, B:42:0x0120, B:44:0x0127, B:46:0x0132, B:48:0x0139, B:54:0x0152, B:58:0x015e, B:384:0x0710, B:387:0x0722, B:389:0x072c, B:391:0x0737, B:393:0x0740, B:396:0x0753, B:399:0x0759, B:404:0x0778), top: B:444:0x0008, inners: #8, #11, #12, #13, #15 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.ads.zzakd zzb(byte[] r46, int r47, int r48) {
        /*
            Method dump skipped, instruction units count: 1964
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzali.zzb(byte[], int, int):com.google.android.gms.internal.ads.zzakd");
    }

    public zzali() {
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.zzi = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }
}
