package com.facebook.ads.redexgen.core;

import android.util.Pair;
import com.facebook.ads.androidx.media3.common.Timeline;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2536nD extends AbstractC1214Ew {
    public static String[] A01 = {"LN1kZ6lR3vZBqqrviA4uTSOzBGS9o2bO", "mUQPITaRnEXTrG2Wr7xIAnPzPHhU6DS3", "avW0I4bwWNzzQZleeOInYpLZY9PTle7", "LGUT8ZIo3joumZn9NybI7JCchk0DSCTG", "S4WFRdtC0lcE2afHWARgiwpUU5tNPmtd", "SbOYlLigHNVPkFHrMvYK7wwtNeL", "2fmBOvz22OTh8nUuYBKjoVDFU", "lR30iWlIbuozJgbVtB9O9DOed4NJenPq"};
    public C1206Eo A00;

    public abstract Pair<C10477s[], InterfaceC2537nE[]> A0d(C1206Eo c1206Eo, int[][][] iArr, int[] iArr2, C2573no c2573no, Timeline timeline) throws AD;

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /* JADX WARN: Incorrect condition in loop: B:7:0x000d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A0Y(com.facebook.ads.redexgen.core.InterfaceC10447p[] r8, com.facebook.ads.redexgen.core.C2688pg r9, int[] r10, boolean r11) throws com.facebook.ads.redexgen.core.AD {
        /*
            int r6 = r8.length
            r5 = 0
            r7 = 1
            r4 = 0
        L4:
            int r0 = r8.length
            if (r4 >= r0) goto L39
            r3 = r8[r4]
            r2 = 0
            r1 = 0
        Lb:
            int r0 = r9.A01
            if (r1 >= r0) goto L22
            com.facebook.ads.redexgen.X.qI r0 = r9.A08(r1)
            int r0 = r3.AKM(r0)
            int r0 = com.facebook.ads.redexgen.core.AbstractC10377i.A03(r0)
            int r2 = java.lang.Math.max(r2, r0)
            int r1 = r1 + 1
            goto Lb
        L22:
            r0 = r10[r4]
            if (r0 != 0) goto L37
            r0 = 1
        L27:
            if (r2 > r5) goto L31
            if (r2 != r5) goto L34
            if (r11 == 0) goto L34
            if (r7 != 0) goto L34
            if (r0 == 0) goto L34
        L31:
            r6 = r4
            r5 = r2
            r7 = r0
        L34:
            int r4 = r4 + 1
            goto L4
        L37:
            r0 = 0
            goto L27
        L39:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC2536nD.A0Y(com.facebook.ads.redexgen.X.7p[], com.facebook.ads.redexgen.X.pg, int[], boolean):int");
    }

    public static int[] A0Z(InterfaceC10447p interfaceC10447p, C2688pg c2688pg) throws AD {
        int[] iArr = new int[c2688pg.A01];
        for (int i = 0; i < c2688pg.A01; i++) {
            iArr[i] = interfaceC10447p.AKM(c2688pg.A08(i));
        }
        return iArr;
    }

    public static int[] A0a(InterfaceC10447p[] interfaceC10447pArr) throws AD {
        int[] iArr = new int[interfaceC10447pArr.length];
        for (int i = 0; i < iArr.length; i++) {
            int iAKO = interfaceC10447pArr[i].AKO();
            String[] strArr = A01;
            String str = strArr[4];
            String str2 = strArr[1];
            int i2 = str.charAt(23);
            if (i2 == str2.charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "1ViYEGUZxGRCVXLKV1NACncyCaxKGcLE";
            strArr2[1] = "WZkUCc71MckdncxFpAml539B1oxWjr0A";
            iArr[i] = iAKO;
        }
        return iArr;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1214Ew
    public final C1215Ex A0b(InterfaceC10447p[] interfaceC10447pArr, C2555nW c2555nW, C2573no c2573no, Timeline timeline) throws AD {
        int[] rendererTrackGroupCounts;
        int[] iArr = new int[interfaceC10447pArr.length + 1];
        C2688pg[][] c2688pgArr = new C2688pg[interfaceC10447pArr.length + 1][];
        int[][][] iArr2 = new int[interfaceC10447pArr.length + 1][][];
        for (int i = 0; i < c2688pgArr.length; i++) {
            c2688pgArr[i] = new C2688pg[c2555nW.A01];
            iArr2[i] = new int[c2555nW.A01][];
        }
        int[] iArrA0a = A0a(interfaceC10447pArr);
        for (int i2 = 0; i2 < c2555nW.A01; i2++) {
            C2688pg c2688pgA05 = c2555nW.A05(i2);
            int groupIndex = A0Y(interfaceC10447pArr, c2688pgA05, iArr, c2688pgA05.A02 == 5);
            if (groupIndex == interfaceC10447pArr.length) {
                rendererTrackGroupCounts = new int[c2688pgA05.A01];
            } else {
                rendererTrackGroupCounts = A0Z(interfaceC10447pArr[groupIndex], c2688pgA05);
            }
            int i3 = iArr[groupIndex];
            c2688pgArr[groupIndex][i3] = c2688pgA05;
            iArr2[groupIndex][i3] = rendererTrackGroupCounts;
            iArr[groupIndex] = iArr[groupIndex] + 1;
        }
        C2555nW[] c2555nWArr = new C2555nW[interfaceC10447pArr.length];
        String[] strArr = new String[interfaceC10447pArr.length];
        int[] iArr3 = new int[interfaceC10447pArr.length];
        int i4 = 0;
        while (true) {
            int length = interfaceC10447pArr.length;
            String[] strArr2 = A01;
            if (strArr2[4].charAt(23) == strArr2[1].charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr3 = A01;
            strArr3[4] = "hppY0P6sht5kF7is4RCKyMBKsFUVAoRB";
            strArr3[1] = "XeHPWbHBeoBDFVDQc4DbmKa9NYqMdrJh";
            if (i4 < length) {
                int i5 = iArr[i4];
                c2555nWArr[i4] = new C2555nW((C2688pg[]) C5C.A1I(c2688pgArr[i4], i5));
                iArr2[i4] = (int[][]) C5C.A1I(iArr2[i4], i5);
                strArr[i4] = interfaceC10447pArr[i4].getName();
                iArr3[i4] = interfaceC10447pArr[i4].A9N();
                i4++;
            } else {
                C1206Eo c1206Eo = new C1206Eo(strArr, iArr3, c2555nWArr, iArrA0a, iArr2, new C2555nW((C2688pg[]) C5C.A1I(c2688pgArr[interfaceC10447pArr.length], iArr[interfaceC10447pArr.length])));
                Pair<C10477s[], InterfaceC2537nE[]> pairA0d = A0d(c1206Eo, iArr2, iArrA0a, c2573no, timeline);
                return new C1215Ex((C10477s[]) pairA0d.first, (InterfaceC2537nE[]) pairA0d.second, AbstractC1211Et.A00(c1206Eo, (InterfaceC1208Eq[]) pairA0d.second), c1206Eo);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1214Ew
    public final void A0c(Object obj) {
        this.A00 = (C1206Eo) obj;
    }
}
