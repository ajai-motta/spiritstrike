package com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3;

import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public static final int b = z.a("ID3");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.l f1402a;

    public n() {
        this.f1402a = null;
    }

    public static int a(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public static h b(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, int i, int i2, boolean z, int i3, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l lVar) {
        int i4 = nVar.b;
        int iB = b(i4, nVar.f1472a);
        String str = new String(nVar.f1472a, i4, iB - i4, C.ISO88591_NAME);
        nVar.e(iB + 1);
        int iJ = nVar.j();
        boolean z2 = (iJ & 2) != 0;
        boolean z3 = (iJ & 1) != 0;
        int iJ2 = nVar.j();
        String[] strArr = new String[iJ2];
        for (int i5 = 0; i5 < iJ2; i5++) {
            int i6 = nVar.b;
            int iB2 = b(i6, nVar.f1472a);
            strArr[i5] = new String(nVar.f1472a, i6, iB2 - i6, C.ISO88591_NAME);
            nVar.e(iB2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i7 = i4 + i;
        while (nVar.b < i7) {
            o oVarA = a(i2, nVar, z, i3, lVar);
            if (oVarA != null) {
                arrayList.add(oVarA);
            }
        }
        o[] oVarArr = new o[arrayList.size()];
        arrayList.toArray(oVarArr);
        return new h(str, z2, z3, strArr, oVarArr);
    }

    public static q c(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        byte[] bArr = new byte[i];
        nVar.a(bArr, 0, i);
        int iB = b(0, bArr);
        String str = new String(bArr, 0, iB, C.ISO88591_NAME);
        int i2 = iB + 1;
        return new q(str, i2 < i ? Arrays.copyOfRange(bArr, i2, i) : new byte[0]);
    }

    public static s d(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        if (i < 1) {
            return null;
        }
        int iJ = nVar.j();
        String strB = b(iJ);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        nVar.a(bArr, 0, i2);
        int iA = a(bArr, 0, iJ);
        String str = new String(bArr, 0, iA, strB);
        int iA2 = a(iJ) + iA;
        return new s("TXXX", str, iA2 < i2 ? new String(bArr, iA2, a(bArr, iA2, iJ) - iA2, strB) : "");
    }

    public static u e(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        if (i < 1) {
            return null;
        }
        int iJ = nVar.j();
        String strB = b(iJ);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        nVar.a(bArr, 0, i2);
        int iA = a(bArr, 0, iJ);
        String str = new String(bArr, 0, iA, strB);
        int iA2 = a(iJ) + iA;
        return new u("WXXX", str, iA2 < i2 ? new String(bArr, iA2, b(iA2, bArr) - iA2, C.ISO88591_NAME) : "");
    }

    public static int f(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        byte[] bArr = nVar.f1472a;
        int i2 = nVar.b;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= i) {
                return i;
            }
            if ((bArr[i2] & 255) == 255 && bArr[i3] == 0) {
                System.arraycopy(bArr, i2 + 2, bArr, i3, (i - i2) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.fyber.inneractive.sdk.player.exoplayer2.metadata.b a(int r14, byte[] r15) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.n.a(int, byte[]):com.fyber.inneractive.sdk.player.exoplayer2.metadata.b");
    }

    public n(com.fyber.inneractive.sdk.player.exoplayer2.extractor.l lVar) {
        this.f1402a = lVar;
    }

    public static u b(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, String str) {
        byte[] bArr = new byte[i];
        nVar.a(bArr, 0, i);
        return new u(str, null, new String(bArr, 0, b(0, bArr), C.ISO88591_NAME));
    }

    public static l b(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        int iJ = nVar.j();
        String strB = b(iJ);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        nVar.a(bArr, 0, i2);
        int iB = b(0, bArr);
        String str = new String(bArr, 0, iB, C.ISO88591_NAME);
        int i3 = iB + 1;
        int iA = a(bArr, i3, iJ);
        String str2 = new String(bArr, i3, iA - i3, strB);
        int iA2 = a(iJ) + iA;
        int iA3 = a(bArr, iA2, iJ);
        return new l(str, str2, new String(bArr, iA2, iA3 - iA2, strB), Arrays.copyOfRange(bArr, a(iJ) + iA3, i2));
    }

    public static f a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, int i, int i2, boolean z, int i3, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l lVar) {
        int i4 = nVar.b;
        int iB = b(i4, nVar.f1472a);
        String str = new String(nVar.f1472a, i4, iB - i4, C.ISO88591_NAME);
        nVar.e(iB + 1);
        int iB2 = nVar.b();
        int iB3 = nVar.b();
        long jK = nVar.k();
        long j = jK == 4294967295L ? -1L : jK;
        long jK2 = nVar.k();
        long j2 = jK2 == 4294967295L ? -1L : jK2;
        ArrayList arrayList = new ArrayList();
        int i5 = i4 + i;
        while (nVar.b < i5) {
            o oVarA = a(i2, nVar, z, i3, lVar);
            if (oVarA != null) {
                arrayList.add(oVarA);
            }
        }
        o[] oVarArr = new o[arrayList.size()];
        arrayList.toArray(oVarArr);
        return new f(str, iB2, iB3, j, j2, oVarArr);
    }

    public static String b(int i) {
        if (i == 1) {
            return C.UTF16_NAME;
        }
        if (i == 2) {
            return "UTF-16BE";
        }
        if (i != 3) {
            return C.ISO88591_NAME;
        }
        return "UTF-8";
    }

    public static int b(int i, byte[] bArr) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0086 A[PHI: r3
  0x0086: PHI (r3v17 int) = (r3v6 int), (r3v20 int) binds: [B:39:0x0083, B:31:0x0075] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.fyber.inneractive.sdk.player.exoplayer2.util.n r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r1.b
        L6:
            int r3 = r1.c     // Catch: java.lang.Throwable -> Lb0
            int r4 = r1.b     // Catch: java.lang.Throwable -> Lb0
            int r3 = r3 - r4
            r4 = 1
            r5 = r20
            if (r3 < r5) goto Lac
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L21
            int r7 = r18.b()     // Catch: java.lang.Throwable -> Lb0
            long r8 = r18.k()     // Catch: java.lang.Throwable -> Lb0
            int r10 = r18.o()     // Catch: java.lang.Throwable -> Lb0
            goto L2b
        L21:
            int r7 = r18.l()     // Catch: java.lang.Throwable -> Lb0
            int r8 = r18.l()     // Catch: java.lang.Throwable -> Lb0
            long r8 = (long) r8
            r10 = r6
        L2b:
            r11 = 0
            if (r7 != 0) goto L39
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L39
            if (r10 != 0) goto L39
            r1.e(r2)
            return r4
        L39:
            r7 = 4
            if (r0 != r7) goto L6a
            if (r21 != 0) goto L6a
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L4a
            r1.e(r2)
            return r6
        L4a:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L6a:
            if (r0 != r7) goto L78
            r3 = r10 & 64
            if (r3 == 0) goto L72
            r3 = r4
            goto L73
        L72:
            r3 = r6
        L73:
            r7 = r10 & 1
            if (r7 == 0) goto L86
            goto L8a
        L78:
            if (r0 != r3) goto L88
            r3 = r10 & 32
            if (r3 == 0) goto L80
            r3 = r4
            goto L81
        L80:
            r3 = r6
        L81:
            r7 = r10 & 128(0x80, float:1.8E-43)
            if (r7 == 0) goto L86
            goto L8a
        L86:
            r4 = r6
            goto L8a
        L88:
            r3 = r6
            r4 = r3
        L8a:
            if (r4 == 0) goto L8e
            int r3 = r3 + 4
        L8e:
            long r3 = (long) r3
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L97
            r1.e(r2)
            return r6
        L97:
            int r3 = r1.c     // Catch: java.lang.Throwable -> Lb0
            int r4 = r1.b     // Catch: java.lang.Throwable -> Lb0
            int r3 = r3 - r4
            long r10 = (long) r3
            int r3 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r3 >= 0) goto La5
            r1.e(r2)
            return r6
        La5:
            int r3 = (int) r8
            int r4 = r4 + r3
            r1.e(r4)     // Catch: java.lang.Throwable -> Lb0
            goto L6
        Lac:
            r1.e(r2)
            return r4
        Lb0:
            r0 = move-exception
            r1.e(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.n.a(com.fyber.inneractive.sdk.player.exoplayer2.util.n, int, int, boolean):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e1 A[Catch: all -> 0x0135, UnsupportedEncodingException -> 0x0213, TryCatch #0 {UnsupportedEncodingException -> 0x0213, blocks: (B:161:0x01f4, B:151:0x01c0, B:158:0x01d0, B:159:0x01e1), top: B:172:0x0119 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f4 A[Catch: all -> 0x0135, UnsupportedEncodingException -> 0x0213, TRY_LEAVE, TryCatch #0 {UnsupportedEncodingException -> 0x0213, blocks: (B:161:0x01f4, B:151:0x01c0, B:158:0x01d0, B:159:0x01e1), top: B:172:0x0119 }] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v9, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.o a(int r20, com.fyber.inneractive.sdk.player.exoplayer2.util.n r21, boolean r22, int r23, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l r24) {
        /*
            Method dump skipped, instruction units count: 556
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.n.a(int, com.fyber.inneractive.sdk.player.exoplayer2.util.n, boolean, int, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l):com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.o");
    }

    public static s a(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, String str) {
        if (i < 1) {
            return null;
        }
        int iJ = nVar.j();
        String strB = b(iJ);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        nVar.a(bArr, 0, i2);
        return new s(str, null, new String(bArr, 0, a(bArr, 0, iJ), strB));
    }

    public static b a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, int i, int i2) {
        int iB;
        String strConcat;
        int iJ = nVar.j();
        String strB = b(iJ);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        nVar.a(bArr, 0, i3);
        if (i2 == 2) {
            strConcat = "image/" + new String(bArr, 0, 3, C.ISO88591_NAME).toLowerCase(Locale.US);
            if (strConcat.equals("image/jpg")) {
                strConcat = "image/jpeg";
            }
            iB = 2;
        } else {
            iB = b(0, bArr);
            String lowerCase = new String(bArr, 0, iB, C.ISO88591_NAME).toLowerCase(Locale.US);
            strConcat = lowerCase.indexOf(47) == -1 ? "image/".concat(lowerCase) : lowerCase;
        }
        int i4 = bArr[iB + 1] & 255;
        int i5 = iB + 2;
        int iA = a(bArr, i5, iJ);
        return new b(strConcat, new String(bArr, i5, iA - i5, strB), i4, Arrays.copyOfRange(bArr, a(iJ) + iA, i3));
    }

    public static j a(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        String str;
        if (i < 4) {
            return null;
        }
        int iJ = nVar.j();
        String strB = b(iJ);
        byte[] bArr = new byte[3];
        nVar.a(bArr, 0, 3);
        String str2 = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        nVar.a(bArr2, 0, i2);
        int iA = a(bArr2, 0, iJ);
        String str3 = new String(bArr2, 0, iA, strB);
        int iA2 = a(iJ) + iA;
        if (iA2 < i2) {
            str = new String(bArr2, iA2, a(bArr2, iA2, iJ) - iA2, strB);
        } else {
            str = "";
        }
        return new j(str2, str3, str);
    }

    public static String a(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static int a(byte[] bArr, int i, int i2) {
        int iB = b(i, bArr);
        if (i2 == 0 || i2 == 3) {
            return iB;
        }
        while (iB < bArr.length - 1) {
            if (iB % 2 == 0 && bArr[iB + 1] == 0) {
                return iB;
            }
            iB = b(iB + 1, bArr);
        }
        return bArr.length;
    }
}
