package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.work.WorkInfo;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class K2 {
    public static byte[] A07;
    public static String[] A08 = {"kwH2IgvZBGVpLaminurwcFHn", "J6e0tkh1Ff6tZSOwzR7AwbvIu8fVWeGQ", "bmiWbLOqDwiyYFUNe9As1QTlUgH4xYog", "dMXPCdyZdj7A6mfCnV5k3qiAvM2EcvhL", "upBvpVjUbbd4tW9uVknw3ChYtDg3XaKB", "lx9xVZ51GyjZV5dkAVxa", "4OpeXOwoxJhsdURDQeyl4TBKgN5cofiY", "16zjJfNWedSO35u1fMpvBODfGSUbEH9B"};
    public static final byte[] A09;
    public static final byte[] A0A;
    public static final byte[] A0B;
    public Bitmap A00;
    public final Canvas A01;
    public final Paint A02 = new Paint();
    public final Paint A03;
    public final C1340Ju A04;
    public final C1341Jv A05;
    public final K1 A06;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1340Ju A04(C09714u c09714u, int i) {
        int iA04;
        int iA042;
        int iA043;
        int iA044;
        int i2 = 8;
        int iA045 = c09714u.A04(8);
        c09714u.A09(8);
        int i3 = i - 2;
        int[] iArrA0F = A0F();
        int[] iArrA0G = A0G();
        int[] iArrA0H = A0H();
        while (i3 > 0) {
            int iA046 = c09714u.A04(i2);
            int iA047 = c09714u.A04(i2);
            int i4 = i3 - 2;
            int[] iArr = (iA047 & 128) != 0 ? iArrA0F : (iA047 & 64) != 0 ? iArrA0G : iArrA0H;
            int i5 = iA047 & 1;
            String[] strArr = A08;
            if (strArr[2].charAt(19) == strArr[6].charAt(19)) {
                throw new RuntimeException();
            }
            A08[3] = "yhDNrhcDigDR24Kxe5BS389mQBs2ZM2v";
            if (i5 != 0) {
                iA04 = c09714u.A04(i2);
                iA042 = c09714u.A04(i2);
                iA043 = c09714u.A04(i2);
                iA044 = c09714u.A04(i2);
                i3 = i4 - 4;
            } else {
                iA04 = c09714u.A04(6) << 2;
                iA042 = c09714u.A04(4) << 4;
                iA043 = c09714u.A04(4) << 4;
                iA044 = c09714u.A04(2) << 6;
                i3 = i4 - 2;
            }
            if (iA04 == 0) {
                iA042 = 0;
                if (A08[3].charAt(20) != '3') {
                    throw new RuntimeException();
                }
                A08[7] = "NRFOfVblegIP33K9RsgAL0VferudmJOb";
                iA043 = 0;
                iA044 = 255;
            }
            iArr[iA046] = A00(255 - (iA044 & 255), C5C.A07((int) (((double) iA04) + (((double) (iA042 + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT)) * 1.402d)), 0, 255), C5C.A07((int) ((((double) iA04) - (((double) (iA043 + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT)) * 0.34414d)) - (((double) (iA042 + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT)) * 0.71414d)), 0, 255), C5C.A07((int) (((double) iA04) + (((double) (iA043 + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT)) * 1.772d)), 0, 255));
            i2 = 8;
        }
        return new C1340Ju(iA045, iArrA0F, iArrA0G, iArrA0H);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1341Jv A05(C09714u c09714u) {
        int iA04;
        int iA042;
        int iA043;
        int iA044;
        c09714u.A09(4);
        boolean zA0H = c09714u.A0H();
        c09714u.A09(3);
        int iA045 = c09714u.A04(16);
        int iA046 = c09714u.A04(16);
        if (zA0H) {
            iA04 = c09714u.A04(16);
            iA044 = c09714u.A04(16);
            iA042 = c09714u.A04(16);
            iA043 = c09714u.A04(16);
        } else {
            iA04 = 0;
            iA042 = 0;
            iA043 = iA046;
            iA044 = iA045;
        }
        return new C1341Jv(iA045, iA046, iA04, iA044, iA042, iA043);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1345Jz A08(C09714u c09714u, int i) {
        int i2 = 8;
        int iA04 = c09714u.A04(8);
        c09714u.A09(4);
        boolean zA0H = c09714u.A0H();
        c09714u.A09(3);
        int iA042 = c09714u.A04(16);
        int iA043 = c09714u.A04(16);
        int iA044 = c09714u.A04(3);
        int iA045 = c09714u.A04(3);
        c09714u.A09(2);
        int iA046 = c09714u.A04(8);
        int iA047 = c09714u.A04(8);
        int iA048 = c09714u.A04(4);
        int iA049 = c09714u.A04(2);
        c09714u.A09(2);
        int i3 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i3 > 0) {
            int iA0410 = c09714u.A04(16);
            int iA0411 = c09714u.A04(2);
            int iA0412 = c09714u.A04(2);
            int iA0413 = c09714u.A04(12);
            c09714u.A09(4);
            int iA0414 = c09714u.A04(12);
            i3 -= 6;
            int iA0415 = 0;
            int iA0416 = 0;
            if (iA0411 == 1 || iA0411 == 2) {
                iA0415 = c09714u.A04(i2);
                iA0416 = c09714u.A04(i2);
                i3 -= 2;
            }
            sparseArray.put(iA0410, new K0(iA0411, iA0412, iA0413, iA0414, iA0415, iA0416));
            i2 = 8;
        }
        return new C1345Jz(iA04, zA0H, iA042, iA043, iA044, iA045, iA046, iA047, iA048, iA049, sparseArray);
    }

    public static String A09(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 22);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A07 = new byte[]{63, Ascii.SUB, Ascii.SI, Ascii.SUB, 91, Ascii.GS, Ascii.DC2, Ascii.RS, Ascii.ETB, Ascii.US, 91, Ascii.ETB, Ascii.RS, Ascii.NAK, Ascii.FS, Ascii.SI, 19, 91, Ascii.RS, 3, Ascii.CAN, Ascii.RS, Ascii.RS, Ascii.US, 8, 91, Ascii.ETB, Ascii.DC2, Ascii.SYN, Ascii.DC2, Ascii.SI, 98, 80, 68, 118, 71, 84, 85, 67, 84};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final List<C2675pT> A0I(byte[] bArr, int i) {
        C09714u c09714u = new C09714u(bArr, i);
        while (c09714u.A01() >= 48 && c09714u.A04(8) == 15) {
            A0B(c09714u, this.A06);
        }
        C1343Jx c1343Jx = this.A06.A01;
        if (c1343Jx == null) {
            return Collections.emptyList();
        }
        C1341Jv c1341Jv = this.A06.A00 != null ? this.A06.A00 : this.A05;
        if (this.A00 == null || c1341Jv.A05 + 1 != this.A00.getWidth() || c1341Jv.A00 + 1 != this.A00.getHeight()) {
            this.A00 = Bitmap.createBitmap(c1341Jv.A05 + 1, c1341Jv.A00 + 1, Bitmap.Config.ARGB_8888);
            this.A01.setBitmap(this.A00);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<C1344Jy> sparseArray = c1343Jx.A03;
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            this.A01.save();
            C1344Jy c1344JyValueAt = sparseArray.valueAt(i2);
            C1345Jz c1345Jz = this.A06.A08.get(sparseArray.keyAt(i2));
            int i3 = c1344JyValueAt.A00 + c1341Jv.A02;
            int i4 = c1344JyValueAt.A01 + c1341Jv.A04;
            this.A01.clipRect(i3, i4, Math.min(c1345Jz.A08 + i3, c1341Jv.A01), Math.min(c1345Jz.A02 + i4, c1341Jv.A03));
            C1340Ju c1340Ju = this.A06.A06.get(c1345Jz.A00);
            if (c1340Ju == null && (c1340Ju = this.A06.A04.get(c1345Jz.A00)) == null) {
                c1340Ju = this.A04;
            }
            SparseArray<K0> sparseArray2 = c1345Jz.A09;
            for (int i5 = 0; i5 < sparseArray2.size(); i5++) {
                int iKeyAt = sparseArray2.keyAt(i5);
                K0 k0ValueAt = sparseArray2.valueAt(i5);
                C1342Jw c1342Jw = this.A06.A07.get(iKeyAt);
                if (c1342Jw == null) {
                    c1342Jw = this.A06.A05.get(iKeyAt);
                }
                if (c1342Jw != null) {
                    A0C(c1342Jw, c1340Ju, c1345Jz.A01, i3 + k0ValueAt.A02, i4 + k0ValueAt.A05, c1342Jw.A01 ? null : this.A02, this.A01);
                }
            }
            if (A08[4].charAt(14) != '9') {
                throw new RuntimeException();
            }
            A08[0] = "Y9Cu9eZ8R7HUBmBBCZ1DilUT";
            if (c1345Jz.A0A) {
                this.A03.setColor(c1345Jz.A01 == 3 ? c1340Ju.A03[c1345Jz.A07] : c1345Jz.A01 == 2 ? c1340Ju.A02[c1345Jz.A06] : c1340Ju.A01[c1345Jz.A05]);
                this.A01.drawRect(i3, i4, c1345Jz.A08 + i3, c1345Jz.A02 + i4, this.A03);
            }
            arrayList.add(new C09393o().A0D(Bitmap.createBitmap(this.A00, i3, i4, c1345Jz.A08, c1345Jz.A02)).A04(i3 / c1341Jv.A05).A0A(0).A07(i4 / c1341Jv.A00, 0).A09(0).A06(c1345Jz.A08 / c1341Jv.A05).A03(c1345Jz.A02 / c1341Jv.A00).A0H());
            this.A01.drawColor(0, PorterDuff.Mode.CLEAR);
            this.A01.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }

    static {
        A0A();
        A09 = new byte[]{0, 7, 8, Ascii.SI};
        A0A = new byte[]{0, 119, -120, -1};
        A0B = new byte[]{0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    }

    public K2(int i, int i2) {
        this.A02.setStyle(Paint.Style.FILL_AND_STROKE);
        this.A02.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.A02.setPathEffect(null);
        this.A03 = new Paint();
        this.A03.setStyle(Paint.Style.FILL);
        this.A03.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.A03.setPathEffect(null);
        this.A01 = new Canvas();
        this.A05 = new C1341Jv(AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 575, 0, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 0, 575);
        this.A04 = new C1340Ju(0, A0F(), A0G(), A0H());
        this.A06 = new K1(i, i2);
    }

    public static int A00(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    public static int A01(C09714u c09714u, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        boolean z = false;
        do {
            int iA04 = 0;
            int iA042 = c09714u.A04(2);
            if (iA042 != 0) {
                iA04 = 1;
            } else if (c09714u.A0H()) {
                iA04 = c09714u.A04(3) + 3;
                iA042 = c09714u.A04(2);
            } else if (c09714u.A0H()) {
                iA04 = 1;
                iA042 = 0;
            } else {
                switch (c09714u.A04(2)) {
                    case 0:
                        z = true;
                        iA042 = 0;
                        break;
                    case 1:
                        iA04 = 2;
                        iA042 = 0;
                        break;
                    case 2:
                        int iA043 = c09714u.A04(4);
                        if (A08[7].charAt(9) != 'e') {
                            A08[7] = "PWQusWjmzTX1R8w37TeIuijcGSqhz46U";
                            iA04 = iA043 + 12;
                            iA042 = c09714u.A04(2);
                        } else {
                            throw new RuntimeException();
                        }
                        break;
                    case 3:
                        iA04 = c09714u.A04(8) + 29;
                        iA042 = c09714u.A04(2);
                        break;
                    default:
                        iA042 = 0;
                        break;
                }
            }
            if (iA04 != 0 && paint != null) {
                if (bArr != null) {
                    iA042 = bArr[iA042];
                }
                paint.setColor(iArr[iA042]);
                canvas.drawRect(i, i2, i + iA04, i2 + 1, paint);
            }
            i += iA04;
        } while (!z);
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0071 A[PHI: r0
  0x0071: PHI (r0v20 int) = (r0v18 int), (r0v23 int) binds: [B:25:0x0080, B:22:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A02(com.facebook.ads.redexgen.core.C09714u r14, int[] r15, byte[] r16, int r17, int r18, android.graphics.Paint r19, android.graphics.Canvas r20) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.K2.A02(com.facebook.ads.redexgen.X.4u, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    public static int A03(C09714u c09714u, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        int runLength;
        int i3 = i;
        boolean z = false;
        do {
            int iA04 = c09714u.A04(8);
            if (iA04 != 0) {
                runLength = 1;
            } else if (!c09714u.A0H()) {
                runLength = c09714u.A04(7);
                if (runLength != 0) {
                    iA04 = 0;
                } else {
                    z = true;
                    runLength = 0;
                    iA04 = 0;
                }
            } else {
                runLength = c09714u.A04(7);
                iA04 = c09714u.A04(8);
            }
            if (runLength != 0 && paint != null) {
                if (bArr != null) {
                    iA04 = bArr[iA04];
                }
                paint.setColor(iArr[iA04]);
                if (A08[3].charAt(20) != '3') {
                    throw new RuntimeException();
                }
                A08[3] = "mqxvpcZRbZaRJOXRSA703vBu0XWYN9Vd";
                canvas.drawRect(i3, i2, i3 + runLength, i2 + 1, paint);
            }
            i3 += runLength;
        } while (!z);
        return i3;
    }

    public static C1342Jw A06(C09714u c09714u) {
        int iA04 = c09714u.A04(16);
        c09714u.A09(4);
        int objectCodingMethod = c09714u.A04(2);
        boolean zA0H = c09714u.A0H();
        c09714u.A09(1);
        byte[] bottomFieldData = C5C.A07;
        byte[] bArr = C5C.A07;
        if (objectCodingMethod == 1) {
            int numberOfCodes = c09714u.A04(8);
            c09714u.A09(numberOfCodes * 16);
        } else if (objectCodingMethod == 0) {
            int iA042 = c09714u.A04(16);
            int topFieldDataLength = c09714u.A04(16);
            int objectId = A08[4].charAt(14);
            if (objectId != 57) {
                throw new RuntimeException();
            }
            A08[7] = "H05iJqDXaQUoFjCcOPsdhLa69PYGJoEl";
            if (iA042 > 0) {
                bottomFieldData = new byte[iA042];
                c09714u.A0G(bottomFieldData, 0, iA042);
            }
            if (topFieldDataLength > 0) {
                bArr = new byte[topFieldDataLength];
                c09714u.A0G(bArr, 0, topFieldDataLength);
            } else {
                bArr = bottomFieldData;
            }
        }
        return new C1342Jw(iA04, zA0H, bottomFieldData, bArr);
    }

    public static C1343Jx A07(C09714u c09714u, int i) {
        int iA04 = c09714u.A04(8);
        int iA042 = c09714u.A04(4);
        int iA043 = c09714u.A04(2);
        c09714u.A09(2);
        int i2 = i - 2;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int remainingLength = c09714u.A04(8);
            c09714u.A09(8);
            int version = c09714u.A04(16);
            int timeoutSecs = c09714u.A04(16);
            i2 -= 6;
            sparseArray.put(remainingLength, new C1344Jy(version, timeoutSecs));
        }
        return new C1343Jx(iA04, iA042, iA043, sparseArray);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0B(com.facebook.ads.redexgen.core.C09714u r7, com.facebook.ads.redexgen.core.K1 r8) {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.K2.A0B(com.facebook.ads.redexgen.X.4u, com.facebook.ads.redexgen.X.K1):void");
    }

    public static void A0C(C1342Jw c1342Jw, C1340Ju c1340Ju, int i, int i2, int i3, Paint paint, Canvas canvas) {
        int[] iArr;
        if (i == 3) {
            iArr = c1340Ju.A03;
        } else if (i == 2) {
            iArr = c1340Ju.A02;
        } else {
            iArr = c1340Ju.A01;
        }
        A0D(c1342Jw.A03, iArr, i, i2, i3, paint, canvas);
        A0D(c1342Jw.A02, iArr, i, i2, i3 + 1, paint, canvas);
    }

    public static void A0D(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        int i4 = i3;
        C09714u c09714u = new C09714u(bArr);
        byte[] clutMapTable2To8 = null;
        byte[] clutMapTable2To4 = null;
        byte[] bArrA0E = null;
        int line = i2;
        while (c09714u.A01() != 0) {
            switch (c09714u.A04(8)) {
                case 16:
                    if (i == 3) {
                        bArr2 = clutMapTable2To4 == null ? A0A : clutMapTable2To4;
                    } else if (i == 2) {
                        bArr2 = clutMapTable2To8 == null ? A09 : clutMapTable2To8;
                    } else {
                        bArr2 = null;
                    }
                    line = A01(c09714u, iArr, bArr2, line, i4, paint, canvas);
                    c09714u.A06();
                    break;
                case 17:
                    if (i == 3) {
                        bArr3 = bArrA0E == null ? A0B : bArrA0E;
                    } else {
                        bArr3 = null;
                    }
                    line = A02(c09714u, iArr, bArr3, line, i4, paint, canvas);
                    c09714u.A06();
                    break;
                case 18:
                    line = A03(c09714u, iArr, null, line, i4, paint, canvas);
                    break;
                case 32:
                    clutMapTable2To8 = A0E(4, 4, c09714u);
                    break;
                case 33:
                    clutMapTable2To4 = A0E(4, 8, c09714u);
                    break;
                case 34:
                    bArrA0E = A0E(16, 8, c09714u);
                    break;
                case PsExtractor.VIDEO_STREAM_MASK /* 240 */:
                    i4 += 2;
                    line = i2;
                    break;
            }
        }
    }

    public static byte[] A0E(int i, int i2, C09714u c09714u) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) c09714u.A04(i2);
        }
        return bArr;
    }

    public static int[] A0F() {
        int[] iArr = new int[4];
        iArr[0] = 0;
        iArr[1] = -1;
        iArr[2] = -16777216;
        String[] strArr = A08;
        if (strArr[2].charAt(19) == strArr[6].charAt(19)) {
            throw new RuntimeException();
        }
        A08[1] = "Jw8cEdbjQQjFC79Gk6sPH9AUdvvWBQg4";
        iArr[3] = -8421505;
        return iArr;
    }

    public static int[] A0G() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < iArr.length; i++) {
            if (i < 8) {
                int i2 = (i & 1) != 0 ? 255 : 0;
                iArr[i] = A00(255, i2, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                int i3 = (i & 1) != 0 ? 127 : 0;
                int i4 = (i & 2) != 0 ? 127 : 0;
                int i5 = i & 4;
                if (A08[4].charAt(14) != '9') {
                    throw new RuntimeException();
                }
                A08[3] = "UrHD9QQTZDyJKzMppguU3aPtXoZ0irSR";
                iArr[i] = A00(255, i3, i4, i5 == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x0029, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] A0H() {
        /*
            Method dump skipped, instruction units count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.K2.A0H():int[]");
    }

    public final void A0J() {
        this.A06.A00();
    }
}
